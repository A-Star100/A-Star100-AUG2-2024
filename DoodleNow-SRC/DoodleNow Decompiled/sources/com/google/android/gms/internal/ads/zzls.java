package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzls implements Runnable {
    public final /* synthetic */ zzlt zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzuy zzc;
    public final /* synthetic */ zzvd zzd;

    public /* synthetic */ zzls(zzlt zzlt, Pair pair, zzuy zzuy, zzvd zzvd) {
        this.zza = zzlt;
        this.zzb = pair;
        this.zzc = zzuy;
        this.zzd = zzvd;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzag(((Integer) pair.first).intValue(), (zzvh) pair.second, this.zzc, this.zzd);
    }
}
