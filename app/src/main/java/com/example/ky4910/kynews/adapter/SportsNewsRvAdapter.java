package com.example.ky4910.kynews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.model.entity.NewsBean;
import com.example.ky4910.kynews.utils.PubtimeConverter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SportsNewsRvAdapter extends RecyclerView.Adapter<SportsNewsRvAdapter.ViewHolder> {

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

    public SportsNewsRvAdapter(Context mContext, List<NewsBean.DataBean.ListBean> listBeans) {
        this.mContext = mContext;
        this.listBeans = listBeans;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.news_item,null);
        ViewHolder viewHolder = new ViewHolder(view, mOnItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SportsNewsRvAdapter.ViewHolder holder, int position) {
        NewsBean.DataBean.ListBean listBean = listBeans.get(position);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.default_img)
                .error(R.drawable.default_img)
                .override(336, 210);
        Glide.with(mContext).load(listBean.getHeadpic()).apply(options).into(holder.imageView);
        holder.textTitle.setText(listBean.getTitle());
        Log.i("kimber", "pubTime is " + listBean.getPub_time() + "\n"
                + "title is " + listBean.getTitle());
        String realTime = PubtimeConverter.pubtimeToDate(String.format("%s", listBean.getPub_time()));
        holder.textTime.setText(realTime);
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

        public ViewHolder(View itemView, final OnItemClickListener onClickListener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (onClickListener != null) {
                        int position = getAdapterPosition();
                        //确保position值有效
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
