package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgny {
    private final zzgxm zza;
    private final Class zzb;

    /* synthetic */ zzgny(zzgxm zzgxm, Class cls, zzgnx zzgnx) {
        this.zza = zzgxm;
        this.zzb = cls;
    }

    public static zzgny zzb(zzgnw zzgnw, zzgxm zzgxm, Class cls) {
        return new zzgnv(zzgxm, cls, zzgnw);
    }

    public abstract zzggi zza(zzgoy zzgoy) throws GeneralSecurityException;

    public final zzgxm zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
