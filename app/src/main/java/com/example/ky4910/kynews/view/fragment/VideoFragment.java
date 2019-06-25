package com.example.ky4910.kynews.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import java.util.List;

public class VideoFragment extends Fragment {

    private View view;
    RecyclerView recyclerView;
    VideoRvAdapter videoAdapter;
    public List<VideoBean.TrailersBean> trailersBeanList;

    public VideoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_videos, container,false);
        initVideoData();
        return view;
    }

    public void initVideoData() {
        String filename = "VideoInfoList.json";
        InputStream inputStream = null;
        try {
            inputStream = getResources().getAssets().open(filename);
            String videoData = convertStreamToString(inputStream);
            Gson gson = new Gson();
            VideoBean videoBean = gson.fromJson(videoData, VideoBean.class);
            trailersBeanList = videoBean.getTrailers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("kimber", "count is " + trailersBeanList.size());
        for (VideoBean.TrailersBean trailer: trailersBeanList) {
            Log.e("kimber", "ID: " + trailer.getId() +
                    " movieName: " + trailer.getMovieName() +
                    " videoTitle: " + trailer.getVideoTitle());
        }
        recyclerView = view.findViewById(R.id.video_rv);
        videoAdapter = new VideoRvAdapter(getContext(), trailersBeanList);
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
