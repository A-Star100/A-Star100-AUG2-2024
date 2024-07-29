package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfhm implements zzhiv {
    private final zzfhl zza;

    public zzfhm(zzfhl zzfhl) {
        this.zza = zzfhl;
    }

    public final /* synthetic */ Object zzb() {
        Clock instance = DefaultClock.getInstance();
        zzhjd.zzb(instance);
        return instance;
    }
}
