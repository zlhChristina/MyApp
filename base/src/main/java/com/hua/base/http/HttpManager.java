package com.hua.base.http;

import com.hua.huahua.util.LogUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    public static final String BASE_URL = "";
    private Retrofit retrofit;
    private static HttpManager manager;

    private HttpManager() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            try {
                String text = URLDecoder.decode(message, "utf-8");
                LogUtil.Companion.e(text);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                LogUtil.Companion.e(message);
            }
        }
    });

    public static HttpManager getInstance() {
        if (manager == null) {
            synchronized (HttpManager.class) {
                manager = new HttpManager();
            }
        }
        return manager;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}
