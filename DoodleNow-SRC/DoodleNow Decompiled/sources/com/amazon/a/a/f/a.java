package com.amazon.a.a.f;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.amazon.a.a.o.c;

/* compiled from: ApplicationLifecycleObserver */
public class a implements Application.ActivityLifecycleCallbacks {
    private static final c a = new c("ApplicationLifecycleObserver");
    private static final String b = "a";
    private static final a c = new a();

    public static a a() {
        return c;
    }

    private a() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!com.amazon.a.a.d()) {
            com.amazon.a.a.a((Context) activity.getApplication());
            a.a("AppstoreSDK Re-initialized");
        }
        if (a("onCreate", activity)) {
            com.amazon.a.a.b().a(activity);
        }
        if (c.a) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            c cVar = a;
            cVar.a("ActivityOnCreate Time: " + (elapsedRealtime2 - elapsedRealtime));
        }
    }

    public void onActivityStarted(Activity activity) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onStart", activity)) {
            com.amazon.a.a.b().e(activity);
        }
        if (c.a) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            c cVar = a;
            cVar.a("ActivityOnStart Time: " + (elapsedRealtime2 - elapsedRealtime));
        }
    }

    public void onActivityResumed(Activity activity) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onResume", activity)) {
            com.amazon.a.a.b().c(activity);
        }
        if (c.a) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            c cVar = a;
            cVar.a("ActivityOnResume Time: " + (elapsedRealtime2 - elapsedRealtime));
        }
    }

    public void onActivityPaused(Activity activity) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onPause", activity)) {
            com.amazon.a.a.b().d(activity);
        }
        if (c.a) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            c cVar = a;
            cVar.a("ActivityOnPause Time: " + (elapsedRealtime2 - elapsedRealtime));
        }
    }

    public void onActivityStopped(Activity activity) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onStop", activity)) {
            com.amazon.a.a.b().f(activity);
        }
        if (c.a) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            c cVar = a;
            cVar.a("ActivityOnStop Time: " + (elapsedRealtime2 - elapsedRealtime));
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        c cVar = a;
        cVar.a(b + " onActivitySaveInstanceState " + activity.getLocalClassName());
    }

    public void onActivityDestroyed(Activity activity) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onDestroy", activity)) {
            try {
                com.amazon.a.a.b().b(activity);
            } catch (Exception e) {
                a.b("ActivityOnDestroy Error: ", e);
            }
        }
        if (c.a) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            c cVar = a;
            cVar.a("ActivityOnDestroy Time: " + (elapsedRealtime2 - elapsedRealtime));
        }
    }

    private static boolean b() {
        return com.amazon.a.a.d();
    }

    private static boolean a(String str, Context context) {
        return com.amazon.a.a.a(str, context);
    }
}
