package com.bhargav.hcms.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bhargav.hcms.Alarms;
import com.bhargav.hcms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmLandingPageFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_alarm_landing_page, container, false);

        final Button launchMainActivityBtn = (Button) v.findViewById(R.id.load_main_activity_btn);
        final Button dismiss = (Button) v.findViewById(R.id.dismiss_btn);

        launchMainActivityBtn.setOnClickListener(this);
        dismiss.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.load_main_activity_btn:
                startActivity(new Intent(getContext(), Alarms.class));
                getActivity().finish();
                break;
            case R.id.dismiss_btn:
                getActivity().finish();
                break;
        }

    }

}
