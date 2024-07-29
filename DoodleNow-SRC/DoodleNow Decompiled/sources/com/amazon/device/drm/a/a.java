package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;
import com.amazon.device.drm.a.d.c;

/* compiled from: LicenseImplementationFactory */
public final class a {
    private static a a = new a();
    private static volatile c b;

    public static a a() {
        return a;
    }

    private a() {
    }

    public c a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                        b = new c();
                    } else {
                        b = new com.amazon.device.drm.a.b.c();
                    }
                }
            }
        }
        return b;
    }
}
