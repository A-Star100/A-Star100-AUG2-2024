package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzboz implements Runnable {
    public final /* synthetic */ zzbpa zza;
    public final /* synthetic */ zzbnx zzb;

    public /* synthetic */ zzboz(zzbpa zzbpa, zzbnx zzbnx) {
        this.zza = zzbpa;
        this.zzb = zzbnx;
    }

    public final void run() {
        zzbnx zzbnx = this.zzb;
        zzbnx.zzr("/result", zzbkx.zzo);
        zzbnx.zzc();
    }
}
