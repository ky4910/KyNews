package com.example.ky4910.kynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ky4910.kynews.view.fragment.NewsFragment;
import com.example.ky4910.kynews.view.fragment.PersonFragment;
import com.example.ky4910.kynews.view.fragment.VideoFragment;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new NewsFragment();
                break;
            case 1:
                fragment = new VideoFragment();
                break;
            case 2:
                fragment = new PersonFragment();
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
