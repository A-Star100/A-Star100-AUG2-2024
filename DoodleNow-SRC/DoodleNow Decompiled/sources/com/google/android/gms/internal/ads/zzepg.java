package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzepg implements zzewr {
    private final Clock zza;
    private final zzfgi zzb;

    zzepg(Clock clock, zzfgi zzfgi) {
        this.zza = clock;
        this.zzb = zzfgi;
    }

    public final int zza() {
        return 4;
    }

    public final ListenableFuture zzb() {
        return zzgee.zzh(new zzeph(this.zzb, this.zza.currentTimeMillis()));
    }
}
