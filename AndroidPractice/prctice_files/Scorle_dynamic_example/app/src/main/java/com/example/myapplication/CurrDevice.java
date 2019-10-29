package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrDevice {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("location")
    @Expose
    private String location;


    public CurrDevice(String name, String location) {
        this.name = name;
        this.location = location;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getCurrDeviceName() {
        return name;
    }

    public String getCurrDeviceLocation() {
        return location;
    }

}
