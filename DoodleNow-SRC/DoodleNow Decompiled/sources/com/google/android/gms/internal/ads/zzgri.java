package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgri implements zzgpw {
    private final zzgpm zza;

    public zzgri(zzgpm zzgpm) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            this.zza = zzgpm;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
