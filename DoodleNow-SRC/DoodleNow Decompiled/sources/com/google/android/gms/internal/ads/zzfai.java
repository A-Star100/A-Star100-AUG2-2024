package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfai implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;
    private final zzhjm zzf;
    private final zzhjm zzg;

    public zzfai(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6, zzhjm zzhjm7) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
        this.zzf = zzhjm6;
        this.zzg = zzhjm7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        boolean booleanValue = ((zzezw) this.zzb).zzb().booleanValue();
        boolean booleanValue2 = ((zzezx) this.zzc).zzb().booleanValue();
        zzcaw zzcaw = new zzcaw();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzfag((zzcbh) this.zza.zzb(), booleanValue, booleanValue2, zzcaw, zzgep, ((zzezt) this.zzf).zza(), (ScheduledExecutorService) this.zzg.zzb());
    }
}
