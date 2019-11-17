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
import com.bhargav.hcms.TotalHealthTips.PageAdapter.WorkoutManagementPageAdapter;
import com.bhargav.hcms.TotalHealthTips.Tabs.Workout_Management.WorkoutManagementTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Workout_Management.WorkoutManagementTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Workout_Management.WorkoutManagementTab3;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WorkoutManagement extends AppCompatActivity implements WorkoutManagementTab1.OnFragmentInteractionListener,WorkoutManagementTab2.OnFragmentInteractionListener,WorkoutManagementTab3.OnFragmentInteractionListener {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_management);

        if(!isConnected(WorkoutManagement.this)) buildDialog(WorkoutManagement.this).show();
        else {
            Toast.makeText(WorkoutManagement.this,R.string.workoutmanagement, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_workout_management);
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sample1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sample2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.sample3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final WorkoutManagementPageAdapter adapter = new WorkoutManagementPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
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
            startActivity(new Intent(WorkoutManagement.this, LoginActivity.class));
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
