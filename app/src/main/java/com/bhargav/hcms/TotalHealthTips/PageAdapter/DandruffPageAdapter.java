package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Dandruff.DandruffTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Dandruff.DandruffTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Dandruff.DandruffTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Dandruff.DandruffTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Dandruff.DandruffTab5;

/**
 * Created by Gurramkonda Bhargav on 07-07-2018.
 */

public class DandruffPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public DandruffPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                DandruffTab1 tab1 = new DandruffTab1();
                return tab1;
            case 1:
                DandruffTab2 tab2 = new DandruffTab2();
                return tab2;
            case 2:
                DandruffTab3 tab3 = new DandruffTab3();
                return tab3;
            case 3:
                DandruffTab4 tab4 = new DandruffTab4();
                return tab4;
            case 4:
                DandruffTab5 tab5 = new DandruffTab5();
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
