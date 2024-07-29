package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzevj implements zzewr {
    private final String zza;
    private final String zzb;

    zzevj(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final int zza() {
        return 31;
    }

    public final ListenableFuture zzb() {
        return zzgee.zzh(new zzevk(this.zza, this.zzb));
    }
}
