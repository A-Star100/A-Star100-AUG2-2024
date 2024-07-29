package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfex implements zzgea {
    final /* synthetic */ zzeop zza;
    final /* synthetic */ zzflh zzb;
    final /* synthetic */ zzfkw zzc;
    final /* synthetic */ zzfez zzd;
    final /* synthetic */ zzffa zze;

    zzfex(zzffa zzffa, zzeop zzeop, zzflh zzflh, zzfkw zzfkw, zzfez zzfez) {
        this.zza = zzeop;
        this.zzb = zzflh;
        this.zzc = zzfkw;
        this.zzd = zzfez;
        this.zze = zzffa;
    }

    public final void zza(Throwable th) {
        zze zze2;
        zzflh zzflh;
        zzdqr zzdqr = (zzdqr) this.zze.zze.zzd();
        if (zzdqr == null) {
            zze2 = zzfhk.zzb(th, (zzego) null);
        } else {
            zze2 = zzdqr.zzb().zza(th);
        }
        synchronized (this.zze) {
            if (zzdqr != null) {
                zzdqr.zza().zzdB(zze2);
                this.zze.zzb.execute(new zzfev(this, zze2));
            } else {
                this.zze.zzd.zzdB(zze2);
                this.zze.zzk(this.zzd).zze().zzb().zzc().zzh();
            }
            zzfhf.zzb(zze2.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zzg = this.zze.zzg;
                zzfkw zzfkw = this.zzc;
                zzfkw.zza(zze2);
                zzfkw.zzh(th);
                zzfkw.zzg(false);
                zzg.zzb(zzfkw.zzm());
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
        zzdqm zzdqm = (zzdqm) obj;
        synchronized (this.zze) {
            zzdqm.zzn().zzd(this.zze.zzd);
            this.zza.zzb(zzdqm);
            zzffa zzffa = this.zze;
            Executor zzh = zzffa.zzb;
            zzfeq zzf = zzffa.zzd;
            Objects.requireNonNull(zzf);
            zzh.execute(new zzfew(zzf));
            this.zze.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbfm.zzc.zze()).booleanValue() || (zzflh = this.zzb) == null) {
                zzflk zzg = this.zze.zzg;
                zzfkw zzfkw = this.zzc;
                zzfkw.zzb(zzdqm.zzp().zzb);
                zzfkw.zze(zzdqm.zzl().zzg());
                zzfkw.zzg(true);
                zzg.zzb(zzfkw.zzm());
            } else {
                zzflh.zzg(zzdqm.zzp().zzb);
                zzflh.zzf(zzdqm.zzl().zzg());
                zzfkw zzfkw2 = this.zzc;
                zzfkw2.zzg(true);
                zzflh.zza(zzfkw2);
                zzflh.zzh();
            }
        }
    }
}
