package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcmz implements Runnable {
    public final /* synthetic */ zzcna zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcmz(zzcna zzcna, Runnable runnable) {
        this.zza = zzcna;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
