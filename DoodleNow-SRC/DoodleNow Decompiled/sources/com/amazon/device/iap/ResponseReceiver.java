package com.amazon.device.iap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.internal.d;
import com.amazon.device.iap.internal.util.b;

public final class ResponseReceiver extends BroadcastReceiver {
    private static final String TAG = "ResponseReceiver";

    public void onReceive(Context context, Intent intent) {
        try {
            d.e().a(context, intent);
        } catch (Exception e) {
            String str = TAG;
            b.b(str, "Error in onReceive: " + e);
        }
    }
}
