package com.example.ky4910.kynews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.model.entity.VideoBean;
import com.example.ky4910.kynews.utils.KyVideoPlayer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoRvAdapter extends RecyclerView.Adapter<VideoRvAdapter.ViewHolder> {

    private Context mContext;
    private List<VideoBean.TrailersBean> trailersBeanList;

    public VideoRvAdapter(Context context, List<VideoBean.TrailersBean> trailersBean) {
        this.mContext = context;
        this.trailersBeanList = trailersBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.video_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoBean.TrailersBean trailersBean = trailersBeanList.get(position);
    }

    @Override
    public int getItemCount() {
        return trailersBeanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
