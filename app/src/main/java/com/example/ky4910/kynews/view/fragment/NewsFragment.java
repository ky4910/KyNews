package com.example.ky4910.kynews.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment{

    TabLayout tabLayout;
    ViewPager viewPager;

    private PagerAdapter pagerAdapter;
    private List<String> newTypes = new ArrayList<>();

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
        return inflater.inflate(R.layout.fragment_news, container, false);
    }
}
