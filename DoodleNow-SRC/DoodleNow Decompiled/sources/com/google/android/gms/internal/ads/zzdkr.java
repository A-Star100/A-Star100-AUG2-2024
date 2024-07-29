package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdkr implements zzgea {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdkt zzb;

    zzdkr(zzdkt zzdkt, String str, boolean z) {
        this.zzb = zzdkt;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfd)).booleanValue()) {
            zzu.zzo().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zze.zzT((zzcgm) obj);
        zzdkt zzdkt = this.zzb;
        zzcbw zzp = zzdkt.zze.zzp();
        zzfmy zzf = zzdkt.zzf(this.zza, true);
        if (zzf != null && zzp != null) {
            zzp.zzc(zzf);
        } else if (zzp != null) {
            zzp.cancel(false);
        }
    }
}
