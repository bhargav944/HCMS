package com.bhargav.hcms.TotalHealthTips.Tabs.Diet_Plan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhargav.hcms.views.TotalHlthView.DietOneView;
import com.bhargav.hcms.R;
import com.bhargav.hcms.models.TotalHlthModels.ModelDietOne;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 05-07-2018.
 */

public class DietTab1 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DietTab1() {

    }

    public static DietTab1 newInstance(String param1, String param2) {
        DietTab1 fragment = new DietTab1();
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
        View view = inflater.inflate(R.layout.dietfragment_tab1, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Diet Plan").child("Diet 1");

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelDietOne, DietOneView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelDietOne, DietOneView>(
                        ModelDietOne.class,
                        R.layout.dietone_list,
                        DietOneView.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(DietOneView dietOneView, ModelDietOne modelDietOne, int i) {
                        dietOneView.setDetails(getActivity(),modelDietOne.getHeader(), modelDietOne.getTitle(), modelDietOne.getImage(), modelDietOne.getHeadertit(), modelDietOne.getDescription(), modelDietOne.getAdvantage(), modelDietOne.getAdvantagedescrp(), modelDietOne.getDayone(), modelDietOne.getDayonedescrp(), modelDietOne.getDaytwo(), modelDietOne.getDaytwodescrp(), modelDietOne.getDaythree(), modelDietOne.getDaythreedescrp(), modelDietOne.getDayfour(), modelDietOne.getDayfourdescrp(), modelDietOne.getDayfive(), modelDietOne.getDayfivedescrp(), modelDietOne.getDaysix(), modelDietOne.getDaysixdescrp(), modelDietOne.getDayseven(), modelDietOne.getDaysevendescrp());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
