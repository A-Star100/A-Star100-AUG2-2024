package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzghl extends zzggt {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzghj zze;
    private final zzghi zzf;

    /* synthetic */ zzghl(int i, int i2, int i3, int i4, zzghj zzghj, zzghi zzghi, zzghk zzghk) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzghj;
        this.zzf = zzghi;
    }

    public static zzghh zzf() {
        return new zzghh((zzghg) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghl)) {
            return false;
        }
        zzghl zzghl = (zzghl) obj;
        return zzghl.zza == this.zza && zzghl.zzb == this.zzb && zzghl.zzc == this.zzc && zzghl.zzd == this.zzd && zzghl.zze == this.zze && zzghl.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzghl.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        zzghi zzghi = this.zzf;
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(zzghi);
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    public final boolean zza() {
        return this.zze != zzghj.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzghi zzg() {
        return this.zzf;
    }

    public final zzghj zzh() {
        return this.zze;
    }
}
