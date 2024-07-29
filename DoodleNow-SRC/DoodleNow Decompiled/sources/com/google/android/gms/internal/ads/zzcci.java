package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcci implements Runnable {
    public final /* synthetic */ zzccr zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzcci(zzccr zzccr, int i) {
        this.zza = zzccr;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
