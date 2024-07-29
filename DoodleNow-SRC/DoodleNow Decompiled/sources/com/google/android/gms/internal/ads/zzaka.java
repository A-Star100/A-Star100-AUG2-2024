package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaka {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, Sniffer.BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzaej zza(zzadg zzadg) throws IOException {
        return zzc(zzadg, true, false);
    }

    public static zzaej zzb(zzadg zzadg, boolean z) throws IOException {
        return zzc(zzadg, false, z);
    }

    private static zzaej zzc(zzadg zzadg, boolean z, boolean z2) throws IOException {
        zzfo zzfo;
        int i;
        boolean z3;
        zzfo zzfo2;
        int[] iArr;
        zzadg zzadg2 = zzadg;
        boolean z4 = z2;
        long zzd = zzadg.zzd();
        long j = -1;
        int i2 = (zzd > -1 ? 1 : (zzd == -1 ? 0 : -1));
        long j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (i2 != 0 && zzd <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j2 = zzd;
        }
        zzfo zzfo3 = new zzfo(64);
        int i3 = (int) j2;
        boolean z5 = false;
        int i4 = 0;
        boolean z6 = false;
        while (true) {
            if (i4 >= i3) {
                boolean z7 = z5;
                break;
            }
            zzfo3.zzH(8);
            boolean z8 = true;
            if (!zzadg2.zzm(zzfo3.zzM(), z5 ? 1 : 0, 8, true)) {
                break;
            }
            long zzu = zzfo3.zzu();
            int zzg = zzfo3.zzg();
            if (zzu == 1) {
                zzadg2.zzh(zzfo3.zzM(), 8, 8);
                i = 16;
                zzfo3.zzJ(16);
                zzu = zzfo3.zzt();
                zzfo = zzfo3;
            } else {
                if (zzu == 0) {
                    long zzd2 = zzadg.zzd();
                    if (zzd2 != j) {
                        zzu = (zzd2 - zzadg.zze()) + 8;
                    }
                }
                zzfo = zzfo3;
                i = 8;
            }
            long j3 = zzu;
            long j4 = (long) i;
            if (j3 < j4) {
                return new zzajj(zzg, j3, i);
            }
            i4 += i;
            if (zzg == 1836019574) {
                i3 += (int) j3;
                if (i2 != 0 && ((long) i3) > zzd) {
                    i3 = (int) zzd;
                }
                zzfo3 = zzfo;
                j = -1;
                z5 = false;
            } else if (zzg == 1836019558 || zzg == 1836475768) {
                z5 = true;
            } else {
                z6 |= !(zzg != 1835295092);
                int i5 = zzg;
                long j5 = zzd;
                if ((((long) i4) + j3) - j4 >= ((long) i3)) {
                    z5 = false;
                    break;
                }
                int i6 = (int) (j3 - j4);
                i4 += i6;
                if (i5 != 1718909296) {
                    zzfo2 = zzfo;
                    z3 = false;
                    if (i6 != 0) {
                        zzadg2.zzg(i6);
                    }
                } else if (i6 < 8) {
                    return new zzajj(Atom.TYPE_ftyp, (long) i6, 8);
                } else {
                    zzfo2 = zzfo;
                    zzfo2.zzH(i6);
                    z3 = false;
                    zzadg2.zzh(zzfo2.zzM(), 0, i6);
                    int zzg2 = zzfo2.zzg();
                    boolean zzd3 = zzd(zzg2, z4) | z6;
                    zzfo2.zzL(4);
                    int zzb = zzfo2.zzb() / 4;
                    if (!zzd3 && zzb > 0) {
                        iArr = new int[zzb];
                        int i7 = 0;
                        while (true) {
                            if (i7 >= zzb) {
                                z8 = zzd3;
                                break;
                            }
                            int zzg3 = zzfo2.zzg();
                            iArr[i7] = zzg3;
                            if (zzd(zzg3, z4)) {
                                break;
                            }
                            i7++;
                        }
                    } else {
                        z8 = zzd3;
                        iArr = null;
                    }
                    if (!z8) {
                        return new zzakf(zzg2, iArr);
                    }
                    z6 = z8;
                }
                zzfo3 = zzfo2;
                z5 = z3;
                zzd = j5;
                j = -1;
            }
        }
        if (!z6) {
            return zzajw.zza;
        }
        if (z != z5) {
            return z5 ? zzajq.zza : zzajq.zzb;
        }
        return null;
    }

    private static boolean zzd(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579) {
            if (z) {
                return true;
            }
            i = 1751476579;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
