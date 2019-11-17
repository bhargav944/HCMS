package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class DietOneView extends RecyclerView.ViewHolder {

    View mView;

    public DietOneView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String header, String title, String image, String headertit, String description, String advantage, String advantagedescrp, String dayone, String dayonedescrp, String daytwo, String daytwodescrp, String daythree, String daythreedescrp, String dayfour, String dayfourdescrp, String dayfive, String dayfivedescrp, String daysix, String daysixdescrp, String dayseven, String daysevendescrp) {

        TextView mHeaderTv = mView.findViewById(R.id.dHeader);
        TextView mTitleTv = mView.findViewById(R.id.dTitle);
        ImageView mImageIv = mView.findViewById(R.id.dImage);
        TextView mHeaderTit = mView.findViewById(R.id.dHeaderTitle);
        TextView mDetail = mView.findViewById(R.id.dDetail);
        TextView mAdvantage = mView.findViewById(R.id.dAdvantage);
        TextView mAdvatageDescrp = mView.findViewById( R.id.dAdvatgeDetail);
        TextView mDayOne = mView.findViewById( R.id.dDayOne);
        TextView mDayOneDescrp = mView.findViewById( R.id.dDayOneDetail);
        TextView mDayTwo = mView.findViewById( R.id.dDayTwo);
        TextView mDayTwoDescrp = mView.findViewById( R.id.dDayTwoDetail);
        TextView mDayThree = mView.findViewById( R.id.dDayThree);
        TextView mDayThreeDescrp = mView.findViewById( R.id.dDayThreeDetail);
        TextView mDayFour = mView.findViewById( R.id.dDayFour);
        TextView mDayFourDescrp = mView.findViewById( R.id.dDayFourDetail);
        TextView mDayFive = mView.findViewById( R.id.dDayFive);
        TextView mDayFiveDescrp = mView.findViewById( R.id.dDayFiveDetail);
        TextView mDaySix = mView.findViewById( R.id.dDaySix);
        TextView mDaySixDescrp = mView.findViewById( R.id.dDaySixDetail);
        TextView mDaySeven = mView.findViewById( R.id.dDaySeven);
        TextView mDaySevenDescrp = mView.findViewById( R.id.dDaySevenDetail);

        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        Picasso.get().load(image).into(mImageIv);
        mHeaderTit.setText(headertit);
        mDetail.setText(description);
        mAdvantage.setText(advantage);
        mAdvatageDescrp.setText(advantagedescrp);
        mDayOne.setText(dayone);
        mDayOneDescrp.setText(dayonedescrp);
        mDayTwo.setText(daytwo);
        mDayTwoDescrp.setText(daytwodescrp);
        mDayThree.setText(daythree);
        mDayThreeDescrp.setText(daythreedescrp);
        mDayFour.setText(dayfour);
        mDayFourDescrp.setText(dayfourdescrp);
        mDayFive.setText(dayfive);
        mDayFiveDescrp.setText(dayfivedescrp);
        mDaySix.setText(daysix);
        mDaySixDescrp.setText(daysixdescrp);
        mDaySeven.setText(dayseven);
        mDaySevenDescrp.setText(daysevendescrp);
    }
}
