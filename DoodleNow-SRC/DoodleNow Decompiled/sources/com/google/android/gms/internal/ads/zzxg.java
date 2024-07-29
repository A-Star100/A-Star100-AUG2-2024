package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzxg implements zzvf, zzve {
    private final zzvf zza;
    private final long zzb;
    private zzve zzc;

    public zzxg(zzvf zzvf, long j) {
        this.zza = zzvf;
        this.zzb = j;
    }

    public final long zza(long j, zzmj zzmj) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzmj) + j2;
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb2 + this.zzb;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc2 + this.zzb;
    }

    public final long zzd() {
        long zzd = this.zza.zzd();
        return zzd == C.TIME_UNSET ? C.TIME_UNSET : zzd + this.zzb;
    }

    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    public final long zzf(zzyz[] zzyzArr, boolean[] zArr, zzwy[] zzwyArr, boolean[] zArr2, long j) {
        zzwy[] zzwyArr2 = zzwyArr;
        zzwy[] zzwyArr3 = new zzwy[zzwyArr2.length];
        int i = 0;
        while (true) {
            zzwy zzwy = null;
            if (i >= zzwyArr2.length) {
                break;
            }
            zzxf zzxf = (zzxf) zzwyArr2[i];
            if (zzxf != null) {
                zzwy = zzxf.zzc();
            }
            zzwyArr3[i] = zzwy;
            i++;
        }
        long zzf = this.zza.zzf(zzyzArr, zArr, zzwyArr3, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzwyArr2.length; i2++) {
            zzwy zzwy2 = zzwyArr3[i2];
            if (zzwy2 == null) {
                zzwyArr2[i2] = null;
            } else {
                zzwy zzwy3 = zzwyArr2[i2];
                if (zzwy3 == null || ((zzxf) zzwy3).zzc() != zzwy2) {
                    zzwyArr2[i2] = new zzxf(zzwy2, this.zzb);
                }
            }
        }
        return zzf + this.zzb;
    }

    public final /* bridge */ /* synthetic */ void zzg(zzxa zzxa) {
        zzvf zzvf = (zzvf) zzxa;
        zzve zzve = this.zzc;
        zzve.getClass();
        zzve.zzg(this);
    }

    public final zzxk zzh() {
        return this.zza.zzh();
    }

    public final void zzj(long j, boolean z) {
        this.zza.zzj(j - this.zzb, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zzve zzve, long j) {
        this.zzc = zzve;
        this.zza.zzl(this, j - this.zzb);
    }

    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzvf zzn() {
        return this.zza;
    }

    public final boolean zzo(zzlg zzlg) {
        long j = zzlg.zza;
        long j2 = this.zzb;
        zzle zza2 = zzlg.zza();
        zza2.zze(j - j2);
        return this.zza.zzo(zza2.zzg());
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }

    public final void zzi(zzvf zzvf) {
        zzve zzve = this.zzc;
        zzve.getClass();
        zzve.zzi(this);
    }
}
