package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzqc implements Runnable {
    public final /* synthetic */ zzqf zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzqc(zzqf zzqf, boolean z) {
        this.zza = zzqf;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzt(this.zzb);
    }
}
