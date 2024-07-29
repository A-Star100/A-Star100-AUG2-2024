package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzlr implements Runnable {
    public final /* synthetic */ zzlt zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzvd zzc;

    public /* synthetic */ zzlr(zzlt zzlt, Pair pair, zzvd zzvd) {
        this.zza = zzlt;
        this.zzb = pair;
        this.zzc = zzvd;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzae(((Integer) pair.first).intValue(), (zzvh) pair.second, this.zzc);
    }
}
