package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkr implements zzbky {
    zzbkr() {
    }

    public final void zza(Object obj, Map map) {
        zzm.zzi("Received log message: ".concat(String.valueOf((String) map.get("string"))));
    }
}
