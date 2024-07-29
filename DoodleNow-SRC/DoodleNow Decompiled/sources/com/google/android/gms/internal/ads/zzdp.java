package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdp {
    public static final zzdp zza = new zzdp(0, 0, 0, 1.0f);
    @Deprecated
    public static final zzn zzb = zzdo.zza;
    private static final String zzg = Integer.toString(0, 36);
    private static final String zzh = Integer.toString(1, 36);
    private static final String zzi = Integer.toString(2, 36);
    private static final String zzj = Integer.toString(3, 36);
    public final int zzc;
    public final int zzd;
    public final int zze = 0;
    public final float zzf;

    public zzdp(int i, int i2, int i3, float f) {
        this.zzc = i;
        this.zzd = i2;
        this.zzf = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdp) {
            zzdp zzdp = (zzdp) obj;
            if (this.zzc == zzdp.zzc && this.zzd == zzdp.zzd) {
                int i = zzdp.zze;
                if (this.zzf == zzdp.zzf) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzc + JfifUtil.MARKER_EOI) * 31) + this.zzd) * 961) + Float.floatToRawIntBits(this.zzf);
    }
}
