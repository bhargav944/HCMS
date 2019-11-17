package com.bhargav.hcms.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class DoctorView extends RecyclerView.ViewHolder {

    View mView;

    public DoctorView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx, String image, String name, String gender, String hspname, String designation, String email, String phone) {

        ImageView mImageIv = mView.findViewById(R.id.doctor_image);
        TextView mNameTv = mView.findViewById(R.id.doctor_name);
        TextView mGenderTv = mView.findViewById(R.id.doctor_gender);
        TextView mHspNameTv = mView.findViewById(R.id.hos_name);
        TextView mDesignationTv = mView.findViewById( R.id.doctor_desi);
        TextView mEmailTv = mView.findViewById( R.id.doctor_email);
        TextView mPhoneTv = mView.findViewById( R.id.doctor_phone);

        Picasso.get().load(image).into(mImageIv);
        mNameTv.setText(name);
        mGenderTv.setText(gender);
        mHspNameTv.setText(hspname);
        mDesignationTv.setText(designation);
        mEmailTv.setText(email);
        mPhoneTv.setText(phone);
    }

    private HspView.ClickListener mClickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(HspView.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}
