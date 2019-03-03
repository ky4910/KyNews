package com.example.ky4910.kynews;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ky4910.kynews.adapter.MyFragmentAdapter;
import com.example.ky4910.kynews.utils.TabFactory;
import com.example.ky4910.kynews.view.fragment.NewsListFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // GET/POST URL => http://localhost:8090/KimDemo-0.0.1-SNAPSHOT/test/mynews/all

    private TabLayout mTab;
    private ViewPager viewPager;
    private List<NewsListFragment> mFragments = new ArrayList<>();
    private List<String> mTabTitles = new ArrayList<>();

    //the news item titles
    private String[] titleNames = {"要闻", "财经", "娱乐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTabTitles.add("要闻");
//        mTabTitles.add("财经");
//        mTabTitles.add("娱乐");

        initTabTitle();
        initViews();

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), mTabTitles, TabFactory.mTabFragment));
        mTab.setupWithViewPager(viewPager);
    }

    protected void initViews() {
        this.viewPager = findViewById(R.id.vp_content);
        this.mTab = findViewById(R.id.tl_tabs);
    }

    protected void initTabTitle() {
        for (int i = 0; i < titleNames.length; i++) {
            mTabTitles.add(String.format(Locale.CHINA, titleNames[i]));
        }
    }
}
