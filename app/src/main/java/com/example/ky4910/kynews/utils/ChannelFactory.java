package com.example.ky4910.kynews.utils;

import com.example.ky4910.kynews.view.fragment.NewsListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimberJin on 2018/12/25.
 */

public class ChannelFactory {

    public final static List<NewsListFragment> mTabFragment = new ArrayList<>();

    static {
        mTabFragment.add(NewsListFragment.newInstance("要闻"));
        mTabFragment.add(NewsListFragment.newInstance("财经"));
        mTabFragment.add(NewsListFragment.newInstance("娱乐"));
    }
}
