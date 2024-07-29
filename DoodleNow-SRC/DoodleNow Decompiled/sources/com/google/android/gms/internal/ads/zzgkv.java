package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgkv extends zzggt {
    private final zzgku zza;

    private zzgkv(zzgku zzgku) {
        this.zza = zzgku;
    }

    public static zzgkv zzc(zzgku zzgku) {
        return new zzgkv(zzgku);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgkv) && ((zzgkv) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgkv.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "XChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final boolean zza() {
        return this.zza != zzgku.zzc;
    }

    public final zzgku zzb() {
        return this.zza;
    }
}
