package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzajf implements zzajd {
    private final int zza;
    private final int zzb;
    private final zzfo zzc;

    public zzajf(zzaiz zzaiz, zzam zzam) {
        zzfo zzfo = zzaiz.zza;
        this.zzc = zzfo;
        zzfo.zzK(12);
        int zzp = zzfo.zzp();
        if (MimeTypes.AUDIO_RAW.equals(zzam.zzm)) {
            int zzm = zzfx.zzm(zzam.zzB, zzam.zzz);
            if (zzp == 0 || zzp % zzm != 0) {
                zzfe.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzm + ", stsz sample size: " + zzp);
                zzp = zzm;
            }
        }
        this.zza = zzp == 0 ? -1 : zzp;
        this.zzb = zzfo.zzp();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}
