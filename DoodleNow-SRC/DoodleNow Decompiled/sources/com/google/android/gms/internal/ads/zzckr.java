package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzckr implements zzfao {
    private final zzckh zza;
    private final zzckr zzb = this;
    private final zzhje zzc;
    private final zzhje zzd;
    private final zzhje zze;
    private final zzhje zzf;
    private final zzhje zzg;
    private final zzhje zzh;

    /* synthetic */ zzckr(zzckh zzckh, Context context, String str, zzckq zzckq) {
        this.zza = zzckh;
        zzhiv zza2 = zzhiw.zza(context);
        this.zzc = zza2;
        zzhiv zza3 = zzhiw.zza(str);
        this.zzd = zza3;
        zzfdg zzfdg = new zzfdg(zza2, zzckh.zzaD, zzckh.zzaE);
        this.zze = zzfdg;
        zzhje zzc2 = zzhiu.zzc(new zzfbm(zzckh.zzaD));
        this.zzf = zzc2;
        zzhje zzhje = zzc2;
        zzhje zzc3 = zzhiu.zzc(new zzfbo(zza2, zzckh.zzc, zzckh.zzO, zzfdg, zzhje, zzfgk.zza(), zzckh.zzl));
        this.zzg = zzc3;
        this.zzh = zzhiu.zzc(new zzfbu(zzckh.zzO, zza2, zza3, zzc3, zzhje, zzckh.zzl, zzckh.zzM));
    }

    public final zzfbt zza() {
        return (zzfbt) this.zzh.zzb();
    }
}
