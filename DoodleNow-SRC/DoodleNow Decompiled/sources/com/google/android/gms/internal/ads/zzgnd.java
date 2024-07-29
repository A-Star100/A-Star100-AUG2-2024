package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnd extends zzgft {
    private final zzgot zza;

    public zzgnd(zzgot zzgot, @Nullable zzggn zzggn) throws GeneralSecurityException {
        zzc(zzgot, zzggn);
        this.zza = zzgot;
    }

    private static void zzc(zzgot zzgot, @Nullable zzggn zzggn) throws GeneralSecurityException {
        int i = zzgnc.zzb[zzgot.zzb().ordinal()];
    }

    public final zzgot zza(@Nullable zzggn zzggn) throws GeneralSecurityException {
        zzc(this.zza, zzggn);
        return this.zza;
    }

    @Nullable
    public final Integer zzb() {
        return this.zza.zzf();
    }
}
