package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzadc {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, OpusUtil.SAMPLE_RATE, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, OpusUtil.SAMPLE_RATE, 96000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(byte[] bArr) {
        zzfn zzg2 = zzg(bArr);
        zzg2.zzm(42);
        return zzg2.zzd(true != zzg2.zzo() ? 8 : 12) + 1;
    }

    public static int zzb(byte[] bArr) {
        zzfn zzg2 = zzg(bArr);
        zzg2.zzm(32);
        return zzf(zzg2, zzj, true) + 1;
    }

    public static zzam zzc(byte[] bArr, String str, String str2, int i, zzae zzae) {
        int i2;
        zzfn zzg2 = zzg(bArr);
        zzg2.zzm(60);
        int i3 = zzb[zzg2.zzd(6)];
        int i4 = zzc[zzg2.zzd(4)];
        int zzd2 = zzg2.zzd(5);
        if (zzd2 >= 29) {
            i2 = -1;
        } else {
            i2 = (zzd[zzd2] * 1000) / 2;
        }
        zzg2.zzm(10);
        int i5 = i3 + (zzg2.zzd(2) > 0 ? 1 : 0);
        zzak zzak = new zzak();
        zzak.zzK(str);
        zzak.zzW(MimeTypes.AUDIO_DTS);
        zzak.zzx(i2);
        zzak.zzy(i5);
        zzak.zzX(i4);
        zzak.zzE((zzae) null);
        zzak.zzN(str2);
        zzak.zzU(i);
        return zzak.zzac();
    }

    public static zzadb zzd(byte[] bArr) throws zzcc {
        int i;
        int i2;
        int i3;
        long j;
        int i4;
        zzfn zzg2 = zzg(bArr);
        zzg2.zzm(40);
        int zzd2 = zzg2.zzd(2);
        boolean zzo = zzg2.zzo();
        int i5 = true != zzo ? 16 : 20;
        zzg2.zzm(true != zzo ? 8 : 12);
        int zzd3 = zzg2.zzd(i5) + 1;
        boolean zzo2 = zzg2.zzo();
        int i6 = 0;
        if (zzo2) {
            i = zzg2.zzd(2);
            int zzd4 = zzg2.zzd(3) + 1;
            if (zzg2.zzo()) {
                zzg2.zzm(36);
            }
            int zzd5 = zzg2.zzd(3) + 1;
            int zzd6 = zzg2.zzd(3) + 1;
            if (zzd5 == 1 && zzd6 == 1) {
                int i7 = zzd2 + 1;
                int zzd7 = zzg2.zzd(i7);
                for (int i8 = 0; i8 < i7; i8++) {
                    if (((zzd7 >> i8) & 1) == 1) {
                        zzg2.zzm(8);
                    }
                }
                int i9 = zzd4 * 512;
                if (zzg2.zzo()) {
                    zzg2.zzm(2);
                    int zzd8 = (zzg2.zzd(2) + 1) << 2;
                    int zzd9 = zzg2.zzd(2) + 1;
                    while (i6 < zzd9) {
                        zzg2.zzm(zzd8);
                        i6++;
                    }
                }
                i6 = i9;
            } else {
                throw zzcc.zzc("Multiple audio presentations or assets not supported");
            }
        } else {
            i = -1;
        }
        zzg2.zzm(i5);
        zzg2.zzm(12);
        if (zzo2) {
            if (zzg2.zzo()) {
                zzg2.zzm(4);
            }
            if (zzg2.zzo()) {
                zzg2.zzm(24);
            }
            if (zzg2.zzo()) {
                zzg2.zzn(zzg2.zzd(10) + 1);
            }
            zzg2.zzm(5);
            int i10 = zze[zzg2.zzd(4)];
            i3 = zzg2.zzd(8) + 1;
            i2 = i10;
        } else {
            i2 = -2147483647;
            i3 = -1;
        }
        if (zzo2) {
            if (i == 0) {
                i4 = 32000;
            } else if (i == 1) {
                i4 = 44100;
            } else if (i == 2) {
                i4 = OpusUtil.SAMPLE_RATE;
            } else {
                throw zzcc.zza("Unsupported reference clock code in DTS HD header: " + i, (Throwable) null);
            }
            j = zzfx.zzt((long) i6, 1000000, (long) i4, RoundingMode.FLOOR);
        } else {
            j = C.TIME_UNSET;
        }
        return new zzadb(MimeTypes.AUDIO_DTS_EXPRESS, i3, i2, zzd3, j, 0, (zzada) null);
    }

    public static zzadb zze(byte[] bArr, AtomicInteger atomicInteger) throws zzcc {
        long j;
        int i;
        int i2;
        int i3;
        byte[] bArr2 = bArr;
        zzfn zzg2 = zzg(bArr);
        int zzd2 = zzg2.zzd(32);
        int zzf2 = zzf(zzg2, zzf, true);
        int i4 = zzf2 + 1;
        char c = zzd2 == 1078008818 ? (char) 1 : 0;
        if (c == 0) {
            j = C.TIME_UNSET;
            i = C.RATE_UNSET_INT;
        } else if (zzg2.zzo()) {
            int i5 = zzf2 - 1;
            if (((bArr2[zzf2] & 255) | ((char) (bArr2[i5] << 8))) == zzfx.zzd(bArr2, 0, i5, 65535)) {
                int zzd3 = zzg2.zzd(2);
                if (zzd3 == 0) {
                    i2 = 512;
                } else if (zzd3 == 1) {
                    i2 = 480;
                } else if (zzd3 == 2) {
                    i2 = BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
                } else {
                    throw zzcc.zza("Unsupported base duration index in DTS UHD header: " + zzd3, (Throwable) null);
                }
                int zzd4 = zzg2.zzd(3) + 1;
                int zzd5 = zzg2.zzd(2);
                if (zzd5 == 0) {
                    i3 = 32000;
                } else if (zzd5 == 1) {
                    i3 = 44100;
                } else if (zzd5 == 2) {
                    i3 = OpusUtil.SAMPLE_RATE;
                } else {
                    throw zzcc.zza("Unsupported clock rate index in DTS UHD header: " + zzd5, (Throwable) null);
                }
                if (zzg2.zzo()) {
                    zzg2.zzm(36);
                }
                i = (1 << zzg2.zzd(2)) * i3;
                j = zzfx.zzt((long) (i2 * zzd4), 1000000, (long) i3, RoundingMode.FLOOR);
            } else {
                throw zzcc.zza("CRC check failed", (Throwable) null);
            }
        } else {
            throw zzcc.zzc("Only supports full channel mask-based audio presentation");
        }
        int i6 = i;
        long j2 = j;
        int i7 = 0;
        for (char c2 = 0; c2 < c; c2 = 1) {
            i7 += zzf(zzg2, zzg, true);
        }
        for (char c3 = 0; c3 <= 0; c3 = 1) {
            if (c != 0) {
                atomicInteger.set(zzf(zzg2, zzh, true));
            } else {
                AtomicInteger atomicInteger2 = atomicInteger;
            }
            i7 += atomicInteger.get() != 0 ? zzf(zzg2, zzi, true) : 0;
        }
        return new zzadb(MimeTypes.AUDIO_DTS_X, 2, i6, i4 + i7, j2, 0, (zzada) null);
    }

    private static int zzf(zzfn zzfn, int[] iArr, boolean z) {
        int i = 0;
        for (int i2 = 0; i2 < 3 && zzfn.zzo(); i2++) {
            i++;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += 1 << iArr[i4];
        }
        return i3 + zzfn.zzd(iArr[i]);
    }

    private static zzfn zzg(byte[] bArr) {
        byte b = bArr[0];
        if (b == Byte.MAX_VALUE || b == 100 || b == 64 || b == 113) {
            return new zzfn(bArr, bArr.length);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        byte b2 = copyOf[0];
        if (b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte b3 = copyOf[i];
                int i2 = i + 1;
                copyOf[i] = copyOf[i2];
                copyOf[i2] = b3;
            }
        }
        int length = copyOf.length;
        zzfn zzfn = new zzfn(copyOf, length);
        if (copyOf[0] == 31) {
            zzfn zzfn2 = new zzfn(copyOf, length);
            while (zzfn2.zza() >= 16) {
                zzfn2.zzm(2);
                zzfn.zzf(zzfn2.zzd(14), 14);
            }
        }
        zzfn.zzj(copyOf, copyOf.length);
        return zzfn;
    }
}
