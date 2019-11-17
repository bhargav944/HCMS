package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Back_Pain.BackPainTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Back_Pain.BackPainTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Back_Pain.BackPainTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Back_Pain.BackPainTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Back_Pain.BackPainTab5;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class BackPainPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public BackPainPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                BackPainTab1 tab1 = new BackPainTab1();
                return tab1;
            case 1:
                BackPainTab2 tab2 = new BackPainTab2();
                return tab2;
            case 2:
                BackPainTab3 tab3 = new BackPainTab3();
                return tab3;
            case 3:
                BackPainTab4 tab4 = new BackPainTab4();
                return tab4;
            case 4:
                BackPainTab5 tab5 = new BackPainTab5();
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
