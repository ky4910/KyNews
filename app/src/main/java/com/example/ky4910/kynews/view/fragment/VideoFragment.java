package com.example.ky4910.kynews.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.VideoRvAdapter;
import com.example.ky4910.kynews.model.entity.VideoBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// http://api.m.mtime.cn/PageSubArea/TrailerList.api

public class VideoFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<VideoBean> videoBeanList = new ArrayList<>();
    private VideoRvAdapter videoAdapter;

    public VideoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_videos, container, false);
        recyclerView = view.findViewById(R.id.video_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (videoAdapter == null) {
            videoAdapter = new VideoRvAdapter(this.getActivity(), videoBeanList);
            recyclerView.setAdapter(videoAdapter);
        } else {
            videoAdapter.notifyDataSetChanged();
        }
        recyclerView.setAdapter(videoAdapter);
        return view;
    }

    private void initData() {
        VideoBean bean1 = new VideoBean("《速度与激情:特别行动》曝全新中文预告",
                "http://img5.mtime.cn/mg/2019/06/29/002009.16684021_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/29/mp4/190629004821240734.mp4");
        VideoBean bean2 = new VideoBean("《决战中途岛》预告再现海空激战",
                "http://img5.mtime.cn/mg/2019/06/27/231348.59732586_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/27/mp4/190627231412433967.mp4");
        VideoBean bean3 = new VideoBean("小K领衔新版《霹雳娇娃》帅酷预告",
                "http://img5.mtime.cn/mg/2019/06/27/224744.68512147_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/28/mp4/190628075308350550.mp4");
        VideoBean bean4 = new VideoBean("郑秀文《花椒之味》预告刘德华客串",
                "http://img5.mtime.cn/mg/2019/06/27/225551.29349352_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/27/mp4/190627225613276924.mp4");
        VideoBean bean5 = new VideoBean("张晋《九龙不败》终极预告现飞龙出海",
                "http://img5.mtime.cn/mg/2019/06/27/104144.36321374_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/27/mp4/190627104751316049.mp4");
        VideoBean bean6 = new VideoBean("伊恩麦克莱恩、海伦米伦《优秀的骗子》预告",
                "http://img5.mtime.cn/mg/2019/06/27/104649.48931556_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/27/mp4/190627104816316366.mp4");
        VideoBean bean7 = new VideoBean("《铤而走险》大鹏欧豪雨夜亡命追击",
                "http://img5.mtime.cn/mg/2019/06/21/175640.99146689_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/21/mp4/190621175731672800.mp4");
        VideoBean bean8 = new VideoBean("恐怖喜剧片《准备好了没》发红标预告",
                "http://img5.mtime.cn/mg/2019/06/18/231051.97747383_120X90X4.jpg",
                "http://vfx.mtime.cn/Video/2019/06/18/mp4/190618231303510938.mp4");

        videoBeanList.add(bean1);
        videoBeanList.add(bean2);
        videoBeanList.add(bean3);
        videoBeanList.add(bean4);
        videoBeanList.add(bean5);
        videoBeanList.add(bean6);
        videoBeanList.add(bean7);
        videoBeanList.add(bean8);
    }

    public String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
