package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab5;

/**
 * Created by Gurramkonda Bhargav on 07-07-2018.
 */

public class ScarsPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public ScarsPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                ScarsTab1 tab1 = new ScarsTab1();
                return tab1;
            case 1:
                ScarsTab2 tab2 = new ScarsTab2();
                return tab2;
            case 2:
                ScarsTab3 tab3 = new ScarsTab3();
                return tab3;
            case 3:
                ScarsTab4 tab4 = new ScarsTab4();
                return tab4;
            case 4:
                ScarsTab5 tab5 = new ScarsTab5();
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
