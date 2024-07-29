package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdnu implements zzgdl {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdnu(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        if (((zzcgm) obj) != null) {
            return this.zza;
        }
        throw new zzekh(1, "Retrieve Web View from image ad response failed.");
    }
}
