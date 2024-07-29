package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzggm {
    private static final Logger zza = Logger.getLogger(zzggm.class.getName());
    private static final ConcurrentMap zzb = new ConcurrentHashMap();
    private static final Set zzc;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(zzgfj.class);
        hashSet.add(zzgfp.class);
        hashSet.add(zzggo.class);
        hashSet.add(zzgfr.class);
        hashSet.add(zzgfq.class);
        hashSet.add(zzggh.class);
        hashSet.add(zzgsa.class);
        hashSet.add(zzggk.class);
        hashSet.add(zzggl.class);
        zzc = Collections.unmodifiableSet(hashSet);
    }

    private zzggm() {
    }

    @Nullable
    public static Class zza(Class cls) {
        try {
            return zzgnr.zza().zzb(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zzb(zzgup zzgup, Class cls) throws GeneralSecurityException {
        String zzg = zzgup.zzg();
        return zzgms.zzc().zza(zzg, cls).zzc(zzgup.zzf());
    }
}
