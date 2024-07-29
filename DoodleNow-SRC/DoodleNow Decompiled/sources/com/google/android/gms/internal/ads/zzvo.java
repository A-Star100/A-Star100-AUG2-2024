package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzvo implements Runnable {
    public final /* synthetic */ zzvq zza;
    public final /* synthetic */ zzvr zzb;
    public final /* synthetic */ zzuy zzc;
    public final /* synthetic */ zzvd zzd;

    public /* synthetic */ zzvo(zzvq zzvq, zzvr zzvr, zzuy zzuy, zzvd zzvd) {
        this.zza = zzvq;
        this.zzb = zzvr;
        this.zzc = zzuy;
        this.zzd = zzvd;
    }

    public final void run() {
        this.zzb.zzaf(0, this.zza.zzb, this.zzc, this.zzd);
    }
}
