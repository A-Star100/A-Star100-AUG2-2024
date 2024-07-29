package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzlo implements Runnable {
    public final /* synthetic */ zzlt zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzuy zzc;
    public final /* synthetic */ zzvd zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzlo(zzlt zzlt, Pair pair, zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
        this.zza = zzlt;
        this.zzb = pair;
        this.zzc = zzuy;
        this.zzd = zzvd;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzvh) pair.second, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
