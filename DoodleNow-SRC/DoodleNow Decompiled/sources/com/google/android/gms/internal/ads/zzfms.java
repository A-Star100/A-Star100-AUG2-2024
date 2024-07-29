package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfms implements Runnable {
    public final /* synthetic */ zzfmt zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzflh zzc;

    public /* synthetic */ zzfms(zzfmt zzfmt, String str, zzflh zzflh) {
        this.zza = zzfmt;
        this.zzb = str;
        this.zzc = zzflh;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc);
    }
}
