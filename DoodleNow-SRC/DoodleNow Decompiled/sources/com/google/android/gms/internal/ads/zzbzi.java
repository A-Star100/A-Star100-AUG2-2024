package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbzi implements zzgea {
    final /* synthetic */ ListenableFuture zza;

    zzbzi(zzbzj zzbzj, ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final void zza(Throwable th) {
        zzbzj.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzbzj.zzc.remove(this.zza);
    }
}
