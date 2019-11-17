package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Stomach_Ache.StomachAcheTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Stomach_Ache.StomachAcheTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Stomach_Ache.StomachAcheTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Stomach_Ache.StomachAcheTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Stomach_Ache.StomachAcheTab5;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class StomachAchePageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public StomachAchePageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                StomachAcheTab1 tab1 = new StomachAcheTab1();
                return tab1;
            case 1:
                StomachAcheTab2 tab2 = new StomachAcheTab2();
                return tab2;
            case 2:
                StomachAcheTab3 tab3 = new StomachAcheTab3();
                return tab3;
            case 3:
                StomachAcheTab4 tab4 = new StomachAcheTab4();
                return tab4;
            case 4:
                StomachAcheTab5 tab5 = new StomachAcheTab5();
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
