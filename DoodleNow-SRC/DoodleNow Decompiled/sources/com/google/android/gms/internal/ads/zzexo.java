package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzexo implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;
    private final zzhjm zzf;
    private final zzhjm zzg;

    public zzexo(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6, zzhjm zzhjm7) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
        this.zzf = zzhjm6;
        this.zzg = zzhjm7;
    }

    public static zzexm zza(zzcay zzcay, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        return new zzexm(zzcay, context, scheduledExecutorService, executor, i, z, z2);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzexm(new zzcay(), ((zzciq) this.zzb).zza(), (ScheduledExecutorService) this.zzc.zzb(), zzgep, ((zzezu) this.zze).zzb().intValue(), ((zzezv) this.zzf).zzb().booleanValue(), ((zzezx) this.zzg).zzb().booleanValue());
    }
}
