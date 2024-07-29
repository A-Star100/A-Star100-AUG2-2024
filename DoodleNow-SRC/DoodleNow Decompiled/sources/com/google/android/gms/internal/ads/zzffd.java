package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzffd implements zzeop {
    final /* synthetic */ zzffe zza;

    zzffd(zzffe zzffe) {
        this.zza = zzffe;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzi = (zzdqm) obj;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzdt)).booleanValue()) {
                ((zzdqm) obj).zzd().zza = this.zza.zzd;
            }
            this.zza.zzi.zzj();
        }
    }
}
