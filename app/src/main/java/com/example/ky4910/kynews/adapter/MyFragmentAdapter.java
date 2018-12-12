package com.example.ky4910.kynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ky4910.kynews.view.fragment.MainnewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ky4910 on 2018/12/12.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<String> mTabTitles;
//    private ArrayList<Fragment> mNewsFragments;
    private String[] titleNames = {"要闻", "财经", "娱乐"};

    public MyFragmentAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.mTabTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return MainnewsFragment.newInstance(mTabTitles.get(position));
    }

    @Override
    public int getCount() {
        return mTabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleNames[position];
    }
}
