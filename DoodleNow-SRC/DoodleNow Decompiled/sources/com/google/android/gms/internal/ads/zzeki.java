package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeki implements zzgdl {
    public final /* synthetic */ zzekk zza;
    public final /* synthetic */ zzffn zzb;
    public final /* synthetic */ zzffz zzc;
    public final /* synthetic */ zzegj zzd;

    public /* synthetic */ zzeki(zzekk zzekk, zzffn zzffn, zzffz zzffz, zzegj zzegj) {
        this.zza = zzekk;
        this.zzb = zzffn;
        this.zzc = zzffz;
        this.zzd = zzegj;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, (Throwable) obj);
    }
}
