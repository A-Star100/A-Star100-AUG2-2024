package com.amazon.device.drm.a.b;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.drm.a.e.b;
import com.amazon.device.drm.model.RequestId;

/* compiled from: KiwiRequestHandler */
public class c implements com.amazon.device.drm.a.c {
    private static final String a = "c";

    public void a(Context context, Intent intent) {
    }

    public void a(RequestId requestId) {
        b.a(a, "sendGetLicense");
        new com.amazon.device.drm.a.a.b(requestId).e();
    }
}
