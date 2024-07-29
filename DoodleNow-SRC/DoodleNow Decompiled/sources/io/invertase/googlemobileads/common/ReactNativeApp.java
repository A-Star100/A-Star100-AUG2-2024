package io.invertase.googlemobileads.common;

import android.content.Context;
import android.util.Log;

public class ReactNativeApp {
    private static Context applicationContext;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(Context context) {
        Log.d("ReactNativeApp", "received application context.");
        applicationContext = context;
    }
}
