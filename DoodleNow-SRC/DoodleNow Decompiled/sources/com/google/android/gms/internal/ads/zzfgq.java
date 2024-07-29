package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfgq implements zzbky {
    public final /* synthetic */ zzdgn zza;
    public final /* synthetic */ zzcpk zzb;
    public final /* synthetic */ zzfmt zzc;
    public final /* synthetic */ zzefd zzd;

    public /* synthetic */ zzfgq(zzdgn zzdgn, zzcpk zzcpk, zzfmt zzfmt, zzefd zzefd) {
        this.zza = zzdgn;
        this.zzb = zzcpk;
        this.zzc = zzfmt;
        this.zzd = zzefd;
    }

    public final void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        zzbkx.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from click GMSG.");
            return;
        }
        zzefd zzefd = this.zzd;
        zzfmt zzfmt = this.zzc;
        zzgee.zzr(zzbkx.zza(zzcgm, str), new zzfgs(zzcgm, this.zzb, zzfmt, zzefd), zzcbr.zza);
    }
}
