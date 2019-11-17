package com.bhargav.hcms.views.VitaminsView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.squareup.picasso.Picasso;

public class VitaminView extends RecyclerView.ViewHolder {

    View mView;

    public VitaminView(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String image, String header, String title, String description, String functions, String fundescrp, String interactions, String interdescrp, String note, String notedescrp) {

        ImageView mImageIv = mView.findViewById(R.id.rImageVw);
        TextView mHeaderTv = mView.findViewById(R.id.rHeader);
        TextView mTitleTv = mView.findViewById(R.id.rTitle);
        TextView mTitleDetailTv = mView.findViewById(R.id.rTitledes);
        TextView mFunctionTv = mView.findViewById(R.id.rFunc);
        TextView mFunctionDetailTv = mView.findViewById( R.id.rFuncdes);
        TextView mInteractionTv = mView.findViewById( R.id.rInter);
        TextView mInteractionDetailTv = mView.findViewById( R.id.rInterdes);
        TextView mNoteTv = mView.findViewById( R.id.rNote);
        TextView mNoteDetailTv = mView.findViewById( R.id.rNotedes);

        Picasso.get().load(image).into(mImageIv);
        mHeaderTv.setText(header);
        mTitleTv.setText(title);
        mTitleDetailTv.setText(description);
        mFunctionTv.setText(functions);
        mFunctionDetailTv.setText(fundescrp);
        mInteractionTv.setText(interactions);
        mInteractionDetailTv.setText(interdescrp);
        mNoteTv.setText(note);
        mNoteDetailTv.setText(notedescrp);
    }
}
