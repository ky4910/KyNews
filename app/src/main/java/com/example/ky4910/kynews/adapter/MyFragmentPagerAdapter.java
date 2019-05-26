package com.example.ky4910.kynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ky4910.kynews.view.fragment.NewsListFragment;

import java.util.List;

/**
 * Created by ky4910 on 2018/12/12.
 */

//The adapter for ViewPager
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mTabTitles;
    private List<NewsListFragment> mFragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<String> titles, List<NewsListFragment> fragments) {
        super(fm);
        this.mTabTitles = titles;
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTabTitles.size();
    }

    // 最好重写，否则TabLayout的setupWithViewPager可能将tab删除掉。
    // 具体参见https://blog.csdn.net/Ivenes/article/details/60133099
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }
}
