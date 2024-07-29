package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzggg {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    @Deprecated
    public static zzggf zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            zzggf zzggf = (zzggf) it.next();
            if (zzggf.zza()) {
                return zzggf;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
