package com.example.ky4910.kynews.view.fragment.NewsTypeFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.Toast;

import com.cleveroad.pulltorefresh.firework.FireworkyPullToRefreshLayout;
import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.adapter.MainNewsRvAdapter;
import com.example.ky4910.kynews.model.entity.NewsBean;
import com.example.ky4910.kynews.utils.ApiServer;
import com.example.ky4910.kynews.utils.OkHttpManager;
import com.example.ky4910.kynews.view.activity.NewsDetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainNewsFragment extends Fragment {

    private View view;
//    @BindView(R.id.main_news_rcviews)
    private RecyclerView recyclerView;

    MainNewsRvAdapter rvAdapter;
    FireworkyPullToRefreshLayout mPullToRefresh;
    private boolean NEED_REFRESH = true;

    public MainNewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (NEED_REFRESH) {
            initRetrofit();
        }
        view = inflater.inflate(R.layout.main_news, container, false);
        mPullToRefresh = view.findViewById(R.id.pullToRefresh);
        mPullToRefresh.setOnRefreshListener(new FireworkyPullToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initRetrofit();
                        mPullToRefresh.setRefreshing(false);
                    }
                }, 5000);
            }
        });
        return view;
//        return inflater.inflate(R.layout.main_news, container, false);
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
        NEED_REFRESH = false;
    }

    private void initData(final NewsBean datas) {
        recyclerView = view.findViewById(R.id.main_news_rcviews);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));
        //设置item的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rvAdapter = new MainNewsRvAdapter(this.getActivity(), datas.getData().getList());
        recyclerView.setAdapter(rvAdapter);
        rvAdapter.setOnItemClickListener(new MainNewsRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                String newURL = datas.getData().getList().get(position).getSource_url();
                //fragment中启动activity，Intent第一个参数getActivity().getApplicationContext()
                Intent intent = new Intent(getActivity().getApplicationContext(), NewsDetailActivity.class);
                intent.putExtra("detail_news", newURL);
                startActivity(intent);
            }
        });
    }
}
