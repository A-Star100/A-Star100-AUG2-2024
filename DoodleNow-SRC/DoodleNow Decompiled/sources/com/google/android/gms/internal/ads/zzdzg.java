package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdzg implements zzgdl {
    public final /* synthetic */ zzdzh zza;
    public final /* synthetic */ zzbxd zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzdzg(zzdzh zzdzh, zzbxd zzbxd, int i) {
        this.zza = zzdzh;
        this.zzb = zzbxd;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (Throwable) obj);
    }
}
