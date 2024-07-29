package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgmo {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzgmo() {
    }

    public final zzgmo zza(Enum enumR, Object obj) {
        this.zza.put(enumR, obj);
        this.zzb.put(obj, enumR);
        return this;
    }

    public final zzgmq zzb() {
        return new zzgmq(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), (zzgmp) null);
    }

    /* synthetic */ zzgmo(zzgmn zzgmn) {
    }
}
