package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzafa implements zzaev {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzafa(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzafa zzb(zzfo zzfo) {
        int zzi = zzfo.zzi();
        zzfo.zzL(8);
        int zzi2 = zzfo.zzi();
        int zzi3 = zzfo.zzi();
        zzfo.zzL(4);
        int zzi4 = zzfo.zzi();
        zzfo.zzL(12);
        return new zzafa(zzi, zzi2, zzi3, zzi4);
    }

    public final int zza() {
        return AviExtractor.FOURCC_avih;
    }
}
