package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzclb implements zzfcc {
    private final Context zza;
    private final zzq zzb;
    private final String zzc;
    private final zzckh zzd;
    private final zzclb zze = this;
    private final zzhje zzf;
    private final zzhje zzg;
    private final zzhje zzh;
    private final zzhje zzi;
    private final zzhje zzj;
    private final zzhje zzk;

    /* synthetic */ zzclb(zzckh zzckh, Context context, String str, zzq zzq, zzcla zzcla) {
        this.zzd = zzckh;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        zzhiv zza2 = zzhiw.zza(context);
        this.zzf = zza2;
        zzhiv zza3 = zzhiw.zza(zzq);
        this.zzg = zza3;
        zzhje zzc2 = zzhiu.zzc(new zzeob(zzckh.zzM));
        this.zzh = zzc2;
        zzhje zzc3 = zzhiu.zzc(zzeog.zza());
        this.zzi = zzc3;
        zzhje zzc4 = zzhiu.zzc(zzddo.zza());
        this.zzj = zzc4;
        this.zzk = zzhiu.zzc(new zzfca(zza2, zzckh.zzc, zza3, zzckh.zzO, zzc2, zzc3, zzfgk.zza(), zzc4));
    }

    public final zzeng zza() {
        VersionInfoParcel zze2 = this.zzd.zza.zze();
        zzhjd.zzb(zze2);
        return new zzeng(this.zza, this.zzb, this.zzc, (zzfbz) this.zzk.zzb(), (zzeoa) this.zzh.zzb(), zze2, (zzduh) this.zzd.zzM.zzb());
    }
}
