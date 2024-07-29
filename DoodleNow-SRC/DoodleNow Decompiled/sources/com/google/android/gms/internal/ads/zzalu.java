package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzalu {
    private final zzfo zza = new zzfo();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static /* bridge */ /* synthetic */ void zzb(zzalu zzalu, zzfo zzfo, int i) {
        int zzo;
        if (i >= 4) {
            zzfo.zzL(3);
            int i2 = i - 4;
            if ((zzfo.zzm() & 128) != 0) {
                if (i2 >= 7 && (zzo = zzfo.zzo()) >= 4) {
                    zzalu.zzh = zzfo.zzq();
                    zzalu.zzi = zzfo.zzq();
                    zzalu.zza.zzH(zzo - 4);
                    i2 = i - 11;
                } else {
                    return;
                }
            }
            zzfo zzfo2 = zzalu.zza;
            int zzd2 = zzfo2.zzd();
            int zze2 = zzfo2.zze();
            if (zzd2 < zze2 && i2 > 0) {
                int min = Math.min(i2, zze2 - zzd2);
                zzfo.zzG(zzfo2.zzM(), zzd2, min);
                zzalu.zza.zzK(zzd2 + min);
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzc(zzalu zzalu, zzfo zzfo, int i) {
        if (i >= 19) {
            zzalu.zzd = zzfo.zzq();
            zzalu.zze = zzfo.zzq();
            zzfo.zzL(11);
            zzalu.zzf = zzfo.zzq();
            zzalu.zzg = zzfo.zzq();
        }
    }

    static /* bridge */ /* synthetic */ void zzd(zzalu zzalu, zzfo zzfo, int i) {
        zzalu zzalu2 = zzalu;
        if (i % 5 == 2) {
            zzfo.zzL(2);
            int i2 = 0;
            Arrays.fill(zzalu2.zzb, 0);
            int i3 = i / 5;
            int i4 = 0;
            while (i4 < i3) {
                int zzm = zzfo.zzm();
                int zzm2 = zzfo.zzm();
                int zzm3 = zzfo.zzm();
                int zzm4 = zzfo.zzm();
                double d = (double) zzm2;
                double d2 = (double) (zzm3 - 128);
                double d3 = (double) (zzm4 - 128);
                zzalu2.zzb[zzm] = Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)) | (zzfo.zzm() << 24) | (Math.max(i2, Math.min((int) ((1.402d * d2) + d), 255)) << 16) | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8);
                i4++;
                i2 = 0;
            }
            zzalu2.zzc = true;
        }
    }

    public final zzec zza() {
        int i;
        int i2;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzfo zzfo = this.zza;
        if (zzfo.zze() == 0 || zzfo.zzd() != zzfo.zze() || !this.zzc) {
            return null;
        }
        zzfo.zzK(0);
        int i3 = this.zzh * this.zzi;
        int[] iArr = new int[i3];
        int i4 = 0;
        while (i4 < i3) {
            int zzm = this.zza.zzm();
            if (zzm != 0) {
                i2 = i4 + 1;
                iArr[i4] = this.zzb[zzm];
            } else {
                int zzm2 = this.zza.zzm();
                if (zzm2 != 0) {
                    int i5 = zzm2 & 63;
                    if ((zzm2 & 64) != 0) {
                        i5 = (i5 << 8) | this.zza.zzm();
                    }
                    if ((zzm2 & 128) == 0) {
                        i = 0;
                    } else {
                        i = this.zzb[this.zza.zzm()];
                    }
                    i2 = i5 + i4;
                    Arrays.fill(iArr, i4, i2, i);
                }
            }
            i4 = i2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzea zzea = new zzea();
        zzea.zzc(createBitmap);
        zzea.zzh(((float) this.zzf) / ((float) this.zzd));
        zzea.zzi(0);
        zzea.zze(((float) this.zzg) / ((float) this.zze), 0);
        zzea.zzf(0);
        zzea.zzk(((float) this.zzh) / ((float) this.zzd));
        zzea.zzd(((float) this.zzi) / ((float) this.zze));
        return zzea.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzH(0);
        this.zzc = false;
    }
}
