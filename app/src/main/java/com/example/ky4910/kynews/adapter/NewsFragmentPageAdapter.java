package com.example.ky4910.kynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ky4910.kynews.view.fragment.NewsTypeFragment.SportsNewsFragment;
import com.example.ky4910.kynews.view.fragment.NewsTypeFragment.TechNewsFragment;
import com.example.ky4910.kynews.view.fragment.NewsTypeFragment.MainNewsFragment;

public class NewsFragmentPageAdapter extends FragmentPagerAdapter {

    public NewsFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MainNewsFragment();
                break;
            case 1:
                fragment = new SportsNewsFragment();
                break;
            case 2:
                fragment = new TechNewsFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
