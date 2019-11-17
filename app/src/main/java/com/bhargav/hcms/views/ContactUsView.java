package com.bhargav.hcms.views;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;

public class ContactUsView extends RecyclerView.ViewHolder {

    View mView;

    public ContactUsView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String header, String title, String developed, String name, String email, String emailid, String phone, String number) {

        TextView mHeaderTv = mView.findViewById(R.id.header);
        TextView mTitleTv = mView.findViewById(R.id.title);
        TextView mDevelopedTv = mView.findViewById(R.id.developed);
        TextView mNameTv = mView.findViewById(R.id.name);
        TextView mEmailTv = mView.findViewById( R.id.email);
        TextView mEmailIDTv = mView.findViewById( R.id.emailid);
        TextView mPhoneTv = mView.findViewById( R.id.phone);
        TextView mNumberTv = mView.findViewById( R.id.number);

        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDevelopedTv.setText(developed);
        mNameTv.setText(name);
        mEmailTv.setText(email);
        mEmailIDTv.setText(emailid);
        mPhoneTv.setText(phone);
        mNumberTv.setText(number);
    }
}
