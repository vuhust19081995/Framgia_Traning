package com.workspace.retrofitapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by workspace on 31/08/2017.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String baseUrl){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
