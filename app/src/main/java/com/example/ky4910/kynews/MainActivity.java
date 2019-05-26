package com.example.ky4910.kynews;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ky4910.kynews.adapter.MainFragmentAdapter;
import com.example.ky4910.kynews.view.fragment.NewsTabAndPagerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // GET/POST URL => http://localhost:8090/KimDemo-0.0.1-SNAPSHOT/test/mynews/all

    // R.string.XXX, R.drawable.YYY返回类型均为int
    // menu titles
    private final int[] MENU_TITLES= {R.string.news, R.string.videos, R.string.mine};
    //menu icon
    private final int[] MENU_ICONS = {R.drawable.tab_news_selector, R.drawable.tab_video_selector, R.drawable.tab_me_selector};

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initPager();
        setTabs(tabLayout, getLayoutInflater(), MENU_TITLES, MENU_ICONS);

        //initViews();
    }

    private void initPager() {
        pagerAdapter = new MainFragmentAdapter(getSupportFragmentManager());
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
