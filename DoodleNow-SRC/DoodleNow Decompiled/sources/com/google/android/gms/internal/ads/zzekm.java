package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzekm {
    private zzekd zza;

    zzekm() {
    }

    private zzekm(zzekd zzekd) {
        this.zza = zzekd;
    }

    public static zzekm zzb(zzekd zzekd) {
        return new zzekm(zzekd);
    }

    public final zzekd zza(Clock clock, zzekf zzekf, zzego zzego, zzfmt zzfmt) {
        zzekd zzekd = this.zza;
        return zzekd != null ? zzekd : new zzekd(clock, zzekf, zzego, zzfmt);
    }
}
