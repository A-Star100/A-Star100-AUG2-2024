package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzghx extends zzggt {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzghv zzd;

    /* synthetic */ zzghx(int i, int i2, int i3, zzghv zzghv, zzghw zzghw) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzghv;
    }

    public static zzghu zzd() {
        return new zzghu((zzght) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghx)) {
            return false;
        }
        zzghx zzghx = (zzghx) obj;
        if (zzghx.zza == this.zza && zzghx.zzb == this.zzb) {
            int i = zzghx.zzc;
            if (zzghx.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzghx.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AesEax Parameters (variant: " + valueOf + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzd != zzghv.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzghv zze() {
        return this.zzd;
    }
}
