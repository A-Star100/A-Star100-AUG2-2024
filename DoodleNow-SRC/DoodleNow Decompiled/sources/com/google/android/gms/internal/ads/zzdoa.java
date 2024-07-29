package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdoa implements zzgdl {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdoa(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        return obj != null ? this.zza : zzgee.zzg(new zzekh(1, "Retrieve required value in native ad response failed."));
    }
}
