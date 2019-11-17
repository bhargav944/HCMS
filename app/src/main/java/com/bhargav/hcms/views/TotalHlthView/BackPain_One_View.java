package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class BackPain_One_View extends RecyclerView.ViewHolder{

    View mView;

    public BackPain_One_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String header, String title1, String image1, String description1, String title2, String image2, String description2, String title3, String image3, String description3, String title4, String image4, String description4, String description5, String description6, String description7, String title5, String image5, String description8) {

        TextView mHeaderTv = mView.findViewById(R.id.header);
        TextView mTitleTv1 = mView.findViewById(R.id.title1);
        ImageView mImageIv1 = mView.findViewById(R.id.image1);
        TextView mDetail1 = mView.findViewById(R.id.description1);
        TextView mTitleTv2 = mView.findViewById(R.id.title2);
        ImageView mImageIv2 = mView.findViewById(R.id.image2);
        TextView mDetail2 = mView.findViewById(R.id.description2);
        TextView mTitleTv3 = mView.findViewById(R.id.title3);
        ImageView mImageIv3 = mView.findViewById(R.id.image3);
        TextView mDetail3 = mView.findViewById(R.id.description3);
        TextView mTitleTv4 = mView.findViewById(R.id.title4);
        ImageView mImageIv4 = mView.findViewById(R.id.image4);
        TextView mDetail4 = mView.findViewById(R.id.description4);
        TextView mDetail5 = mView.findViewById(R.id.description5);
        TextView mDetail6 = mView.findViewById(R.id.description6);
        TextView mDetail7 = mView.findViewById(R.id.description7);
        TextView mTitleTv5 = mView.findViewById(R.id.title5);
        ImageView mImageIv5 = mView.findViewById(R.id.image5);
        TextView mDetail8 = mView.findViewById(R.id.description8);

        mHeaderTv.setText(header);
        mTitleTv1.setText(title1);
        Picasso.get().load(image1).into(mImageIv1);
        mDetail1.setText(description1);
        mTitleTv2.setText(title2);
        Picasso.get().load(image2).into(mImageIv2);
        mDetail2.setText(description2);
        mTitleTv3.setText(title3);
        Picasso.get().load(image3).into(mImageIv3);
        mDetail3.setText(description3);
        mTitleTv4.setText(title4);
        Picasso.get().load(image4).into(mImageIv4);
        mDetail4.setText(description4);
        mDetail5.setText(description5);
        mDetail6.setText(description6);
        mDetail7.setText(description7);
        mTitleTv5.setText(title5);
        Picasso.get().load(image5).into(mImageIv5);
        mDetail8.setText(description8);

    }
}
