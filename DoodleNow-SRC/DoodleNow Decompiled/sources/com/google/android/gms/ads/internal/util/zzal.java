package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzgep;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzal implements Runnable {
    public final /* synthetic */ zzau zza;
    public final /* synthetic */ zzgep zzb;

    public /* synthetic */ zzal(zzau zzau, zzgep zzgep) {
        this.zza = zzau;
        this.zzb = zzgep;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
