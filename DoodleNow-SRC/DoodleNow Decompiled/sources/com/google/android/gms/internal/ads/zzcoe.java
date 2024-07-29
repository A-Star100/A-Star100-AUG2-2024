package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcoe implements zzcoa {
    private final zzg zza;

    public zzcoe(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map map) {
        this.zza.zzy(Boolean.parseBoolean((String) map.get("content_vertical_opted_out")));
    }
}
