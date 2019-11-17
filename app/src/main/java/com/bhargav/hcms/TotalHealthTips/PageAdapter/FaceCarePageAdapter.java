package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Face_Care.FaceCareTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Face_Care.FaceCareTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Face_Care.FaceCareTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Face_Care.FaceCareTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Face_Care.FaceCareTab5;

/**
 * Created by Gurramkonda Bhargav on 07-07-2018.
 */

public class FaceCarePageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public FaceCarePageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                FaceCareTab1 tab1 = new FaceCareTab1();
                return tab1;
            case 1:
                FaceCareTab2 tab2 = new FaceCareTab2();
                return tab2;
            case 2:
                FaceCareTab3 tab3 = new FaceCareTab3();
                return tab3;
            case 3:
                FaceCareTab4 tab4 = new FaceCareTab4();
                return tab4;
            case 4:
                FaceCareTab5 tab5 = new FaceCareTab5();
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
