package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzgdb implements Runnable {
    public final /* synthetic */ zzgdd zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzgdb(zzgdd zzgdd, ListenableFuture listenableFuture, int i) {
        this.zza = zzgdd;
        this.zzb = listenableFuture;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc);
    }
}
