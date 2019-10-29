package com.example.myapplication.api;

import com.example.myapplication.model.Token;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("local")
    Call<Token> createUser(
       @Field("email") String email,
       @Field("password") String password
     );

}
