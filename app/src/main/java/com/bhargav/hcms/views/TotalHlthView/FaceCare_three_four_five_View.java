package com.bhargav.hcms.views.TotalHlthView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class FaceCare_three_four_five_View extends RecyclerView.ViewHolder {

    View mView;

    public FaceCare_three_four_five_View(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String description, String description1, String description2, String description3) {

        ImageView mImageIv = mView.findViewById(R.id.ImageView);
        TextView mHeaderTv = mView.findViewById(R.id.Header);
        TextView mTitleTv = mView.findViewById(R.id.title);
        TextView mDetailTv = mView.findViewById(R.id.description);
        TextView mDetailTv1 = mView.findViewById(R.id.description1);
        TextView mDetailTv2 = mView.findViewById(R.id.description2);
        TextView mDetailTv3 = mView.findViewById( R.id.description3);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mDetailTv.setText(description);
        mDetailTv1.setText(description1);
        mDetailTv2.setText(description2);
        mDetailTv3.setText(description3);
    }
}
