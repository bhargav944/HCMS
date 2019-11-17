package com.bhargav.hcms;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bhargav.hcms.Vitamin.VitaminA;
import com.bhargav.hcms.detail.DonateDetail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDonateBlood extends AppCompatActivity {

    TextView ename,eemail,ephone,eblood;
    Button save;
    FirebaseDatabase database;
    DatabaseReference myRef;

    ActionBar actionBar;

    String email, uid;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donate_blood);

        if(!isConnected(AddDonateBlood.this)) buildDialog(AddDonateBlood.this).show();
        else {
            Toast.makeText(AddDonateBlood.this,R.string.blooddonation_me, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_add_donate_blood);
        }

        actionBar = getSupportActionBar();
        actionBar.setTitle("Donate Blood");

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        ename = (TextView) findViewById(R.id.etname);
        eemail = (TextView) findViewById(R.id.eemail);
        ephone = (TextView) findViewById(R.id.ephone);
        eblood = (TextView) findViewById(R.id.eblood);
        save = (Button) findViewById(R.id.pUploadBtn);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Donate Blood");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =  ename.getText().toString();
                String email =  eemail.getText().toString();
                String address =  ephone.getText().toString();
                String blood = eblood.getText().toString();


                String key =myRef.push().getKey();
                DonateDetail userdetails = new DonateDetail();

                userdetails.setName(name);
                userdetails.setEmail(email);
                userdetails.setPhone(address);
                userdetails.setBlood(blood);

                myRef.child(key).setValue(userdetails);
                ename.setText("");
                eemail.setText("");
                ephone.setText("");
                eblood.setText("");

                Toast.makeText(AddDonateBlood.this,"Thank You for Donating Blood...", Toast.LENGTH_SHORT).show();

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
            email = user.getEmail();
            uid = user.getUid();
        }
        else {
            startActivity(new Intent(AddDonateBlood.this, LoginActivity.class));
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
