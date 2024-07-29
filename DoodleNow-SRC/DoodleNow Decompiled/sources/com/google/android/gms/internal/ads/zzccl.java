package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzccl implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzccr zzc;

    zzccl(zzccr zzccr, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzccr;
    }

    public final void run() {
        zzccr zzccr = this.zzc;
        if (zzccr.zzq != null) {
            zzccr.zzq.zzb(this.zza, this.zzb);
        }
    }
}
