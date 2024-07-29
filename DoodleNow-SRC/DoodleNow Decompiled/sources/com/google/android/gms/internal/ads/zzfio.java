package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfio implements zzgea {
    final /* synthetic */ zzfir zza;
    final /* synthetic */ zzfis zzb;

    zzfio(zzfis zzfis, zzfir zzfir) {
        this.zza = zzfir;
        this.zzb = zzfis;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            zzfis zzfis = this.zzb;
            if (zzfis.zzf == 1) {
                zzfis.zzh();
            }
        }
    }
}
