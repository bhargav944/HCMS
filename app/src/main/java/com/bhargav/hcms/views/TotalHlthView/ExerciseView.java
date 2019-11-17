package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class ExerciseView extends RecyclerView.ViewHolder {

    View mView;

    public ExerciseView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String header, String image1, String title1, String detail1, String image2, String title2, String detail2, String image3, String title3, String detail3, String image4, String title4, String detail4, String image5, String title5, String detail5) {

        TextView mHeaderTv = mView.findViewById(R.id.Header);
        ImageView mImageIv = mView.findViewById(R.id.image1);
        TextView mTitleTv = mView.findViewById(R.id.title1);
        TextView mDetailTv = mView.findViewById(R.id.detail1);
        ImageView mImageIv1 = mView.findViewById(R.id.image2);
        TextView mTitleTv1 = mView.findViewById(R.id.title2);
        TextView mDetailTv1 = mView.findViewById(R.id.detail2);
        ImageView mImageIv2 = mView.findViewById(R.id.image3);
        TextView mTitleTv2 = mView.findViewById(R.id.title3);
        TextView mDetailTv2 = mView.findViewById(R.id.detail3);
        ImageView mImageIv3 = mView.findViewById(R.id.image4);
        TextView mTitleTv3= mView.findViewById(R.id.title4);
        TextView mDetailTv3 = mView.findViewById(R.id.detail4);
        ImageView mImageIv4 = mView.findViewById(R.id.image5);
        TextView mTitleTv4 = mView.findViewById(R.id.title5);
        TextView mDetailTv4 = mView.findViewById(R.id.detail5);


        mHeaderTv.setText(header);
        Picasso.get().load(image1).into(mImageIv);
        mTitleTv.setText(title1);
        mDetailTv.setText(detail1);
        Picasso.get().load(image2).into(mImageIv1);
        mTitleTv1.setText(title2);
        mDetailTv1.setText(detail2);
        Picasso.get().load(image3).into(mImageIv2);
        mTitleTv2.setText(title3);
        mDetailTv2.setText(detail3);
        Picasso.get().load(image4).into(mImageIv3);
        mTitleTv3.setText(title4);
        mDetailTv3.setText(detail4);
        Picasso.get().load(image5).into(mImageIv4);
        mTitleTv4.setText(title5);
        mDetailTv4.setText(detail5);
    }
}
