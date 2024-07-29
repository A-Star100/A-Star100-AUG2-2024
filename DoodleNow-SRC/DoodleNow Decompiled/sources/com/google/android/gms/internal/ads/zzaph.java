package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaph implements zzapg {
    private final zzadi zza;
    private final zzaem zzb;
    private final zzapj zzc;
    private final zzam zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaph(zzadi zzadi, zzaem zzaem, zzapj zzapj, String str, int i) throws zzcc {
        this.zza = zzadi;
        this.zzb = zzaem;
        this.zzc = zzapj;
        int i2 = zzapj.zzb * zzapj.zze;
        int i3 = zzapj.zzd;
        int i4 = i2 / 8;
        if (i3 == i4) {
            int i5 = zzapj.zzc * i4;
            int i6 = i5 * 8;
            int max = Math.max(i4, i5 / 10);
            this.zze = max;
            zzak zzak = new zzak();
            zzak.zzW(str);
            zzak.zzx(i6);
            zzak.zzR(i6);
            zzak.zzO(max);
            zzak.zzy(zzapj.zzb);
            zzak.zzX(zzapj.zzc);
            zzak.zzQ(i);
            this.zzd = zzak.zzac();
            return;
        }
        throw zzcc.zza("Expected block size: " + i4 + "; got: " + i3, (Throwable) null);
    }

    public final void zza(int i, long j) {
        this.zza.zzO(new zzapm(this.zzc, 1, (long) i, j));
        this.zzb.zzl(this.zzd);
    }

    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzadg zzadg, long j) throws IOException {
        int i;
        int i2;
        int i3;
        long j2 = j;
        while (true) {
            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i <= 0 || (i2 = this.zzg) >= (i3 = this.zze)) {
                zzapj zzapj = this.zzc;
                int i4 = this.zzg;
                int i5 = zzapj.zzd;
                int i6 = i4 / i5;
            } else {
                int zza2 = zzaek.zza(this.zzb, zzadg, (int) Math.min((long) (i3 - i2), j2), true);
                if (zza2 == -1) {
                    j2 = 0;
                } else {
                    this.zzg += zza2;
                    j2 -= (long) zza2;
                }
            }
        }
        zzapj zzapj2 = this.zzc;
        int i42 = this.zzg;
        int i52 = zzapj2.zzd;
        int i62 = i42 / i52;
        if (i62 > 0) {
            int i7 = i62 * i52;
            int i8 = this.zzg - i7;
            this.zzb.zzs(this.zzf + zzfx.zzt(this.zzh, 1000000, (long) zzapj2.zzc, RoundingMode.FLOOR), 1, i7, i8, (zzael) null);
            this.zzh += (long) i62;
            this.zzg = i8;
        }
        if (i <= 0) {
            return true;
        }
        return false;
    }
}
