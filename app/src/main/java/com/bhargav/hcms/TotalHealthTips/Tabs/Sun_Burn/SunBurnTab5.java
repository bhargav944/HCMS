package com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn;

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
import com.bhargav.hcms.models.TotalHlthModels.ModelSunBurn_Four_Five;
import com.bhargav.hcms.views.TotalHlthView.SunBurn_Four_Five_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class SunBurnTab5 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SunBurnTab5() {

    }

    public static SunBurnTab5 newInstance(String param1, String param2) {
        SunBurnTab5 fragment = new SunBurnTab5();
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
        View view = inflater.inflate(R.layout.sunburnfragment_tab5, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Sun Burn").child("Sun Burn 5");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelSunBurn_Four_Five, SunBurn_Four_Five_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelSunBurn_Four_Five, SunBurn_Four_Five_View>(
                        ModelSunBurn_Four_Five.class,
                        R.layout.sunburn_four_five_list,
                        SunBurn_Four_Five_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(SunBurn_Four_Five_View sunBurn_four_five_view, ModelSunBurn_Four_Five modelSunBurn_four_five, int i) {
                        sunBurn_four_five_view.setDetails(getActivity(),modelSunBurn_four_five.getImage(), modelSunBurn_four_five.getHeader(), modelSunBurn_four_five.getTitle(), modelSunBurn_four_five.getDetail1(), modelSunBurn_four_five.getDetail2(), modelSunBurn_four_five.getDetail3());
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
        if (context instanceof SunBurnTab5.OnFragmentInteractionListener) {
            mListener = (SunBurnTab5.OnFragmentInteractionListener) context;
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
