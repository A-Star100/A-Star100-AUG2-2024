package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgxw {
    static int zza(byte[] bArr, int i, zzgxv zzgxv) throws zzhak {
        int zzh = zzh(bArr, i, zzgxv);
        int i2 = zzgxv.zza;
        if (i2 < 0) {
            throw zzhak.zzf();
        } else if (i2 > bArr.length - zzh) {
            throw zzhak.zzj();
        } else if (i2 == 0) {
            zzgxv.zzc = zzgyj.zzb;
            return zzh;
        } else {
            zzgxv.zzc = zzgyj.zzv(bArr, zzh, i2);
            return zzh + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zzc(zzhcg zzhcg, byte[] bArr, int i, int i2, int i3, zzgxv zzgxv) throws IOException {
        Object zze = zzhcg.zze();
        int zzl = zzl(zze, zzhcg, bArr, i, i2, i3, zzgxv);
        zzhcg.zzf(zze);
        zzgxv.zzc = zze;
        return zzl;
    }

    static int zzd(zzhcg zzhcg, byte[] bArr, int i, int i2, zzgxv zzgxv) throws IOException {
        Object zze = zzhcg.zze();
        int zzm = zzm(zze, zzhcg, bArr, i, i2, zzgxv);
        zzhcg.zzf(zze);
        zzgxv.zzc = zze;
        return zzm;
    }

    static int zze(zzhcg zzhcg, int i, byte[] bArr, int i2, int i3, zzhah zzhah, zzgxv zzgxv) throws IOException {
        int zzd = zzd(zzhcg, bArr, i2, i3, zzgxv);
        zzhah.add(zzgxv.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzgxv);
            if (i != zzgxv.zza) {
                break;
            }
            zzd = zzd(zzhcg, bArr, zzh, i3, zzgxv);
            zzhah.add(zzgxv.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzhah zzhah, zzgxv zzgxv) throws IOException {
        zzgzw zzgzw = (zzgzw) zzhah;
        int zzh = zzh(bArr, i, zzgxv);
        int i2 = zzgxv.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzgxv);
            zzgzw.zzi(zzgxv.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw zzhak.zzj();
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzhcy zzhcy, zzgxv zzgxv) throws zzhak {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzk = zzk(bArr, i2, zzgxv);
                zzhcy.zzj(i, Long.valueOf(zzgxv.zzb));
                return zzk;
            } else if (i4 == 1) {
                zzhcy.zzj(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzh = zzh(bArr, i2, zzgxv);
                int i5 = zzgxv.zza;
                if (i5 < 0) {
                    throw zzhak.zzf();
                } else if (i5 <= bArr.length - zzh) {
                    if (i5 == 0) {
                        zzhcy.zzj(i, zzgyj.zzb);
                    } else {
                        zzhcy.zzj(i, zzgyj.zzv(bArr, zzh, i5));
                    }
                    return zzh + i5;
                } else {
                    throw zzhak.zzj();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzhcy zzf = zzhcy.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzh2 = zzh(bArr, i2, zzgxv);
                    int i8 = zzgxv.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzh2;
                        break;
                    }
                    int zzg = zzg(i7, bArr, zzh2, i3, zzf, zzgxv);
                    i7 = i8;
                    i2 = zzg;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzhak.zzg();
                }
                zzhcy.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzhcy.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzhak.zzc();
            }
        } else {
            throw zzhak.zzc();
        }
    }

    static int zzh(byte[] bArr, int i, zzgxv zzgxv) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgxv);
        }
        zzgxv.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzgxv zzgxv) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgxv.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgxv.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgxv.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgxv.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzgxv.zza = i11;
                return i12;
            }
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzhah zzhah, zzgxv zzgxv) {
        zzgzw zzgzw = (zzgzw) zzhah;
        int zzh = zzh(bArr, i2, zzgxv);
        zzgzw.zzi(zzgxv.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzgxv);
            if (i != zzgxv.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzgxv);
            zzgzw.zzi(zzgxv.zza);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i, zzgxv zzgxv) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgxv.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzgxv.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzhcg zzhcg, byte[] bArr, int i, int i2, int i3, zzgxv zzgxv) throws IOException {
        int zzc = ((zzhbo) zzhcg).zzc(obj, bArr, i, i2, i3, zzgxv);
        zzgxv.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzm(java.lang.Object r6, com.google.android.gms.internal.ads.zzhcg r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzgxv r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzi(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.ads.zzhak r6 = com.google.android.gms.internal.ads.zzhak.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgxw.zzm(java.lang.Object, com.google.android.gms.internal.ads.zzhcg, byte[], int, int, com.google.android.gms.internal.ads.zzgxv):int");
    }

    static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
