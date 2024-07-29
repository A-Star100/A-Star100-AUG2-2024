package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzabn implements Runnable {
    public final /* synthetic */ zzabu zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzabn(zzabu zzabu, Object obj, long j) {
        this.zza = zzabu;
        this.zzb = obj;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzm(this.zzb, this.zzc);
    }
}
