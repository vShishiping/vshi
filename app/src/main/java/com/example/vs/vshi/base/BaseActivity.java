package com.example.vs.vshi.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.example.vs.vshi.view.interfaces.BaseView;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    private P basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ButterKnife.bind(this);
        basePresenter=initPresenter();
        basePresenter.attachView(this);
        initData();
        initListener();
    }

    //获取activity布局
    protected abstract int getActivityLayout();
    //初始化presenter
    protected abstract P initPresenter();
    //获取presenter
    public P getBasePresenter() {
        return basePresenter;
    }
    //初始化数据
    protected abstract void initData();
    //初始化监听
    protected abstract void initListener();

}
