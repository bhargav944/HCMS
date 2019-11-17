package com.bhargav.hcms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.bhargav.hcms.detail.DoctorDetail;
import com.bhargav.hcms.models.ModelDoctor;
import com.bhargav.hcms.views.DoctorView;
import com.bhargav.hcms.views.HspView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Doctor extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        if(!isConnected(Doctor.this)) buildDialog(Doctor.this).show();
        else {
            Toast.makeText(Doctor.this,R.string.doctordetails, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_doctor);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Doctor");
        getSupportActionBar().setIcon(R.drawable.ic_doctor);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Doctor");
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

    private void firebaseSearch(String searchText) {

        String query = searchText.toLowerCase();
        Query firebaseSearchQuery = mRef.orderByChild("search").startAt(query).endAt(query + "\uf8ff");

        FirebaseRecyclerAdapter<ModelDoctor, DoctorView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelDoctor, DoctorView>(
                        ModelDoctor.class,
                        R.layout.doctorlist,
                        DoctorView.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(DoctorView doctorView, ModelDoctor modelDoctor, int i) {
                        doctorView.setDetails(getApplicationContext(), modelDoctor.getImage(), modelDoctor.getName(), modelDoctor.getGender(), modelDoctor.getHspname(), modelDoctor.getDesignation(), modelDoctor.getEmail(), modelDoctor.getPhone());
                    }

                    @Override
                    public DoctorView onCreateViewHolder(ViewGroup parent, int viewType) {
                        DoctorView doctorView = super.onCreateViewHolder(parent, viewType);
                        doctorView.setOnClickListener(new HspView.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView mNameTv = view.findViewById(R.id.doctor_name);
                                TextView mGenderTv = view.findViewById(R.id.doctor_gender);
                                ImageView mImageIv = view.findViewById(R.id.doctor_image);
                                TextView mHspnameTv = view.findViewById(R.id.hos_name);
                                TextView mDesiTv = view.findViewById(R.id.doctor_desi);
                                TextView mEmailTv = view.findViewById(R.id.doctor_email);
                                TextView mPhoneTv = view.findViewById(R.id.doctor_phone);

                                String mName = mNameTv.getText().toString();
                                String mGender = mGenderTv.getText().toString();
                                Drawable mDrawable = mImageIv.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();
                                String mHspName = mHspnameTv.getText().toString();
                                String mDesi = mDesiTv.getText().toString();
                                String mEmail = mEmailTv.getText().toString();
                                String mPhone = mPhoneTv.getText().toString();

                                Intent intent = new Intent(view.getContext(), DoctorDetail.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image",bytes);
                                intent.putExtra("name",mName);
                                intent.putExtra("gender",mGender);
                                intent.putExtra("hspname",mHspName);
                                intent.putExtra("designation",mDesi);
                                intent.putExtra("email",mEmail);
                                intent.putExtra("phone",mPhone);
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });

                        return doctorView;
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelDoctor, DoctorView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelDoctor, DoctorView>(
                        ModelDoctor.class,
                        R.layout.doctorlist,
                        DoctorView.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(DoctorView doctorView, ModelDoctor modelDoctor, int i) {
                        doctorView.setDetails(getApplicationContext(), modelDoctor.getImage(), modelDoctor.getName(), modelDoctor.getGender(), modelDoctor.getHspname(), modelDoctor.getDesignation(), modelDoctor.getEmail(), modelDoctor.getPhone());
                    }

                    @Override
                    public DoctorView onCreateViewHolder(ViewGroup parent, int viewType) {
                        DoctorView doctorView = super.onCreateViewHolder(parent, viewType);
                        doctorView.setOnClickListener(new HspView.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView mNameTv = view.findViewById(R.id.doctor_name);
                                TextView mGenderTv = view.findViewById(R.id.doctor_gender);
                                ImageView mImageIv = view.findViewById(R.id.doctor_image);
                                TextView mHspnameTv = view.findViewById(R.id.hos_name);
                                TextView mDesiTv = view.findViewById(R.id.doctor_desi);
                                TextView mEmailTv = view.findViewById(R.id.doctor_email);
                                TextView mPhoneTv = view.findViewById(R.id.doctor_phone);

                                String mName = mNameTv.getText().toString();
                                String mGender = mGenderTv.getText().toString();
                                Drawable mDrawable = mImageIv.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();
                                String mHspName = mHspnameTv.getText().toString();
                                String mDesi = mDesiTv.getText().toString();
                                String mEmail = mEmailTv.getText().toString();
                                String mPhone = mPhoneTv.getText().toString();

                                Intent intent = new Intent(view.getContext(), DoctorDetail.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image",bytes);
                                intent.putExtra("name",mName);
                                intent.putExtra("gender",mGender);
                                intent.putExtra("hspname",mHspName);
                                intent.putExtra("designation",mDesi);
                                intent.putExtra("email",mEmail);
                                intent.putExtra("phone",mPhone);
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });

                        return doctorView;
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private void checkUserStatus() {

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

        }
        else {
            startActivity(new Intent(Doctor.this, LoginActivity.class));
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
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                firebaseSearch(newText);
                return false;
            }
        });
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
            startActivity(new Intent(Doctor.this,DashboardActivity.class));
            finish();
        } else if (id == R.id.nav_doctor) {
            startActivity(new Intent(Doctor.this,Doctor.class));
            finish();
        } else if (id == R.id.nav_google) {
            startActivity(new Intent(Doctor.this,MapsActivity.class));
            finish();
        } else if (id == R.id.nav_tophsp) {
            startActivity(new Intent(Doctor.this,TopHsp.class));
            finish();
        } else if (id == R.id.nav_hspinindia) {
            startActivity(new Intent(Doctor.this,Hospital.class));
            finish();
        } else if (id == R.id.nav_donate) {
            startActivity(new Intent(Doctor.this,DonateBlood.class));
            finish();
        } else if (id == R.id.nav_communicate) {
            startActivity(new Intent(Doctor.this, Communicate.class));
            finish();
        }  else if (id == R.id.nav_vitamins) {
            startActivity(new Intent(Doctor.this,Vitamins.class));
            finish();
        } else if (id == R.id.nav_totalhealth) {
            startActivity(new Intent(Doctor.this,TotalTips.class));
            finish();
        } else if (id == R.id.nav_alarm) {
            startActivity(new Intent(Doctor.this, Alarms.class));
            finish();
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(Doctor.this,Settings.class));
            finish();
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Doctor.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
