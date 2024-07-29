package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdk {
    public static final zzdk zza = new zzdk(zzfzn.zzm());
    @Deprecated
    public static final zzn zzb = zzdh.zza;
    private static final String zzc = Integer.toString(0, 36);
    private final zzfzn zzd;

    public zzdk(List list) {
        this.zzd = zzfzn.zzk(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzd.equals(((zzdk) obj).zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final zzfzn zza() {
        return this.zzd;
    }

    public final boolean zzb(int i) {
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            zzdj zzdj = (zzdj) this.zzd.get(i2);
            if (zzdj.zzc() && zzdj.zza() == i) {
                return true;
            }
        }
        return false;
    }
}
