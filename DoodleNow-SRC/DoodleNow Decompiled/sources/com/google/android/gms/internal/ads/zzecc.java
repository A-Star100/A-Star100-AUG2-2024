package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzecc implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzecc(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    /* renamed from: zza */
    public final zzecb zzb() {
        return new zzecb(((zzciq) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
