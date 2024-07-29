package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfby implements zzgea {
    final /* synthetic */ zzeop zza;
    final /* synthetic */ zzflh zzb;
    final /* synthetic */ zzfkw zzc;
    final /* synthetic */ zzcsm zzd;
    final /* synthetic */ zzfbz zze;

    zzfby(zzfbz zzfbz, zzeop zzeop, zzflh zzflh, zzfkw zzfkw, zzcsm zzcsm) {
        this.zza = zzeop;
        this.zzb = zzflh;
        this.zzc = zzfkw;
        this.zzd = zzcsm;
        this.zze = zzfbz;
    }

    public final void zza(Throwable th) {
        zzflh zzflh;
        zze zza2 = this.zzd.zzd().zza(th);
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zzd.zzf().zzdB(zza2);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzie)).booleanValue()) {
                this.zze.zzb.execute(new zzfbw(this, zza2));
            }
            zzfbz zzfbz = this.zze;
            zzfbz.zzh.zzd(zzfbz.zzj.zzc());
            zzfhf.zzb(zza2.zza, th, "BannerAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zzj = this.zze.zzi;
                zzfkw zzfkw = this.zzc;
                zzfkw.zza(zza2);
                zzfkw.zzh(th);
                zzfkw.zzg(false);
                zzj.zzb(zzfkw.zzm());
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
        zzcrm zzcrm = (zzcrm) obj;
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zze.zzf.removeAllViews();
            if (zzcrm.zzc() != null) {
                ViewParent parent = zzcrm.zzc().getParent();
                if (parent instanceof ViewGroup) {
                    String str = "";
                    if (zzcrm.zzl() != null) {
                        str = zzcrm.zzl().zzg();
                    }
                    zzm.zzj("Banner view provided from " + str + " already has a parent view. Removing its old parent.");
                    ((ViewGroup) parent).removeView(zzcrm.zzc());
                }
            }
            if (((Boolean) zzba.zzc().zza(zzbdz.zzie)).booleanValue()) {
                zzdcv zzn = zzcrm.zzn();
                zzn.zza(this.zze.zzd);
                zzn.zzc(this.zze.zze);
            }
            this.zze.zzf.addView(zzcrm.zzc());
            this.zza.zzb(zzcrm);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzie)).booleanValue()) {
                zzfbz zzfbz = this.zze;
                Executor zzk = zzfbz.zzb;
                zzeoa zzg = zzfbz.zzd;
                Objects.requireNonNull(zzg);
                zzk.execute(new zzfbx(zzg));
            }
            this.zze.zzh.zzd(zzcrm.zza());
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zzj = this.zze.zzi;
                zzfkw zzfkw = this.zzc;
                zzfkw.zzb(zzcrm.zzp().zzb);
                zzfkw.zze(zzcrm.zzl().zzg());
                zzfkw.zzg(true);
                zzj.zzb(zzfkw.zzm());
            } else {
                zzflh.zzg(zzcrm.zzp().zzb);
                zzflh.zzf(zzcrm.zzl().zzg());
                zzfkw zzfkw2 = this.zzc;
                zzfkw2.zzg(true);
                zzflh.zza(zzfkw2);
                zzflh.zzh();
            }
        }
    }
}
