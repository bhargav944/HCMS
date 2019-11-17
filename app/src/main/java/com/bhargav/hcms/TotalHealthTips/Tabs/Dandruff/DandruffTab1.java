package com.bhargav.hcms.TotalHealthTips.Tabs.Dandruff;

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
import com.bhargav.hcms.models.TotalHlthModels.ModelOverall;
import com.bhargav.hcms.views.TotalHlthView.OverallView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 07-07-2018.
 */

public class DandruffTab1 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DandruffTab1() {

    }

    public static DandruffTab1 newInstance(String param1, String param2) {
        DandruffTab1 fragment = new DandruffTab1();
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
        View view = inflater.inflate(R.layout.dandrufffragment_tab1, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Dandruff").child("Dandruff 1");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelOverall, OverallView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelOverall, OverallView>(
                        ModelOverall.class,
                        R.layout.healthtips_overall_list,
                        OverallView.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(OverallView overallView, ModelOverall modelOverall, int i) {
                        overallView.setDetails(getActivity(),modelOverall.getImage(), modelOverall.getTitle(), modelOverall.getDescription());
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
        if (context instanceof DandruffTab1.OnFragmentInteractionListener) {
            mListener = (DandruffTab1.OnFragmentInteractionListener) context;
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
