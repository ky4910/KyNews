package com.example.ky4910.kynews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PagerSlidingTabStrip pst;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;

    //the news item titles
    String[] titles = {"要闻", "财经", "娱乐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pst = (PagerSlidingTabStrip)findViewById(R.id.pst);
        viewPager = (ViewPager)findViewById(R.id.pager);

        fragments = new ArrayList<>();
        MainnewsFragment mainnewsFragment = new MainnewsFragment();
        FinanceFragment financeFragment = new FinanceFragment();
        EntertainmentFragment entertainmentFragment = new EntertainmentFragment();

        fragments.add(mainnewsFragment);
        fragments.add(financeFragment);
        fragments.add(entertainmentFragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyPagerAdapter(fragmentManager, titles, fragments));
        viewPager.setCurrentItem(0);
        pst.setViewPager(viewPager);
        pst.setTextSize(30);
    }

    //custom adapter
    class MyPagerAdapter extends FragmentPagerAdapter {
        private String[] titles;
        ArrayList<Fragment> fragments;

        public MyPagerAdapter(FragmentManager fm, String[] titles, ArrayList<Fragment> fragments) {
            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        //set item title
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        //get correct page fragment
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        //fragment count

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
