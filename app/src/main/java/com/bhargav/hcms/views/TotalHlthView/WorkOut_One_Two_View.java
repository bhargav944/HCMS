package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class WorkOut_One_Two_View extends RecyclerView.ViewHolder {

    View mView;

    public WorkOut_One_Two_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String title1, String detail1, String title2, String detail2, String title3, String detail3, String title4, String detail4, String title5, String detail5, String title6, String detail6, String title7, String detail7) {

        TextView mTitleTv1 = mView.findViewById(R.id.title1);
        TextView mDetailTv1 = mView.findViewById(R.id.detail1);
        TextView mTitleTv2 = mView.findViewById(R.id.title2);
        TextView mDetailTv2 = mView.findViewById(R.id.detail2);
        TextView mTitleTv3 = mView.findViewById(R.id.title3);
        TextView mDetailTv3 = mView.findViewById(R.id.detail3);
        TextView mTitleTv4 = mView.findViewById( R.id.title4);
        TextView mDetailTv4 = mView.findViewById( R.id.detail4);
        TextView mTitleTv5 = mView.findViewById( R.id.title5);
        TextView mDetailTv5 = mView.findViewById( R.id.detail5);
        TextView mTitleTv6 = mView.findViewById( R.id.title6);
        TextView mDetailTv6 = mView.findViewById( R.id.detail6);
        TextView mTitleTv7 = mView.findViewById( R.id.title7);
        TextView mDetailTv7 = mView.findViewById( R.id.detail7);

        mTitleTv1.setText(title1);
        mDetailTv1.setText(detail1);
        mTitleTv2.setText(title2);
        mDetailTv2.setText(detail2);
        mTitleTv3.setText(title3);
        mDetailTv3.setText(detail3);
        mTitleTv4.setText(title4);
        mDetailTv4.setText(detail4);
        mTitleTv5.setText(title5);
        mDetailTv5.setText(detail5);
        mTitleTv6.setText(title6);
        mDetailTv6.setText(detail6);
        mTitleTv7.setText(title7);
        mDetailTv7.setText(detail7);
    }
}
