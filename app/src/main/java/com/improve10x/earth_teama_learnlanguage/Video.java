package com.improve10x.earth_teama_learnlanguage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Video implements Serializable {

    @SerializedName("_id")
    public String id;
    public String imageUrl;
    public String title;
    public String channelLogImgUrl;
    public String channelName;
    public String views;
    public String uploadedTime;
}
