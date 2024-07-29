package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfgt implements zzgea {
    final /* synthetic */ zzfgu zza;
    final /* synthetic */ int zzb;

    zzfgt(zzfgu zzfgu, int i) {
        this.zzb = i;
        this.zza = zzfgu;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "BufferingUrlPinger.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i = this.zzb;
        this.zza.zzb((String) obj, i);
    }
}
