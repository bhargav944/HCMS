package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Workout_Management.WorkoutManagementTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Workout_Management.WorkoutManagementTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Workout_Management.WorkoutManagementTab3;

/**
 * Created by Gurramkonda Bhargav on 06-07-2018.
 */

public class WorkoutManagementPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public WorkoutManagementPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                WorkoutManagementTab1 tab1 = new WorkoutManagementTab1();
                return tab1;
            case 1:
                WorkoutManagementTab2 tab2 = new WorkoutManagementTab2();
                return  tab2;
            case 2:
                WorkoutManagementTab3 tab3 = new WorkoutManagementTab3();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
