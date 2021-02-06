package com.vimal.dynamicviewpager.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.vimal.dynamicviewpager.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerCustomAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    Fragment fragment = null;

    List<String> tabs = new ArrayList<>();

    public ViewPagerCustomAdapter(FragmentManager fm, List<String> tabs) {
        super(fm);
        this.tabs = tabs;
        this.mNumOfTabs = tabs.size();
    }

    @Override
    public Fragment getItem(int position) {

        for (int i = 0; i < mNumOfTabs ; i++) {
//            if (i==0){
//
//            }else {
                if (i == position) {
                    fragment = MyFragment.newInstance(position);
                    break;
                }
//            }

        }
        return fragment;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


    // this method return the name of tab
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }



}
