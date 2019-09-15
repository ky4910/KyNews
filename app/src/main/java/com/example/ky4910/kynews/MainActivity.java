package com.example.ky4910.kynews;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ky4910.kynews.view.fragment.NewsFragment;
import com.example.ky4910.kynews.view.fragment.MusicFragment;
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

//                        case R.id.menu_person:
//                            selectedFragment = new MusicFragment();
//                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}


