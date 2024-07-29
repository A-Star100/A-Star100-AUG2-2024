package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzgdv extends zzgef {
    zzgdv() {
    }

    public static zzgdv zzu(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof zzgdv) {
            return (zzgdv) listenableFuture;
        }
        return new zzgdw(listenableFuture);
    }
}
