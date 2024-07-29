package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzpz implements Runnable {
    public final /* synthetic */ zzqf zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzpz(zzqf zzqf, Exception exc) {
        this.zza = zzqf;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
