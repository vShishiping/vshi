package com.example.vs.vshi.presenter;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class AbstractObserver<T> implements Observer<T> {

    public abstract void onSuccess(T t);
    public abstract void onFailure();

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {
        onSuccess(value);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
