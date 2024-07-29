package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeoh implements zzeop {
    final /* synthetic */ zzeoi zza;

    zzeoh(zzeoi zzeoi) {
        this.zza = zzeoi;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdhl zzdhl = (zzdhl) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdhl;
            this.zza.zzj.zzj();
        }
    }
}
