package io.nlopez.smartlocation.location.utils;

import android.content.Context;
import android.location.LocationManager;
import android.provider.Settings;

public class LocationState {
    private static LocationState instance;
    private Context context;
    private LocationManager locationManager;

    private LocationState(Context context2) {
        this.context = context2;
        this.locationManager = (LocationManager) context2.getSystemService("location");
    }

    public static LocationState with(Context context2) {
        if (instance == null) {
            instance = new LocationState(context2.getApplicationContext());
        }
        return instance;
    }

    public boolean locationServicesEnabled() {
        try {
            return Settings.Secure.getInt(this.context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException unused) {
        }
    }

    public boolean isAnyProviderAvailable() {
        return isGpsAvailable() || isNetworkAvailable();
    }

    public boolean isGpsAvailable() {
        return this.locationManager.isProviderEnabled("gps");
    }

    public boolean isNetworkAvailable() {
        return this.locationManager.isProviderEnabled("network");
    }

    public boolean isPassiveAvailable() {
        return this.locationManager.isProviderEnabled("passive");
    }

    @Deprecated
    public boolean isMockSettingEnabled() {
        return !SessionDescription.SUPPORTED_SDP_VERSION.equals(Settings.Secure.getString(this.context.getContentResolver(), "mock_location"));
    }
}
