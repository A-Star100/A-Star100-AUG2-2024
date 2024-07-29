package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzqb implements Runnable {
    public final /* synthetic */ zzqf zza;
    public final /* synthetic */ zzam zzb;
    public final /* synthetic */ zzis zzc;

    public /* synthetic */ zzqb(zzqf zzqf, zzam zzam, zzis zzis) {
        this.zza = zzqf;
        this.zzb = zzam;
        this.zzc = zzis;
    }

    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
