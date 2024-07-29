package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzclz implements zzfdt {
    private final zzckh zza;
    private final zzclz zzb = this;
    private final zzhje zzc;
    private final zzhje zzd;
    private final zzhje zze;
    private final zzhje zzf;
    private final zzhje zzg;
    private final zzhje zzh;
    private final zzhje zzi;

    /* synthetic */ zzclz(zzckh zzckh, Context context, String str, zzq zzq, zzcly zzcly) {
        this.zza = zzckh;
        zzhiv zza2 = zzhiw.zza(context);
        this.zzc = zza2;
        zzhiv zza3 = zzhiw.zza(zzq);
        this.zzd = zza3;
        zzhiv zza4 = zzhiw.zza(str);
        this.zze = zza4;
        zzhje zzc2 = zzhiu.zzc(new zzeob(zzckh.zzM));
        this.zzf = zzc2;
        zzhje zzc3 = zzhiu.zzc(new zzfer(zzckh.zzaD));
        this.zzg = zzc3;
        zzhje zzhje = zzc2;
        zzhje zzhje2 = zzc3;
        zzhje zzc4 = zzhiu.zzc(new zzfdr(zza2, zzckh.zzc, zzckh.zzO, zzhje, zzhje2, zzfgk.zza()));
        this.zzh = zzc4;
        this.zzi = zzhiu.zzc(new zzeoj(zza2, zza3, zza4, zzc4, zzhje, zzhje2, zzckh.zzl, zzckh.zzQ, zzckh.zzM));
    }

    public final zzeoi zza() {
        return (zzeoi) this.zzi.zzb();
    }
}
