package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbjp implements zzbky {
    private final zzbjq zza;

    public zzbjp(zzbjq zzbjq) {
        this.zza = zzbjq;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzm.zzj("App event with no name parameter.");
        } else {
            this.zza.zzb(str, (String) map.get("info"));
        }
    }
}
