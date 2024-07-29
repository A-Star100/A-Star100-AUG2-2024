package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzews implements Runnable {
    public final /* synthetic */ zzewu zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzewr zzc;
    public final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzews(zzewu zzewu, long j, zzewr zzewr, Bundle bundle) {
        this.zza = zzewu;
        this.zzb = j;
        this.zzc = zzewr;
        this.zzd = bundle;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
