package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjq extends zzggs {
    private final zzgjr zza;

    private zzgjq(zzgjr zzgjr) {
        this.zza = zzgjr;
    }

    public static zzgjq zza(zzgjr zzgjr) throws GeneralSecurityException {
        return new zzgjq(zzgjr);
    }

    public final zzgjr zzb() {
        return this.zza;
    }
}
