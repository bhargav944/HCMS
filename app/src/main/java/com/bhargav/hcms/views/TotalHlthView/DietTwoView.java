package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class DietTwoView extends RecyclerView.ViewHolder {

    View mView;

    public DietTwoView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String description, String breakfast, String breaskfastdescrp, String lunch, String lunchdescrp, String dinner, String dinnerdescrp, String descrpdinner) {

        ImageView mImageIv = mView.findViewById(R.id.ImageView);
        TextView mHeaderTv = mView.findViewById(R.id.Header);
        TextView mTitleTv = mView.findViewById(R.id.Title);
        TextView mDetail = mView.findViewById(R.id.Detail);
        TextView mBreakFast = mView.findViewById(R.id.BreakFast);
        TextView mBreakFastDescrp = mView.findViewById( R.id.BDescrp);
        TextView mLunch = mView.findViewById( R.id.Lunch);
        TextView mLuchDescrp = mView.findViewById( R.id.LDescrp);
        TextView mDinner = mView.findViewById( R.id.Dinner);
        TextView mDinnerDescrp = mView.findViewById( R.id.DDescrp);
        TextView mDescrpDinner = mView.findViewById( R.id.DDescrpi);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDetail.setText(description);
        mBreakFast.setText(breakfast);
        mBreakFastDescrp.setText(breaskfastdescrp);
        mLunch.setText(lunch);
        mLuchDescrp.setText(lunchdescrp);
        mDinner.setText(dinner);
        mDinnerDescrp.setText(dinnerdescrp);
        mDescrpDinner.setText(descrpdinner);
    }
}
