package com.bhargav.hcms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.bhargav.hcms.TotalHealthTips.BackPain;
import com.bhargav.hcms.TotalHealthTips.Cough;
import com.bhargav.hcms.TotalHealthTips.Dandruff;
import com.bhargav.hcms.TotalHealthTips.DietPlan;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.bhargav.hcms.TotalHealthTips.Exercise;
import com.bhargav.hcms.TotalHealthTips.FaceCare;
import com.bhargav.hcms.TotalHealthTips.HairGrowth;
import com.bhargav.hcms.TotalHealthTips.HairLoss;
import com.bhargav.hcms.TotalHealthTips.HeadAche;
import com.bhargav.hcms.TotalHealthTips.JointPain;
import com.bhargav.hcms.TotalHealthTips.Pimples;
import com.bhargav.hcms.TotalHealthTips.RoutineMaker;
import com.bhargav.hcms.TotalHealthTips.Scars;
import com.bhargav.hcms.TotalHealthTips.StomachAche;
import com.bhargav.hcms.TotalHealthTips.SunBurn;
import com.bhargav.hcms.TotalHealthTips.WorkoutManagement;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class TotalTips extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_tips);

        if(!isConnected(TotalTips.this)) buildDialog(TotalTips.this).show();
        else {
            Toast.makeText(TotalTips.this, R.string.totalhealth, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_total_tips);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Total Health Tips");
        getSupportActionBar().setIcon(R.drawable.ic_totalhealth);

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

    public void dietplan(View view) {
        Intent i = new Intent(TotalTips.this, DietPlan.class);
        startActivity(i);
    }
    public void exercise(View view) {
        Intent i = new Intent(TotalTips.this, Exercise.class);
        startActivity(i);
    }
    public void routinemaker(View view) {
        Intent i = new Intent(TotalTips.this, RoutineMaker.class);
        startActivity(i);
    }
    public void workoutmanagement(View view){
        Intent i = new Intent(TotalTips.this, WorkoutManagement.class);
        startActivity(i);
    }
    public void pimples(View view) {
        Intent i = new Intent(TotalTips.this, Pimples.class);
        startActivity(i);
    }
    public void scars(View view) {
        Intent i = new Intent(TotalTips.this, Scars.class);
        startActivity(i);
    }
    public void facecare(View view) {
        Intent i = new Intent(TotalTips.this, FaceCare.class);
        startActivity(i);
    }
    public void hairloss(View view) {
        Intent i = new Intent(TotalTips.this, HairLoss.class);
        startActivity(i);
    }
    public void dandruff(View view) {
        Intent i = new Intent(TotalTips.this, Dandruff.class);
        startActivity(i);
    }
    public void hairgrowth(View view) {
        Intent i = new Intent(TotalTips.this, HairGrowth.class);
        startActivity(i);
    }
    public void cough(View view) {
        Intent i = new Intent(TotalTips.this, Cough.class);
        startActivity(i);
    }
    public void stomachache(View view) {
        Intent i = new Intent(TotalTips.this, StomachAche.class);
        startActivity(i);
    }
    public void headache(View view) {
        Intent i = new Intent(TotalTips.this, HeadAche.class);
        startActivity(i);
    }
    public void backpain(View view) {
        Intent i = new Intent(TotalTips.this, BackPain.class);
        startActivity(i);
    }
    public void jointpain(View view) {
        Intent i = new Intent(TotalTips.this, JointPain.class);
        startActivity(i);
    }
    public void sunburn(View view) {
        Intent i = new Intent(TotalTips.this, SunBurn.class);
        startActivity(i);
    }

    private void checkUserStatus() {

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

        }
        else {
            startActivity(new Intent(TotalTips.this, LoginActivity.class));
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_liveuser) {
            startActivity(new Intent(TotalTips.this,DashboardActivity.class));
            finish();
        } else if (id == R.id.nav_doctor) {
            startActivity(new Intent(TotalTips.this,Doctor.class));
            finish();
        } else if (id == R.id.nav_google) {
            startActivity(new Intent(TotalTips.this,MapsActivity.class));
            finish();
        } else if (id == R.id.nav_tophsp) {
            startActivity(new Intent(TotalTips.this,TopHsp.class));
            finish();
        } else if (id == R.id.nav_hspinindia) {
            startActivity(new Intent(TotalTips.this,Hospital.class));
            finish();
        } else if (id == R.id.nav_donate) {
            startActivity(new Intent(TotalTips.this,DonateBlood.class));
            finish();
        } else if (id == R.id.nav_communicate) {
            startActivity(new Intent(TotalTips.this, Communicate.class));
            finish();
        } else if (id == R.id.nav_vitamins) {
            startActivity(new Intent(TotalTips.this,Vitamins.class));
            finish();
        } else if (id == R.id.nav_totalhealth) {
            startActivity(new Intent(TotalTips.this,TotalTips.class));
            finish();
        } else if (id == R.id.nav_alarm) {
            startActivity(new Intent(TotalTips.this, Alarms.class));
            finish();
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(TotalTips.this,Settings.class));
            finish();
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(TotalTips.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
