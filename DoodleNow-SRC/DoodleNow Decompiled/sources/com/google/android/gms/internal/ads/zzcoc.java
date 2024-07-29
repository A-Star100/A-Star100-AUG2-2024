package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcoc implements zzcoa {
    private final zzg zza;

    public zzcoc(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map map) {
        this.zza.zzw(Boolean.parseBoolean((String) map.get("content_url_opted_out")));
    }
}
