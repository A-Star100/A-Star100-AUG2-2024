package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejv extends zzejs {
    private final zzcik zza;
    private final zzcxy zzb;
    private final zzemj zzc;
    private final zzdeh zzd;
    private final zzdjd zze;
    private final zzdbf zzf;
    private final ViewGroup zzg;
    private final zzddm zzh;
    private final zzekd zzi;
    private final zzego zzj;

    public zzejv(zzcik zzcik, zzcxy zzcxy, zzemj zzemj, zzdeh zzdeh, zzdjd zzdjd, zzdbf zzdbf, ViewGroup viewGroup, zzddm zzddm, zzekd zzekd, zzego zzego) {
        this.zza = zzcik;
        this.zzb = zzcxy;
        this.zzc = zzemj;
        this.zzd = zzdeh;
        this.zze = zzdjd;
        this.zzf = zzdbf;
        this.zzg = viewGroup;
        this.zzh = zzddm;
        this.zzi = zzekd;
        this.zzj = zzego;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfgi zzfgi, Bundle bundle, zzffn zzffn, zzffz zzffz) {
        zzcxy zzcxy = this.zzb;
        zzcxy.zzi(zzfgi);
        zzcxy.zzf(bundle);
        zzcxy.zzg(new zzcxs(zzffz, zzffn, this.zzi));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdv)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzcik zzcik = this.zza;
        zzcxy zzcxy2 = this.zzb;
        zzcsl zze2 = zzcik.zze();
        zze2.zzi(zzcxy2.zzj());
        zze2.zzf(this.zzd);
        zze2.zze(this.zzc);
        zze2.zzd(this.zze);
        zze2.zzg(new zzctn(this.zzf, this.zzh));
        zze2.zzc(new zzcrj(this.zzg));
        zzcvd zzd2 = zze2.zzk().zzd();
        return zzd2.zzi(zzd2.zzj());
    }
}
