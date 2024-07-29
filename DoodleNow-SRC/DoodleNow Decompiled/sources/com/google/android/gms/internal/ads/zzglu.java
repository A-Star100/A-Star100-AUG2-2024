package com.google.android.gms.internal.ads;

import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzglu {
    public static final /* synthetic */ int zza = 0;
    private static final ThreadLocal zzb = new zzglt();

    public static Cipher zza() {
        return (Cipher) zzb.get();
    }
}
