package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgpv extends zzgqr {
    private final int zza;
    private final int zzb;
    private final zzgpt zzc;

    /* synthetic */ zzgpv(int i, int i2, zzgpt zzgpt, zzgpu zzgpu) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgpt;
    }

    public static zzgps zze() {
        return new zzgps((zzgpr) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpv)) {
            return false;
        }
        zzgpv zzgpv = (zzgpv) obj;
        if (zzgpv.zza == this.zza && zzgpv.zzd() == zzd() && zzgpv.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgpv.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzc != zzgpt.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgpt zzgpt = this.zzc;
        if (zzgpt == zzgpt.zzd) {
            return this.zzb;
        }
        if (zzgpt == zzgpt.zza || zzgpt == zzgpt.zzb || zzgpt == zzgpt.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgpt zzf() {
        return this.zzc;
    }
}
