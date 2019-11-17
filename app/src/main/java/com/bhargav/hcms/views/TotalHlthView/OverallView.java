package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class OverallView extends RecyclerView.ViewHolder {

    View mView;

    public OverallView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String title, String description) {

        ImageView mImageIv = mView.findViewById(R.id.ImageView);
        TextView mTitleTv = mView.findViewById(R.id.Title);
        TextView mDetailTv = mView.findViewById(R.id.Description);

        Picasso.get().load(image).into(mImageIv);
        mTitleTv.setText(title);
        mDetailTv.setText(description);
    }
}
