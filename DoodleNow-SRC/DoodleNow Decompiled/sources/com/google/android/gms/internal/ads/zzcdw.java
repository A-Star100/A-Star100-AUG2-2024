package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcdw implements Runnable {
    public final /* synthetic */ zzcef zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcdw(zzcef zzcef, int i, int i2) {
        this.zza = zzcef;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzO(this.zzb, this.zzc);
    }
}
