package com.example.ky4910.kynews.utils;

/**
 * 
 *   Created by kimber on 2019/07/17
 *   视频播放管理器
 */

public class KyVideoPlayerManager {

    private KyVideoPlayer mVideoPlayer;

    private KyVideoPlayerManager() {
    }

    private static KyVideoPlayerManager sInstance;

    public static synchronized KyVideoPlayerManager instance() {
        if (sInstance == null) {
            sInstance = new KyVideoPlayerManager();
        }
        return sInstance;
    }

    public void setCurrentKyVideoPlayer(KyVideoPlayer videoPlayer) {
        mVideoPlayer = videoPlayer;
    }

    public void releaseKyVideoPlayer() {
        if (mVideoPlayer != null) {
            mVideoPlayer.release();
            mVideoPlayer = null;
        }
    }

    public boolean onBackPressd() {
        if (mVideoPlayer != null) {
            if (mVideoPlayer.isFullScreen()) {
                return mVideoPlayer.exitFullScreen();
            } else if (mVideoPlayer.isTinyWindow()) {
                return mVideoPlayer.exitTinyWindow();
            } else {
                mVideoPlayer.release();
                return false;
            }
        }
        return false;
    }

}
