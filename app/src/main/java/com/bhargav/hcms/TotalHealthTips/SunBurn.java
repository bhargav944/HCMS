package com.bhargav.hcms.TotalHealthTips;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.MainActivity;
import com.bhargav.hcms.R;
import com.bhargav.hcms.TotalHealthTips.PageAdapter.SunBurnPageAdapter;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab5;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SunBurn extends AppCompatActivity implements SunBurnTab1.OnFragmentInteractionListener,SunBurnTab2.OnFragmentInteractionListener,SunBurnTab3.OnFragmentInteractionListener,SunBurnTab4.OnFragmentInteractionListener,SunBurnTab5.OnFragmentInteractionListener {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun_burn);

        if(!isConnected(SunBurn.this)) buildDialog(SunBurn.this).show();
        else {
            Toast.makeText(SunBurn.this,R.string.sunburn, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_sun_burn);
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy3));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy4));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy5));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final SunBurnPageAdapter adapter = new SunBurnPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(R.string.no_internet);
        builder.setMessage(R.string.no_internet_msg);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    private void checkUserStatus() {

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

        }
        else {
            startActivity(new Intent(SunBurn.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        MenuItem item = menu.findItem(R.id.action_search).setVisible(false);
        MenuItem item1 = menu.findItem(R.id.action_add_post).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            firebaseAuth.signOut();
            checkUserStatus();
        }

        return super.onOptionsItemSelected(item);
    }
}
