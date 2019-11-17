package com.bhargav.hcms.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class HspView extends RecyclerView.ViewHolder {

    View mView;
    public HspView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx, String title, String description, String image, String phone, String link) {

        TextView mTitleTv = mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);
        TextView mPhoneTv = mView.findViewById(R.id.rPhoneTv);
        TextView mLinkTv = mView.findViewById( R.id.rLinkTv);

        mTitleTv.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageIv);
        mPhoneTv.setText(phone);
        mLinkTv.setText(link);
    }

    private HspView.ClickListener mClickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(HspView.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}
