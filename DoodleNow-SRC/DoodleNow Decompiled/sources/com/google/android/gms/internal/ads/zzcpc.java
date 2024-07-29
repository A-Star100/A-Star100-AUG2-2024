package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcpc implements Runnable {
    public final /* synthetic */ zzcpk zza;
    public final /* synthetic */ Throwable zzb;

    public /* synthetic */ zzcpc(zzcpk zzcpk, Throwable th) {
        this.zza = zzcpk;
        this.zzb = th;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
