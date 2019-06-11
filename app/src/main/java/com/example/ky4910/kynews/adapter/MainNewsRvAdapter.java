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

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClicked(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.mOnItemClickListener = clickListener;
    }

    public MainNewsRvAdapter(Context context, List<NewsBean.DataBean.ListBean> listBeans) {
        this.mContext = context;
        this.listBeans = listBeans;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.news_item, null);
        ViewHolder viewHolder = new ViewHolder(view, mOnItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsBean.DataBean.ListBean listBean = listBeans.get(position);
        Glide.with(mContext).load(listBean.getHeadpic()).into(holder.imageView);
        holder.textTitle.setText(listBean.getTitle());
//        holder.textTitle.setText(listBean.getPub_time());
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    //如果一个类要被声明为static的，只有一种情况，就是静态内部类。
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_image)
        ImageView imageView;
        @BindView(R.id.news_title)
        TextView textTitle;
        @BindView(R.id.news_time)
        TextView textTime;

        public ViewHolder(View itemView, final OnItemClickListener onClickListener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onClickListener.onItemClicked(view, position);
                        }
                    }
                }
            });
            ButterKnife.bind(this, itemView);
        }
    }
}
