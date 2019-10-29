package com.example.gridtolist;


public class item {
    private int imgResId;
    private String title;
    private String desc;
    private String comments;

    public item(int imgResId, String title, String desc, String comments){
        this.imgResId=imgResId;
        this.title=title;
        this.desc=desc;
        this.comments=comments;
    }
    public int getImgResId(){
        return imgResId;
    }
    public String getTitle(){
        return title;
    }
    public String  getDesc(){
        return desc;
    }
    public String getComments(){
        return comments;
    }
    }

