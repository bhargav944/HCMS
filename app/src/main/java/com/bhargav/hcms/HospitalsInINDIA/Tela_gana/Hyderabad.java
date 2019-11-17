package com.bhargav.hcms.HospitalsInINDIA.Tela_gana;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Vellore;
import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.detail.HspDetail;
import com.bhargav.hcms.MainActivity;
import com.bhargav.hcms.views.HspView;
import com.bhargav.hcms.models.ModelHsp;
import com.bhargav.hcms.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayOutputStream;

public class Hyderabad extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyderabad);

        if(!isConnected(Hyderabad.this)) buildDialog(Hyderabad.this).show();
        else {
            Toast.makeText(Hyderabad.this,R.string.hyderabad, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_hyderabad);
        }

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Hospitals").child("Telangana").child("Hyderabad");
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
            startActivity(new Intent(Hyderabad.this, LoginActivity.class));
            finish();
        }
    }

    private void firebaseSearch(String searchText) {
        String query = searchText.toLowerCase();
        Query firebaseSearchQuery = mRef.orderByChild("search").startAt(query).endAt(query + "\uf8ff");

        FirebaseRecyclerAdapter<ModelHsp, HspView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelHsp, HspView>(
                        ModelHsp.class,
                        R.layout.hsplist,
                        HspView.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(HspView hspView, ModelHsp modelHsp, int i) {
                        hspView.setDetails(getApplicationContext(), modelHsp.getTitle(), modelHsp.getDescription(), modelHsp.getImage(), modelHsp.getPhone(), modelHsp.getLink());
                    }
                    @Override
                    public HspView onCreateViewHolder(ViewGroup parent, int viewType) {
                        HspView hspView = super.onCreateViewHolder(parent, viewType);
                        hspView.setOnClickListener(new HspView.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView mTitleTv = view.findViewById(R.id.rTitleTv);
                                TextView mDescTv = view.findViewById(R.id.rDescriptionTv);
                                ImageView mImageView = view.findViewById(R.id.rImageView);
                                TextView mPhoneTv = view.findViewById(R.id.rPhoneTv);
                                TextView mLinkTv = view.findViewById(R.id.rLinkTv);

                                String mTitle = mTitleTv.getText().toString();
                                String mDesc = mDescTv.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();
                                String mPhone = mPhoneTv.getText().toString();
                                String mLink = mLinkTv.getText().toString();

                                Intent intent = new Intent(view.getContext(), HspDetail.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image",bytes);
                                intent.putExtra("title",mTitle);
                                intent.putExtra("description", mDesc);
                                intent.putExtra("phone",mPhone);
                                intent.putExtra("link",mLink);
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });

                        return hspView;
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelHsp, HspView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelHsp, HspView>(
                        ModelHsp.class,
                        R.layout.hsplist,
                        HspView.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(HspView hspView, ModelHsp modelHsp, int i) {
                        hspView.setDetails(getApplicationContext(), modelHsp.getTitle(), modelHsp.getDescription(), modelHsp.getImage(), modelHsp.getPhone(), modelHsp.getLink());
                    }

                    @Override
                    public HspView onCreateViewHolder(ViewGroup parent, int viewType) {
                        HspView hspView = super.onCreateViewHolder(parent, viewType);
                        hspView.setOnClickListener(new HspView.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView mTitleTv = view.findViewById(R.id.rTitleTv);
                                TextView mDescTv = view.findViewById(R.id.rDescriptionTv);
                                ImageView mImageView = view.findViewById(R.id.rImageView);
                                TextView mPhoneTv = view.findViewById(R.id.rPhoneTv);
                                TextView mLinkTv = view.findViewById(R.id.rLinkTv);

                                String mTitle = mTitleTv.getText().toString();
                                String mDesc = mDescTv.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();
                                String mPhone = mPhoneTv.getText().toString();
                                String mLink = mLinkTv.getText().toString();

                                Intent intent = new Intent(view.getContext(), HspDetail.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image",bytes);
                                intent.putExtra("title",mTitle);
                                intent.putExtra("description", mDesc);
                                intent.putExtra("phone",mPhone);
                                intent.putExtra("link",mLink);
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });

                        return hspView;
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
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
}
