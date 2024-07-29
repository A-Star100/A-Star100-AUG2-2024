package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzczf implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;

    public zzczf(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzczc zza2 = ((zzcze) this.zza).zzb();
        Set zzc2 = ((zzhjj) this.zzb).zzb();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzczd(zza2, zzc2, zzgep, (ScheduledExecutorService) this.zzd.zzb());
    }
}
