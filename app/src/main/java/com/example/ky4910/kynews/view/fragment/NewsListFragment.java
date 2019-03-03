package com.example.ky4910.kynews.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.kynews.R;

public class NewsListFragment extends Fragment {

    public NewsListFragment() {}

    //创建一个新闻类型Fragment的时候为其赋值新闻类型id(tabId)
    public static NewsListFragment newInstance(String newsType) {
        Bundle bundle = new Bundle();
        bundle.putString("newType", newsType);
        NewsListFragment newsListFragment =  new NewsListFragment();
        newsListFragment.setArguments(bundle);
        return newsListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_front, null);

        return null;
    }
}
