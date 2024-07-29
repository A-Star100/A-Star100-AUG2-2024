package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrz {
    private final zzgrs zza;
    private final List zzb;
    @Nullable
    private final Integer zzc;

    /* synthetic */ zzgrz(zzgrs zzgrs, List list, Integer num, zzgry zzgry) {
        this.zza = zzgrs;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgrz)) {
            return false;
        }
        zzgrz zzgrz = (zzgrz) obj;
        if (!this.zza.equals(zzgrz.zza) || !this.zzb.equals(zzgrz.zzb) || !Objects.equals(this.zzc, zzgrz.zzc)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }
}
