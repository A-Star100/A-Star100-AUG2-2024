package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzabo implements Runnable {
    public final /* synthetic */ zzabu zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzabo(zzabu zzabu, long j, int i) {
        this.zza = zzabu;
        this.zzb = j;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
