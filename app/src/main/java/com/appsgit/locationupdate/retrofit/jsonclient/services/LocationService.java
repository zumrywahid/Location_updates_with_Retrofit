package com.appsgit.locationupdate.retrofit.jsonclient.services;

import android.content.Context;

import com.appsgit.locationupdate.retrofit.jsonclient.ApiClient;
import com.appsgit.locationupdate.retrofit.jsonclient.ApiClientBuilder;
import com.appsgit.locationupdate.retrofit.jsonclient.model.LocationData;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;


public class LocationService {

    String BASE_URL = "";

    public void saveLocationData(Context context, LocationData data, Callback<ResponseBody> callback) {

        ApiClient service = ApiClientBuilder.getMGClient();

        Call<ResponseBody> result =  service.updateLocation(data.getName(), data.getLat(), data.getLng());

        result.enqueue(callback);

    }

}
