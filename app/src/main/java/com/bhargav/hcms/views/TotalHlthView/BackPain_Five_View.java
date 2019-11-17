package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;

public class BackPain_Five_View extends RecyclerView.ViewHolder {

    View mView;

    public BackPain_Five_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String title, String description) {

        TextView mTitleTv = mView.findViewById(R.id.Title);
        TextView mDetailTv = mView.findViewById(R.id.Description);

        mTitleTv.setText(title);
        mDetailTv.setText(description);
    }
}
