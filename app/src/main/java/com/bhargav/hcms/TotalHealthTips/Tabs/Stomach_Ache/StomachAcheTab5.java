package com.bhargav.hcms.TotalHealthTips.Tabs.Stomach_Ache;

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
import com.bhargav.hcms.models.TotalHlthModels.ModelStomachAche_Five;
import com.bhargav.hcms.views.TotalHlthView.StomachAche_Five_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class StomachAcheTab5 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StomachAcheTab5() {

    }

    public static StomachAcheTab5 newInstance(String param1, String param2) {
        StomachAcheTab5 fragment = new StomachAcheTab5();
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
        View view = inflater.inflate(R.layout.stomachachefragment_tab5, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Stomach Ache").child("Stomach Ache 5");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelStomachAche_Five, StomachAche_Five_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelStomachAche_Five, StomachAche_Five_View>(
                        ModelStomachAche_Five.class,
                        R.layout.stomachache_five_list,
                        StomachAche_Five_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(StomachAche_Five_View stomachAche_five_view, ModelStomachAche_Five modelStomachAche_five, int i) {
                        stomachAche_five_view.setDetails(getActivity(),modelStomachAche_five.getImage(), modelStomachAche_five.getHeader(), modelStomachAche_five.getTitle(), modelStomachAche_five.getDescription(), modelStomachAche_five.getDescription1(), modelStomachAche_five.getDescription2());
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
        if (context instanceof StomachAcheTab5.OnFragmentInteractionListener) {
            mListener = (StomachAcheTab5.OnFragmentInteractionListener) context;
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
