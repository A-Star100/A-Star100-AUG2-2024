package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgmj extends ThreadLocal {
    zzgmj() {
    }

    protected static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzgwv.zza.zza("AES/GCM-SIV/NoPadding");
            if (!zzgmk.zze(cipher)) {
                return null;
            }
            return cipher;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
