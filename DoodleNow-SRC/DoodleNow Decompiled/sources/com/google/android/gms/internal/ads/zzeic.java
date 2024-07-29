package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeic implements zzgea {
    final /* synthetic */ zzeid zza;

    zzeic(zzeid zzeid) {
        this.zza = zzeid;
    }

    public final void zza(Throwable th) {
        zze zza2 = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzdB(zza2);
        zzfhf.zzb(zza2.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzb(Object obj) {
        ((zzcrm) obj).zzj();
    }
}
