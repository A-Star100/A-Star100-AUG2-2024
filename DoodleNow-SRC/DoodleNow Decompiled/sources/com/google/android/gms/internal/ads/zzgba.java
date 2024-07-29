package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgba extends zzfzn {
    final /* synthetic */ zzgbb zza;

    zzgba(zzgbb zzgbb) {
        this.zza = zzgbb;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzfwr.zza(i, this.zza.zzc, "index");
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[i2]), Objects.requireNonNull(this.zza.zzb[i2 + 1]));
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
