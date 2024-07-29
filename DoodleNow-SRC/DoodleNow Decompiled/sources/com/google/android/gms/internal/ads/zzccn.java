package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzccn implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzccr zzc;

    zzccn(zzccr zzccr, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzccr;
    }

    public final void run() {
        zzccr zzccr = this.zzc;
        if (zzccr.zzq != null) {
            zzccr.zzq.zzj(this.zza, this.zzb);
        }
    }
}
