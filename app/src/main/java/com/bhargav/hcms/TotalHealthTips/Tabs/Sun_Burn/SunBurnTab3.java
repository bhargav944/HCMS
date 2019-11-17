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
import com.bhargav.hcms.models.TotalHlthModels.ModelSunBurn_One_Three;
import com.bhargav.hcms.views.TotalHlthView.SunBurn_One_Three_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class SunBurnTab3 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SunBurnTab3() {

    }

    public static SunBurnTab3 newInstance(String param1, String param2) {
        SunBurnTab3 fragment = new SunBurnTab3();
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
        View view = inflater.inflate(R.layout.sunburnfragment_tab3, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Sun Burn").child("Sun Burn 3");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelSunBurn_One_Three, SunBurn_One_Three_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelSunBurn_One_Three, SunBurn_One_Three_View>(
                        ModelSunBurn_One_Three.class,
                        R.layout.sunburn_one_three_list,
                        SunBurn_One_Three_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(SunBurn_One_Three_View sunBurn_one_three_view, ModelSunBurn_One_Three modelSunBurn_one_three, int i) {
                        sunBurn_one_three_view.setDetails(getActivity(),modelSunBurn_one_three.getImage(), modelSunBurn_one_three.getHeader(), modelSunBurn_one_three.getTitle(), modelSunBurn_one_three.getDescription1(), modelSunBurn_one_three.getDescription2(), modelSunBurn_one_three.getDescription3(), modelSunBurn_one_three.getDescription4());
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
        if (context instanceof SunBurnTab3.OnFragmentInteractionListener) {
            mListener = (SunBurnTab3.OnFragmentInteractionListener) context;
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
