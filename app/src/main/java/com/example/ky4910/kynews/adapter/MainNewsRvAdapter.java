package com.example.ky4910.kynews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.model.entity.NewsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainNewsRvAdapter extends RecyclerView.Adapter<MainNewsRvAdapter.ViewHolder> {

    private Context mContext;
    private List<NewsBean.DataBean.ListBean> listBeans;
    private LayoutInflater mLayoutInflater;

    public MainNewsRvAdapter(Context context, List<NewsBean.DataBean.ListBean> listBeans) {
        this.mContext = context;
        this.listBeans = listBeans;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.news_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView imageView;
        NewsBean.DataBean.ListBean listBean = listBeans.get(position);
//        Glide.with(mContext).load(listBean.getHeadpic()).into(holder.)
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_image)
        ImageView imageView;
        @BindView(R.id.news_title)
        TextView textTitle;
        @BindView(R.id.news_time)
        TextView textTime;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
