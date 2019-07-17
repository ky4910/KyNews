package com.example.ky4910.kynews.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ky4910.kynews.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 *  Created by kimber on 2019/07/16
 *  Video Player Controller
 */

public class KyVideoPlayerController extends FrameLayout
    implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Context mContext;
    private KyVideoPlayerControl mKyVideoPlayer;
    private ImageView mImage;
    private ImageView mCenterStart;
    private LinearLayout ll_mTop;
    private ImageView mBack;
    private TextView mTitle;

    private LinearLayout ll_mBottom;
    private ImageView mRestartPause;
    private TextView mPosition;
    private TextView mDuration;
    private SeekBar mSeek;
    private ImageView mFullScreen;

    private LinearLayout ll_mLoading;
    private TextView mLoadText;

    private LinearLayout ll_mError;
    private TextView mRetry;

    private LinearLayout ll_mCompleted;
    private TextView mReplay;
    private TextView mShare;

    private Timer mUpdateProgressTimer;
    private TimerTask mUpdateProgressTimerTask;
    private boolean topBottomVisible;
    private CountDownTimer mDismissTopBottomCountDownTimer;

    public KyVideoPlayerController(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.video_player_controller, this, true);

        mImage = findViewById(R.id.iv_image);
        mCenterStart = findViewById(R.id.center_start);

        ll_mTop = findViewById(R.id.top);
        mBack = findViewById(R.id.iv_back);
        mTitle = findViewById(R.id.title);

        ll_mBottom = findViewById(R.id.ll_bottom);
        mRestartPause = findViewById(R.id.iv_restart_pause);
        mPosition = findViewById(R.id.tv_position);
        mDuration = findViewById(R.id.tv_duration);
        mSeek = findViewById(R.id.seek);
        mFullScreen = findViewById(R.id.iv_full_screen);

        ll_mLoading = findViewById(R.id.ll_loading);
        mLoadText = findViewById(R.id.tv_loading);

        ll_mError = findViewById(R.id.ll_error);
        mRetry = findViewById(R.id.tv_retry);

        ll_mCompleted = findViewById(R.id.ll_completed);
        mReplay = findViewById(R.id.tv_replay);
        mShare = findViewById(R.id.tv_share);

        mCenterStart.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mRestartPause.setOnClickListener(this);
        mFullScreen.setOnClickListener(this);
        mRetry.setOnClickListener(this);
        mReplay.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mSeek.setOnSeekBarChangeListener(this);
        this.setOnClickListener(this);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setImage(String imageUrl) {
        Glide.with(mContext)
                .load(imageUrl)
                .apply(new RequestOptions().error(R.drawable.default_img))
                .into(mImage);
    }

    public void setImage(@DrawableRes int resId) {
        mImage.setImageResource(resId);
    }

    public void setKyVideoPlayer(KyVideoPlayerControl kyVideoPlayer) {
        mKyVideoPlayer = kyVideoPlayer;
        if (mKyVideoPlayer.isIdle()) {
            mBack.setVisibility(View.GONE);
            ll_mTop.setVisibility(View.VISIBLE);
            ll_mBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == mCenterStart) {
            if (mKyVideoPlayer.isIdle()) {
                mKyVideoPlayer.start();
            }
        } else if (v == mBack) {
            if (mKyVideoPlayer.isFullScreen()) {
                mKyVideoPlayer.exitFullScreen();
            } else if (mKyVideoPlayer.isTinyWindow()) {
                mKyVideoPlayer.exitTinyWindow();
            }
        } else if (v == mRestartPause) {
            if (mKyVideoPlayer.isPlaying() || mKyVideoPlayer.isBufferingPlaying()) {
                mKyVideoPlayer.pause();
            } else if (mKyVideoPlayer.isPaused() || mKyVideoPlayer.isBufferingPaused()) {
                mKyVideoPlayer.restart();
            }
        } else if (v == mFullScreen) {
            if (mKyVideoPlayer.isNormal()) {
                mKyVideoPlayer.enterFullScreen();
            } else if (mKyVideoPlayer.isFullScreen()) {
                mKyVideoPlayer.exitFullScreen();
            }
        } else if (v == mRetry) {
            mKyVideoPlayer.release();
            mKyVideoPlayer.start();
        } else if (v == mReplay) {
            mRetry.performClick();
        } else if (v == mShare) {
            Toast.makeText(mContext, "分享", Toast.LENGTH_SHORT).show();
        } else if (v == this) {
            if (mKyVideoPlayer.isPlaying()
                    || mKyVideoPlayer.isPaused()
                    || mKyVideoPlayer.isBufferingPlaying()
                    || mKyVideoPlayer.isBufferingPaused()) {
                setTopBottomVisible(!topBottomVisible);
            }
        }
    }

    private void setTopBottomVisible(boolean visible) {
        ll_mTop.setVisibility(visible ? View.VISIBLE : View.GONE);
        ll_mBottom.setVisibility(visible ? View.VISIBLE : View.GONE);
        topBottomVisible = visible;
        if (visible) {
            if (!mKyVideoPlayer.isPaused() && !mKyVideoPlayer.isBufferingPaused()) {
                startDismissTopBottomTimer();
            }
        } else {
            cancelDismissTopBottomTimer();
        }
    }

    private void startDismissTopBottomTimer() {
        cancelDismissTopBottomTimer();
        if (mDismissTopBottomCountDownTimer == null) {
            mDismissTopBottomCountDownTimer = new CountDownTimer(8000, 8000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    setTopBottomVisible(false);
                }
            };
        }
        mDismissTopBottomCountDownTimer.start();
    }

    private void cancelDismissTopBottomTimer() {
        if (mDismissTopBottomCountDownTimer != null) {
            mDismissTopBottomCountDownTimer.cancel();
        }
    }

    public void setControllerState(int playerState, int playState) {
        switch (playerState) {
            case KyVideoPlayer.PLAYER_NORMAL:
                mBack.setVisibility(View.GONE);
                mFullScreen.setVisibility(View.VISIBLE);
                mFullScreen.setImageResource(R.drawable.ic_player_enlarge);
                break;
            case KyVideoPlayer.PLAYER_FULL_SCREEN:
                mBack.setVisibility(View.VISIBLE);
                mFullScreen.setVisibility(View.VISIBLE);
                mFullScreen.setImageResource(R.drawable.ic_player_shrink);
                break;
            case KyVideoPlayer.PLAYER_TINY_WINDOW:
                mFullScreen.setVisibility(View.GONE);
                break;
        }
        switch (playState) {
            case KyVideoPlayer.STATE_IDLE:
                break;
            case KyVideoPlayer.STATE_PREPARING:
                //只显示动画，其他不显示
                mImage.setVisibility(View.GONE);
                ll_mLoading.setVisibility(View.VISIBLE);
                mLoadText.setText("正在准备...");
                ll_mError.setVisibility(View.GONE);
                ll_mCompleted.setVisibility(View.GONE);
                ll_mTop.setVisibility(View.GONE);
                mCenterStart.setVisibility(View.GONE);
                break;
            case KyVideoPlayer.STATE_PREPARED:
                startUpdateProgressTimer();
                break;
            case KyVideoPlayer.STATE_PLAYING:
                ll_mLoading.setVisibility(View.GONE);
                mRestartPause.setImageResource(R.drawable.ic_player_pause);
                startDismissTopBottomTimer();
                break;
            case KyVideoPlayer.STATE_PAUSED:
                ll_mLoading.setVisibility(View.GONE);
                mRestartPause.setImageResource(R.drawable.ic_player_start);
                cancelDismissTopBottomTimer();
                break;
            case KyVideoPlayer.STATE_BUFFERING_PLAYING:
                ll_mLoading.setVisibility(View.VISIBLE);
                mRestartPause.setImageResource(R.drawable.ic_player_pause);
                mLoadText.setText("正在缓冲...");
                startDismissTopBottomTimer();
                break;
            case KyVideoPlayer.STATE_BUFFERING_PAUSED:
                ll_mLoading.setVisibility(View.VISIBLE);
                mRestartPause.setImageResource(R.drawable.ic_player_start);
                mLoadText.setText("正在缓冲...");
                cancelDismissTopBottomTimer();
                break;
            case KyVideoPlayer.STATE_COMPLETED:
                cancelUpdateProgressTimer();
                setTopBottomVisible(false);
                mImage.setVisibility(View.VISIBLE);
                ll_mCompleted.setVisibility(View.VISIBLE);
                if (mKyVideoPlayer.isFullScreen()) {
                    mKyVideoPlayer.exitFullScreen();
                }
                if (mKyVideoPlayer.isTinyWindow()) {
                    mKyVideoPlayer.exitTinyWindow();
                }
                break;
            case KyVideoPlayer.STATE_ERROR:
                cancelUpdateProgressTimer();
                setTopBottomVisible(false);
                ll_mTop.setVisibility(View.VISIBLE);
                ll_mError.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void startUpdateProgressTimer() {
        cancelUpdateProgressTimer();
        if (mUpdateProgressTimer == null) {
            mUpdateProgressTimer = new Timer();
        }
        if (mUpdateProgressTimerTask == null) {
            mUpdateProgressTimerTask = new TimerTask() {
                @Override
                public void run() {
                    KyVideoPlayerController.this.post(new Runnable() {
                        @Override
                        public void run() {
                            updateProgress();
                        }
                    });
                }
            };
        }
        mUpdateProgressTimer.schedule(mUpdateProgressTimerTask, 0, 300);
    }

    private void updateProgress() {
        int position = mKyVideoPlayer.getCurrentPosition();
        int duration = mKyVideoPlayer.getDuration();
        int bufferPercentage = mKyVideoPlayer.getBufferPercentage();
        mSeek.setSecondaryProgress(bufferPercentage);
        int progress = (int) (100f * position / duration);
        mSeek.setProgress(progress);
        mPosition.setText(VideoUtil.formatTime(position));
        mDuration.setText(VideoUtil.formatTime(duration));
    }

    private void cancelUpdateProgressTimer() {
        if (mUpdateProgressTimer != null) {
            mUpdateProgressTimer.cancel();
            mUpdateProgressTimer = null;
        }
        if (mUpdateProgressTimerTask != null) {
            mUpdateProgressTimerTask.cancel();
            mUpdateProgressTimerTask = null;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        cancelDismissTopBottomTimer();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (mKyVideoPlayer.isBufferingPaused() || mKyVideoPlayer.isPaused()) {
            mKyVideoPlayer.restart();
        }
        int position = (int)(mKyVideoPlayer.getDuration() * seekBar.getProgress() / 100f);
        mKyVideoPlayer.seekTo(position);
        startDismissTopBottomTimer();
    }

    /**
     * 控制器恢复到初始状态
     */
    public void reset() {
        topBottomVisible = false;
        cancelUpdateProgressTimer();
        cancelDismissTopBottomTimer();
        mSeek.setProgress(0);
        mSeek.setSecondaryProgress(0);

        mCenterStart.setVisibility(View.VISIBLE);
        mImage.setVisibility(View.VISIBLE);

        ll_mBottom.setVisibility(View.GONE);
        mFullScreen.setImageResource(R.drawable.ic_player_enlarge);

        ll_mTop.setVisibility(View.VISIBLE);
        mBack.setVisibility(View.GONE);

        ll_mLoading.setVisibility(View.GONE);
        ll_mError.setVisibility(View.GONE);
        ll_mCompleted.setVisibility(View.GONE);
    }
}
