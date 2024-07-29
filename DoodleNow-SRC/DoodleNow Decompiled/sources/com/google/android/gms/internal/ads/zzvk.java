package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzvk implements Runnable {
    public final /* synthetic */ zzvq zza;
    public final /* synthetic */ zzvr zzb;
    public final /* synthetic */ zzvd zzc;

    public /* synthetic */ zzvk(zzvq zzvq, zzvr zzvr, zzvd zzvd) {
        this.zza = zzvq;
        this.zzb = zzvr;
        this.zzc = zzvd;
    }

    public final void run() {
        this.zzb.zzae(0, this.zza.zzb, this.zzc);
    }
}
