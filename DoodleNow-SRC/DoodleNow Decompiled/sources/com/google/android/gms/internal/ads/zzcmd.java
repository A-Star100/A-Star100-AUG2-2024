package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcmd implements zzffh {
    private final zzckh zza;
    private final zzcmd zzb = this;
    private final zzhje zzc;
    private final zzhje zzd;
    private final zzhje zze;
    private final zzhje zzf;
    private final zzhje zzg;
    private final zzhje zzh;
    private final zzhje zzi;
    private final zzhje zzj;

    /* synthetic */ zzcmd(zzckh zzckh, Context context, String str, zzcmc zzcmc) {
        this.zza = zzckh;
        zzhiv zza2 = zzhiw.zza(context);
        this.zzc = zza2;
        zzfdh zzfdh = new zzfdh(zza2, zzckh.zzaD, zzckh.zzaE);
        this.zzd = zzfdh;
        zzhje zzc2 = zzhiu.zzc(new zzfer(zzckh.zzaD));
        this.zze = zzc2;
        zzhje zzc3 = zzhiu.zzc(zzfgf.zza());
        this.zzf = zzc3;
        zzhje zzc4 = zzhiu.zzc(new zzffb(zza2, zzckh.zzc, zzckh.zzO, zzfdh, zzc2, zzfgk.zza(), zzc3));
        this.zzg = zzc4;
        this.zzh = zzhiu.zzc(new zzffl(zzc4, zzc2, zzc3));
        zzhiv zzc5 = zzhiw.zzc(str);
        this.zzi = zzc5;
        this.zzj = zzhiu.zzc(new zzfff(zzc5, zzc4, zza2, zzc2, zzc3, zzckh.zzl, zzckh.zzQ, zzckh.zzM));
    }

    public final zzffe zza() {
        return (zzffe) this.zzj.zzb();
    }

    public final zzffk zzb() {
        return (zzffk) this.zzh.zzb();
    }
}
