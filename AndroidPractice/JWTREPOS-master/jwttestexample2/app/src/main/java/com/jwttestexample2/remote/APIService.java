package com.jwttestexample2.remote;

import com.jwttestexample2.model.JWTToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by lenovo on 4/18/2018.
 */

public interface APIService {

 @FormUrlEncoded
 @POST("/phptest/testlogin.php")
 Call<JWTToken> userlogin(@Field("username") String username, @Field("userpass")String userpass);

 @GET("/phptest/jwttest.php")
 Call<String> getUser(@Header("Authorization") String authorization);

}
