package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfas implements zzgea {
    final /* synthetic */ zzeop zza;
    final /* synthetic */ zzflh zzb;
    final /* synthetic */ zzfkw zzc;
    final /* synthetic */ zzfau zzd;
    final /* synthetic */ zzfav zze;

    zzfas(zzfav zzfav, zzeop zzeop, zzflh zzflh, zzfkw zzfkw, zzfau zzfau) {
        this.zza = zzeop;
        this.zzb = zzflh;
        this.zzc = zzfkw;
        this.zzd = zzfau;
        this.zze = zzfav;
    }

    /* JADX WARNING: type inference failed for: r0v17, types: [com.google.android.gms.internal.ads.zzcqw, java.lang.Object] */
    public final void zza(Throwable th) {
        zze zze2;
        zzflh zzflh;
        zzcqw zzcqw = (zzcqw) this.zze.zze.zzd();
        if (zzcqw == null) {
            zze2 = zzfhk.zzb(th, (zzego) null);
        } else {
            zze2 = zzcqw.zzb().zza(th);
        }
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (zzcqw != null) {
                zzcqw.zzc().zzdB(zze2);
                if (((Boolean) zzba.zzc().zza(zzbdz.zzif)).booleanValue()) {
                    this.zze.zzc.execute(new zzfar(this, zze2));
                }
            } else {
                this.zze.zzd.zzdB(zze2);
                this.zze.zzm(this.zzd).zzh().zzb().zzc().zzh();
            }
            zzfhf.zzb(zze2.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zzh = this.zze.zzh;
                zzfkw zzfkw = this.zzc;
                zzfkw.zza(zze2);
                zzfkw.zzh(th);
                zzfkw.zzg(false);
                zzh.zzb(zzfkw.zzm());
            } else {
                zzflh.zzc(zze2);
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
        zzctv zzctv = (zzctv) obj;
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzif)).booleanValue()) {
                zzctv.zzn().zzb(this.zze.zzd);
            }
            this.zza.zzb(zzctv);
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zzh = this.zze.zzh;
                zzfkw zzfkw = this.zzc;
                zzfkw.zzb(zzctv.zzp().zzb);
                zzfkw.zze(zzctv.zzl().zzg());
                zzfkw.zzg(true);
                zzh.zzb(zzfkw.zzm());
            } else {
                zzflh.zzg(zzctv.zzp().zzb);
                zzflh.zzf(zzctv.zzl().zzg());
                zzfkw zzfkw2 = this.zzc;
                zzfkw2.zzg(true);
                zzflh.zza(zzfkw2);
                zzflh.zzh();
            }
        }
    }
}
