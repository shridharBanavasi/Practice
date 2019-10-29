package com.sessionloginviewretrofit.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lenovo on 3/31/2018.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("/hit/logintab.php")
    Call<String> userLogin (@Field("username") String username,@Field("userpass") String userpass);

}
