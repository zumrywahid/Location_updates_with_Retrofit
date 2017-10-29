package com.appsgit.locationupdate.retrofit;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.view.View;

import com.appsgit.locationupdate.retrofit.jsonclient.model.LocationData;
import com.appsgit.locationupdate.retrofit.jsonclient.services.LocationService;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Handles incoming location updates and displays a notification with the location data.
 */
public class LocationUpdatesIntentService extends IntentService {

    static final String ACTION_PROCESS_UPDATES =
            "com.appsgit.locationupdate.retrofit.action" + ".PROCESS_UPDATES";

    private static final String TAG = LocationUpdatesIntentService.class.getSimpleName();


    public LocationUpdatesIntentService() {
        // Name the worker thread.
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_PROCESS_UPDATES.equals(action)) {
                LocationResult result = LocationResult.extractResult(intent);
                if (result != null) {
                    List<Location> locations = result.getLocations();
                    LocationResultHelper locationResultHelper = new LocationResultHelper(this,
                            locations);
                    // Save the location data to SharedPreferences.
                    locationResultHelper.saveResults();

                    Location firstLocation = locations.get(0);

                    LocationData data = new LocationData();
                    data.setName(LocationRequestHelper.getFilterName(this));
                    data.setLat(firstLocation.getLatitude());
                    data.setLng(firstLocation.getLongitude());
                    updateServer(data);
                    // Show notification with the location data.
                    locationResultHelper.showNotification();
                    Log.i(TAG, LocationResultHelper.getSavedLocationResult(this));
                }
            }
        }
    }

    public void updateServer(LocationData locationData) {
        try {
            Log.d(TAG, "updateServer: called.. " + LocationRequestHelper.getFilterName(this));
            new LocationService().saveLocationData(this, locationData, new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    Log.d(TAG, "onResponse: called...");
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

