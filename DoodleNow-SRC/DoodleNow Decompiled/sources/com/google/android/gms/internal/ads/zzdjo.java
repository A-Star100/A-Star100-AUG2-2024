package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdjo implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;
    private final zzhjm zzf;

    public zzdjo(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5, zzhjm zzhjm6) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
        this.zzf = zzhjm6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcxy zza2 = ((zzcyi) this.zzb).zza();
        zzdeh zza3 = ((zzdfb) this.zzc).zza();
        zzdjd zza4 = ((zzdjf) this.zzd).zza();
        zzdbf zza5 = ((zzcrl) this.zze).zzb();
        zzekd zzekd = (zzekd) this.zzf.zzb();
        zzcsl zze2 = ((zzcik) this.zza.zzb()).zze();
        zze2.zzi(zza2.zzj());
        zze2.zzf(zza3);
        zze2.zzd(zza4);
        zze2.zze(new zzemj((zzbeu) null));
        zze2.zzg(new zzctn(zza5, (zzddm) null));
        zze2.zzc(new zzcrj((ViewGroup) null));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdy)).booleanValue()) {
            zze2.zzj(zzekm.zzb(zzekd));
        }
        zzcty zzc2 = zze2.zzk().zzc();
        zzhjd.zzb(zzc2);
        return zzc2;
    }
}
