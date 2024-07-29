package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfbs implements zzeop {
    final /* synthetic */ zzfbt zza;

    zzfbs(zzfbt zzfbt) {
        this.zza = zzfbt;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcrg zzcrg = (zzcrg) obj;
        synchronized (this.zza) {
            zzcrg zzcrg2 = this.zza.zza;
            if (zzcrg2 != null) {
                zzcrg2.zzb();
            }
            zzfbt zzfbt = this.zza;
            zzfbt.zza = zzcrg;
            zzcrg.zzc(zzfbt);
            zzfbt zzfbt2 = this.zza;
            zzfbt2.zzg.zzk(new zzcrh(zzcrg, zzfbt2, zzfbt2.zzg, zzfbt2.zzi));
            zzcrg.zzj();
        }
    }
}
