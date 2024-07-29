package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcff implements Runnable {
    public final /* synthetic */ zzcdn zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcff(zzcdn zzcdn, boolean z, long j) {
        this.zza = zzcdn;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        int i = zzcfh.zzd;
        this.zza.zzv(this.zzb, this.zzc);
    }
}
