package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdzf implements Callable {
    public final /* synthetic */ zzdzh zza;
    public final /* synthetic */ zzbxd zzb;

    public /* synthetic */ zzdzf(zzdzh zzdzh, zzbxd zzbxd) {
        this.zza = zzdzh;
        this.zzb = zzbxd;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
