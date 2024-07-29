package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzxf implements zzwy {
    private final zzwy zza;
    private final long zzb;

    public zzxf(zzwy zzwy, long j) {
        this.zza = zzwy;
        this.zzb = j;
    }

    public final int zza(zzlb zzlb, zzih zzih, int i) {
        int zza2 = this.zza.zza(zzlb, zzih, i);
        if (zza2 != -4) {
            return zza2;
        }
        zzih.zze += this.zzb;
        return -4;
    }

    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzwy zzc() {
        return this.zza;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return this.zza.zze();
    }
}
