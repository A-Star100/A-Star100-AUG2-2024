package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzegq implements zzgdl {
    public final /* synthetic */ zzegu zza;
    public final /* synthetic */ zzffn zzb;
    public final /* synthetic */ zzffz zzc;
    public final /* synthetic */ zzdrm zzd;

    public /* synthetic */ zzegq(zzegu zzegu, zzffn zzffn, zzffz zzffz, zzdrm zzdrm) {
        this.zza = zzegu;
        this.zzb = zzffn;
        this.zzc = zzffz;
        this.zzd = zzdrm;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, obj);
    }
}
