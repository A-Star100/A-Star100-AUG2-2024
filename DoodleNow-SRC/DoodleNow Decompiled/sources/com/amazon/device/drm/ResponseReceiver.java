package com.amazon.device.drm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.drm.a.d;
import com.amazon.device.drm.a.e.b;

public class ResponseReceiver extends BroadcastReceiver {
    private static final String TAG = "ResponseReceiver";

    public void onReceive(Context context, Intent intent) {
        try {
            d.d().a(context, intent);
        } catch (Exception e) {
            String str = TAG;
            b.b(str, "Error in onReceive: " + e);
        }
    }
}
