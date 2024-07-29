package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdns implements zzgdl {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdns(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        zzcgm zzcgm = (zzcgm) obj;
        if (zzcgm != null && zzcgm.zzq() != null) {
            return this.zza;
        }
        throw new zzekh(1, "Retrieve video view in html5 ad response failed.");
    }
}
