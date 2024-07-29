package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzblg implements zzgea {
    final /* synthetic */ zza zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzblk zzd;

    zzblg(zzblk zzblk, zza zza2, Map map, String str) {
        this.zza = zza2;
        this.zzb = map;
        this.zzc = str;
        this.zzd = zzblk;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "OpenGmsgHandler.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zza zza2 = this.zza;
        Map map = this.zzb;
        String str = this.zzc;
        this.zzd.zzh((String) obj, zza2, map, str);
    }
}
