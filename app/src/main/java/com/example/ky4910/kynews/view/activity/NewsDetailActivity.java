package com.example.ky4910.kynews.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.ky4910.kynews.R;

public class NewsDetailActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_detail);
        Intent intent = getIntent();
        String newsUrl = intent.getStringExtra("detail_news");
        mWebView = (WebView)findViewById(R.id.web_view);
        mWebView.loadUrl(newsUrl);
    }
}
