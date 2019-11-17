package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Growth.HairGrowthTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Growth.HairGrowthTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Growth.HairGrowthTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Growth.HairGrowthTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Growth.HairGrowthTab5;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class HairGrowthPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public HairGrowthPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                HairGrowthTab1 tab1 = new HairGrowthTab1();
                return tab1;
            case 1:
                HairGrowthTab2 tab2 = new HairGrowthTab2();
                return tab2;
            case 2:
                HairGrowthTab3 tab3 = new HairGrowthTab3();
                return tab3;
            case 3:
                HairGrowthTab4 tab4 = new HairGrowthTab4();
                return tab4;
            case 4:
                HairGrowthTab5 tab5 = new HairGrowthTab5();
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
