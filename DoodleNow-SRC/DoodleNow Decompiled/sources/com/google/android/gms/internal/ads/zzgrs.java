package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrs {
    public static final zzgrs zza = new zzgrq().zza();
    private final Map zzb;

    /* synthetic */ zzgrs(Map map, zzgrr zzgrr) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgrs)) {
            return false;
        }
        return this.zzb.equals(((zzgrs) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
