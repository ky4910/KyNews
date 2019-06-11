package com.example.ky4910.kynews.view.fragment.NewsTypeFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.SportsNewsRvAdapter;
import com.example.ky4910.kynews.model.entity.NewsBean;
import com.example.ky4910.kynews.utils.ApiServer;
import com.example.ky4910.kynews.utils.OkHttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsNewsFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;

    SportsNewsRvAdapter rvAdapter;

    public SportsNewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sports_news, container, false);
        initRetrofit();
        return view;
    }

    public void initRetrofit() {
        OkHttpManager httpManager = new OkHttpManager();
        ApiServer apiServer = httpManager.getRetrofit(httpManager.okHttpClient())
                .create(ApiServer.class);
        apiServer.getNewsBean(6).enqueue(new Callback<NewsBean>() {
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
        recyclerView = view.findViewById(R.id.sports_news_rcviews);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rvAdapter = new SportsNewsRvAdapter(this.getActivity(), datas.getData().getList());
        recyclerView.setAdapter(rvAdapter);
    }
}
