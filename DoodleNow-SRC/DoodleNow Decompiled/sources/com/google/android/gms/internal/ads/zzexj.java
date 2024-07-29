package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzexj implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;
    private final zzhjm zzf;

    public zzexj(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
        this.zzf = zzhjm6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzg zza2 = ((zzcio) this.zza).zzb();
        Context zza3 = ((zzciq) this.zzb).zza();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzexg(zza2, zza3, zzgep, (ScheduledExecutorService) this.zzd.zzb(), ((zzegi) this.zze).zzb(), ((zzcyh) this.zzf).zza());
    }
}
