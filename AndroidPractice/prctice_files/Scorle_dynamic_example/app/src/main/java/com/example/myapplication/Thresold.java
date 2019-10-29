package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thresold {
    @SerializedName("max")
    @Expose
    private float max;

    public Thresold(float max) {
        this.max = max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getThresoldMax() {
        return max;
    }
}
