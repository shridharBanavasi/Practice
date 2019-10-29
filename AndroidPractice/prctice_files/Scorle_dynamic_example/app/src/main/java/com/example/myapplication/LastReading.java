package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastReading {
    @SerializedName("reading")
    @Expose
    private Reading reading;

    public LastReading(Reading reading) {
        this.reading = reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    public Reading getReading() {
        return reading;
    }
}

