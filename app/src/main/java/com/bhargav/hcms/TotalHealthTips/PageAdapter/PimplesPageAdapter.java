package com.bhargav.hcms.TotalHealthTips.PageAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bhargav.hcms.TotalHealthTips.Tabs.Acne_Pimples.PimplesTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Acne_Pimples.PimplesTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Acne_Pimples.PimplesTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Acne_Pimples.PimplesTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Acne_Pimples.PimplesTab5;

/**
 * Created by Gurramkonda Bhargav on 06-07-2018.
 */

public class PimplesPageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PimplesPageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                PimplesTab1 tab1 = new PimplesTab1();
                return tab1;
            case 1:
                PimplesTab2 tab2 = new PimplesTab2();
                return tab2;
            case 2:
                PimplesTab3 tab3 = new PimplesTab3();
                return tab3;
            case 3:
                PimplesTab4 tab4 = new PimplesTab4();
                return tab4;
            case 4:
                PimplesTab5 tab5 = new PimplesTab5();
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
