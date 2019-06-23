package com.example.ky4910.kynews.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.model.entity.NewsBean;
import com.example.ky4910.kynews.utils.PubtimeConverter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TechNewsRvAdapter extends RecyclerView.Adapter<TechNewsRvAdapter.ViewHolder> {

    private Context mContext;
    private List<NewsBean.DataBean.ListBean> listBeans;
    private LayoutInflater mLayoutInflater;

    public TechNewsRvAdapter(Context context, List<NewsBean.DataBean.ListBean> listBeans) {
        this.mContext = context;
        this.listBeans = listBeans;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.news_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
