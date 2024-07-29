package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbf {
    public static final zzbf zza = new zzbf(new zzbd());
    @Deprecated
    public static final zzn zzb = zzbc.zza;
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    private static final String zzl = Integer.toString(4, 36);
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final float zzf;
    public final float zzg;

    private zzbf(zzbd zzbd) {
        this.zzc = C.TIME_UNSET;
        this.zzd = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbf)) {
            return false;
        }
        zzbf zzbf = (zzbf) obj;
        long j = zzbf.zzc;
        long j2 = zzbf.zzd;
        long j3 = zzbf.zze;
        float f = zzbf.zzf;
        float f2 = zzbf.zzg;
        return true;
    }

    public final int hashCode() {
        int i = (int) -9223372034707292159L;
        return (((((((i * 31) + i) * 31) + i) * 31) + Float.floatToIntBits(-3.4028235E38f)) * 31) + Float.floatToIntBits(-3.4028235E38f);
    }
}
