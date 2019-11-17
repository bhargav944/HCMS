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

import com.bhargav.hcms.R;
import com.bhargav.hcms.models.TotalHlthModels.ModelDietThree;
import com.bhargav.hcms.views.TotalHlthView.DietThreeView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 05-07-2018.
 */

public class DietTab3 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DietTab3() {

    }

    public static DietTab3 newInstance(String param1, String param2) {
        DietTab3 fragment = new DietTab3();
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
        View view = inflater.inflate(R.layout.dietfragment_tab3, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Diet Plan").child("Diet 3");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelDietThree, DietThreeView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelDietThree, DietThreeView>(
                        ModelDietThree.class,
                        R.layout.dietthree_list,
                        DietThreeView.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(DietThreeView dietThreeView, ModelDietThree modelDietThree, int i) {
                        dietThreeView.setDetails(getActivity(),modelDietThree.getImage(), modelDietThree.getHeader(), modelDietThree.getTitle(), modelDietThree.getDayone(), modelDietThree.getDayonedetail(), modelDietThree.getDaytwo(), modelDietThree.getDaytwodetail(), modelDietThree.getDaythree(), modelDietThree.getDaythreedetail());
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
        if (context instanceof DietTab3.OnFragmentInteractionListener) {
            mListener = (DietTab3.OnFragmentInteractionListener) context;
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