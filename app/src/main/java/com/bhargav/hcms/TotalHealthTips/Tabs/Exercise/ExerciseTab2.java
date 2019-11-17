package com.bhargav.hcms.TotalHealthTips.Tabs.Exercise;

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
import com.bhargav.hcms.models.TotalHlthModels.ModelExercise;
import com.bhargav.hcms.views.TotalHlthView.ExerciseView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 06-07-2018.
 */

public class ExerciseTab2 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExerciseTab2() {

    }

    public static ExerciseTab2 newInstance(String param1, String param2) {
        ExerciseTab2 fragment = new ExerciseTab2();
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
        View view = inflater.inflate(R.layout.exercisefragment_tab2, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Exercise").child("Exercise 2");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelExercise, ExerciseView> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelExercise, ExerciseView>(
                        ModelExercise.class,
                        R.layout.exercise_overall_list,
                        ExerciseView.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ExerciseView exerciseView, ModelExercise modelExercise, int i) {
                        exerciseView.setDetails(getActivity(),modelExercise.getHeader(), modelExercise.getImage1(), modelExercise.getTitle1(), modelExercise.getDetail1(), modelExercise.getImage2(),modelExercise.getTitle2(), modelExercise.getDetail2(), modelExercise.getImage3(), modelExercise.getTitle3(), modelExercise.getDetail3(), modelExercise.getImage4(), modelExercise.getTitle4(), modelExercise.getDetail4(), modelExercise.getImage5(), modelExercise.getTitle5(), modelExercise.getDetail5());
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
        if (context instanceof ExerciseTab2.OnFragmentInteractionListener) {
            mListener = (ExerciseTab2.OnFragmentInteractionListener) context;
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
