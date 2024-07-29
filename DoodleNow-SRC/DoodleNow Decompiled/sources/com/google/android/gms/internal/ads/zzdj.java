package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdj {
    @Deprecated
    public static final zzn zza = zzdi.zza;
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(3, 36);
    private static final String zzf = Integer.toString(4, 36);
    public final int zzb;
    private final zzcz zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final boolean[] zzj;

    public zzdj(zzcz zzcz, boolean z, int[] iArr, boolean[] zArr) {
        int i = zzcz.zzb;
        this.zzb = i;
        boolean z2 = true;
        zzek.zzd(i == iArr.length && i == zArr.length);
        this.zzg = zzcz;
        this.zzh = (!z || i <= 1) ? false : z2;
        this.zzi = (int[]) iArr.clone();
        this.zzj = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzdj zzdj = (zzdj) obj;
            return this.zzh == zzdj.zzh && this.zzg.equals(zzdj.zzg) && Arrays.equals(this.zzi, zzdj.zzi) && Arrays.equals(this.zzj, zzdj.zzj);
        }
    }

    public final int hashCode() {
        return (((((this.zzg.hashCode() * 31) + (this.zzh ? 1 : 0)) * 31) + Arrays.hashCode(this.zzi)) * 31) + Arrays.hashCode(this.zzj);
    }

    public final int zza() {
        return this.zzg.zzd;
    }

    public final zzam zzb(int i) {
        return this.zzg.zzb(i);
    }

    public final boolean zzc() {
        for (boolean z : this.zzj) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzd(int i) {
        return this.zzj[i];
    }
}
