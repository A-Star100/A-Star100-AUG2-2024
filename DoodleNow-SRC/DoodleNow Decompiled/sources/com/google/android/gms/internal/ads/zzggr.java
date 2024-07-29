package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzggr {
    @Deprecated
    static final zzgvy zza;
    @Deprecated
    static final zzgvy zzb;
    @Deprecated
    static final zzgvy zzc;

    static {
        zzgvy zzc2 = zzgvy.zzc();
        zza = zzc2;
        zzb = zzc2;
        zzc = zzc2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzggx.zzd();
        zzgqp.zza();
        zzghf.zza(true);
        zzgif.zza(true);
        if (!zzgmm.zzb()) {
            zzghs.zza(true);
            zzgis.zza(true);
            zzgjb.zza(true);
            zzgjl.zza(true);
            zzgjp.zza(true);
            zzgkt.zza(true);
        }
    }
}
