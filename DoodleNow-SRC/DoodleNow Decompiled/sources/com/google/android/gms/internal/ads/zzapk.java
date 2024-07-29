package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzapk {
    public final int zza;
    public final long zzb;

    private zzapk(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzapk zza(zzadg zzadg, zzfo zzfo) throws IOException {
        ((zzact) zzadg).zzm(zzfo.zzM(), 0, 8, false);
        zzfo.zzK(0);
        return new zzapk(zzfo.zzg(), zzfo.zzs());
    }
}
