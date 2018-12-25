package com.example.ky4910.kynews.view.fragment;

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

public class EntertainmentFragment extends BaseFragment {

    public EntertainmentFragment() {}

    public static EntertainmentFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        EntertainmentFragment entertainmentFragment =  new EntertainmentFragment();
        entertainmentFragment.setArguments(bundle);
        return entertainmentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ent, null);
        return view;
    }
}
