package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzehj implements zzgdl {
    public final /* synthetic */ zzehk zza;
    public final /* synthetic */ zzffz zzb;
    public final /* synthetic */ zzffn zzc;

    public /* synthetic */ zzehj(zzehk zzehk, zzffz zzffz, zzffn zzffn) {
        this.zza = zzehk;
        this.zzb = zzffz;
        this.zzc = zzffn;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
