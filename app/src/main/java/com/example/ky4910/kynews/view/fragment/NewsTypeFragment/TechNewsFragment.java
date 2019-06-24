package com.example.ky4910.kynews.view.fragment.NewsTypeFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.TechNewsRvAdapter;
import com.example.ky4910.kynews.model.entity.NewsBean;
import com.example.ky4910.kynews.utils.ApiServer;
import com.example.ky4910.kynews.utils.OkHttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechNewsFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    TechNewsRvAdapter rvAdapter;

    public TechNewsFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("kimber", "TechNews onAttach!");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("kimber", "TechNews onCreate!");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initRetrofit();
        view = inflater.inflate(R.layout.tech_news, container, false);
        return view;
    }

    private void initRetrofit() {
        OkHttpManager httpManager = new OkHttpManager();
        ApiServer apiServer = httpManager.getRetrofit(httpManager.okHttpClient())
                .create(ApiServer.class);
        apiServer.getNewsBean(7).enqueue(new Callback<NewsBean>() {
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

    private void initData(final NewsBean datas){
        recyclerView = view.findViewById(R.id.tech_news_rcviews);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rvAdapter = new TechNewsRvAdapter(this.getActivity(), datas.getData().getList());
        recyclerView.setAdapter(rvAdapter);
    }
}
