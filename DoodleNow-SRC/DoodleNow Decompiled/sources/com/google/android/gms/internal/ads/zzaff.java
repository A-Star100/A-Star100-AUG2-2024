package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaff implements zzaev {
    public final String zza;

    private zzaff(String str) {
        this.zza = str;
    }

    public static zzaff zzb(zzfo zzfo) {
        return new zzaff(zzfo.zzA(zzfo.zzb(), zzfwd.zzc));
    }

    public final int zza() {
        return AviExtractor.FOURCC_strn;
    }
}
