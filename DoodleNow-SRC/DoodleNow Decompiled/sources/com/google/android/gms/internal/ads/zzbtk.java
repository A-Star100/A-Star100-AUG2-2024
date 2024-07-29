package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbtk implements Runnable {
    public final /* synthetic */ zzbtm zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzbtk(zzbtm zzbtm, boolean z) {
        this.zza = zzbtm;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
