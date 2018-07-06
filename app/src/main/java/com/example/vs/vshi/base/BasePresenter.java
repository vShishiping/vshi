package com.example.vs.vshi.base;


import com.example.vs.vshi.view.interfaces.BaseView;

public class BasePresenter<V extends BaseView>{
    private V baseView;

    public void attachView(V baseView){
        this.baseView=baseView;
    }

    public void detachView(){
        if(this.baseView!=null){
            this.baseView=null;
        }
    }

    public V getBaseView() {
        return baseView;
    }
}
