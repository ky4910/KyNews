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

public class SportsNewsRvAdapter extends RecyclerView.Adapter<SportsNewsRvAdapter.ViewHolder> {

    private Context mContext;
    private List<NewsBean.DataBean.ListBean> listBeans;
    private LayoutInflater mLayoutInflater;

    public SportsNewsRvAdapter(Context mContext, List<NewsBean.DataBean.ListBean> listBeans) {
        this.mContext = mContext;
        this.listBeans = listBeans;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.news_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SportsNewsRvAdapter.ViewHolder holder, int position) {
        NewsBean.DataBean.ListBean listBean = listBeans.get(position);
        Glide.with(mContext).load(listBean.getHeadpic()).into(holder.imageView);
        holder.textTitle.setText(listBean.getTitle());
//        holder.textTime.setText(listBean.getPub_time());
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
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
