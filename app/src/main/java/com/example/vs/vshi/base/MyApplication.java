package com.example.vs.vshi.base;

import android.app.Application;


import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;


import static android.content.Context.WINDOW_SERVICE;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }

}
