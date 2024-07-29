package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkw implements zzbky {
    zzbkw() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        if (map.keySet().contains("start")) {
            zzcgm.zzau(true);
        }
        if (map.keySet().contains("stop")) {
            zzcgm.zzau(false);
        }
    }
}
