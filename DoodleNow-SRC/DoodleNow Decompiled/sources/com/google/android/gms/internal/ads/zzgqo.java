package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgqo extends zzgqr {
    private final int zza;
    private final int zzb;
    private final zzgqm zzc;
    private final zzgql zzd;

    /* synthetic */ zzgqo(int i, int i2, zzgqm zzgqm, zzgql zzgql, zzgqn zzgqn) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgqm;
        this.zzd = zzgql;
    }

    public static zzgqk zze() {
        return new zzgqk((zzgqj) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgqo)) {
            return false;
        }
        zzgqo zzgqo = (zzgqo) obj;
        if (zzgqo.zza == this.zza && zzgqo.zzd() == zzd() && zzgqo.zzc == this.zzc && zzgqo.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgqo.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        zzgql zzgql = this.zzd;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(zzgql);
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzc != zzgqm.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgqm zzgqm = this.zzc;
        if (zzgqm == zzgqm.zzd) {
            return this.zzb;
        }
        if (zzgqm == zzgqm.zza || zzgqm == zzgqm.zzb || zzgqm == zzgqm.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgql zzf() {
        return this.zzd;
    }

    public final zzgqm zzg() {
        return this.zzc;
    }
}
