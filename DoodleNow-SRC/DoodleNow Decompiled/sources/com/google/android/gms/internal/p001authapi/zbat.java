package com.google.android.gms.internal.p001authapi;

import android.util.Base64;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.auth-api.zbat  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final class zbat {
    private static final SecureRandom zba = new SecureRandom();

    public static String zba() {
        byte[] bArr = new byte[16];
        zba.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
