package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzenf implements zzeop {
    final /* synthetic */ zzeng zza;

    zzenf(zzeng zzeng) {
        this.zza = zzeng;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcrm zzcrm = (zzcrm) obj;
        synchronized (this.zza) {
            zzeng zzeng = this.zza;
            if (zzeng.zzi != null) {
                zzeng.zzi.zzb();
            }
            this.zza.zzi = zzcrm;
            this.zza.zzi.zzj();
        }
    }
}
