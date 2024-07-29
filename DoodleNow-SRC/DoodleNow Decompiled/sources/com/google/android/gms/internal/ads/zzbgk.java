package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbgk {
    static final AtomicBoolean zza = new AtomicBoolean();
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();

    static zzbgi zza() {
        return (zzbgi) zzb.get();
    }

    static zzbgj zzb() {
        return (zzbgj) zzc.get();
    }

    public static void zzc(zzbgi zzbgi) {
        zzb.set(zzbgi);
    }
}
