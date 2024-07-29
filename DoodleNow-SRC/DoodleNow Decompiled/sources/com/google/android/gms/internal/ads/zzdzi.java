package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzi implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;

    public zzdzi(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
    }

    /* renamed from: zza */
    public final zzdzh zzb() {
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        zzgep zzgep2 = zzcbr.zzb;
        zzhjd.zzb(zzgep2);
        return new zzdzh((ScheduledExecutorService) this.zza.zzb(), zzgep, zzgep2, ((zzdzz) this.zzd).zzb(), zzhiu.zza(zzhjg.zza(this.zze)));
    }
}
