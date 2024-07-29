package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaml implements zzalc {
    private final zzame zza;
    private final long[] zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;

    public zzaml(zzame zzame, Map map, Map map2, Map map3) {
        this.zza = zzame;
        this.zzd = map2;
        this.zze = map3;
        this.zzc = Collections.unmodifiableMap(map);
        this.zzb = zzame.zzh();
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final long zzb(int i) {
        return this.zzb[i];
    }

    public final List zzc(long j) {
        return this.zza.zze(j, this.zzc, this.zzd, this.zze);
    }
}
