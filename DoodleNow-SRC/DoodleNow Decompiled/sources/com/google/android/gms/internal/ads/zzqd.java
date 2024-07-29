package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzqd implements Runnable {
    public final /* synthetic */ zzqf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzqd(zzqf zzqf, String str, long j, long j2) {
        this.zza = zzqf;
        this.zzb = str;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd);
    }
}
