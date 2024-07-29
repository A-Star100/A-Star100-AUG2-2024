package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzccq implements Runnable {
    final /* synthetic */ zzccr zza;

    zzccq(zzccr zzccr) {
        this.zza = zzccr;
    }

    public final void run() {
        zzccr zzccr = this.zza;
        if (zzccr.zzq != null) {
            zzccr.zzq.zzd();
        }
    }
}
