package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnm {
    private static final zzgnm zza = new zzgnm();
    private final Map zzb = new HashMap();

    public static zzgnm zza() {
        return zza;
    }

    public final synchronized void zzb(zzgnl zzgnl, Class cls) throws GeneralSecurityException {
        zzgnl zzgnl2 = (zzgnl) this.zzb.get(cls);
        if (zzgnl2 != null) {
            if (!zzgnl2.equals(zzgnl)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
        }
        this.zzb.put(cls, zzgnl);
    }
}
