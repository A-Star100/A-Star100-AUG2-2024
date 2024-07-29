package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdyk implements Callable {
    public final /* synthetic */ zzdyn zza;
    public final /* synthetic */ zzbxd zzb;

    public /* synthetic */ zzdyk(zzdyn zzdyn, zzbxd zzbxd) {
        this.zza = zzdyn;
        this.zzb = zzbxd;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
