package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhdi {
    static /* bridge */ /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (zzg(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || zzg(b3) || zzg(b4)) {
            throw zzhak.zzd();
        }
        byte b5 = b2 & Utf8.REPLACEMENT_BYTE;
        byte b6 = b3 & Utf8.REPLACEMENT_BYTE;
        byte b7 = ((b & 7) << Ascii.DC2) | (b5 << Ascii.FF) | (b6 << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((b7 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((b7 & 1023) + 56320);
    }

    static /* bridge */ /* synthetic */ void zzc(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zzg(b2)) {
            throw zzhak.zzd();
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    static /* bridge */ /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    static /* bridge */ /* synthetic */ boolean zze(byte b) {
        return b < -16;
    }

    static /* bridge */ /* synthetic */ boolean zzf(byte b) {
        return b < -32;
    }

    private static boolean zzg(byte b) {
        return b > -65;
    }

    static /* bridge */ /* synthetic */ void zzb(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!zzg(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zzg(b3)) {
                cArr[i] = (char) (((b & Ascii.SI) << Ascii.FF) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzhak.zzd();
    }
}
