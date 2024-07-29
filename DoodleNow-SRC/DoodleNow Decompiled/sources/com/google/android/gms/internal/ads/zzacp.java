package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzacp {
    protected final zzacj zza;
    protected final zzaco zzb;
    protected zzacl zzc;
    private final int zzd;

    protected zzacp(zzacm zzacm, zzaco zzaco, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzaco;
        this.zzd = i;
        this.zza = new zzacj(zzacm, j, 0, j3, j4, j5, j6);
    }

    protected static final int zzf(zzadg zzadg, long j, zzaec zzaec) {
        if (j == zzadg.zzf()) {
            return 0;
        }
        zzaec.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzadg zzadg, long j) throws IOException {
        long zzf = j - zzadg.zzf();
        if (zzf < 0 || zzf > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        ((zzact) zzadg).zzo((int) zzf, false);
        return true;
    }

    public final int zza(zzadg zzadg, zzaec zzaec) throws IOException {
        while (true) {
            zzacl zzacl = this.zzc;
            zzek.zzb(zzacl);
            long zzb2 = zzacl.zzf;
            int i = this.zzd;
            long zzc2 = zzacl.zzh;
            if (zzacl.zzg - zzb2 <= ((long) i)) {
                zzc(false, zzb2);
                return zzf(zzadg, zzb2, zzaec);
            } else if (!zzg(zzadg, zzc2)) {
                return zzf(zzadg, zzc2, zzaec);
            } else {
                zzadg.zzj();
                zzacn zza2 = this.zzb.zza(zzadg, zzacl.zzb);
                int zza3 = zza2.zzb;
                if (zza3 == -3) {
                    zzc(false, zzc2);
                    return zzf(zzadg, zzc2, zzaec);
                } else if (zza3 == -2) {
                    zzacl.zzh(zzacl, zza2.zzc, zza2.zzd);
                } else if (zza3 != -1) {
                    zzg(zzadg, zza2.zzd);
                    zzc(true, zza2.zzd);
                    return zzf(zzadg, zza2.zzd, zzaec);
                } else {
                    zzacl.zzg(zzacl, zza2.zzc, zza2.zzd);
                }
            }
        }
    }

    public final zzaef zzb() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        long j2 = j;
        zzacl zzacl = this.zzc;
        if (zzacl == null || zzacl.zza != j2) {
            zzacj zzacj = this.zza;
            zzacl zzacl2 = r1;
            zzacl zzacl3 = new zzacl(j, zzacj.zzf(j2), 0, zzacj.zzc, zzacj.zzd, zzacj.zze, zzacj.zzf);
            this.zzc = zzacl2;
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
