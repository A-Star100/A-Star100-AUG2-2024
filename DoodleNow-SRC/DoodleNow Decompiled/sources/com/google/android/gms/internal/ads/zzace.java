package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzace {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] zzd = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, JfifUtil.MARKER_RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return zzb[i] * 256;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return zzf((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    public static zzam zzc(zzfo zzfo, String str, String str2, zzae zzae) {
        zzfn zzfn = new zzfn();
        zzfn.zzi(zzfo);
        int i = zzc[zzfn.zzd(2)];
        zzfn.zzm(8);
        int i2 = zze[zzfn.zzd(3)];
        if (zzfn.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzfn.zzd(5)] * 1000;
        zzfn.zze();
        zzfo.zzK(zzfn.zzb());
        zzak zzak = new zzak();
        zzak.zzK(str);
        zzak.zzW(MimeTypes.AUDIO_AC3);
        zzak.zzy(i2);
        zzak.zzX(i);
        zzak.zzE(zzae);
        zzak.zzN(str2);
        zzak.zzx(i3);
        zzak.zzR(i3);
        return zzak.zzac();
    }

    public static zzam zzd(zzfo zzfo, String str, String str2, zzae zzae) {
        String str3;
        zzfn zzfn = new zzfn();
        zzfn.zzi(zzfo);
        int zzd2 = zzfn.zzd(13) * 1000;
        zzfn.zzm(3);
        int i = zzc[zzfn.zzd(2)];
        zzfn.zzm(10);
        int i2 = zze[zzfn.zzd(3)];
        if (zzfn.zzd(1) != 0) {
            i2++;
        }
        zzfn.zzm(3);
        int zzd3 = zzfn.zzd(4);
        zzfn.zzm(1);
        if (zzd3 > 0) {
            zzfn.zzm(6);
            if (zzfn.zzd(1) != 0) {
                i2 += 2;
            }
            zzfn.zzm(1);
        }
        if (zzfn.zza() > 7) {
            zzfn.zzm(7);
            if (zzfn.zzd(1) != 0) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
                zzfn.zze();
                zzfo.zzK(zzfn.zzb());
                zzak zzak = new zzak();
                zzak.zzK(str);
                zzak.zzW(str3);
                zzak.zzy(i2);
                zzak.zzX(i);
                zzak.zzE(zzae);
                zzak.zzN(str2);
                zzak.zzR(zzd2);
                return zzak.zzac();
            }
        }
        str3 = MimeTypes.AUDIO_E_AC3;
        zzfn.zze();
        zzfo.zzK(zzfn.zzb());
        zzak zzak2 = new zzak();
        zzak2.zzK(str);
        zzak2.zzW(str3);
        zzak2.zzy(i2);
        zzak2.zzX(i);
        zzak2.zzE(zzae);
        zzak2.zzN(str2);
        zzak2.zzR(zzd2);
        return zzak2.zzac();
    }

    public static zzacd zze(zzfn zzfn) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzfn zzfn2 = zzfn;
        int zzc2 = zzfn.zzc();
        zzfn2.zzm(40);
        int zzd2 = zzfn2.zzd(5);
        zzfn2.zzk(zzc2);
        int i12 = -1;
        if (zzd2 > 10) {
            zzfn2.zzm(16);
            int zzd3 = zzfn2.zzd(2);
            if (zzd3 == 0) {
                i12 = 0;
            } else if (zzd3 == 1) {
                i12 = 1;
            } else if (zzd3 == 2) {
                i12 = 2;
            }
            zzfn2.zzm(3);
            int zzd4 = zzfn2.zzd(11) + 1;
            int zzd5 = zzfn2.zzd(2);
            if (zzd5 == 3) {
                i9 = zzd[zzfn2.zzd(2)];
                i7 = 6;
                i8 = 3;
            } else {
                int zzd6 = zzfn2.zzd(2);
                int i13 = zzb[zzd6];
                i8 = zzd6;
                i9 = zzc[zzd5];
                i7 = i13;
            }
            int i14 = zzd4 + zzd4;
            int i15 = (i14 * i9) / (i7 * 32);
            int zzd7 = zzfn2.zzd(3);
            boolean zzo = zzfn.zzo();
            i6 = zze[zzd7] + (zzo ? 1 : 0);
            zzfn2.zzm(10);
            if (zzfn.zzo()) {
                zzfn2.zzm(8);
            }
            if (zzd7 == 0) {
                zzfn2.zzm(5);
                if (zzfn.zzo()) {
                    zzfn2.zzm(8);
                }
                i10 = 0;
                zzd7 = 0;
            } else {
                i10 = zzd7;
            }
            if (i12 == 1) {
                if (zzfn.zzo()) {
                    zzfn2.zzm(16);
                }
                i11 = 1;
            } else {
                i11 = i12;
            }
            if (zzfn.zzo()) {
                if (i10 > 2) {
                    zzfn2.zzm(2);
                }
                if ((i10 & 1) != 0 && i10 > 2) {
                    zzfn2.zzm(6);
                }
                if ((i10 & 4) != 0) {
                    zzfn2.zzm(6);
                }
                if (zzo && zzfn.zzo()) {
                    zzfn2.zzm(5);
                }
                if (i11 == 0) {
                    if (zzfn.zzo()) {
                        zzfn2.zzm(6);
                    }
                    if (i10 == 0 && zzfn.zzo()) {
                        zzfn2.zzm(6);
                    }
                    if (zzfn.zzo()) {
                        zzfn2.zzm(6);
                    }
                    int zzd8 = zzfn2.zzd(2);
                    if (zzd8 == 1) {
                        zzfn2.zzm(5);
                    } else if (zzd8 == 2) {
                        zzfn2.zzm(12);
                    } else if (zzd8 == 3) {
                        int zzd9 = zzfn2.zzd(5);
                        if (zzfn.zzo()) {
                            zzfn2.zzm(5);
                            if (zzfn.zzo()) {
                                zzfn2.zzm(4);
                            }
                            if (zzfn.zzo()) {
                                zzfn2.zzm(4);
                            }
                            if (zzfn.zzo()) {
                                zzfn2.zzm(4);
                            }
                            if (zzfn.zzo()) {
                                zzfn2.zzm(4);
                            }
                            if (zzfn.zzo()) {
                                zzfn2.zzm(4);
                            }
                            if (zzfn.zzo()) {
                                zzfn2.zzm(4);
                            }
                            if (zzfn.zzo()) {
                                zzfn2.zzm(4);
                            }
                            if (zzfn.zzo()) {
                                if (zzfn.zzo()) {
                                    zzfn2.zzm(4);
                                }
                                if (zzfn.zzo()) {
                                    zzfn2.zzm(4);
                                }
                            }
                        }
                        if (zzfn.zzo()) {
                            zzfn2.zzm(5);
                            if (zzfn.zzo()) {
                                zzfn2.zzm(7);
                                if (zzfn.zzo()) {
                                    zzfn2.zzm(8);
                                }
                            }
                        }
                        zzfn2.zzm((zzd9 + 2) * 8);
                        zzfn.zze();
                    }
                    if (i10 < 2) {
                        if (zzfn.zzo()) {
                            zzfn2.zzm(14);
                        }
                        if (zzd7 == 0 && zzfn.zzo()) {
                            zzfn2.zzm(14);
                        }
                    }
                    if (zzfn.zzo()) {
                        if (i8 == 0) {
                            zzfn2.zzm(5);
                            i11 = 0;
                            i8 = 0;
                        } else {
                            for (int i16 = 0; i16 < i7; i16++) {
                                if (zzfn.zzo()) {
                                    zzfn2.zzm(5);
                                }
                            }
                        }
                    }
                    i11 = 0;
                }
            }
            if (zzfn.zzo()) {
                zzfn2.zzm(5);
                if (i10 == 2) {
                    zzfn2.zzm(4);
                    i10 = 2;
                }
                if (i10 >= 6) {
                    zzfn2.zzm(2);
                }
                if (zzfn.zzo()) {
                    zzfn2.zzm(8);
                }
                if (i10 == 0 && zzfn.zzo()) {
                    zzfn2.zzm(8);
                }
                if (zzd5 < 3) {
                    zzfn.zzl();
                }
            }
            if (i11 == 0 && i8 != 3) {
                zzfn.zzl();
            }
            if (i11 == 2 && (i8 == 3 || zzfn.zzo())) {
                zzfn2.zzm(6);
            }
            str = (zzfn.zzo() && zzfn2.zzd(6) == 1 && zzfn2.zzd(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i5 = i12;
            i3 = i14;
            i4 = i9;
            i2 = i7 * 256;
            i = i15;
        } else {
            zzfn2.zzm(32);
            int zzd10 = zzfn2.zzd(2);
            String str2 = zzd10 == 3 ? null : MimeTypes.AUDIO_AC3;
            int zzd11 = zzfn2.zzd(6);
            int i17 = zzf[zzd11 / 2] * 1000;
            int zzf2 = zzf(zzd10, zzd11);
            zzfn2.zzm(8);
            int zzd12 = zzfn2.zzd(3);
            if (!((zzd12 & 1) == 0 || zzd12 == 1)) {
                zzfn2.zzm(2);
            }
            if ((zzd12 & 4) != 0) {
                zzfn2.zzm(2);
            }
            if (zzd12 == 2) {
                zzfn2.zzm(2);
            }
            int i18 = zzd10 < 3 ? zzc[zzd10] : -1;
            i6 = zze[zzd12] + (zzfn.zzo() ? 1 : 0);
            i5 = -1;
            str = str2;
            i = i17;
            i3 = zzf2;
            i4 = i18;
            i2 = 1536;
        }
        return new zzacd(str, i5, i6, i4, i3, i2, i, (zzacc) null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
