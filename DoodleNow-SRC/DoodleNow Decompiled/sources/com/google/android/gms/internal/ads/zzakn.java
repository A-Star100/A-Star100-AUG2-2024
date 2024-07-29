package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzakn {
    private final zzako zza = new zzako();
    private final zzfo zzb = new zzfo(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzakn() {
    }

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzako zzako = this.zza;
            if (i5 >= zzako.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzako.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzfo zza() {
        return this.zzb;
    }

    public final zzako zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzH(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzfo zzfo = this.zzb;
        if (zzfo.zzM().length != 65025) {
            zzfo.zzI(Arrays.copyOf(zzfo.zzM(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, zzfo.zze())), this.zzb.zze());
        }
    }

    public final boolean zze(zzadg zzadg) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzH(0);
        }
        while (true) {
            boolean z = true;
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                if (!this.zza.zzc(zzadg, -1) || !this.zza.zzb(zzadg, true)) {
                    return false;
                }
                zzako zzako = this.zza;
                int i2 = zzako.zzd;
                if ((zzako.zza & 1) == 1 && this.zzb.zze() == 0) {
                    i2 += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzadj.zze(zzadg, i2)) {
                    return false;
                }
                this.zzc = i;
            }
            int zzf = zzf(i);
            int i3 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzfo zzfo = this.zzb;
                zzfo.zzE(zzfo.zze() + zzf);
                zzfo zzfo2 = this.zzb;
                if (!zzadj.zzd(zzadg, zzfo2.zzM(), zzfo2.zze(), zzf)) {
                    return false;
                }
                zzfo zzfo3 = this.zzb;
                zzfo3.zzJ(zzfo3.zze() + zzf);
                if (this.zza.zzf[i3 - 1] == 255) {
                    z = false;
                }
                this.zze = z;
            }
            if (i3 == this.zza.zzc) {
                i3 = -1;
            }
            this.zzc = i3;
        }
        return false;
    }
}
