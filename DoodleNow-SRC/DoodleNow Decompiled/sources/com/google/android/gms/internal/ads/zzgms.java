package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgms {
    private static final Logger zza = Logger.getLogger(zzgms.class.getName());
    private static final zzgms zzb = new zzgms();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgms zzc() {
        return zzb;
    }

    private final synchronized zzgfu zzg(String str) throws GeneralSecurityException {
        if (this.zzc.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgfu) this.zzc.get(str);
    }

    private final synchronized void zzh(zzgfu zzgfu, boolean z, boolean z2) throws GeneralSecurityException {
        String str = ((zzgnb) zzgfu).zza;
        if (this.zzd.containsKey(str)) {
            if (!((Boolean) this.zzd.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
        }
        zzgfu zzgfu2 = (zzgfu) this.zzc.get(str);
        if (zzgfu2 != null) {
            if (!zzgfu2.getClass().equals(zzgfu.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(str));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, zzgfu2.getClass().getName(), zzgfu.getClass().getName()}));
            }
        }
        this.zzc.putIfAbsent(str, zzgfu);
        this.zzd.put(str, true);
    }

    public final zzgfu zza(String str, Class cls) throws GeneralSecurityException {
        zzgfu zzg = zzg(str);
        if (zzg.zzb().equals(cls)) {
            return zzg;
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzg.getClass());
        String obj = zzg.zzb().toString();
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", which only supports: " + obj);
    }

    public final zzgfu zzb(String str) throws GeneralSecurityException {
        return zzg(str);
    }

    public final synchronized void zzd(zzgfu zzgfu, boolean z) throws GeneralSecurityException {
        zzf(zzgfu, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzgfu zzgfu, int i, boolean z) throws GeneralSecurityException {
        if (zzgml.zza(i)) {
            zzh(zzgfu, false, true);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }
}
