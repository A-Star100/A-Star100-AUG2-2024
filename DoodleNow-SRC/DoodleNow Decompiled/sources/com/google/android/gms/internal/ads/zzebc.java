package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzebc implements zzgdl {
    public final /* synthetic */ zzebd zza;
    public final /* synthetic */ zzbwi zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzebc(zzebd zzebd, zzbwi zzbwi, int i) {
        this.zza = zzebd;
        this.zzb = zzbwi;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (zzeal) obj);
    }
}
