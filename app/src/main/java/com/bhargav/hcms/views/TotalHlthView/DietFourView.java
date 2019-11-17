package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class DietFourView extends RecyclerView.ViewHolder {

    View mView;

    public DietFourView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String description, String last) {

        ImageView mImageIv = mView.findViewById(R.id.ImageView);
        TextView mHeaderTv = mView.findViewById(R.id.Header);
        TextView mTitleTv = mView.findViewById(R.id.Title);
        TextView mDescription = mView.findViewById(R.id.Detail);
        TextView mLast = mView.findViewById(R.id.last);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDescription.setText(description);
        mLast.setText(last);
    }
}
