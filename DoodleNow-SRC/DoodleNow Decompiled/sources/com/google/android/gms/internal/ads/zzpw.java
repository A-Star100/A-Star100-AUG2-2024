package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzpw implements Runnable {
    public final /* synthetic */ zzqf zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzpw(zzqf zzqf, int i, long j, long j2) {
        this.zza = zzqf;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzu(this.zzb, this.zzc, this.zzd);
    }
}
