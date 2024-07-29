package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcxv implements zzhiv {
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
    private final zzhjm zzk;
    private final zzhjm zzl;

    public zzcxv(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6, zzhjm zzhjm7, zzhjm zzhjm8, zzhjm zzhjm9, zzhjm zzhjm10, zzhjm zzhjm11, zzhjm zzhjm12) {
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
        this.zzk = zzhjm11;
        this.zzl = zzhjm12;
    }

    /* renamed from: zza */
    public final zzcxu zzb() {
        VersionInfoParcel zza2 = ((zzcjc) this.zzb).zza();
        ApplicationInfo zza3 = ((zzdyv) this.zzc).zzb();
        String zza4 = ((zzdza) this.zzd).zzb();
        zzbdq zzbdq = zzbdz.zza;
        return new zzcxu((zzfkn) this.zza.zzb(), zza2, zza3, zza4, zzba.zza().zza(), (PackageInfo) this.zzf.zzb(), zzhiu.zza(zzhjg.zza(this.zzg)), ((zzcio) this.zzh).zzb(), (String) this.zzi.zzb(), ((zzewv) this.zzj).zzb(), ((zzcyh) this.zzk).zza(), (zzddz) this.zzl.zzb());
    }
}
