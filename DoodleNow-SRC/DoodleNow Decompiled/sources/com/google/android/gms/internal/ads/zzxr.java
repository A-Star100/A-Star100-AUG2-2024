package com.google.android.gms.internal.ads;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzxr extends zzxt {
    private final zzzn zzd;
    private final zzfzn zze;
    private final zzel zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zzxr(zzcz zzcz, int[] iArr, int i, zzzn zzzn, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzel zzel) {
        super(zzcz, iArr, 0);
        zzcz zzcz2 = zzcz;
        int[] iArr2 = iArr;
        this.zzd = zzzn;
        this.zze = zzfzn.zzk(list);
        this.zzf = zzel;
    }

    static /* bridge */ /* synthetic */ zzfzn zzf(zzyy[] zzyyArr) {
        int i;
        int i2;
        double d;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 2;
            i2 = 1;
            if (i4 >= 2) {
                break;
            }
            zzyy zzyy = zzyyArr[i4];
            if (zzyy == null || zzyy.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzfzk zzfzk = new zzfzk();
                zzfzk.zzf(new zzxp(0, 0));
                arrayList.add(zzfzk);
            }
            i4++;
        }
        long[][] jArr = new long[2][];
        for (int i5 = 0; i5 < 2; i5++) {
            zzyy zzyy2 = zzyyArr[i5];
            if (zzyy2 == null) {
                jArr[i5] = new long[0];
            } else {
                jArr[i5] = new long[zzyy2.zzb.length];
                int i6 = 0;
                while (true) {
                    int[] iArr = zzyy2.zzb;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    long j = (long) zzyy2.zza.zzb(iArr[i6]).zzi;
                    long[] jArr2 = jArr[i5];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i6] = j;
                    i6++;
                }
                Arrays.sort(jArr[i5]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            long[] jArr4 = jArr[i7];
            jArr3[i7] = jArr4.length == 0 ? 0 : jArr4[0];
        }
        zzg(arrayList, jArr3);
        zzfzy zza = zzgat.zzc(zzgay.zzc()).zzb(2).zza();
        int i8 = 0;
        while (i8 < i) {
            int length = jArr[i8].length;
            if (length > i2) {
                double[] dArr = new double[length];
                int i9 = i3;
                while (true) {
                    long[] jArr5 = jArr[i8];
                    int length2 = jArr5.length;
                    double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                    if (i9 >= length2) {
                        break;
                    }
                    long j2 = jArr5[i9];
                    if (j2 != -1) {
                        d2 = Math.log((double) j2);
                    }
                    dArr[i9] = d2;
                    i9++;
                }
                int i10 = length - 1;
                double d3 = dArr[i10] - dArr[i3];
                int i11 = i3;
                while (i11 < i10) {
                    double d4 = dArr[i11];
                    i11++;
                    double d5 = d4 + dArr[i11];
                    if (d3 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                        d = 1.0d;
                    } else {
                        d = ((d5 * 0.5d) - dArr[i3]) / d3;
                    }
                    zza.zzq(Double.valueOf(d), Integer.valueOf(i8));
                    i3 = 0;
                }
            }
            i8++;
            i3 = 0;
            i = 2;
            i2 = 1;
        }
        zzfzn zzk = zzfzn.zzk(zza.zzr());
        for (int i12 = 0; i12 < zzk.size(); i12++) {
            int intValue = ((Integer) zzk.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr3[intValue] = jArr[intValue][i13];
            zzg(arrayList, jArr3);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j3 = jArr3[i14];
                jArr3[i14] = j3 + j3;
            }
        }
        zzg(arrayList, jArr3);
        zzfzk zzfzk2 = new zzfzk();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzfzk zzfzk3 = (zzfzk) arrayList.get(i15);
            zzfzk2.zzf(zzfzk3 == null ? zzfzn.zzm() : zzfzk3.zzi());
        }
        return zzfzk2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfzk zzfzk = (zzfzk) list.get(i2);
            if (zzfzk != null) {
                zzfzk.zzf(new zzxp(j, jArr[i2]));
            }
        }
    }
}
