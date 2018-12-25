package com.example.ky4910.kynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ky4910.kynews.utils.TabFactory;

import java.util.List;

/**
 * Created by ky4910 on 2018/12/12.
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    private List<String> mTabTitles;
    private String[] titleNames = {"要闻", "财经", "娱乐"};

    public MyFragmentAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.mTabTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TabFactory.mTabFragment.get(0);
            case 1:
                return TabFactory.mTabFragment.get(1);
            case 2:
                return TabFactory.mTabFragment.get(2);
        }
        return TabFactory.mTabFragment.get(0);
    }

    @Override
    public int getCount() {
        return mTabTitles.size();
    }

    // 最好重写，否则TabLayout的setupWithViewPager可能将tab删除掉。
    // 具体参见https://blog.csdn.net/Ivenes/article/details/60133099
    @Override
    public CharSequence getPageTitle(int position) {
        return titleNames[position];
    }
}
