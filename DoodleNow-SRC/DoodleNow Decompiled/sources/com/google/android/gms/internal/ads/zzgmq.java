package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgmq {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzgmq(Map map, Map map2, zzgmp zzgmp) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzgmo zza() {
        return new zzgmo((zzgmn) null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum enumR = (Enum) this.zzb.get(obj);
        if (enumR != null) {
            return enumR;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(String.valueOf(obj))));
    }

    public final Object zzc(Enum enumR) throws GeneralSecurityException {
        Object obj = this.zza.get(enumR);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(String.valueOf(enumR))));
    }
}
