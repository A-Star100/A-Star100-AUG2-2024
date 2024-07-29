package com.google.android.gms.internal.measurement;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzna {
    private static final zzmx zza = new zzmy();

    static {
        if (zzmv.zzx() && zzmv.zzy()) {
            int i = zzin.zza;
        }
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b2 = bArr[i];
                if (b <= -12 && b2 <= -65) {
                    return b ^ (b2 << 8);
                }
            } else if (i3 == 2) {
                byte b3 = bArr[i];
                byte b4 = bArr[i + 1];
                if (b <= -12 && b3 <= -65 && b4 <= -65) {
                    return ((b3 << 8) ^ b) ^ (b4 << Ascii.DLE);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b <= -12) {
            return b;
        }
        return -1;
    }

    static int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i + length;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i7 < i5) {
                bArr[i7] = (byte) charAt2;
                i7++;
            } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 += 2;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || charAt2 > 57343) && i7 <= i5 - 3) {
                bArr[i7] = (byte) ((charAt2 >>> 12) | 480);
                int i9 = i7 + 2;
                bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i7 += 3;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if (i7 <= i5 - 4) {
                int i10 = i6 + 1;
                if (i10 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i10);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i7] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i11 = i7 + 3;
                        bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i7 += 4;
                        bArr[i11] = (byte) ((codePoint & 63) | 128);
                        i6 = i10;
                    } else {
                        i6 = i10;
                    }
                }
                throw new zzmz(i6 - 1, length);
            } else if (charAt2 < 55296 || charAt2 > 57343 || ((i3 = i6 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
            } else {
                throw new zzmz(i6, length);
            }
            i6++;
        }
        return i7;
    }

    static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzmz(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    static String zzd(byte[] bArr, int i, int i2) throws zzkm {
        int i3;
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r10 < i4) {
                byte b = bArr[r10];
                if (!zzmw.zzd(b)) {
                    break;
                }
                i = r10 + 1;
                cArr[i3] = (char) b;
                i5 = i3 + 1;
            }
            while (r10 < i4) {
                int i6 = r10 + 1;
                byte b2 = bArr[r10];
                if (zzmw.zzd(b2)) {
                    cArr[i3] = (char) b2;
                    i3++;
                    r10 = i6;
                    while (r10 < i4) {
                        byte b3 = bArr[r10];
                        if (!zzmw.zzd(b3)) {
                            break;
                        }
                        r10++;
                        cArr[i3] = (char) b3;
                        i3++;
                    }
                } else if (b2 < -32) {
                    if (i6 < i4) {
                        r10 += 2;
                        zzmw.zzc(b2, bArr[i6], cArr, i3);
                        i3++;
                    } else {
                        throw zzkm.zzc();
                    }
                } else if (b2 < -16) {
                    if (i6 < i4 - 1) {
                        int i7 = r10 + 2;
                        r10 += 3;
                        zzmw.zzb(b2, bArr[i6], bArr[i7], cArr, i3);
                        i3++;
                    } else {
                        throw zzkm.zzc();
                    }
                } else if (i6 < i4 - 2) {
                    int i8 = r10 + 2;
                    int i9 = r10 + 3;
                    r10 += 4;
                    zzmw.zza(b2, bArr[i6], bArr[i8], bArr[i9], cArr, i3);
                    i3 += 2;
                } else {
                    throw zzkm.zzc();
                }
            }
            return new String(cArr, 0, i3);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzf(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }
}
