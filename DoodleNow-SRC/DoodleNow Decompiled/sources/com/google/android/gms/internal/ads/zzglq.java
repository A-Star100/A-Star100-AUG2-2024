package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzglq extends ThreadLocal {
    zzglq() {
    }

    @Nullable
    protected static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzgwv.zza.zza("ChaCha20-Poly1305");
            if (!zzglr.zzf(cipher)) {
                return null;
            }
            return cipher;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
