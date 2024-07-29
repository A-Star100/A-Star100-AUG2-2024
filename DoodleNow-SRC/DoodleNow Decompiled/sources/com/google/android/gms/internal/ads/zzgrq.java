package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrq {
    private HashMap zza = new HashMap();

    public final zzgrs zza() {
        if (this.zza != null) {
            zzgrs zzgrs = new zzgrs(Collections.unmodifiableMap(this.zza), (zzgrr) null);
            this.zza = null;
            return zzgrs;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
