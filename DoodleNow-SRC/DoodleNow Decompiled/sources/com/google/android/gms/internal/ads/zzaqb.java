package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaqb implements Runnable {
    final /* synthetic */ zzaqq zza;
    final /* synthetic */ zzaqc zzb;

    zzaqb(zzaqc zzaqc, zzaqq zzaqq) {
        this.zza = zzaqq;
        this.zzb = zzaqc;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
