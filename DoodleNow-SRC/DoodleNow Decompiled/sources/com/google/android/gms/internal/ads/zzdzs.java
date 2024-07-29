package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzs implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;
    private final zzhjm zzf;
    private final zzhjm zzg;
    private final zzhjm zzh;

    public zzdzs(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6, zzhjm zzhjm7, zzhjm zzhjm8) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
        this.zzf = zzhjm6;
        this.zzg = zzhjm7;
        this.zzh = zzhjm8;
    }

    /* renamed from: zza */
    public final zzdzr zzb() {
        Context zza2 = ((zzciq) this.zzb).zza();
        VersionInfoParcel zza3 = ((zzcjc) this.zzc).zza();
        zzfgi zza4 = ((zzcyh) this.zzd).zza();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        return new zzdzr((zzcik) this.zza.zzb(), zza2, zza3, zza4, zzgep, (String) this.zzf.zzb(), (zzflh) this.zzg.zzb(), (zzduc) this.zzh.zzb());
    }
}
