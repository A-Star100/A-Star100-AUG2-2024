package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcrq implements zzhiv {
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

    public zzcrq(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6, zzhjm zzhjm7, zzhjm zzhjm8, zzhjm zzhjm9, zzhjm zzhjm10) {
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

    public static zzcrp zzc(zzctu zzctu, Context context, zzffo zzffo, View view, zzcgm zzcgm, zzctt zzctt, zzdlj zzdlj, zzdgp zzdgp, zzhip zzhip, Executor executor) {
        return new zzcrp(zzctu, context, zzffo, view, zzcgm, zzctt, zzdlj, zzdgp, zzhip, executor);
    }

    /* renamed from: zza */
    public final zzcrp zzb() {
        return new zzcrp(((zzcwf) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcrw) this.zzc).zza(), ((zzcrv) this.zzd).zza(), ((zzcsi) this.zze).zza(), ((zzcrx) this.zzf).zza(), ((zzdjg) this.zzg).zza(), (zzdgp) this.zzh.zzb(), zzhiu.zza(zzhjg.zza(this.zzi)), (Executor) this.zzj.zzb());
    }
}
