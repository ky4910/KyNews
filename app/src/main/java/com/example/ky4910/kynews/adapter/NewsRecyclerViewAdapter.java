package com.example.ky4910.kynews.adapter;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.model.entity.NewsBean;

import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {

    private Fragment mFragment;
    private List<NewsBean.DataBean.ListBean> listBeans;

    public NewsRecyclerViewAdapter(List<NewsBean.DataBean.ListBean> mBeans) {
        this.listBeans = mBeans;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView newsTitle;
        private TextView newsTime;

        ViewHolder(View itemView, final List<NewsBean.DataBean.ListBean> mBeans) {
            super(itemView);
            imageView = itemView.findViewById(R.id.news_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsTime = itemView.findViewById(R.id.news_time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Call callback API to get news detail information
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsView = inflater.inflate(R.layout.news_item, parent, false);
        return new ViewHolder(newsView, listBeans);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.ViewHolder holder, int position) {
        NewsBean.DataBean.ListBean dataBean = listBeans.get(position);
        holder.newsTitle.setText(dataBean.getTitle());
        //时间戳需要转换(http://www.beijing-time.org/shijianchuo/)
        holder.newsTime.setText(dataBean.getPub_time());
        //loadImage need do some days later
    }

    @Override
    public int getItemCount() {
        if (listBeans == null) {
            return 0;
        }
        return listBeans.size() + 1;
    }
}
