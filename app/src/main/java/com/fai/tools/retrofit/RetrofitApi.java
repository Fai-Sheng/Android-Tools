package com.fai.tools.retrofit;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by PVer on 2018/3/15.
 * 提供全局唯一的 retrofit对象 和 OkHttpClient 对象
 */


public class RetrofitApi {

    private static final String TAG = "RetrofitApi";
    private static final String BASE_URL = "";

    private static final String BASE_URL_XX = "";

    public RetrofitApi()
    {

    }

    public OkHttpClient provideHttpClient()
    {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request = chain.request().newBuilder().build();
                        String url = chain.request().url().toString();


                        Log.v(TAG,"url: " + url);

                        return chain.proceed(request);
                    }
                })
                .retryOnConnectionFailure(true)
                .readTimeout(15000,TimeUnit.MILLISECONDS)
                .connectTimeout(15000, TimeUnit.MILLISECONDS)
                .build();

        return client;
    }


    public Retrofit provideRetrofit(OkHttpClient okHttpClient)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build();

        return retrofit;
    }

}
