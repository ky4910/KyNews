package com.example.ky4910.kynews.utils;

import com.example.ky4910.base.BaseFragment;
import com.example.ky4910.kynews.view.fragment.EntertainmentFragment;
import com.example.ky4910.kynews.view.fragment.FinanceFragment;
import com.example.ky4910.kynews.view.fragment.MainnewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimberJin on 2018/12/25.
 */

public class TabFactory {

    public final static List<BaseFragment> mTabFragment = new ArrayList<>();

    static {
        mTabFragment.add(MainnewsFragment.newInstance("要闻"));
        mTabFragment.add(FinanceFragment.newInstance("财经"));
        mTabFragment.add(EntertainmentFragment.newInstance("娱乐"));
    }

/*
    public final static List<TabItemModel> mTabItems = new ArrayList<TabItemModel>();
    static {
        mTabItems.add(new TabItemModel(R.drawable.icon_home_normal, R.drawable.icon_home_focus, ResourceUtil.getString(R.string.tab_home)));
        mTabItems.add(new TabItemModel(R.drawable.icon_blog_normal, R.drawable.icon_blog_focus, ResourceUtil.getString(R.string.tab_blog)));
        mTabItems.add(new TabItemModel(R.drawable.icon_recommend_normal, R.drawable.icon_recommend_focus, ResourceUtil.getString(R.string.tab_rec)));
//        mTabItems.add(new TabItemModel(R.drawable.icon_me_normal, R.drawable.icon_me_focus, ResourceUtil.getString(R.string.tab_me)));
    }
*/

}
