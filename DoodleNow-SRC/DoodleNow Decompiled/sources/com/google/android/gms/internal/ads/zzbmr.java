package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbmr implements zzgdl {
    final /* synthetic */ zzbmj zza;

    zzbmr(zzbmv zzbmv, zzbmj zzbmj) {
        this.zza = zzbmj;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzcbw zzcbw = new zzcbw();
        ((zzbmp) obj).zze(this.zza, new zzbmq(this, zzcbw));
        return zzcbw;
    }
}
