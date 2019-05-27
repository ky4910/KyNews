package com.example.ky4910.kynews;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ky4910.kynews.view.fragment.NewsFragment;
import com.example.ky4910.kynews.view.fragment.PersonFragment;
import com.example.ky4910.kynews.view.fragment.VideoFragment;


public class MainActivity extends AppCompatActivity {

    // GET/POST URL => http://localhost:8090/KimDemo-0.0.1-SNAPSHOT/test/mynews/all

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //防止第一次进入page里内容
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new NewsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.menu_news:
                            selectedFragment = new NewsFragment();
                            break;
                        case R.id.menu_videos:
                            selectedFragment = new VideoFragment();
                            break;
                        case R.id.menu_person:
                            selectedFragment = new PersonFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}


/*
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
*/

