package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcgq implements Runnable {
    public final /* synthetic */ zzcgu zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcgq(zzcgu zzcgu, boolean z, long j) {
        this.zza = zzcgu;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
