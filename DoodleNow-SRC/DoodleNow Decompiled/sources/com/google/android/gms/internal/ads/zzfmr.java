package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfmr implements Runnable {
    public final /* synthetic */ zzfmt zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfmr(zzfmt zzfmt, String str) {
        this.zza = zzfmt;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
