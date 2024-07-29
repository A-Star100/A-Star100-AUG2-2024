package com.amazon.a;

import android.app.Activity;
import com.amazon.a.a.o.a.a;
import com.amazon.a.a.o.c;

/* compiled from: CrossPlatformPluginUtils */
public class d {
    private static final c a = new c("CrossPlatformPluginUtils");

    private static boolean a() {
        if (a.b() != null) {
            return a.b().h();
        }
        return false;
    }

    public static void a(Activity activity) {
        a.a(a.d(), "AppstoreSDK not initialized");
        if (!a()) {
            a.b().c(activity);
            c cVar = a;
            if (c.a) {
                cVar.a("Notified Visibility for activity:" + activity);
            }
        }
    }
}
