package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeav implements zzgdl {
    public final /* synthetic */ zzeay zza;
    public final /* synthetic */ zzeax zzb;
    public final /* synthetic */ zzbxd zzc;
    public final /* synthetic */ zzgdl zzd;

    public /* synthetic */ zzeav(zzeay zzeay, zzeax zzeax, zzbxd zzbxd, zzgdl zzgdl) {
        this.zza = zzeay;
        this.zzb = zzeax;
        this.zzc = zzbxd;
        this.zzd = zzgdl;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, (zzeal) obj);
    }
}
