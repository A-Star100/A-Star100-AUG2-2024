package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgmw {
    private final zzgxm zza;
    private final Class zzb;

    /* synthetic */ zzgmw(zzgxm zzgxm, Class cls, zzgmv zzgmv) {
        this.zza = zzgxm;
        this.zzb = cls;
    }

    public static zzgmw zzb(zzgmu zzgmu, zzgxm zzgxm, Class cls) {
        return new zzgmt(zzgxm, cls, zzgmu);
    }

    public abstract zzgft zza(zzgoy zzgoy, @Nullable zzggn zzggn) throws GeneralSecurityException;

    public final zzgxm zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
