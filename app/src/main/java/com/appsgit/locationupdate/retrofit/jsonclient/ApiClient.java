//ApiClient.java
package com.appsgit.locationupdate.retrofit.jsonclient;

import android.location.Location;

import com.appsgit.locationupdate.retrofit.jsonclient.model.LocationData;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created on 10/15/17.
 */

public interface ApiClient {

    @FormUrlEncoded
    @POST("/mapsync/add_markers.php")
    Call<ResponseBody> updateLocation(@Field(value = "name") String name, @Field(value = "lat") double lat, @Field(value = "lng") double lng);
}
