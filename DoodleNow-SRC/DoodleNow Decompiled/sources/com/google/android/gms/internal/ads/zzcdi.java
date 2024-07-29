package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcdi implements Runnable {
    zzcdi(zzcdk zzcdk) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
