package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzejm implements zzgea {
    final /* synthetic */ zzffn zza;
    final /* synthetic */ zzejn zzb;

    zzejm(zzejn zzejn, zzffn zzffn) {
        this.zza = zzffn;
        this.zzb = zzejn;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzb(th, this.zza);
            if (this.zzb.zzh.zze()) {
                zzejn zzejn = this.zzb;
                zzejn.zze(zzejn.zzh.zza());
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeke zzeke = (zzeke) obj;
        synchronized (this.zzb) {
            this.zzb.zzh.zzc(zzeke, this.zza);
            if (this.zzb.zzh.zze()) {
                zzejn zzejn = this.zzb;
                zzejn.zze(zzejn.zzh.zza());
            }
        }
    }
}
