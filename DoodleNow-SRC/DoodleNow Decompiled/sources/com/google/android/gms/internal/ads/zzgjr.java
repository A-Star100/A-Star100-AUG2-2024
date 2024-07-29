package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjr extends zzggt {
    private final String zza;

    private zzgjr(String str) {
        this.zza = str;
    }

    public static zzgjr zzb(String str) throws GeneralSecurityException {
        return new zzgjr(str);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjr)) {
            return false;
        }
        return ((zzgjr) obj).zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgjr.class, this.zza});
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ")";
    }

    public final boolean zza() {
        return false;
    }

    public final String zzc() {
        return this.zza;
    }
}
