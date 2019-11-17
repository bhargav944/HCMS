package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Loss.HairlossTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Loss.HairlossTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Loss.HairlossTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Loss.HairlossTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Hair_Loss.HairlossTab5;

/**
 * Created by Gurramkonda Bhargav on 07-07-2018.
 */

public class HairlossPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public HairlossPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                HairlossTab1 tab1 = new HairlossTab1();
                return tab1;
            case 1:
                HairlossTab2 tab2 = new HairlossTab2();
                return tab2;
            case 2:
                HairlossTab3 tab3 = new HairlossTab3();
                return tab3;
            case 3:
                HairlossTab4 tab4 = new HairlossTab4();
                return tab4;
            case 4:
                HairlossTab5 tab5 = new HairlossTab5();
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
