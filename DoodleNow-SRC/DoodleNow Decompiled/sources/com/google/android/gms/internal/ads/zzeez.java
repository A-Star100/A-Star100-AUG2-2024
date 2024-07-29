package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeez implements Callable {
    public final /* synthetic */ zzefd zza;

    public /* synthetic */ zzeez(zzefd zzefd) {
        this.zza = zzefd;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
