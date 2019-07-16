package com.example.ky4910.kynews.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 *  Created by kimber on 2019/07/16
 *  Video Player Controller
 */

public class KyVideoPlayerController extends FrameLayout
    implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Context mContext;
    private KyVideoPlayerControl mKyVideoPlayerControl;
    private ImageView mImageView;
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
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
