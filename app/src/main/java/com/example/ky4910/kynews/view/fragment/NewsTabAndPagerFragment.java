package com.example.ky4910.kynews.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.MyFragmentPagerAdapter;
import com.example.ky4910.kynews.utils.ChannelFactory;
import com.example.ky4910.kynews.utils.TabFactory;

import java.util.ArrayList;
import java.util.List;

/*  Fragment有两个不同的package。一个是系统内置的android.app.Fragment,
    另一个是support-v4库中的android.support.v4.app.Fragment。强烈建议使用support-v4库中的Fragment，
    因为它可以让碎片在所有Android系统版本中保持功能一致性。比如，Fragment中嵌套使用Fragment是
    在Android4.2系统中才开始支持的，Android4.2之前的系统内置Fragment不支持这样的操作。
 */

public class NewsTabAndPagerFragment extends Fragment {

    private List<String> mTabTitles = new ArrayList<>();
    private List<NewsListFragment> mFragmentList = new ArrayList<>();
    private ViewPager mPager;
    private MyFragmentPagerAdapter fragmentPagerAdapter;
    private TabLayout mTabLayout;

    //Fragment => onCreate VS onCreateView
    // onCreate     创建该fragment类似于Activity.onCreate，可以在其中初始化除了view之外的东西
    // onCreateView 创建该fragment对应的视图,必须在这里创建自己的视图并返回给调用者

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadTabTitles();
        loadNewsChannels();
    }

    private void loadTabTitles(){
        mTabTitles.addAll(TabFactory.mNewsTabTitles);
    }

    private void loadNewsChannels(){
        mFragmentList.addAll(ChannelFactory.mTabFragment);
        loadFragments();
    }

    private void loadFragments() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_and_pager, viewGroup, false);
        mTabLayout = view.findViewById(R.id.tl_tabs);
        mPager = view.findViewById(R.id.vp_content);
        mTabLayout.setupWithViewPager(mPager);
        mPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), mTabTitles, mFragmentList));
        return view;
    }
}
