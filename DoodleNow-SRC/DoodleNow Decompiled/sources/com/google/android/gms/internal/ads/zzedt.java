package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzedt implements Callable {
    public final /* synthetic */ zzedr zza;

    public /* synthetic */ zzedt(zzedr zzedr) {
        this.zza = zzedr;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
