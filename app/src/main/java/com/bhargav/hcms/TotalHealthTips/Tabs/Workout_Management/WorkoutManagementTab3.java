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
import com.bhargav.hcms.models.TotalHlthModels.ModelWorkOutMgmt_Three;
import com.bhargav.hcms.views.TotalHlthView.WorkOut_Three_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 06-07-2018.
 */

public class WorkoutManagementTab3 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WorkoutManagementTab3() {

    }

    public static WorkoutManagementTab3 newInstance(String param1, String param2) {
        WorkoutManagementTab3 fragment = new WorkoutManagementTab3();
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
        View view = inflater.inflate(R.layout.workoutmanagementfragment_tab3, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Workout Managemen").child("Work out 3");

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
        FirebaseRecyclerAdapter<ModelWorkOutMgmt_Three, WorkOut_Three_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelWorkOutMgmt_Three, WorkOut_Three_View>(
                        ModelWorkOutMgmt_Three.class,
                        R.layout.workout_mgt_three_list,
                        WorkOut_Three_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(WorkOut_Three_View workOut_three_view, ModelWorkOutMgmt_Three modelWorkOutMgmt_three, int i) {
                        workOut_three_view.setDetails(getActivity(), modelWorkOutMgmt_three.getHeader(), modelWorkOutMgmt_three.getTitle(), modelWorkOutMgmt_three.getDescription(), modelWorkOutMgmt_three.getDescription1(), modelWorkOutMgmt_three.getDescription2(), modelWorkOutMgmt_three.getDescription3(), modelWorkOutMgmt_three.getDescription4(), modelWorkOutMgmt_three.getDescription5(), modelWorkOutMgmt_three.getDescription6(), modelWorkOutMgmt_three.getDescription7(), modelWorkOutMgmt_three.getDescription8(), modelWorkOutMgmt_three.getDescription9(), modelWorkOutMgmt_three.getDescription10());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WorkoutManagementTab3.OnFragmentInteractionListener) {
            mListener = (WorkoutManagementTab3.OnFragmentInteractionListener) context;
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
