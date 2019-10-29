package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonitorClass {
    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("currDevice")
    @Expose
    private CurrDevice currDevice;

    @SerializedName("lastReading")
    @Expose
    private LastReading lastReading;

    @SerializedName("thresold")
    @Expose
    private Thresold thresold;

    public MonitorClass(String _id, CurrDevice currDevice, LastReading lastReading, Thresold thresold) {
        this._id = _id;
        this.currDevice = currDevice;
        this.lastReading = lastReading;
        this.thresold = thresold;
    }


    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCurrDevice(CurrDevice currDevice) {
        this.currDevice = currDevice;
    }

    public void setLastReading(LastReading lastReading) {
        this.lastReading = lastReading;
    }

    public void setThresold(Thresold thresold) {
        this.thresold = thresold;
    }

    public String get_idClass() {
        return _id;
    }

    public CurrDevice getCurrDeviceClass() {
        return currDevice;
    }

    public LastReading getLastReadingClass() {
        return lastReading;
    }

    public Thresold getThresoldClass() {
        return thresold;
    }
}
