package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjx extends zzggs {
    private final zzgkc zza;

    private zzgjx(zzgkc zzgkc) {
        this.zza = zzgkc;
    }

    public static zzgjx zza(zzgkc zzgkc) throws GeneralSecurityException {
        return new zzgjx(zzgkc);
    }

    public final zzgkc zzb() {
        return this.zza;
    }
}
