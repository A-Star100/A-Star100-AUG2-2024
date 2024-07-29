package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeck implements Callable {
    public final /* synthetic */ zzecu zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzbxd zzd;
    public final /* synthetic */ zzfkw zze;

    public /* synthetic */ zzeck(zzecu zzecu, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbxd zzbxd, zzfkw zzfkw) {
        this.zza = zzecu;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzbxd;
        this.zze = zzfkw;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
