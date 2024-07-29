package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfle implements zzgea {
    final /* synthetic */ zzflh zza;
    final /* synthetic */ zzfkw zzb;
    final /* synthetic */ boolean zzc;

    zzfle(zzflh zzflh, zzfkw zzfkw, boolean z) {
        this.zza = zzflh;
        this.zzb = zzfkw;
        this.zzc = z;
    }

    public final void zza(Throwable th) {
        zzfkw zzfkw = this.zzb;
        if (zzfkw.zzk()) {
            zzflh zzflh = this.zza;
            zzfkw.zzh(th);
            zzfkw.zzg(false);
            zzflh.zza(zzfkw);
            if (this.zzc) {
                this.zza.zzh();
            }
        }
    }

    public final void zzb(Object obj) {
        zzfkw zzfkw = this.zzb;
        zzfkw.zzg(true);
        this.zza.zza(zzfkw);
        if (this.zzc) {
            this.zza.zzh();
        }
    }
}
