package com.bhargav.hcms.TotalHealthTips.Tabs.Back_Pain;

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
import com.bhargav.hcms.models.TotalHlthModels.ModelBackPain_One;
import com.bhargav.hcms.views.TotalHlthView.BackPain_One_View;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class BackPainTab1 extends Fragment {

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BackPainTab1() {

    }

    public static BackPainTab1 newInstance(String param1, String param2) {
        BackPainTab1 fragment = new BackPainTab1();
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
        View view = inflater.inflate(R.layout.backpainfragment_tab1, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Total Health Tips").child("Back Pain").child("Back Pain 1");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ModelBackPain_One, BackPain_One_View> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelBackPain_One, BackPain_One_View>(
                        ModelBackPain_One.class,
                        R.layout.backpain_one_list,
                        BackPain_One_View.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(BackPain_One_View backPain_one_view, ModelBackPain_One modelBackPain_one, int i) {
                        backPain_one_view.setDetails(getActivity(),modelBackPain_one.getHeader(), modelBackPain_one.getTitle1(), modelBackPain_one.getImage1(), modelBackPain_one.getDescription1(), modelBackPain_one.getTitle2(), modelBackPain_one.getImage2(), modelBackPain_one.getDescription2(), modelBackPain_one.getTitle3(), modelBackPain_one.getImage3(), modelBackPain_one.getDescription3(), modelBackPain_one.getTitle4(), modelBackPain_one.getImage4(), modelBackPain_one.getDescription4(), modelBackPain_one.getDescription5(), modelBackPain_one.getDescription6(), modelBackPain_one.getDescription7(), modelBackPain_one.getTitle5(), modelBackPain_one.getImage5(), modelBackPain_one.getDescription8());
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
        if (context instanceof BackPainTab1.OnFragmentInteractionListener) {
            mListener = (BackPainTab1.OnFragmentInteractionListener) context;
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
