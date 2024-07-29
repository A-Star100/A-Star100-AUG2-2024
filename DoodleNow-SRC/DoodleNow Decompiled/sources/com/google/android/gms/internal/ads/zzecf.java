package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzecf implements Callable {
    public final /* synthetic */ ListenableFuture zza;
    public final /* synthetic */ ListenableFuture zzb;

    public /* synthetic */ zzecf(ListenableFuture listenableFuture, ListenableFuture listenableFuture2) {
        this.zza = listenableFuture;
        this.zzb = listenableFuture2;
    }

    public final Object call() {
        ListenableFuture listenableFuture = this.zzb;
        return new zzect((zzedh) this.zza.get(), ((zzecr) listenableFuture.get()).zzb, ((zzecr) listenableFuture.get()).zza);
    }
}
