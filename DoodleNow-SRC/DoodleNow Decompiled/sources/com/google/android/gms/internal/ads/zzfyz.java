package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyz extends zzfzc {
    zzfyz() {
        super((zzfzb) null);
    }

    static final zzfzc zzg(int i) {
        return i < 0 ? zzfzc.zzb : i > 0 ? zzfzc.zzc : zzfzc.zza;
    }

    public final int zza() {
        return 0;
    }

    public final zzfzc zzb(int i, int i2) {
        return zzg(i < i2 ? -1 : i > i2 ? 1 : 0);
    }

    public final zzfzc zzc(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        return zzg(i < 0 ? -1 : i > 0 ? 1 : 0);
    }

    public final zzfzc zzd(Object obj, Object obj2, Comparator comparator) {
        return zzg(comparator.compare(obj, obj2));
    }

    public final zzfzc zze(boolean z, boolean z2) {
        return zzg(zzgch.zza(z, z2));
    }

    public final zzfzc zzf(boolean z, boolean z2) {
        return zzg(zzgch.zza(z2, z));
    }
}
