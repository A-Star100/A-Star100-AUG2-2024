package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzafb implements zzaev {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzafb(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
    }

    public static zzafb zzb(zzfo zzfo) {
        int zzi = zzfo.zzi();
        zzfo.zzL(12);
        int zzi2 = zzfo.zzi();
        int zzi3 = zzfo.zzi();
        int zzi4 = zzfo.zzi();
        zzfo.zzL(4);
        int zzi5 = zzfo.zzi();
        int zzi6 = zzfo.zzi();
        zzfo.zzL(8);
        return new zzafb(zzi, zzi2, zzi3, zzi4, zzi5, zzi6);
    }

    public final int zza() {
        return AviExtractor.FOURCC_strh;
    }
}
