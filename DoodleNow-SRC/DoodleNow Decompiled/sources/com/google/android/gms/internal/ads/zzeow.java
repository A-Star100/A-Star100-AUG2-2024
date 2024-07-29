package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeow implements zzgea {
    final /* synthetic */ zzeop zza;
    final /* synthetic */ zzflh zzb;
    final /* synthetic */ zzfkw zzc;
    final /* synthetic */ zzdji zzd;
    final /* synthetic */ zzeox zze;

    zzeow(zzeox zzeox, zzeop zzeop, zzflh zzflh, zzfkw zzfkw, zzdji zzdji) {
        this.zza = zzeop;
        this.zzb = zzflh;
        this.zzc = zzfkw;
        this.zzd = zzdji;
        this.zze = zzeox;
    }

    public final void zza(Throwable th) {
        zzflh zzflh;
        zze zza2 = this.zzd.zza().zza(th);
        this.zzd.zzb().zzdB(zza2);
        this.zze.zzb.zzB().execute(new zzeov(this, zza2));
        zzfhf.zzb(zza2.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
            zzeox zzeox = this.zze;
            zzfkw zzfkw = this.zzc;
            zzflk zze2 = zzeox.zze;
            zzfkw.zza(zza2);
            zzfkw.zzh(th);
            zzfkw.zzg(false);
            zze2.zzb(zzfkw.zzm());
            return;
        }
        zzflh.zzc(zza2);
        zzfkw zzfkw2 = this.zzc;
        zzfkw2.zzh(th);
        zzfkw2.zzg(false);
        zzflh.zza(zzfkw2);
        zzflh.zzh();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflh zzflh;
        zzctv zzctv = (zzctv) obj;
        synchronized (this.zze) {
            zzctv.zzn().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzctv);
            this.zze.zzb.zzB().execute(new zzeou(this));
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zze2 = this.zze.zze;
                zzfkw zzfkw = this.zzc;
                zzfkw.zzb(zzctv.zzp().zzb);
                zzfkw.zze(zzctv.zzl().zzg());
                zzfkw.zzg(true);
                zze2.zzb(zzfkw.zzm());
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
