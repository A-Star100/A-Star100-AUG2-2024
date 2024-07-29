package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgik extends zzggt {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgii zzd;

    /* synthetic */ zzgik(int i, int i2, int i3, zzgii zzgii, zzgij zzgij) {
        this.zza = i;
        this.zzd = zzgii;
    }

    public static zzgih zzc() {
        return new zzgih((zzgig) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgik)) {
            return false;
        }
        zzgik zzgik = (zzgik) obj;
        if (zzgik.zza == this.zza) {
            int i = zzgik.zzb;
            int i2 = zzgik.zzc;
            if (zzgik.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgik.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AesGcm Parameters (variant: " + valueOf + ", 12-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzd != zzgii.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgii zzd() {
        return this.zzd;
    }
}
