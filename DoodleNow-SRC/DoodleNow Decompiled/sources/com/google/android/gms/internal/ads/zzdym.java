package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdym implements zzgdl {
    public final /* synthetic */ zzdyn zza;
    public final /* synthetic */ zzbxd zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzdym(zzdyn zzdyn, zzbxd zzbxd, int i) {
        this.zza = zzdyn;
        this.zzb = zzbxd;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (zzeal) obj);
    }
}
