package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdv {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzdv(int i, int i2, float f, float f2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = ((float) i) / ((float) i3);
        this.zzf = i / 400;
        int i4 = i / 65;
        this.zzg = i4;
        int i5 = i4 + i4;
        this.zzh = i5;
        this.zzi = new short[i5];
        int i6 = i5 * i2;
        this.zzj = new short[i6];
        this.zzl = new short[i6];
        this.zzn = new short[i6];
    }

    private final int zzg(short[] sArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = 255;
        int i6 = 0;
        int i7 = 0;
        while (i2 <= i3) {
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = this.zzb * i;
                i8 += Math.abs(sArr[i10 + i9] - sArr[(i10 + i2) + i9]);
            }
            int i11 = i8 * i6;
            int i12 = i4 * i2;
            if (i11 < i12) {
                i4 = i8;
            }
            if (i11 < i12) {
                i6 = i2;
            }
            int i13 = i8 * i5;
            int i14 = i7 * i2;
            if (i13 > i14) {
                i7 = i8;
            }
            if (i13 > i14) {
                i5 = i2;
            }
            i2++;
        }
        this.zzu = i4 / i6;
        this.zzv = i7 / i5;
        return i6;
    }

    private final void zzh(short[] sArr, int i, int i2) {
        short[] zzl2 = zzl(this.zzl, this.zzm, i2);
        this.zzl = zzl2;
        int i3 = this.zzm;
        int i4 = this.zzb;
        System.arraycopy(sArr, i * i4, zzl2, i3 * i4, i2 * i4);
        this.zzm += i2;
    }

    private final void zzi(short[] sArr, int i, int i2) {
        int i3;
        for (int i4 = 0; i4 < this.zzh / i2; i4++) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.zzb;
                i3 = i7 * i2;
                if (i5 >= i3) {
                    break;
                }
                i6 += sArr[(i7 * i) + (i3 * i4) + i5];
                i5++;
            }
            this.zzi[i4] = (short) (i6 / i3);
        }
    }

    private static void zzj(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    private final short[] zzl(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.zzb;
        int i4 = length / i3;
        if (i + i2 <= i4) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int zza() {
        int i = this.zzm * this.zzb;
        return i + i;
    }

    public final int zzb() {
        int i = this.zzk * this.zzb;
        return i + i;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * min);
        int i = this.zzm - min;
        this.zzm = i;
        int i2 = this.zzb;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zze() {
        int i;
        int i2 = this.zzk;
        int i3 = this.zzm;
        float f = this.zzc;
        float f2 = this.zze;
        float f3 = this.zzd;
        int i4 = i3 + ((int) ((((((float) i2) / (f / f3)) + ((float) this.zzo)) / (f2 * f3)) + 0.5f));
        int i5 = this.zzh;
        this.zzj = zzl(this.zzj, i2, i5 + i5 + i2);
        int i6 = 0;
        while (true) {
            int i7 = this.zzh;
            int i8 = this.zzb;
            i = i7 + i7;
            if (i6 >= i * i8) {
                break;
            }
            this.zzj[(i8 * i2) + i6] = 0;
            i6++;
        }
        this.zzk += i;
        zzk();
        if (this.zzm > i4) {
            this.zzm = i4;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzb;
        int i2 = remaining / i;
        int i3 = i * i2;
        short[] zzl2 = zzl(this.zzj, this.zzk, i2);
        this.zzj = zzl2;
        shortBuffer.get(zzl2, this.zzk * this.zzb, (i3 + i3) / 2);
        this.zzk += i2;
        zzk();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a2, code lost:
        r13 = r0.zzs;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzk() {
        /*
            r20 = this;
            r0 = r20
            float r1 = r0.zzc
            float r2 = r0.zzd
            float r1 = r1 / r2
            double r2 = (double) r1
            r4 = 4607182463836013682(0x3ff0000a7c5ac472, double:1.00001)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            int r5 = r0.zzm
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 1
            if (r4 > 0) goto L_0x002c
            r9 = 4607182328728024861(0x3fefffeb074a771d, double:0.99999)
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            short[] r1 = r0.zzj
            int r2 = r0.zzk
            r0.zzh(r1, r7, r2)
            r0.zzk = r7
            goto L_0x0167
        L_0x002c:
            int r4 = r0.zzk
            int r9 = r0.zzh
            if (r4 >= r9) goto L_0x0034
            goto L_0x0167
        L_0x0034:
            r9 = r7
        L_0x0035:
            int r10 = r0.zzr
            if (r10 <= 0) goto L_0x004c
            int r11 = r0.zzh
            int r10 = java.lang.Math.min(r11, r10)
            short[] r11 = r0.zzj
            r0.zzh(r11, r9, r10)
            int r11 = r0.zzr
            int r11 = r11 - r10
            r0.zzr = r11
            int r9 = r9 + r10
            goto L_0x0154
        L_0x004c:
            short[] r10 = r0.zzj
            int r11 = r0.zza
            r12 = 4000(0xfa0, float:5.605E-42)
            if (r11 <= r12) goto L_0x0057
            int r11 = r11 / 4000
            goto L_0x0058
        L_0x0057:
            r11 = r8
        L_0x0058:
            int r12 = r0.zzb
            if (r12 != r8) goto L_0x0067
            if (r11 != r8) goto L_0x0067
            int r11 = r0.zzf
            int r12 = r0.zzg
            int r10 = r0.zzg(r10, r9, r11, r12)
            goto L_0x009c
        L_0x0067:
            r0.zzi(r10, r9, r11)
            short[] r12 = r0.zzi
            int r13 = r0.zzf
            int r14 = r0.zzg
            int r14 = r14 / r11
            int r13 = r13 / r11
            int r12 = r0.zzg(r12, r7, r13, r14)
            if (r11 == r8) goto L_0x009b
            int r12 = r12 * r11
            int r11 = r11 * 4
            int r13 = r0.zzf
            int r14 = r12 - r11
            if (r14 < r13) goto L_0x0082
            r13 = r14
        L_0x0082:
            int r12 = r12 + r11
            int r11 = r0.zzg
            if (r12 <= r11) goto L_0x0088
            r12 = r11
        L_0x0088:
            int r11 = r0.zzb
            if (r11 != r8) goto L_0x0091
            int r10 = r0.zzg(r10, r9, r13, r12)
            goto L_0x009c
        L_0x0091:
            r0.zzi(r10, r9, r8)
            short[] r10 = r0.zzi
            int r10 = r0.zzg(r10, r7, r13, r12)
            goto L_0x009c
        L_0x009b:
            r10 = r12
        L_0x009c:
            int r11 = r0.zzu
            int r12 = r0.zzv
            if (r11 == 0) goto L_0x00b7
            int r13 = r0.zzs
            if (r13 != 0) goto L_0x00a7
            goto L_0x00b7
        L_0x00a7:
            int r14 = r11 * 3
            if (r12 <= r14) goto L_0x00ac
            goto L_0x00b7
        L_0x00ac:
            int r12 = r11 + r11
            int r14 = r0.zzt
            int r14 = r14 * 3
            if (r12 > r14) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r15 = r13
            goto L_0x00b8
        L_0x00b7:
            r15 = r10
        L_0x00b8:
            int r17 = r9 + r15
            r0.zzt = r11
            r0.zzs = r10
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r10 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            float r11 = (float) r15
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r10 <= 0) goto L_0x0102
            short[] r14 = r0.zzj
            float r12 = r12 + r1
            r10 = 1073741824(0x40000000, float:2.0)
            int r13 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r13 < 0) goto L_0x00d4
            float r11 = r11 / r12
            int r10 = (int) r11
            r13 = r10
            goto L_0x00db
        L_0x00d4:
            float r10 = r10 - r1
            float r11 = r11 * r10
            float r11 = r11 / r12
            int r10 = (int) r11
            r0.zzr = r10
            r13 = r15
        L_0x00db:
            short[] r10 = r0.zzl
            int r11 = r0.zzm
            short[] r12 = r0.zzl(r10, r11, r13)
            r0.zzl = r12
            int r11 = r0.zzb
            int r10 = r0.zzm
            r16 = r10
            r10 = r13
            r18 = r13
            r13 = r16
            r16 = r14
            r19 = r15
            r15 = r9
            zzj(r10, r11, r12, r13, r14, r15, r16, r17)
            int r10 = r0.zzm
            int r10 = r10 + r18
            r0.zzm = r10
            int r15 = r19 + r18
            int r9 = r9 + r15
            goto L_0x0154
        L_0x0102:
            r19 = r15
            short[] r15 = r0.zzj
            float r10 = r6 - r1
            r13 = 1056964608(0x3f000000, float:0.5)
            int r13 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x0114
            float r11 = r11 * r1
            float r11 = r11 / r10
            int r10 = (int) r11
            r18 = r10
            goto L_0x011e
        L_0x0114:
            float r13 = r1 + r1
            float r13 = r13 + r12
            float r11 = r11 * r13
            float r11 = r11 / r10
            int r10 = (int) r11
            r0.zzr = r10
            r18 = r19
        L_0x011e:
            short[] r10 = r0.zzl
            int r11 = r0.zzm
            int r14 = r19 + r18
            short[] r10 = r0.zzl(r10, r11, r14)
            r0.zzl = r10
            int r11 = r0.zzb
            int r12 = r9 * r11
            int r13 = r0.zzm
            int r13 = r13 * r11
            int r11 = r11 * r19
            java.lang.System.arraycopy(r15, r12, r10, r13, r11)
            int r11 = r0.zzb
            short[] r12 = r0.zzl
            int r10 = r0.zzm
            int r13 = r10 + r19
            r10 = r18
            r19 = r14
            r14 = r15
            r16 = r15
            r15 = r17
            r17 = r9
            zzj(r10, r11, r12, r13, r14, r15, r16, r17)
            int r10 = r0.zzm
            int r10 = r10 + r19
            r0.zzm = r10
            int r9 = r9 + r18
        L_0x0154:
            int r10 = r0.zzh
            int r10 = r10 + r9
            if (r10 <= r4) goto L_0x0035
            int r1 = r0.zzk
            int r1 = r1 - r9
            short[] r2 = r0.zzj
            int r3 = r0.zzb
            int r9 = r9 * r3
            int r3 = r3 * r1
            java.lang.System.arraycopy(r2, r9, r2, r7, r3)
            r0.zzk = r1
        L_0x0167:
            float r1 = r0.zzd
            float r2 = r0.zze
            float r2 = r2 * r1
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0224
            int r1 = r0.zzm
            if (r1 != r5) goto L_0x0176
            goto L_0x0224
        L_0x0176:
            int r1 = r0.zza
            float r3 = (float) r1
            float r3 = r3 / r2
            int r2 = (int) r3
        L_0x017b:
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r2 > r3) goto L_0x021e
            if (r1 <= r3) goto L_0x0183
            goto L_0x021e
        L_0x0183:
            int r3 = r0.zzm
            int r3 = r3 - r5
            short[] r4 = r0.zzn
            int r6 = r0.zzo
            short[] r4 = r0.zzl(r4, r6, r3)
            r0.zzn = r4
            short[] r6 = r0.zzl
            int r9 = r0.zzb
            int r10 = r5 * r9
            int r11 = r0.zzo
            int r11 = r11 * r9
            int r9 = r9 * r3
            java.lang.System.arraycopy(r6, r10, r4, r11, r9)
            r0.zzm = r5
            int r4 = r0.zzo
            int r4 = r4 + r3
            r0.zzo = r4
            r3 = r7
        L_0x01a5:
            int r4 = r0.zzo
            int r5 = r4 + -1
            if (r3 >= r5) goto L_0x020b
        L_0x01ab:
            int r4 = r0.zzp
            int r4 = r4 + r8
            int r5 = r4 * r2
            int r6 = r0.zzq
            int r9 = r6 * r1
            if (r5 <= r9) goto L_0x01f8
            short[] r4 = r0.zzl
            int r5 = r0.zzm
            short[] r4 = r0.zzl(r4, r5, r8)
            r0.zzl = r4
            r4 = r7
        L_0x01c1:
            int r5 = r0.zzb
            if (r4 >= r5) goto L_0x01ed
            short[] r6 = r0.zzl
            int r9 = r0.zzm
            int r9 = r9 * r5
            short[] r10 = r0.zzn
            int r11 = r3 * r5
            int r11 = r11 + r4
            short r12 = r10[r11]
            int r11 = r11 + r5
            short r5 = r10[r11]
            int r10 = r0.zzq
            int r10 = r10 * r1
            int r11 = r0.zzp
            int r13 = r11 * r2
            int r11 = r11 + r8
            int r11 = r11 * r2
            int r10 = r11 - r10
            int r12 = r12 * r10
            int r11 = r11 - r13
            int r10 = r11 - r10
            int r10 = r10 * r5
            int r12 = r12 + r10
            int r12 = r12 / r11
            short r5 = (short) r12
            int r9 = r9 + r4
            r6[r9] = r5
            int r4 = r4 + 1
            goto L_0x01c1
        L_0x01ed:
            int r4 = r0.zzq
            int r4 = r4 + r8
            r0.zzq = r4
            int r4 = r0.zzm
            int r4 = r4 + r8
            r0.zzm = r4
            goto L_0x01ab
        L_0x01f8:
            r0.zzp = r4
            if (r4 != r1) goto L_0x0208
            r0.zzp = r7
            if (r6 != r2) goto L_0x0202
            r4 = r8
            goto L_0x0203
        L_0x0202:
            r4 = r7
        L_0x0203:
            com.google.android.gms.internal.ads.zzek.zzf(r4)
            r0.zzq = r7
        L_0x0208:
            int r3 = r3 + 1
            goto L_0x01a5
        L_0x020b:
            if (r5 == 0) goto L_0x0224
            short[] r1 = r0.zzn
            int r2 = r0.zzb
            int r4 = r4 - r5
            int r3 = r5 * r2
            int r4 = r4 * r2
            java.lang.System.arraycopy(r1, r3, r1, r7, r4)
            int r1 = r0.zzo
            int r1 = r1 - r5
            r0.zzo = r1
            return
        L_0x021e:
            int r2 = r2 / 2
            int r1 = r1 / 2
            goto L_0x017b
        L_0x0224:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdv.zzk():void");
    }
}
