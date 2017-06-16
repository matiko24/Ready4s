package com.example.mateusz.ready4s.data.model;

/**
 * Created by Mateusz on 2017-06-14.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {


    public Place(String id, String avatar, Double lat, Double lng, String name) {
        this.lng = lng;
        this.name = name;
        this.id = id;
        this.lat = lat;
        this.avatar = avatar;
    }

    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
