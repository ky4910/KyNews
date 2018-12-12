package com.example.ky4910.kynews;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ky4910.kynews.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager viewPager;
    private List<String> tabNameList = new ArrayList<>();
    private List<Fragment> newsFragments = new ArrayList<>();

    //the news item titles
    private String[] titleNames = {"要闻", "财经", "娱乐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabTitle();
        initViews();

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), tabNameList));
        mTab.setupWithViewPager(viewPager);
    }

    protected void initViews() {
        this.viewPager = (ViewPager)findViewById(R.id.vp_content);
        this.mTab = (TabLayout)findViewById(R.id.tl_tabs);
    }

    protected void initTabTitle() {
        for (int i = 0; i < titleNames.length; i++) {
            tabNameList.add(String.format(Locale.CHINA, titleNames[i]));
        }
    }

}
