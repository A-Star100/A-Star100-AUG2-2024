package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgcy extends zzgda {
    zzgcy(ListenableFuture listenableFuture, zzgdl zzgdl) {
        super(listenableFuture, zzgdl);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        zzgdl zzgdl = (zzgdl) obj;
        ListenableFuture zza = zzgdl.zza(obj2);
        zzfwr.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgdl);
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
