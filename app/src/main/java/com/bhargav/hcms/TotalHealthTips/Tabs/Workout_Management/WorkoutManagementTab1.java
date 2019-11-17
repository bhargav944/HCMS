package com.bhargav.hcms.TotalHealthTips.Tabs.Workout_Management;

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
import com.bhargav.hcms.models.TotalHlthModels.ModelWorkOutMgmt_One_Two;
import com.bhargav.hcms.views.TotalHlthView.WorkOut_One_Two_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 06-07-2018.
 */

public class WorkoutManagementTab1 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WorkoutManagementTab1() {

    }

    public static WorkoutManagementTab1 newInstance(String param1, String param2) {
        WorkoutManagementTab1 fragment = new WorkoutManagementTab1();
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
        View view = inflater.inflate(R.layout.workoutmanagementfragment_tab1, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Workout Managemen").child("Work out 1");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelWorkOutMgmt_One_Two, WorkOut_One_Two_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelWorkOutMgmt_One_Two, WorkOut_One_Two_View>(
                        ModelWorkOutMgmt_One_Two.class,
                        R.layout.workout_mgt_one_two_list,
                        WorkOut_One_Two_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(WorkOut_One_Two_View workOut_one_two_view, ModelWorkOutMgmt_One_Two modelWorkOutMgmt_one_two, int i) {
                        workOut_one_two_view.setDetails(getActivity(), modelWorkOutMgmt_one_two.getTitle1(), modelWorkOutMgmt_one_two.getDetail1(), modelWorkOutMgmt_one_two.getTitle2(), modelWorkOutMgmt_one_two.getDetail2(), modelWorkOutMgmt_one_two.getTitle3(), modelWorkOutMgmt_one_two.getDetail3(), modelWorkOutMgmt_one_two.getTitle4(), modelWorkOutMgmt_one_two.getDetail4(), modelWorkOutMgmt_one_two.getTitle5(), modelWorkOutMgmt_one_two.getDetail5(), modelWorkOutMgmt_one_two.getTitle6(), modelWorkOutMgmt_one_two.getDetail6(), modelWorkOutMgmt_one_two.getTitle7(), modelWorkOutMgmt_one_two.getDetail7());
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
        if (context instanceof WorkoutManagementTab1.OnFragmentInteractionListener) {
            mListener = (WorkoutManagementTab1.OnFragmentInteractionListener) context;
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
