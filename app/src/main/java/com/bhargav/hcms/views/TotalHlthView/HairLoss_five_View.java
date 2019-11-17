package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class HairLoss_five_View extends RecyclerView.ViewHolder {

    View mView;

    public HairLoss_five_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String description) {

        ImageView mImageIv = mView.findViewById(R.id.ImageView);
        TextView mHeaderTv = mView.findViewById(R.id.Header);
        TextView mTitleTv = mView.findViewById(R.id.Title);
        TextView mDescriptionTv = mView.findViewById(R.id.Description);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDescriptionTv.setText(description);
    }
}
