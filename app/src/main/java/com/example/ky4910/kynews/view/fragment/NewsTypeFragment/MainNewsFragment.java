package com.example.ky4910.kynews.view.fragment.NewsTypeFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.MainNewsRvAdapter;
import com.example.ky4910.kynews.model.entity.NewsBean;
import com.example.ky4910.kynews.utils.OkHttpManager;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainNewsFragment extends Fragment {

    @BindView(R.id.main_news_rcviews)
    RecyclerView recyclerView;

    private List<NewsBean.DataBean.ListBean> listBeans;
    MainNewsRvAdapter rvAdapter;

    public MainNewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRetrofit();
        return inflater.inflate(R.layout.main_news, container, false);
    }

    private void initRetrofit() {
        OkHttpManager httpManager = new OkHttpManager();
        ApiServer apiServer = httpManager.getRetrofit(httpManager.okHttpClient())
                .create(ApiServer.class);
        apiServer.getNewsBean(9).enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                NewsBean body = response.body();
                initData(body);
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {

            }
        });
    }

    private void initData(NewsBean datas) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        rvAdapter = new MainNewsRvAdapter(this.getActivity(), datas.getData().getList());
        recyclerView.setAdapter(rvAdapter);
    }

}
