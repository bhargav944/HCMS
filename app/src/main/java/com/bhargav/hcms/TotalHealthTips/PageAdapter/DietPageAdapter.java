package com.bhargav.hcms.TotalHealthTips.PageAdapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Diet_Plan.DietTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Diet_Plan.DietTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Diet_Plan.DietTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Diet_Plan.DietTab4;

/**
 * Created by Gurramkonda Bhargav on 05-07-2018.
 */

public class DietPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public DietPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                DietTab1 tab1 = new DietTab1();
                return tab1;
            case 1:
                DietTab2 tab2 = new DietTab2();
                return  tab2;
            case 2:
                DietTab3 tab3 = new DietTab3();
                return  tab3;
            case 3:
                DietTab4 tab4 = new DietTab4();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
