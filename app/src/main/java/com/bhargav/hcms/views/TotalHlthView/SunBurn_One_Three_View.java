package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class SunBurn_One_Three_View extends RecyclerView.ViewHolder {

    View mView;

    public SunBurn_One_Three_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String description1, String description2, String description3, String description4) {

        ImageView mImageIv = mView.findViewById(R.id.imageView);
        TextView mHeaderTv = mView.findViewById(R.id.header);
        TextView mTitleTv = mView.findViewById(R.id.title);
        TextView mDetailTv1 = mView.findViewById(R.id.description1);
        TextView mDetailTv2 = mView.findViewById(R.id.description2);
        TextView mDetailTv3 = mView.findViewById(R.id.description3);
        TextView mDetailTv4 = mView.findViewById(R.id.description4);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDetailTv1.setText(description1);
        mDetailTv2.setText(description2);
        mDetailTv3.setText(description3);
        mDetailTv4.setText(description4);
    }
}
