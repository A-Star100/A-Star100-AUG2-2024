package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzduh;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ zzduh zzb;
    public final /* synthetic */ Long zzc;

    public /* synthetic */ zze(zzf zzf, zzduh zzduh, Long l) {
        this.zza = zzf;
        this.zzb = zzduh;
        this.zzc = l;
    }

    public final void run() {
        zzf.zzf(this.zzb, "cld_r", zzu.zzB().elapsedRealtime() - this.zzc.longValue());
    }
}
