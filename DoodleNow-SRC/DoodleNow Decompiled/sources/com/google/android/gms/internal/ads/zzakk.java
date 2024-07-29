package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzakk extends zzaku {
    private zzads zza;
    private zzakj zzb;

    zzakk() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public final long zza(zzfo zzfo) {
        if (!zzd(zzfo.zzM())) {
            return -1;
        }
        int i = (zzfo.zzM()[2] & 255) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zza2 = zzado.zza(zzfo, i);
            zzfo.zzK(0);
            return (long) zza2;
        }
        zzfo.zzL(4);
        zzfo.zzw();
        int zza22 = zzado.zza(zzfo, i);
        zzfo.zzK(0);
        return (long) zza22;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfo zzfo, long j, zzakr zzakr) {
        byte[] zzM = zzfo.zzM();
        zzads zzads = this.zza;
        if (zzads == null) {
            zzads zzads2 = new zzads(zzM, 17);
            this.zza = zzads2;
            zzakr.zza = zzads2.zzc(Arrays.copyOfRange(zzM, 9, zzfo.zze()), (zzby) null);
            return true;
        } else if ((zzM[0] & Byte.MAX_VALUE) == 3) {
            zzadr zzb2 = zzadp.zzb(zzfo);
            zzads zzf = zzads.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzakj(zzf, zzb2);
            return true;
        } else if (!zzd(zzM)) {
            return true;
        } else {
            zzakj zzakj = this.zzb;
            if (zzakj != null) {
                zzakj.zza(j);
                zzakr.zzb = this.zzb;
            }
            zzakr.zza.getClass();
            return false;
        }
    }
}
