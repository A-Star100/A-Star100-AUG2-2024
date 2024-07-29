package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzabk implements Runnable {
    public final /* synthetic */ zzabu zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzabk(zzabu zzabu, String str, long j, long j2) {
        this.zza = zzabu;
        this.zzb = str;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzg(this.zzb, this.zzc, this.zzd);
    }
}
