package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab5;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class JointPainPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public JointPainPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                JointPainTab1 tab1 = new JointPainTab1();
                return tab1;
            case 1:
                JointPainTab2 tab2 = new JointPainTab2();
                return tab2;
            case 2:
                JointPainTab3 tab3 = new JointPainTab3();
                return tab3;
            case 3:
                JointPainTab4 tab4 = new JointPainTab4();
                return tab4;
            case 4:
                JointPainTab5 tab5 = new JointPainTab5();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
