package com.appsgit.locationupdate.retrofit;

import android.content.Context;
import android.preference.PreferenceManager;


class LocationRequestHelper {

    final public static String KEY_FILTER_NAME_UPDATED = "filter_name_updated";
    final public static String KEY_LOCATION_UPDATES_REQUESTED = "location-updates-requested";
    final public static String KEY_LOCATION_UPLADED_TO_SERVER = "location-uploaed-to-server";

    public static void setRequesting(Context context, boolean value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_LOCATION_UPDATES_REQUESTED, value)
                .apply();
    }

    public static boolean getRequesting(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_LOCATION_UPDATES_REQUESTED, false);
    }

    public static void setFilterName(Context context, String value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(KEY_FILTER_NAME_UPDATED, value)
                .apply();
    }

    public static String getFilterName(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(KEY_FILTER_NAME_UPDATED, "");
    }

    public static void setServerUpdteDateTime(Context context, String value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(KEY_FILTER_NAME_UPDATED, value)
                .apply();
    }

    public static String getServerUpdteDateTime(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(KEY_FILTER_NAME_UPDATED, "");
    }
}
