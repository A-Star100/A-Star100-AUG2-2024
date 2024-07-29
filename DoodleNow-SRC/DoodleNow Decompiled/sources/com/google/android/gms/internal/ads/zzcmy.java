package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcmy implements Runnable {
    public final /* synthetic */ zzcna zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcmy(zzcna zzcna, Runnable runnable) {
        this.zza = zzcna;
        this.zzb = runnable;
    }

    public final void run() {
        zzcbr.zze.execute(new zzcmz(this.zza, this.zzb));
    }
}
