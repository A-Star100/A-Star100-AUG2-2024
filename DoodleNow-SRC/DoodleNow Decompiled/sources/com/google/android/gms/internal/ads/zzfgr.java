package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfgr implements zzbky {
    public final /* synthetic */ zzfmt zza;
    public final /* synthetic */ zzefd zzb;

    public /* synthetic */ zzfgr(zzfmt zzfmt, zzefd zzefd) {
        this.zza = zzfmt;
        this.zzb = zzefd;
    }

    public final void zza(Object obj, Map map) {
        zzcgd zzcgd = (zzcgd) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from httpTrack GMSG.");
        } else if (!zzcgd.zzD().zzaj) {
            this.zza.zzc(str, (zzflh) null);
        } else {
            this.zzb.zzd(new zzeff(zzu.zzB().currentTimeMillis(), ((zzchn) zzcgd).zzP().zzb, str, 2));
        }
    }
}
