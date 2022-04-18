package com.example.shop.network;

import com.example.shop.constants.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductService {
    private static ProductService instance;
    private Retrofit retrofit;

    private ProductService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(130, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Urls.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ProductService getInstance() {
        if(instance==null)
            instance=new ProductService();
        return instance;
    }

    public ProductApi jsonApi() {
        return retrofit.create(ProductApi.class);
    }


}