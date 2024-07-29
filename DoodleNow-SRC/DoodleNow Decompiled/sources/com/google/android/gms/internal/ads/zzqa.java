package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzqa implements Runnable {
    public final /* synthetic */ zzqf zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzqa(zzqf zzqf, Exception exc) {
        this.zza = zzqf;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
