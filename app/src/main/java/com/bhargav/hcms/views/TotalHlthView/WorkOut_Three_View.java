package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;

public class WorkOut_Three_View extends RecyclerView.ViewHolder {

    View mView;

    public WorkOut_Three_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String header, String title, String description, String description1, String description2, String description3, String description4, String description5, String description6, String description7, String description8, String description9, String description10) {

        TextView mHeader = mView.findViewById(R.id.header);
        TextView mTitle = mView.findViewById(R.id.title);
        TextView mDescription = mView.findViewById(R.id.description);
        TextView mDescription1 = mView.findViewById(R.id.description1);
        TextView mDescription2 = mView.findViewById(R.id.description2);
        TextView mDescription3 = mView.findViewById(R.id.description3);
        TextView mDescription4 = mView.findViewById( R.id.description4);
        TextView mDescription5 = mView.findViewById( R.id.description5);
        TextView mDescription6 = mView.findViewById( R.id.description6);
        TextView mDescription7 = mView.findViewById( R.id.description7);
        TextView mDescription8 = mView.findViewById( R.id.description8);
        TextView mDescription9 = mView.findViewById( R.id.description9);
        TextView mDescription10 = mView.findViewById( R.id.description10);

        mHeader.setText(header);
        mTitle.setText(title);
        mDescription.setText(description);
        mDescription1.setText(description1);
        mDescription2.setText(description2);
        mDescription3.setText(description3);
        mDescription4.setText(description4);
        mDescription5.setText(description5);
        mDescription6.setText(description6);
        mDescription7.setText(description7);
        mDescription8.setText(description8);
        mDescription9.setText(description9);
        mDescription10.setText(description10);
    }
}
