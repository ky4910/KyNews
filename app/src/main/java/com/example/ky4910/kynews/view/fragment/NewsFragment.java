package com.example.ky4910.kynews.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.NewsFragmentPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFragment extends Fragment{

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private PagerAdapter pagerAdapter;

    //tab titles
    private final int[] TAB_TITLES = new int[]{R.string.mainNews, R.string.sportsNews, R.string.techNews};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        newTypes.add("要闻");
        newTypes.add("娱乐");
        newTypes.add("财经");

        pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), newTypes, mTabFragment);
        viewPager.setAdapter(pagerAdapter);
        */
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);

        initPager();
        setTabs(tabLayout, getLayoutInflater(), TAB_TITLES);

        return view;
    }

    private void initPager() {
        pagerAdapter = new NewsFragmentPageAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //取消平滑切换
                viewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitles){
        for (int i = 0; i < tabTitles.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.item_main_menu, null);
            tab.setCustomView(view);

            TextView tvTitle = view.findViewById(R.id.txt_tab);
            tvTitle.setText(tabTitles[i]);
            tabLayout.addTab(tab);
        }
    }
}



/*
    private void initPager() {
        pagerAdapter = new NewsFragmentPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //取消平滑切换
                viewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitles, int[] tabImages){
        for (int i = 0; i < tabImages.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.item_main_menu, null);
            tab.setCustomView(view);

            TextView tvTitle = (TextView)view.findViewById(R.id.txt_tab);
            tvTitle.setText(tabTitles[i]);
            ImageView imgTab = (ImageView)view.findViewById(R.id.img_tab);
            imgTab.setImageResource(tabImages[i]);
            tabLayout.addTab(tab);
        }
    }

    protected void initViews() {
        //create tab and pager fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.container, new NewsTabAndPagerFragment()).commit();
    }
}
*/
