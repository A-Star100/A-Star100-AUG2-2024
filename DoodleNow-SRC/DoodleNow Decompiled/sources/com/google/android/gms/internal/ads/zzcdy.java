package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcdy implements Runnable {
    public final /* synthetic */ zzcef zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcdy(zzcef zzcef, boolean z, long j) {
        this.zza = zzcef;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzJ(this.zzb, this.zzc);
    }
}
