package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzuk implements zzwy {
    public final zzwy zza;
    final /* synthetic */ zzul zzb;
    private boolean zzc;

    public zzuk(zzul zzul, zzwy zzwy) {
        this.zzb = zzul;
        this.zza = zzwy;
    }

    public final int zza(zzlb zzlb, zzih zzih, int i) {
        zzul zzul = this.zzb;
        if (zzul.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzih.zzc(4);
            return -4;
        }
        long zzb2 = zzul.zzb();
        int zza2 = this.zza.zza(zzlb, zzih, i);
        if (zza2 == -5) {
            zzam zzam = zzlb.zza;
            zzam.getClass();
            int i2 = zzam.zzC;
            int i3 = 0;
            if (i2 == 0) {
                if (zzam.zzD != 0) {
                    i2 = 0;
                }
                return -5;
            }
            if (this.zzb.zzb == Long.MIN_VALUE) {
                i3 = zzam.zzD;
            }
            zzak zzb3 = zzam.zzb();
            zzb3.zzF(i2);
            zzb3.zzG(i3);
            zzlb.zza = zzb3.zzac();
            return -5;
        }
        long j = this.zzb.zzb;
        if (j == Long.MIN_VALUE || ((zza2 != -4 || zzih.zze < j) && (zza2 != -3 || zzb2 != Long.MIN_VALUE || zzih.zzd))) {
            return zza2;
        }
        zzih.zzb();
        zzih.zzc(4);
        this.zzc = true;
        return -4;
    }

    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
