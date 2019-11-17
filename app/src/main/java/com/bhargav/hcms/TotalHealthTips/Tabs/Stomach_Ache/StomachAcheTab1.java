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
import com.bhargav.hcms.models.TotalHlthModels.ModelStomachAche_One;
import com.bhargav.hcms.views.TotalHlthView.StomachAche_One_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class StomachAcheTab1 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StomachAcheTab1() {

    }

    public static StomachAcheTab1 newInstance(String param1, String param2) {
        StomachAcheTab1 fragment = new StomachAcheTab1();
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
        View view = inflater.inflate(R.layout.stomachachefragment_tab1, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Stomach Ache").child("Stomach Ache 1");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelStomachAche_One, StomachAche_One_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelStomachAche_One, StomachAche_One_View>(
                        ModelStomachAche_One.class,
                        R.layout.stomachache_one_list,
                        StomachAche_One_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(StomachAche_One_View stomachAche_one_view, ModelStomachAche_One modelStomachAche_one, int i) {
                        stomachAche_one_view.setDetails(getActivity(),modelStomachAche_one.getImage(), modelStomachAche_one.getHeader(), modelStomachAche_one.getTitle(), modelStomachAche_one.getDescription(), modelStomachAche_one.getDescription1(), modelStomachAche_one.getDescription2(), modelStomachAche_one.getDescription3());
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
        if (context instanceof StomachAcheTab1.OnFragmentInteractionListener) {
            mListener = (StomachAcheTab1.OnFragmentInteractionListener) context;
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
