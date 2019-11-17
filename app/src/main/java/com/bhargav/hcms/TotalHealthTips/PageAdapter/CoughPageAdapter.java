package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Cold_Cough.CoughTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Cold_Cough.CoughTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Cold_Cough.CoughTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Cold_Cough.CoughTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Cold_Cough.CoughTab5;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class CoughPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public CoughPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                CoughTab1 tab1 = new CoughTab1();
                return tab1;
            case 1:
                CoughTab2 tab2 = new CoughTab2();
                return tab2;
            case 2:
                CoughTab3 tab3 = new CoughTab3();
                return tab3;
            case 3:
                CoughTab4 tab4 = new CoughTab4();
                return tab4;
            case 4:
                CoughTab5 tab5 = new CoughTab5();
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
