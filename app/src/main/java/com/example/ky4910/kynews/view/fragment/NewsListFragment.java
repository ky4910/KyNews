package com.example.ky4910.kynews.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.NewsRecyclerViewAdapter;
import com.example.ky4910.kynews.model.entity.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class NewsListFragment extends Fragment {

    private View mFragmentView;
    private RecyclerView mRecyclerView;
    private NewsRecyclerViewAdapter recyclerViewAdapter;

    public NewsListFragment() {}

    //创建一个新闻类型Fragment的时候为其赋值新闻类型id(tabId)
    public static NewsListFragment newInstance(String newsType) {
        Bundle bundle = new Bundle();
        bundle.putString("newType", newsType);
        NewsListFragment newsListFragment =  new NewsListFragment();
        newsListFragment.setArguments(bundle);
        return newsListFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_news_list, null);
        //initView(mFragmentView);
        return mFragmentView;
    }

    public void initView(View view) {
        List<NewsBean.DataBean.ListBean> listBean = new ArrayList<>();
        initTestData(listBean);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAdapter = new NewsRecyclerViewAdapter(listBean);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    public void initTestData(List<NewsBean.DataBean.ListBean> listBeans) {
        listBeans.add(new NewsBean.DataBean.ListBean(null, "新华社", null, null, null, null, 0, 0, 123));
        listBeans.add(new NewsBean.DataBean.ListBean(null, "阿斯报", null, null, null, null, 0, 0, 754));
        listBeans.add(new NewsBean.DataBean.ListBean(null, "泰晤士", null, null, null, null, 0, 0, 945));
        listBeans.add(new NewsBean.DataBean.ListBean(null, "经济学人", null, null, null, null, 0, 0, 745));
        listBeans.add(new NewsBean.DataBean.ListBean(null, "镜报", null, null, null, null, 0, 0, 956));
        listBeans.add(new NewsBean.DataBean.ListBean(null, "卫报", null, null, null, null, 0, 0, 148));
        listBeans.add(new NewsBean.DataBean.ListBean(null, "太阳报", null, null, null, null, 0, 0, 658));
    }
}

