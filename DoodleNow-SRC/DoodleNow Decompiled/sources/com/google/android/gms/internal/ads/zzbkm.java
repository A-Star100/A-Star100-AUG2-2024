package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkm implements zzgea {
    final /* synthetic */ zzcgm zza;

    zzbkm(zzcgm zzcgm) {
        this.zza = zzcgm;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcgm zzcgm = this.zza;
        new zzca(zzcgm.getContext(), zzcgm.zzn().afmaVersion, (String) obj).zzb();
    }
}
