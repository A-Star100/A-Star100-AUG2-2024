package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgix extends zzggt {
    private final int zza;
    private final zzgiv zzb;

    /* synthetic */ zzgix(int i, zzgiv zzgiv, zzgiw zzgiw) {
        this.zza = i;
        this.zzb = zzgiv;
    }

    public static zzgiu zzc() {
        return new zzgiu((zzgit) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgix)) {
            return false;
        }
        zzgix zzgix = (zzgix) obj;
        return zzgix.zza == this.zza && zzgix.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgix.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzb != zzgiv.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgiv zzd() {
        return this.zzb;
    }
}
