package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class DietThreeView extends RecyclerView.ViewHolder {

    View mView;

    public DietThreeView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String dayone, String dayonedetail, String daytwo, String daytwodetail, String daythree, String daythreedetail) {

        ImageView mImageIv = mView.findViewById(R.id.ImageView);
        TextView mHeaderTv = mView.findViewById(R.id.Header);
        TextView mTitleTv = mView.findViewById(R.id.Title);
        TextView mDayOne = mView.findViewById(R.id.DayOne);
        TextView mDayOneDetail = mView.findViewById(R.id.DayOneDetail);
        TextView mDayTwo = mView.findViewById(R.id.DayTwo);
        TextView mDayTwoDetail = mView.findViewById( R.id.DayTwoDetail);
        TextView mDayThree = mView.findViewById( R.id.DayThree);
        TextView mDayThreeDetail = mView.findViewById( R.id.DayThreeDetail);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDayOne.setText(dayone);
        mDayOneDetail.setText(dayonedetail);
        mDayTwo.setText(daytwo);
        mDayTwoDetail.setText(daytwodetail);
        mDayThree.setText(daythree);
        mDayThreeDetail.setText(daythreedetail);
    }
}
