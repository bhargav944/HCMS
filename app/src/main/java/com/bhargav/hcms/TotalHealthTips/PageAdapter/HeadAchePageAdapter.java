package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab5;

/**
 * Created by Gurramkonda Bhargav on 09-07-2018.
 */

public class HeadAchePageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public HeadAchePageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                HeadAcheTab1 tab1 = new HeadAcheTab1();
                return tab1;
            case 1:
                HeadAcheTab2 tab2 = new HeadAcheTab2();
                return tab2;
            case 2:
                HeadAcheTab3 tab3 = new HeadAcheTab3();
                return tab3;
            case 3:
                HeadAcheTab4 tab4 = new HeadAcheTab4();
                return tab4;
            case 4:
                HeadAcheTab5 tab5 = new HeadAcheTab5();
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
