package com.example.joker.cosmos_android.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.joker.cosmos_android.Acitvity.Tab1;
import com.example.joker.cosmos_android.Acitvity.Tab2;
import com.example.joker.cosmos_android.Acitvity.Tab3;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fragmentManager;
    private Context context;

    public TabPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.fragmentManager = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
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
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "TAB1";
            case 1:
                return "TAB2";
            case 2:
                return  "TAB3";
            default:
                return null;
        }
    }
}
