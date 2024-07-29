package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbjw implements zzbky {
    public final /* synthetic */ zzdgn zza;
    public final /* synthetic */ zzcpk zzb;

    public /* synthetic */ zzbjw(zzdgn zzdgn, zzcpk zzcpk) {
        this.zza = zzdgn;
        this.zzb = zzcpk;
    }

    public final void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        zzbkx.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from click GMSG.");
            return;
        }
        zzgee.zzr(zzgee.zzn(zzgdv.zzu(zzbkx.zza(zzcgm, str)), new zzbjy(this.zzb, str), zzcbr.zza), new zzbkm(zzcgm), zzcbr.zza);
    }
}
