package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzis {
    public final String zza;
    public final zzam zzb;
    public final zzam zzc;
    public final int zzd;
    public final int zze;

    public zzis(String str, zzam zzam, zzam zzam2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        zzek.zzd(z);
        zzek.zzc(str);
        this.zza = str;
        this.zzb = zzam;
        zzam2.getClass();
        this.zzc = zzam2;
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzis zzis = (zzis) obj;
            return this.zzd == zzis.zzd && this.zze == zzis.zze && this.zza.equals(zzis.zza) && this.zzb.equals(zzis.zzb) && this.zzc.equals(zzis.zzc);
        }
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
