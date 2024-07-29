package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjd extends zzggt {
    private final zzgjc zza;

    private zzgjd(zzgjc zzgjc) {
        this.zza = zzgjc;
    }

    public static zzgjd zzc(zzgjc zzgjc) {
        return new zzgjd(zzgjc);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgjd) && ((zzgjd) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgjd.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final boolean zza() {
        return this.zza != zzgjc.zzc;
    }

    public final zzgjc zzb() {
        return this.zza;
    }
}
