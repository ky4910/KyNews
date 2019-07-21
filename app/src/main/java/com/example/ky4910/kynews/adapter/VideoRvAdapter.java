package com.example.ky4910.kynews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ky4910.kynews.R;
import com.example.ky4910.kynews.model.entity.VideoBean;
import com.example.ky4910.kynews.utils.KyVideoPlayer;
import com.example.ky4910.kynews.utils.KyVideoPlayerController;
import com.example.ky4910.kynews.utils.VideoUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoRvAdapter extends RecyclerView.Adapter<VideoRvAdapter.MyViewHolder> {

    private Context mContext;
    private List<VideoBean> videosBeanList;

    public static final String TAG = "VIDEO_RV_ADAPTER";

    public VideoRvAdapter(Context context, List<VideoBean> videoBeans) {
        this.mContext = context;
        this.videosBeanList = videoBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.video_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        KyVideoPlayerController videoController = new KyVideoPlayerController(mContext);
        try {
            myViewHolder.setController(videoController);
        } catch (Exception e){
            Log.e(TAG, e.getMessage());
        }

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(videosBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return videosBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private KyVideoPlayer mVideoPlayer;
        private KyVideoPlayerController mVideoController;

        private MyViewHolder(View itemView) {
            super(itemView);
            mVideoPlayer = itemView.findViewById(R.id.ky_video_player);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mVideoPlayer.getLayoutParams();
            lp.width = VideoUtil.getScreenWidth(mContext);
            lp.height = (VideoUtil.getScreenWidth(mContext) * 9)/16;
            mVideoPlayer.setLayoutParams(lp);
        }
        private void setController(KyVideoPlayerController controller) {
            mVideoController = controller;
        }
        private void bindData(VideoBean videos) {
            mVideoController.setTitle(videos.getTitle());
            mVideoController.setImage(videos.getImageUrl());
            mVideoPlayer.setController(mVideoController);
            mVideoPlayer.setUp(videos.getVideoUrl(), null);
        }
    }
}
