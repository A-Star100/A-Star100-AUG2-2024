package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzakq extends zzaku {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzakq() {
    }

    public static boolean zzd(zzfo zzfo) {
        return zzk(zzfo, zza);
    }

    private static boolean zzk(zzfo zzfo, byte[] bArr) {
        if (zzfo.zzb() < 8) {
            return false;
        }
        int zzd = zzfo.zzd();
        byte[] bArr2 = new byte[8];
        zzfo.zzG(bArr2, 0, 8);
        zzfo.zzK(zzd);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public final long zza(zzfo zzfo) {
        return zzg(zzaeb.zzd(zzfo.zzM()));
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfo zzfo, long j, zzakr zzakr) throws zzcc {
        if (zzk(zzfo, zza)) {
            byte[] copyOf = Arrays.copyOf(zzfo.zzM(), zzfo.zze());
            byte b = copyOf[9] & 255;
            List zze = zzaeb.zze(copyOf);
            if (zzakr.zza == null) {
                zzak zzak = new zzak();
                zzak.zzW(MimeTypes.AUDIO_OPUS);
                zzak.zzy(b);
                zzak.zzX(OpusUtil.SAMPLE_RATE);
                zzak.zzL(zze);
                zzakr.zza = zzak.zzac();
                return true;
            }
        } else if (zzk(zzfo, zzb)) {
            zzek.zzb(zzakr.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzfo.zzL(8);
                zzby zzb2 = zzaes.zzb(zzfzn.zzl(zzaes.zzc(zzfo, false, false).zzb));
                if (zzb2 != null) {
                    zzak zzb3 = zzakr.zza.zzb();
                    zzb3.zzP(zzb2.zzd(zzakr.zza.zzk));
                    zzakr.zza = zzb3.zzac();
                }
            }
        } else {
            zzek.zzb(zzakr.zza);
            return false;
        }
        return true;
    }
}
