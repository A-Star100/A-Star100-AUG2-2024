package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.amazon.a.a;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.a.e.b;
import com.amazon.device.drm.model.AppstoreSDKModes;
import com.amazon.device.drm.model.RequestId;

/* compiled from: LicensingManager */
public final class d {
    private static String a = "d";
    private static d b = new d();
    private c c;
    private Context d;
    private LicensingListener e;

    public static d d() {
        return b;
    }

    public LicensingListener b() {
        return this.e;
    }

    public Context c() {
        return this.d;
    }

    private d() {
    }

    public void a(Context context, LicensingListener licensingListener) {
        if (licensingListener == null || context == null) {
            throw new IllegalArgumentException("LicensingManager/Context cannot be null");
        }
        String str = a;
        b.a(str, "LicensingListener registered: " + licensingListener);
        String str2 = a;
        b.a(str2, "LicensingListener Context: " + context);
        this.d = context.getApplicationContext();
        this.e = licensingListener;
        c a2 = a.a().a(this.d);
        this.c = a2;
        if (a2 == null) {
            b.a(a, "requestHandler is null");
        }
    }

    public String a() {
        try {
            g();
            if (a.a((Application) this.d.getApplicationContext())) {
                return AppstoreSDKModes.SANDBOX.name();
            }
            return AppstoreSDKModes.PRODUCTION.name();
        } catch (IllegalStateException unused) {
            return AppstoreSDKModes.UNKNOWN.name();
        }
    }

    private void f() {
        if (this.e == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    private void g() {
        if (this.d == null) {
            throw new IllegalStateException("You must register a ApplicationContext before invoking this operation");
        }
    }

    public RequestId e() {
        f();
        RequestId requestId = new RequestId();
        this.c.a(requestId);
        return requestId;
    }

    public void a(Context context, Intent intent) {
        try {
            this.c.a(context, intent);
        } catch (Exception e2) {
            String str = a;
            b.b(str, "Error in onReceive: " + e2);
        }
    }
}
