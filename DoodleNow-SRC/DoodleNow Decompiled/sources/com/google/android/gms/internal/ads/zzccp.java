package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzccp implements Runnable {
    final /* synthetic */ zzccr zza;

    zzccp(zzccr zzccr) {
        this.zza = zzccr;
    }

    public final void run() {
        zzccr zzccr = this.zza;
        if (zzccr.zzq != null) {
            if (!zzccr.zzr) {
                zzccr.zzq.zzg();
                this.zza.zzr = true;
            }
            this.zza.zzq.zze();
        }
    }
}
