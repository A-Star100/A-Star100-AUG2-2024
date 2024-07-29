package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbku implements zzbky {
    zzbku() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcgm.zzdg();
        } else if ("resume".equals(str)) {
            zzcgm.zzdh();
        }
    }
}
