package com.sessionloginviewretrofit.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 3/31/2018.
 */

public class RetroClass {

    private static final String BASE_URL="http://192.168.132.2";

    private static Retrofit getRetroInstance()
    {

         Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();


    }

    public static APIService getAPIService()
    {

        return getRetroInstance().create(APIService.class);
    }



}
