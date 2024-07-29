package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdpx;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzn implements Runnable {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ zzdpx[] zzb;

    public /* synthetic */ zzn(zzab zzab, zzdpx[] zzdpxArr) {
        this.zza = zzab;
        this.zzb = zzdpxArr;
    }

    public final void run() {
        this.zza.zzJ(this.zzb);
    }
}
