package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class SunBurn_Four_Five_View extends RecyclerView.ViewHolder {

    View mView;

    public SunBurn_Four_Five_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String detail1, String detail2, String detail3) {

        ImageView mImageIv = mView.findViewById(R.id.imageview);
        TextView mHeaderTv = mView.findViewById(R.id.header);
        TextView mTitleTv = mView.findViewById(R.id.title);
        TextView mDetailTv1 = mView.findViewById(R.id.detail1);
        TextView mDetailTv2 = mView.findViewById(R.id.detail2);
        TextView mDetailTv3 = mView.findViewById(R.id.detail3);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDetailTv1.setText(detail1);
        mDetailTv2.setText(detail2);
        mDetailTv3.setText(detail3);
    }
}
