package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfkp implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzfkp(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzfkn(zzgep, (ScheduledExecutorService) this.zzb.zzb(), ((zzfkq) this.zzc).zzb());
    }
}
