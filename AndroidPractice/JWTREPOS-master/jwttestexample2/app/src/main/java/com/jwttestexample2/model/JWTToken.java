package com.jwttestexample2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 4/18/2018.
 */

public class JWTToken {

    @SerializedName("token")
    @Expose
    public String token;

    public JWTToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
