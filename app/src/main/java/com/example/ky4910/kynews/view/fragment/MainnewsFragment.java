package com.example.ky4910.kynews.view.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ky4910.base.BaseFragment;
import com.example.ky4910.kynews.R;

/**
 * Created by ky4910 on 2018/11/15.
 */

public class MainnewsFragment extends BaseFragment {

    public MainnewsFragment() {}

    public static MainnewsFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        MainnewsFragment mainnewsFragment =  new MainnewsFragment();
        mainnewsFragment.setArguments(bundle);
        return mainnewsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        return view;
    }

}
