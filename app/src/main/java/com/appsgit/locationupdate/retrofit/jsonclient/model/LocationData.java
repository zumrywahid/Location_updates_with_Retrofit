package com.appsgit.locationupdate.retrofit.jsonclient.model;

import com.google.gson.annotations.Expose;

import java.io.File;

/**
 * Created on 10/16/17.
 */

public class LocationData {

    @Expose
    String name;
    @Expose
    double lat;
    @Expose
    double lng;

    String response;

    public String getName() {
        return name;
    }

    public LocationData setName(String name) {
        this.name = name;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public LocationData setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLng() {
        return lng;
    }

    public LocationData setLng(double lng) {
        this.lng = lng;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public LocationData setResponse(String response) {
        this.response = response;
        return this;
    }
}
