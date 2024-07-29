package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeuh implements zzewr {
    private final zzffm zza;

    zzeuh(zzffm zzffm) {
        this.zza = zzffm;
    }

    public final int zza() {
        return 25;
    }

    public final ListenableFuture zzb() {
        return zzgee.zzh(new zzeui(this.zza));
    }
}
