package com.example.vs.vshi.utils;

import company.pp.com.ppcommunity.base.Constant;
import company.pp.com.ppcommunity.moudle.net.OkHttpUtil;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetorfitHelper {
    private final OkHttpClient okHttpClient;
    static RetorfitHelper retorfitHelper;
    private Retrofit retrofit;
    private RetorfitHelper() {
        okHttpClient= OkHttpUtil.getInstance().getOkHttpClient();
    }

    public static RetorfitHelper getInstance(){
        if(retorfitHelper==null){
            synchronized (RetorfitHelper.class){
                if(retorfitHelper==null){
                    retorfitHelper=new RetorfitHelper();
                }
            }
        }
        return retorfitHelper;
    }
    public Retrofit getRetrofit() {
        retrofit=new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    public static<T> T getService(Class<T> clazz){
        return  RetorfitHelper.getInstance().getRetrofit().create(clazz);
    }
}
