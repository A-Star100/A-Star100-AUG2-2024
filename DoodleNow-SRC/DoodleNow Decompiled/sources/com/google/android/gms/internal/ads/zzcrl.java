package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcrl implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzcrl(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    /* renamed from: zza */
    public final zzdbf zzb() {
        return new zzdbf((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb());
    }
}
