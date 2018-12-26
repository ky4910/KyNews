package com.example.ky4910.kynews.view.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.base.BaseFragment;
import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.NewsRecyclerAdapter;
import com.example.ky4910.kynews.model.entity.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ky4910 on 2018/11/15.
 */

public class FrontpageFragment extends BaseFragment {

    private View view;
    private RecyclerView frontpageRecyclerView;
    private NewsRecyclerAdapter mNewsRecyclerAdapter;
    private List<News> newsEntityList = new ArrayList<News>();

    public FrontpageFragment() {}

    public static FrontpageFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        FrontpageFragment frontpageFragment =  new FrontpageFragment();
        frontpageFragment.setArguments(bundle);
        return frontpageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_front, container, false);
        initRecyclerView();
        initData();
        return view;
    }

    private void initRecyclerView() {
        frontpageRecyclerView = (RecyclerView)view.findViewById(R.id.recycle_front);
        mNewsRecyclerAdapter = new NewsRecyclerAdapter(newsEntityList);
        frontpageRecyclerView.setAdapter(mNewsRecyclerAdapter);
        frontpageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        frontpageRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(4, 4, 4, 4);
            }
        });
    }

    //String id, String title, String content, String channel, int imgsrc

    private void initData() {
        News sampleNews1 = new News("1", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews1);
        News sampleNews2 = new News("2", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews2);
        News sampleNews3 = new News("3", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews3);
        News sampleNews4 = new News("4", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews4);
        News sampleNews5 = new News("5", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews5);
        News sampleNews6 = new News("6", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews6);
        News sampleNews7 = new News("7", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews7);
        News sampleNews8 = new News("8", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews8);
        News sampleNews9 = new News("9", "Nothing happen!", "abcdef", "Front Page", R.drawable.list_48dp);
        newsEntityList.add(sampleNews9);
    }

}
