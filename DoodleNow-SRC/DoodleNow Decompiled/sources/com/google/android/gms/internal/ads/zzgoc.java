package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgoc {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgoc(Class cls, Class cls2, zzgob zzgob) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgoc zzb(zzgoa zzgoa, Class cls, Class cls2) {
        return new zzgnz(cls, cls2, zzgoa);
    }

    public abstract zzgoy zza(zzggi zzggi) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
