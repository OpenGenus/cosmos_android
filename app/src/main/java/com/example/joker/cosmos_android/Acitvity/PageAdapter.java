package com.example.joker.cosmos_android.Acitvity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.joker.cosmos_android.Acitvity.Tab1;
import com.example.joker.cosmos_android.Acitvity.Tab2;
import com.example.joker.cosmos_android.Acitvity.Tab3;

public class PageAdapter extends FragmentPagerAdapter {
    int numofTabs;
    public PageAdapter(FragmentManager fm,int NumofTabs) {
        super(fm);
        this.numofTabs=NumofTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return numofTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "TAB1";
        else if(position==1)
            return "TAB2";
        else
            return "TAB3";
    }
}
