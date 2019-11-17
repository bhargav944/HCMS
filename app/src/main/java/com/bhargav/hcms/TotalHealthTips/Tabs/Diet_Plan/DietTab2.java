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
import com.bhargav.hcms.models.TotalHlthModels.ModelDietTwo;
import com.bhargav.hcms.views.TotalHlthView.DietTwoView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 05-07-2018.
 */

public class DietTab2 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DietTab2() {

    }

    public static DietTab2 newInstance(String param1, String param2) {
        DietTab2 fragment = new DietTab2();
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
        View view = inflater.inflate(R.layout.dietfragment_tab2, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Diet Plan").child("Diet 2");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelDietTwo, DietTwoView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelDietTwo, DietTwoView>(
                        ModelDietTwo.class,
                        R.layout.diettwo_list,
                        DietTwoView.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(DietTwoView dietTwoView, ModelDietTwo modelDietTwo, int i) {
                        dietTwoView.setDetails(getActivity(), modelDietTwo.getImage(), modelDietTwo.getHeader(), modelDietTwo.getTitle(), modelDietTwo.getDescription(), modelDietTwo.getBreakfast(), modelDietTwo.getBreaskfastdescrp(), modelDietTwo.getLunch(), modelDietTwo.getLunchdescrp(), modelDietTwo.getDinner(), modelDietTwo.getDinnerdescrp(), modelDietTwo.getDescrpdinner());
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
        if (context instanceof DietTab2.OnFragmentInteractionListener) {
            mListener = (DietTab2.OnFragmentInteractionListener) context;
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
