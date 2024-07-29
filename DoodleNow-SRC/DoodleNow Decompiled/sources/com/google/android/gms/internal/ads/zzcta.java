package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcta implements Runnable {
    public final /* synthetic */ zzctb zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcta(zzctb zzctb, Runnable runnable) {
        this.zza = zzctb;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
