package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzffi implements zzeop {
    final /* synthetic */ zzffk zza;

    zzffi(zzffk zzffk) {
        this.zza = zzffk;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzd = (zzdqm) obj;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzdt)).booleanValue()) {
                ((zzdqm) obj).zzd().zza = this.zza.zzc;
            }
            this.zza.zzd.zzj();
        }
    }
}
