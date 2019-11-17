package com.bhargav.hcms.HospitalsInINDIA;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import com.bhargav.hcms.HospitalsInINDIA.Maha_ashtra.Mumbai;
import com.bhargav.hcms.HospitalsInINDIA.Maha_ashtra.Nagpur;
import com.bhargav.hcms.HospitalsInINDIA.Maha_ashtra.Pune;
import com.bhargav.hcms.HospitalsInINDIA.Maha_ashtra.Shridi;
import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.MainActivity;
import com.bhargav.hcms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Maharashtra extends AppCompatActivity {

    ListView listview;
    ArrayAdapter mAdapter;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maharashtra);

        if(!isConnected(Maharashtra.this)) buildDialog(Maharashtra.this).show();
        else {
            Toast.makeText(Maharashtra.this,R.string.maharashtra, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_maharashtra);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.maharashtra);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        listview = (ListView) findViewById(R.id.list_item);

        mAdapter = new ArrayAdapter(Maharashtra.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Maharashtra));
        listview.setAdapter(mAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Maharashtra.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent myIntent = new Intent(view.getContext(), Mumbai.class);
                    startActivityForResult(myIntent,0);
                }
                if(position==1) {
                    Intent myIntent = new Intent(view.getContext(), Pune.class);
                    startActivityForResult(myIntent, 1);
                }
                if(position==2) {
                    Intent myIntent = new Intent(view.getContext(), Nagpur.class);
                    startActivityForResult(myIntent, 2);
                }
                if(position==3) {
                    Intent myIntent = new Intent(view.getContext(), Shridi.class);
                    startActivityForResult(myIntent, 3);
                }
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

    private void checkUserStatus() {

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

        }
        else {
            startActivity(new Intent(Maharashtra.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard, menu);

        MenuItem item1 = menu.findItem(R.id.action_add_post).setVisible(false);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
