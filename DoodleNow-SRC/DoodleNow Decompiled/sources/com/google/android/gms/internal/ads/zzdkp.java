package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdkp implements Runnable {
    public final /* synthetic */ zzdkt zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzdkp(zzdkt zzdkt, boolean z) {
        this.zza = zzdkt;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzx(this.zzb);
    }
}
