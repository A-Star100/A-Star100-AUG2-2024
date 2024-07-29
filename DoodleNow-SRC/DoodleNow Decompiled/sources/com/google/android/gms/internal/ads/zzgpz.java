package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgpz implements zzggj {
    private static final zzgpz zza = new zzgpz();

    private zzgpz() {
    }

    static void zzd() throws GeneralSecurityException {
        zzgnr.zza().zzf(zza);
    }

    public final Class zza() {
        return zzgpw.class;
    }

    public final Class zzb() {
        return zzgpw.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzgos zzgos) throws GeneralSecurityException {
        if (zzgos.zzb() != null) {
            for (List<zzgoq> it : zzgos.zze()) {
                for (zzgoq zze : it) {
                    zzgpw zzgpw = (zzgpw) zze.zze();
                }
            }
            return new zzgpy(zzgos, (zzgpx) null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
