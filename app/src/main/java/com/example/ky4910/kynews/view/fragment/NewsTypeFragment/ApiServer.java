package com.example.ky4910.kynews.view.fragment.NewsTypeFragment;

import com.example.ky4910.kynews.model.entity.NewsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServer {
    String MAIN_NEWS_URL = "http://api.dagoogle.cn/news/nlist?cid=9/";
    String SPORTS_NEWS_URL = "http://api.dagoogle.cn/news/nlist?cid=6/";
    String FINANCE_NEWS_URL = "http://api.dagoogle.cn/news/nlist?cid=4/";
    String BASE_URL = "http://api.dagoogle.cn/news/";

    @GET("nlist?cid={id}/")
    Call<NewsBean> getNewsBean(@Path("id") int id);
}
