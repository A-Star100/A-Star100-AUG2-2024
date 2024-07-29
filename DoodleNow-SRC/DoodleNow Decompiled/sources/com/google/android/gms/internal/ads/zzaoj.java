package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaoj {
    private final zzfv zza = new zzfv(0);
    private final zzfo zzb = new zzfo();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;

    zzaoj() {
    }

    public static long zzc(zzfo zzfo) {
        zzfo zzfo2 = zzfo;
        int zzd2 = zzfo.zzd();
        if (zzfo.zzb() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzfo2.zzG(bArr, 0, 9);
        zzfo2.zzK(zzd2);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return C.TIME_UNSET;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return C.TIME_UNSET;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return C.TIME_UNSET;
        }
        long j = (long) b;
        long j2 = (long) bArr[1];
        long j3 = (long) b2;
        long j4 = (j2 & 255) << 20;
        long j5 = (j3 & 3) << 13;
        long j6 = j5 | j4 | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (((248 & j3) >> 3) << 15);
        return j6 | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    private final int zzf(zzadg zzadg) {
        byte[] bArr = zzfx.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzadg.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i + 1] & 255) << Ascii.DLE) | ((bArr[i + 2] & 255) << 8);
    }

    public final int zza(zzadg zzadg, zzaec zzaec) throws IOException {
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (!z) {
            long zzd2 = zzadg.zzd();
            int min = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, zzd2);
            long j2 = zzd2 - ((long) min);
            if (zzadg.zzf() != j2) {
                zzaec.zza = j2;
                return 1;
            }
            this.zzb.zzH(min);
            zzadg.zzj();
            ((zzact) zzadg).zzm(this.zzb.zzM(), 0, min, false);
            zzfo zzfo = this.zzb;
            int zzd3 = zzfo.zzd();
            int zze2 = zzfo.zze() - 4;
            while (true) {
                if (zze2 < zzd3) {
                    break;
                }
                if (zzg(zzfo.zzM(), zze2) == 442) {
                    zzfo.zzK(zze2 + 4);
                    long zzc2 = zzc(zzfo);
                    if (zzc2 != C.TIME_UNSET) {
                        j = zzc2;
                        break;
                    }
                }
                zze2--;
            }
            this.zzg = j;
            this.zze = true;
        } else if (this.zzg == C.TIME_UNSET) {
            zzf(zzadg);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, zzadg.zzd());
            if (zzadg.zzf() != 0) {
                zzaec.zza = 0;
                return 1;
            }
            this.zzb.zzH(min2);
            zzadg.zzj();
            ((zzact) zzadg).zzm(this.zzb.zzM(), 0, min2, false);
            zzfo zzfo2 = this.zzb;
            int zzd4 = zzfo2.zzd();
            int zze3 = zzfo2.zze();
            while (true) {
                if (zzd4 >= zze3 - 3) {
                    break;
                }
                if (zzg(zzfo2.zzM(), zzd4) == 442) {
                    zzfo2.zzK(zzd4 + 4);
                    long zzc3 = zzc(zzfo2);
                    if (zzc3 != C.TIME_UNSET) {
                        j = zzc3;
                        break;
                    }
                }
                zzd4++;
            }
            this.zzf = j;
            this.zzd = true;
        } else {
            long j3 = this.zzf;
            if (j3 == C.TIME_UNSET) {
                zzf(zzadg);
                return 0;
            }
            zzfv zzfv = this.zza;
            this.zzh = zzfv.zzc(this.zzg) - zzfv.zzb(j3);
            zzf(zzadg);
            return 0;
        }
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfv zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
