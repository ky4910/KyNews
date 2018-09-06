package com.example.ky4910.kynews;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolBar = (Toolbar)findViewById(R.id.tool_Bar);
        toolBar.setTitle("极速新闻");
        setSupportActionBar(toolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        return super.onCreateOptionsMenu(menu);
    }
}
