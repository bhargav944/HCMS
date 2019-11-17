package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Sun_Burn.SunBurnTab5;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class SunBurnPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public SunBurnPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                SunBurnTab1 tab1 = new SunBurnTab1();
                return tab1;
            case 1:
                SunBurnTab2 tab2 = new SunBurnTab2();
                return tab2;
            case 2:
                SunBurnTab3 tab3 = new SunBurnTab3();
                return tab3;
            case 3:
                SunBurnTab4 tab4 = new SunBurnTab4();
                return tab4;
            case 4:
                SunBurnTab5 tab5 = new SunBurnTab5();
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
