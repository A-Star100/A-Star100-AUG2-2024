package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcuh implements zzgdl {
    public final /* synthetic */ zzcuk zza;
    public final /* synthetic */ zzgea zzb;
    public final /* synthetic */ ListenableFuture zzc;

    public /* synthetic */ zzcuh(zzcuk zzcuk, zzgea zzgea, ListenableFuture listenableFuture) {
        this.zza = zzcuk;
        this.zzb = zzgea;
        this.zzc = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zza(this.zzb, this.zzc, (zzctv) obj);
    }
}
