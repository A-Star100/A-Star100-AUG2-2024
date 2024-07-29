package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrj implements zzgpw {
    private final zzgqd zza;

    public zzgrj(zzgqd zzgqd) throws GeneralSecurityException {
        if (zzgml.zza(2)) {
            this.zza = zzgqd;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
