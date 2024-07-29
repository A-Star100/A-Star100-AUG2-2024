package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
abstract class zzhdj {
    zzhdj() {
    }

    static final String zzd(ByteBuffer byteBuffer, int i, int i2) throws zzhak {
        int i3;
        if ((((byteBuffer.limit() - i) - i2) | i | i2) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r10 < i4) {
                byte b = byteBuffer.get(r10);
                if (!zzhdi.zzd(b)) {
                    break;
                }
                i = r10 + 1;
                cArr[i5] = (char) b;
                i5++;
            }
            int i6 = i5;
            while (r10 < i4) {
                int i7 = r10 + 1;
                byte b2 = byteBuffer.get(r10);
                if (zzhdi.zzd(b2)) {
                    cArr[i6] = (char) b2;
                    i6++;
                    r10 = i7;
                    while (r10 < i4) {
                        byte b3 = byteBuffer.get(r10);
                        if (!zzhdi.zzd(b3)) {
                            break;
                        }
                        r10++;
                        cArr[i6] = (char) b3;
                        i6++;
                    }
                } else {
                    if (zzhdi.zzf(b2)) {
                        if (i7 < i4) {
                            i3 = i6 + 1;
                            r10 = r10 + 2;
                            zzhdi.zzc(b2, byteBuffer.get(i7), cArr, i6);
                        } else {
                            throw zzhak.zzd();
                        }
                    } else if (zzhdi.zze(b2)) {
                        if (i7 < i4 - 1) {
                            i3 = i6 + 1;
                            int i8 = r10 + 2;
                            r10 = r10 + 3;
                            zzhdi.zzb(b2, byteBuffer.get(i7), byteBuffer.get(i8), cArr, i6);
                        } else {
                            throw zzhak.zzd();
                        }
                    } else if (i7 < i4 - 2) {
                        byte b4 = byteBuffer.get(i7);
                        int i9 = r10 + 3;
                        byte b5 = byteBuffer.get(r10 + 2);
                        r10 += 4;
                        zzhdi.zza(b2, b4, b5, byteBuffer.get(i9), cArr, i6);
                        i6 += 2;
                    } else {
                        throw zzhak.zzd();
                    }
                    i6 = i3;
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract String zzb(byte[] bArr, int i, int i2) throws zzhak;

    /* access modifiers changed from: package-private */
    public final boolean zzc(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
