package com.example.ky4910.kynews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.model.entity.News;

import java.util.List;

/**
 * Created by KimberJin on 2018/12/26.
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.MyViewHolder> {

    private List<News> mNewsList;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsTitle;
        TextView newsContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView)itemView.findViewById(R.id.news_image);
            newsTitle = (TextView)itemView.findViewById(R.id.news_title);
            newsContent = (TextView)itemView.findViewById(R.id.news_content);
        }
    }

    public NewsRecyclerAdapter(List<News> mNews) {
        this.mNewsList = mNews;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        final MyViewHolder myHolder = new MyViewHolder(view);
        myHolder.newsImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = myHolder.getAdapterPosition();
                News news = mNewsList.get(position);
                Toast.makeText(view.getContext(), news.getId() + " The image clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myHolder.newsTitle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = myHolder.getAdapterPosition();
                News news = mNewsList.get(position);
                Toast.makeText(view.getContext(), news.getId() + " " + news.getContent(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.newsImage.setImageResource(news.getImgsrc());
        holder.newsTitle.setText(news.getId() + ". " + news.getTitle());
        holder.newsContent.setText(news.getContent() + " && " + news.getChannel());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}
