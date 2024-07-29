package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzpv implements Runnable {
    public final /* synthetic */ zzqf zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzpv(zzqf zzqf, long j) {
        this.zza = zzqf;
        this.zzb = j;
    }

    public final void run() {
        this.zza.zzs(this.zzb);
    }
}
