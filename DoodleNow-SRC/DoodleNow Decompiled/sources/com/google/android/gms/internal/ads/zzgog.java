package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgog {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgog(Class cls, Class cls2, zzgof zzgof) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgog zzb(zzgoe zzgoe, Class cls, Class cls2) {
        return new zzgod(cls, cls2, zzgoe);
    }

    public abstract Object zza(zzgft zzgft) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
