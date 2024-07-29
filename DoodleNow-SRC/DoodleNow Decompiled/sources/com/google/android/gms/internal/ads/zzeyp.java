package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeyp implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;

    public zzeyp(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
    }

    public static zzeyn zza(String str, zzbca zzbca, zzcbh zzcbh, ScheduledExecutorService scheduledExecutorService, zzgep zzgep) {
        return new zzeyn(str, zzbca, zzcbh, scheduledExecutorService, zzgep);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzeyn(((zzezt) this.zza).zza(), new zzbca(), (zzcbh) this.zzc.zzb(), (ScheduledExecutorService) this.zzd.zzb(), zzgep);
    }
}
