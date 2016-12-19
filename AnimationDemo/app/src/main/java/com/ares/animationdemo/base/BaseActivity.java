package com.ares.animationdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.ares.animationdemo.app.MyApplication;

import butterknife.ButterKnife;

/**
 * Created by Ares on 2016/12/19/019.
 */

public abstract class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        MyApplication.addActivity(this);
        initParams();
    }

    protected abstract void initParams();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        MyApplication.removeActivity(this);
        super.onDestroy();
    }
}
