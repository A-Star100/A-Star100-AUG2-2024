package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcu {
    @Deprecated
    public static final zzn zza = zzct.zza;
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);
    public Object zzb;
    public Object zzc;
    public int zzd;
    public long zze;
    public long zzf;
    public boolean zzg;
    private zzd zzm = zzd.zza;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass().equals(obj.getClass())) {
            zzcu zzcu = (zzcu) obj;
            return zzfx.zzG(this.zzb, zzcu.zzb) && zzfx.zzG(this.zzc, zzcu.zzc) && this.zzd == zzcu.zzd && this.zze == zzcu.zze && this.zzg == zzcu.zzg && zzfx.zzG(this.zzm, zzcu.zzm);
        }
    }

    public final int hashCode() {
        Object obj = this.zzb;
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzc;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        int i2 = ((((hashCode + JfifUtil.MARKER_EOI) * 31) + i) * 31) + this.zzd;
        long j = this.zze;
        return (((((i2 * 31) + ((int) (j ^ (j >>> 32)))) * 961) + (this.zzg ? 1 : 0)) * 31) + this.zzm.hashCode();
    }

    public final int zza(int i) {
        return this.zzm.zza(i).zzd;
    }

    public final int zzb() {
        int i = this.zzm.zzc;
        return 0;
    }

    public final int zzc(long j) {
        return -1;
    }

    public final int zzd(long j) {
        this.zzm.zzb(-1);
        return -1;
    }

    public final int zze(int i) {
        return this.zzm.zza(i).zza(-1);
    }

    public final int zzf(int i, int i2) {
        return this.zzm.zza(i).zza(i2);
    }

    public final int zzg() {
        int i = this.zzm.zze;
        return 0;
    }

    public final long zzh(int i, int i2) {
        zzc zza2 = this.zzm.zza(i);
        return zza2.zzd != -1 ? zza2.zzh[i2] : C.TIME_UNSET;
    }

    public final long zzi(int i) {
        long j = this.zzm.zza(i).zzc;
        return 0;
    }

    public final long zzj() {
        long j = this.zzm.zzd;
        return 0;
    }

    public final long zzk(int i) {
        long j = this.zzm.zza(i).zzi;
        return 0;
    }

    public final zzcu zzl(Object obj, Object obj2, int i, long j, long j2, zzd zzd2, boolean z) {
        this.zzb = obj;
        this.zzc = obj2;
        this.zzd = i;
        this.zze = j;
        this.zzf = 0;
        this.zzm = zzd2;
        this.zzg = z;
        return this;
    }

    public final boolean zzm(int i) {
        zzb();
        if (i != -1) {
            return false;
        }
        this.zzm.zzb(-1);
        return false;
    }

    public final boolean zzn(int i) {
        boolean z = this.zzm.zza(i).zzj;
        return false;
    }
}
