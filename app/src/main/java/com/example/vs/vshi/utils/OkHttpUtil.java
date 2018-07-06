package com.example.vs.vshi.utils;

import android.util.Log;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil {

    static OkHttpUtil okHttpUtil;
    private OkHttpClient okHttpClient;

    private OkHttpUtil() {
            okHttpClient=new OkHttpClient.Builder()
                    .readTimeout(5000, TimeUnit.SECONDS)
                    .connectTimeout(5000,TimeUnit.SECONDS)
                    .addInterceptor(new CommonInterceptor())
                    .build();
    }

    public static OkHttpUtil getInstance(){
        if(okHttpUtil==null){
            synchronized (OkHttpUtil.class){
                if(okHttpUtil==null){
                    okHttpUtil=new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }


    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    //公共参数拦截器(source=android)
    class CommonInterceptor  implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            //获取原先的请求
            Request originalRequest = chain.request();
            //重新构建url
            HttpUrl.Builder builder = originalRequest.url().newBuilder();
            //如果是post请求的话就把参数重新拼接一下，get请求的话就可以直接加入公共参数了
            if(originalRequest.method().equals("POST")){
                FormBody body = (FormBody) originalRequest.body();
                for(int i = 0; i < body.size();i++){
                    Log.i("RequestFatory",body.name(i) + "---" + body.value(i));
                    builder.addQueryParameter(body.name(i),body.value(i));
                }
            }
            //这里是我的2个公共参数
            builder.addQueryParameter("source","android");
            //新的url
            HttpUrl httpUrl = builder.build();
            Request request = originalRequest.newBuilder()
                    .method(originalRequest.method(),originalRequest.body())
                    .url(httpUrl).build();
            return chain.proceed(request);
        }
    }
}
