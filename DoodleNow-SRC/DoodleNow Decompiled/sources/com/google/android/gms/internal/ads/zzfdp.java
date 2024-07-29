package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfdp implements zzgea {
    final /* synthetic */ zzeop zza;
    final /* synthetic */ zzflh zzb;
    final /* synthetic */ zzfkw zzc;
    final /* synthetic */ zzdim zzd;
    final /* synthetic */ zzfdq zze;

    zzfdp(zzfdq zzfdq, zzeop zzeop, zzflh zzflh, zzfkw zzfkw, zzdim zzdim) {
        this.zza = zzeop;
        this.zzb = zzflh;
        this.zzc = zzfkw;
        this.zzd = zzdim;
        this.zze = zzfdq;
    }

    public final void zza(Throwable th) {
        zzflh zzflh;
        zze zza2 = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zzdB(zza2);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzig)).booleanValue()) {
                this.zze.zzb.execute(new zzfdl(this, zza2));
                this.zze.zzb.execute(new zzfdm(this, zza2));
            }
            zzfhf.zzb(zza2.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zze2 = this.zze.zzg;
                zzfkw zzfkw = this.zzc;
                zzfkw.zza(zza2);
                zzfkw.zzh(th);
                zzfkw.zzg(false);
                zze2.zzb(zzfkw.zzm());
            } else {
                zzflh.zzc(zza2);
                zzfkw zzfkw2 = this.zzc;
                zzfkw2.zzh(th);
                zzfkw2.zzg(false);
                zzflh.zza(zzfkw2);
                zzflh.zzh();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflh zzflh;
        zzdhl zzdhl = (zzdhl) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzig)).booleanValue()) {
                zzdcv zzn = zzdhl.zzn();
                zzn.zza(this.zze.zzd);
                zzn.zzd(this.zze.zze);
            }
            this.zza.zzb(zzdhl);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzig)).booleanValue()) {
                this.zze.zzb.execute(new zzfdn(this));
                this.zze.zzb.execute(new zzfdo(this));
            }
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zze2 = this.zze.zzg;
                zzfkw zzfkw = this.zzc;
                zzfkw.zzb(zzdhl.zzp().zzb);
                zzfkw.zze(zzdhl.zzl().zzg());
                zzfkw.zzg(true);
                zze2.zzb(zzfkw.zzm());
            } else {
                zzflh.zzg(zzdhl.zzp().zzb);
                zzflh.zzf(zzdhl.zzl().zzg());
                zzfkw zzfkw2 = this.zzc;
                zzfkw2.zzg(true);
                zzflh.zza(zzfkw2);
                zzflh.zzh();
            }
        }
    }
}
