package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdwl implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;
    private final zzhjm zzf;
    private final zzhjm zzg;
    private final zzhjm zzh;
    private final zzhjm zzi;
    private final zzhjm zzj;

    public zzdwl(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6, zzhjm zzhjm7, zzhjm zzhjm8, zzhjm zzhjm9, zzhjm zzhjm10) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
        this.zzf = zzhjm6;
        this.zzg = zzhjm7;
        this.zzh = zzhjm8;
        this.zzi = zzhjm9;
        this.zzj = zzhjm10;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzciq) this.zzb).zza();
        WeakReference zza3 = ((zzcir) this.zzc).zza();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzdwk((Executor) this.zza.zzb(), zza2, zza3, zzgep, (zzdry) this.zze.zzb(), (ScheduledExecutorService) this.zzf.zzb(), (zzdur) this.zzg.zzb(), ((zzcjc) this.zzh).zza(), ((zzdfn) this.zzi).zzb(), (zzflk) this.zzj.zzb());
    }
}
