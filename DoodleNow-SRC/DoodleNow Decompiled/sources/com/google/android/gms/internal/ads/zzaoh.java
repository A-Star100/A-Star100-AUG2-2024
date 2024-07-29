package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaoh implements zzaco {
    private final zzfv zza;
    private final zzfo zzb = new zzfo();

    /* synthetic */ zzaoh(zzfv zzfv, zzaog zzaog) {
        this.zza = zzfv;
    }

    public final zzacn zza(zzadg zzadg, long j) throws IOException {
        int zzh;
        long j2;
        long zzf = zzadg.zzf();
        int min = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, zzadg.zzd() - zzf);
        this.zzb.zzH(min);
        ((zzact) zzadg).zzm(this.zzb.zzM(), 0, min, false);
        int i = -1;
        long j3 = -9223372036854775807L;
        int i2 = -1;
        while (true) {
            zzfo zzfo = this.zzb;
            if (zzfo.zzb() < 4) {
                return j3 != C.TIME_UNSET ? zzacn.zzf(j3, zzf + ((long) i)) : zzacn.zza;
            }
            if (zzaoi.zzh(zzfo.zzM(), zzfo.zzd()) != 442) {
                zzfo.zzL(1);
            } else {
                zzfo.zzL(4);
                long zzc = zzaoj.zzc(zzfo);
                if (zzc != C.TIME_UNSET) {
                    long zzb2 = this.zza.zzb(zzc);
                    if (zzb2 > j) {
                        if (j3 == C.TIME_UNSET) {
                            return zzacn.zzd(zzb2, zzf);
                        }
                        j2 = (long) i2;
                    } else if (100000 + zzb2 > j) {
                        j2 = (long) zzfo.zzd();
                        break;
                    } else {
                        i2 = zzfo.zzd();
                        j3 = zzb2;
                    }
                }
                int zze = zzfo.zze();
                if (zzfo.zzb() >= 10) {
                    zzfo.zzL(9);
                    int zzm = zzfo.zzm() & 7;
                    if (zzfo.zzb() >= zzm) {
                        zzfo.zzL(zzm);
                        if (zzfo.zzb() >= 4) {
                            if (zzaoi.zzh(zzfo.zzM(), zzfo.zzd()) == 443) {
                                zzfo.zzL(4);
                                int zzq = zzfo.zzq();
                                if (zzfo.zzb() < zzq) {
                                    zzfo.zzK(zze);
                                } else {
                                    zzfo.zzL(zzq);
                                }
                            }
                            while (true) {
                                if (zzfo.zzb() < 4 || (zzh = zzaoi.zzh(zzfo.zzM(), zzfo.zzd())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzfo.zzL(4);
                                if (zzfo.zzb() < 2) {
                                    zzfo.zzK(zze);
                                    break;
                                }
                                zzfo.zzK(Math.min(zzfo.zze(), zzfo.zzd() + zzfo.zzq()));
                            }
                        } else {
                            zzfo.zzK(zze);
                        }
                    } else {
                        zzfo.zzK(zze);
                    }
                } else {
                    zzfo.zzK(zze);
                }
                i = zzfo.zzd();
            }
        }
        return zzacn.zze(zzf + j2);
    }

    public final void zzb() {
        byte[] bArr = zzfx.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
