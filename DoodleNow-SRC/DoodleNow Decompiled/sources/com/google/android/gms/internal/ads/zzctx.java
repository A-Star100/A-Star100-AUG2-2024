package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzctx implements zzcty {
    private final Map zza;

    zzctx(Map map) {
        this.zza = map;
    }

    public final zzegj zza(int i, String str) {
        return (zzegj) this.zza.get(str);
    }
}
