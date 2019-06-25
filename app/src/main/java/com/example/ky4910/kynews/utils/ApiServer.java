package com.example.ky4910.kynews.utils;

import com.example.ky4910.kynews.model.entity.NewsBean;
import com.example.ky4910.kynews.model.entity.VideoBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServer {

    @GET("nlist")
    Call<NewsBean> getNewsBean(@Query("cid") int id);

}
