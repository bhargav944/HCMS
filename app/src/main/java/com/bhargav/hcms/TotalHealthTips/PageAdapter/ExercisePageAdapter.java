package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Exercise.ExerciseTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Exercise.ExerciseTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Exercise.ExerciseTab3;

/**
 * Created by Gurramkonda Bhargav on 06-07-2018.
 */

public class ExercisePageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public ExercisePageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                ExerciseTab1 tab1 = new ExerciseTab1();
                return tab1;
            case 1:
                ExerciseTab2 tab2 = new ExerciseTab2();
                return  tab2;
            case 2:
                ExerciseTab3 tab3 = new ExerciseTab3();
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
