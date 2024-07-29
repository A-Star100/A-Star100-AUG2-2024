package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgfw {
    public static final zzggi zza(zzggi zzggi) throws GeneralSecurityException {
        return zzggi != null ? zzggi : zzggp.zza(zzb((zzggi) null).zzaV());
    }

    static final zzguu zzb(zzggi zzggi) {
        try {
            return ((zzgou) zzgnu.zzc().zze((zzggi) null, zzgou.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzgph("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }
}
