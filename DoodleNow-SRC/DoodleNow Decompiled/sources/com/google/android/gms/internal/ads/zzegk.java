package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzegk implements zzegj {
    public final zzegj zza;
    private final zzfwf zzb;

    public zzegk(zzegj zzegj, zzfwf zzfwf) {
        this.zza = zzegj;
        this.zzb = zzfwf;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        return zzgee.zzm(this.zza.zza(zzffz, zzffn), this.zzb, zzcbr.zza);
    }

    public final boolean zzb(zzffz zzffz, zzffn zzffn) {
        return this.zza.zzb(zzffz, zzffn);
    }
}
