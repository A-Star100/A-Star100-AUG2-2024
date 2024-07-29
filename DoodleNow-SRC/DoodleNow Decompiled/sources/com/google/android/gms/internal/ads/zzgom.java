package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgom {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    /* synthetic */ zzgom(zzgoi zzgoi, zzgol zzgol) {
        this.zza = new HashMap(zzgoi.zza);
        this.zzb = new HashMap(zzgoi.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzggj) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzgft zzgft, Class cls) throws GeneralSecurityException {
        zzgok zzgok = new zzgok(zzgft.getClass(), cls, (zzgoj) null);
        if (this.zza.containsKey(zzgok)) {
            return ((zzgog) this.zza.get(zzgok)).zza(zzgft);
        }
        String obj = zzgok.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzgos zzgos, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzggj zzggj = (zzggj) this.zzb.get(cls);
            if (zzgos.zzd().equals(zzggj.zza()) && zzggj.zza().equals(zzgos.zzd())) {
                return zzggj.zzc(zzgos);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
