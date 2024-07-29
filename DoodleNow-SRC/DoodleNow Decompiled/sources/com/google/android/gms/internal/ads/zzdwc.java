package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdwc implements Callable {
    public final /* synthetic */ zzdwk zza;
    public final /* synthetic */ zzfkw zzb;

    public /* synthetic */ zzdwc(zzdwk zzdwk, zzfkw zzfkw) {
        this.zza = zzdwk;
        this.zzb = zzfkw;
    }

    public final Object call() {
        this.zza.zzf(this.zzb);
        return null;
    }
}
