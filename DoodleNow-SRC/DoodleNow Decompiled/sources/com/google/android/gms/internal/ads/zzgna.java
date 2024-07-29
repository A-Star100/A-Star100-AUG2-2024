package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgna {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgna(Class cls, Class cls2, zzgmz zzgmz) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgna zzb(zzgmy zzgmy, Class cls, Class cls2) {
        return new zzgmx(cls, cls2, zzgmy);
    }

    public abstract zzgoy zza(zzgft zzgft, @Nullable zzggn zzggn) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
