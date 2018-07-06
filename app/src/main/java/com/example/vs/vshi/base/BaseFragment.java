package com.example.vs.vshi.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vs.vshi.view.interfaces.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    private P basePresenter;
    private View view;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getFragmentLayout(),container,false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        basePresenter=initPresenter();
        basePresenter.attachView(this);
        initData();
        initListener();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(bind!=null){
            bind.unbind();
        }
    }

    //获取碎片布局
    protected abstract int getFragmentLayout();
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

    @Nullable
    @Override
    public View getView() {
        return view;
    }
}
