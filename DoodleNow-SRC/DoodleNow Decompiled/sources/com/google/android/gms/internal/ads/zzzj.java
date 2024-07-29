package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzzj implements Runnable {
    public final /* synthetic */ zzzk zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzzj(zzzk zzzk, int i, long j, long j2) {
        this.zza = zzzk;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzb.zzX(this.zzb, this.zzc, this.zzd);
    }
}
