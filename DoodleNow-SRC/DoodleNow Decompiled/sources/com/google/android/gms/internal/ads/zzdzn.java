package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzn implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;
    private final zzhjm zzf;
    private final zzhjm zzg;

    public zzdzn(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6, zzhjm zzhjm7) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
        this.zzf = zzhjm6;
        this.zzg = zzhjm7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzciq) this.zza).zza();
        zzfgi zza3 = ((zzcyh) this.zzb).zza();
        zzdyn zza4 = ((zzdyo) this.zzc).zzb();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzdzm(zza2, zza3, zza4, zzgep, (ScheduledExecutorService) this.zze.zzb(), (zzedz) this.zzf.zzb(), (zzflh) this.zzg.zzb());
    }
}
