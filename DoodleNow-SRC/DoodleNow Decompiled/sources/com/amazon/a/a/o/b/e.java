package com.amazon.a.a.o.b;

import com.amazon.a.a.o.c;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;

/* compiled from: SignatureVerifier */
public class e {
    public static final String a = "SHA384withRSA";
    private static final c b = new c("SignatureVerifier");

    public static boolean a(String str, String str2, PublicKey publicKey) {
        if (c.a) {
            c cVar = b;
            cVar.a("Verifying signature of data: '" + str + "', signature: '" + str2 + "', with key: '" + publicKey.toString());
        }
        try {
            byte[] c = com.amazon.c.a.a.c.c(str2.getBytes());
            Signature instance = Signature.getInstance(a);
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            return instance.verify(c);
        } catch (IOException | GeneralSecurityException unused) {
            return false;
        }
    }
}
