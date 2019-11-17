package com.bhargav.hcms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.bhargav.hcms.Vitamin.VitaminA;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.bhargav.hcms.Vitamin.VitaminB1;
import com.bhargav.hcms.Vitamin.VitaminB12;
import com.bhargav.hcms.Vitamin.VitaminB2;
import com.bhargav.hcms.Vitamin.VitaminB3;
import com.bhargav.hcms.Vitamin.VitaminB5;
import com.bhargav.hcms.Vitamin.VitaminB6;
import com.bhargav.hcms.Vitamin.VitaminB7;
import com.bhargav.hcms.Vitamin.VitaminB9;
import com.bhargav.hcms.Vitamin.VitaminC;
import com.bhargav.hcms.Vitamin.VitaminD;
import com.bhargav.hcms.Vitamin.VitaminE;
import com.bhargav.hcms.Vitamin.VitaminK;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class Vitamins extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamins);

        if(!isConnected(Vitamins.this)) buildDialog(Vitamins.this).show();
        else {
            Toast.makeText(Vitamins.this, R.string.vitamins, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_vitamins);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vitamins");
        getSupportActionBar().setIcon(R.drawable.ic_vitamins);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
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

    public void a(View view) {
        Intent i = new Intent(this, VitaminA.class);
        startActivity(i);
    }
    public void b1(View view) {
        Intent i = new Intent(this, VitaminB1.class);
        startActivity(i);
    }
    public void b2(View view) {
        Intent i = new Intent(this, VitaminB2.class);
        startActivity(i);
    }
    public void b3(View view) {
        Intent i = new Intent(this, VitaminB3.class);
        startActivity(i);
    }
    public void b5(View view) {
        Intent i = new Intent(this, VitaminB5.class);
        startActivity(i);
    }
    public void b6(View view) {
        Intent i = new Intent(this, VitaminB6.class);
        startActivity(i);
    }
    public void b7(View view) {
        Intent i = new Intent(this, VitaminB7.class);
        startActivity(i);
    }
    public void b9(View view) {
        Intent i = new Intent(this, VitaminB9.class);
        startActivity(i);
    }
    public void b12(View view) {
        Intent i = new Intent(this, VitaminB12.class);
        startActivity(i);
    }
    public void c(View view) {
        Intent i = new Intent(this, VitaminC.class);
        startActivity(i);
    }
    public void d(View view) {
        Intent i = new Intent(this, VitaminD.class);
        startActivity(i);
    }
    public void e(View view) {
        Intent i = new Intent(this, VitaminE.class);
        startActivity(i);
    }
    public void k(View view) {
        Intent i = new Intent(this, VitaminK.class);
        startActivity(i);
    }

    private void checkUserStatus() {

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

        }
        else {
            startActivity(new Intent(Vitamins.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        MenuItem item1 = menu.findItem(R.id.action_add_post).setVisible(false);
        MenuItem item = menu.findItem(R.id.action_search).setVisible(false);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_liveuser) {
            startActivity(new Intent(Vitamins.this,DashboardActivity.class));
            finish();
        } else if (id == R.id.nav_doctor) {
            startActivity(new Intent(Vitamins.this,Doctor.class));
            finish();
        } else if (id == R.id.nav_google) {
            startActivity(new Intent(Vitamins.this, MapsActivity.class));
            finish();
        } else if (id == R.id.nav_tophsp) {
            startActivity(new Intent(Vitamins.this,TopHsp.class));
            finish();
        } else if (id == R.id.nav_hspinindia) {
            startActivity(new Intent(Vitamins.this,Hospital.class));
            finish();
        } else if (id == R.id.nav_donate) {
            startActivity(new Intent(Vitamins.this,DonateBlood.class));
            finish();
        } else if (id == R.id.nav_communicate) {
            startActivity(new Intent(Vitamins.this, Communicate.class));
            finish();
        } else if (id == R.id.nav_vitamins) {
            startActivity(new Intent(Vitamins.this, Vitamins.class));
            finish();
        } else if (id == R.id.nav_totalhealth) {
            startActivity(new Intent(Vitamins.this, TotalTips.class));
            finish();
        } else if (id == R.id.nav_alarm) {
            startActivity(new Intent(Vitamins.this, Alarms.class));
            finish();
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(Vitamins.this, Settings.class));
            finish();
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Vitamins.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
