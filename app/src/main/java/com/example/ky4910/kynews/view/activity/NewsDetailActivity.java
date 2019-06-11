package com.example.ky4910.kynews.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.ky4910.kynews.R;

public class NewsDetailActivity extends AppCompatActivity {

    private WebView mWebView;

    // http://news.163.com/19/0610/12/EHAKCCGO0001899N.html
    // 重定向为 =》 http://3g.163.com/news/article/EHAKCCGO0001899N.html
    // need fix webview cannot load image issue

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);
        Intent intent = getIntent();
        String BASE_ADDR = "http://3g.163.com/news/article/";
        String newsUrl = intent.getStringExtra("detail_news");
        //获取新闻URL地址的最后/部分，之后利用BASE_ADDR转为移动版URL
        String urls[] = newsUrl.split("/");
        mWebView = findViewById(R.id.detail_webview);
        mWebView.loadUrl(BASE_ADDR + urls[urls.length - 1]);
    }
}
