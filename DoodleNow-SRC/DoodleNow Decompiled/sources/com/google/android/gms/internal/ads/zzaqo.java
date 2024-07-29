package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaqo implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaqq zzc;

    zzaqo(zzaqq zzaqq, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzaqq;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzaqq zzaqq = this.zzc;
        zzaqq.zza.zzb(zzaqq.toString());
    }
}
