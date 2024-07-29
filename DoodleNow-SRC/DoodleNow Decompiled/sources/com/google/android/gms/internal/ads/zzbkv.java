package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkv implements zzbky {
    zzbkv() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        if (map.keySet().contains("start")) {
            zzcgm.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcgm.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcgm.zzN().zzk();
        }
    }
}
