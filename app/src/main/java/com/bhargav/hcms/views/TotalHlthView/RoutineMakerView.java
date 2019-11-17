package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class RoutineMakerView extends RecyclerView.ViewHolder {

    View mView;

    public RoutineMakerView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String header, String title, String description, String quads, String quadsdescrp, String functions, String fundescrp) {

        TextView mHeaderTv = mView.findViewById(R.id.rmTitle);
        TextView mTitleTv = mView.findViewById(R.id.rmDescription);
        TextView mTitleDetailTv = mView.findViewById(R.id.rmFollowing);
        TextView mQuadsTv = mView.findViewById(R.id.rmQuads);
        TextView mQuadsDetailTv = mView.findViewById( R.id.rmQuadsDescrp);
        TextView mFunctionTv = mView.findViewById( R.id.rmQuadsDescrp1);
        TextView mFunctionDetailTv = mView.findViewById( R.id.rmQuadsDescrp2);

        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mTitleDetailTv.setText(description);
        mQuadsTv.setText(quads);
        mQuadsDetailTv.setText(quadsdescrp);
        mFunctionTv.setText(functions);
        mFunctionDetailTv.setText(fundescrp);
    }
}
