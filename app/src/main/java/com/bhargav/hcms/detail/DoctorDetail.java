package com.bhargav.hcms.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.MainActivity;
import com.bhargav.hcms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DoctorDetail extends AppCompatActivity {

    TextView mNameTv, mGenderTv, mHspnameTv, mDesignationTv, mEmailTv, mPhoneTv;
    ImageView mImageIv;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        mNameTv = findViewById(R.id.Doctor_name);
        mGenderTv = findViewById(R.id.Doctor_gender);
        mHspnameTv = findViewById(R.id.Hos_name);
        mDesignationTv = findViewById(R.id.Doctor_desi);
        mEmailTv = findViewById(R.id.Doctor_email);
        mPhoneTv = findViewById(R.id.Doctor_phone);
        mImageIv = findViewById(R.id.Doctor_image);

        byte[] bytes = getIntent().getByteArrayExtra("image");
        String name = getIntent().getStringExtra("name");
        String gender = getIntent().getStringExtra("gender");
        String hspname = getIntent().getStringExtra("hspname");
        String designation = getIntent().getStringExtra("designation");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        mNameTv.setText(name);
        mGenderTv.setText(gender);
        mImageIv.setImageBitmap(bmp);
        mHspnameTv.setText(hspname);
        mDesignationTv.setText(designation);
        mEmailTv.setText(email);
        mPhoneTv.setText(phone);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void checkUserStatus() {

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

        }
        else {
            startActivity(new Intent(DoctorDetail.this, LoginActivity.class));
            finish();
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
}
