package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaos {
    private final zzfv zza = new zzfv(0);
    private final zzfo zzb = new zzfo();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;

    zzaos(int i) {
    }

    private final int zze(zzadg zzadg) {
        byte[] bArr = zzfx.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzadg.zzj();
        return 0;
    }

    public final int zza(zzadg zzadg, zzaec zzaec, int i) throws IOException {
        if (i <= 0) {
            zze(zzadg);
            return 0;
        }
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (!z) {
            long zzd2 = zzadg.zzd();
            int min = (int) Math.min(112800, zzd2);
            long j2 = zzd2 - ((long) min);
            if (zzadg.zzf() != j2) {
                zzaec.zza = j2;
            } else {
                this.zzb.zzH(min);
                zzadg.zzj();
                ((zzact) zzadg).zzm(this.zzb.zzM(), 0, min, false);
                zzfo zzfo = this.zzb;
                int zzd3 = zzfo.zzd();
                int zze2 = zzfo.zze();
                int i2 = zze2 - 188;
                while (true) {
                    if (i2 < zzd3) {
                        break;
                    }
                    byte[] zzM = zzfo.zzM();
                    int i3 = -4;
                    int i4 = 0;
                    while (true) {
                        if (i3 > 4) {
                            break;
                        }
                        int i5 = (i3 * TsExtractor.TS_PACKET_SIZE) + i2;
                        if (i5 < zzd3 || i5 >= zze2 || zzM[i5] != 71) {
                            i4 = 0;
                        } else {
                            i4++;
                            if (i4 == 5) {
                                long zzb2 = zzapc.zzb(zzfo, i2, i);
                                if (zzb2 != C.TIME_UNSET) {
                                    j = zzb2;
                                    break;
                                }
                            }
                        }
                        i3++;
                    }
                    i2--;
                }
                this.zzg = j;
                this.zze = true;
                return 0;
            }
        } else if (this.zzg == C.TIME_UNSET) {
            zze(zzadg);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zzadg.zzd());
            if (zzadg.zzf() != 0) {
                zzaec.zza = 0;
            } else {
                this.zzb.zzH(min2);
                zzadg.zzj();
                ((zzact) zzadg).zzm(this.zzb.zzM(), 0, min2, false);
                zzfo zzfo2 = this.zzb;
                int zzd4 = zzfo2.zzd();
                int zze3 = zzfo2.zze();
                while (true) {
                    if (zzd4 >= zze3) {
                        break;
                    }
                    if (zzfo2.zzM()[zzd4] == 71) {
                        long zzb3 = zzapc.zzb(zzfo2, zzd4, i);
                        if (zzb3 != C.TIME_UNSET) {
                            j = zzb3;
                            break;
                        }
                    }
                    zzd4++;
                }
                this.zzf = j;
                this.zzd = true;
                return 0;
            }
        } else {
            long j3 = this.zzf;
            if (j3 == C.TIME_UNSET) {
                zze(zzadg);
                return 0;
            }
            zzfv zzfv = this.zza;
            this.zzh = zzfv.zzc(this.zzg) - zzfv.zzb(j3);
            zze(zzadg);
            return 0;
        }
        return 1;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfv zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
