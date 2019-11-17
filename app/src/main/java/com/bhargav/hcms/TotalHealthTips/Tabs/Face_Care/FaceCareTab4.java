package com.bhargav.hcms.TotalHealthTips.Tabs.Face_Care;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.R;
import com.bhargav.hcms.models.TotalHlthModels.ModelFaceCare_three_four_five;
import com.bhargav.hcms.views.TotalHlthView.FaceCare_three_four_five_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 07-07-2018.
 */

public class FaceCareTab4 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FaceCareTab4() {

    }

    public static FaceCareTab4 newInstance(String param1, String param2) {
        FaceCareTab4 fragment = new FaceCareTab4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.facecarefragment_tab4, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Face Care").child("Face Care 4");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelFaceCare_three_four_five, FaceCare_three_four_five_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelFaceCare_three_four_five, FaceCare_three_four_five_View>(
                        ModelFaceCare_three_four_five.class,
                        R.layout.facecare_three_four_five_list,
                        FaceCare_three_four_five_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(FaceCare_three_four_five_View faceCare_three_four_five_view, ModelFaceCare_three_four_five modelFaceCare_three_four_five, int i) {
                        faceCare_three_four_five_view.setDetails(getActivity(),modelFaceCare_three_four_five.getImage(), modelFaceCare_three_four_five.getHeader(), modelFaceCare_three_four_five.getTitle(), modelFaceCare_three_four_five.getDescription(), modelFaceCare_three_four_five.getDescription1(), modelFaceCare_three_four_five.getDescription2(), modelFaceCare_three_four_five.getDescription3());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FaceCareTab4.OnFragmentInteractionListener) {
            mListener = (FaceCareTab4.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
