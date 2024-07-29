package com.amazon.device.iap.internal;

import android.app.Application;
import android.content.Context;
import com.amazon.a.a;
import com.amazon.device.iap.internal.a.d;
import com.amazon.device.iap.internal.c.e;

/* compiled from: ImplementationFactory */
public final class b {
    private static b a = new b();
    private static final String b = b.class.getName();
    private static volatile e c;

    public static b a() {
        return a;
    }

    private b() {
    }

    public e a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    if (a.a((Application) context.getApplicationContext())) {
                        c = new e();
                    } else {
                        c = new d();
                    }
                }
            }
        }
        return c;
    }
}
