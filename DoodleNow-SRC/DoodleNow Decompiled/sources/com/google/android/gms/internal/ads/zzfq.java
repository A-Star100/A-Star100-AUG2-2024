package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfq implements zzel {
    protected zzfq() {
    }

    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    public final zzev zzb(Looper looper, Handler.Callback callback) {
        return new zzft(new Handler(looper, callback));
    }
}
