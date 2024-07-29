package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzabm implements Runnable {
    public final /* synthetic */ zzabu zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzabm(zzabu zzabu, int i, long j) {
        this.zza = zzabu;
        this.zzb = i;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}
