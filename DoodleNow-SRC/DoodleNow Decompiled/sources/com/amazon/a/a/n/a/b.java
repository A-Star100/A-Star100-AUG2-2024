package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.amazon.a.a.k.a;
import com.amazon.a.a.o.b.e;
import com.amazon.a.a.o.c;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* compiled from: AuthenticationTokenVerifier */
public class b {
    private static final c a = new c("CommandResultVerifier");
    @a
    private Application b;
    @a
    private com.amazon.a.a.o.b.b c;

    public void a(String str, String str2) throws com.amazon.a.a.d.b {
        if (c.a) {
            c cVar = a;
            cVar.a("Verifying auth token: " + str);
        }
        Signature[] signatureArr = a(str2).signatures;
        int length = signatureArr.length;
        int i = 0;
        while (i < length) {
            if (!a(str, signatureArr[i])) {
                i++;
            } else {
                return;
            }
        }
        throw new com.amazon.a.a.n.a.a.a();
    }

    public boolean a(String str, List<String> list) {
        a.a("checkSignatures(" + str + ", " + list);
        try {
            for (Signature signature : a(str).signatures) {
                for (String b2 : list) {
                    if (b(b2, signature)) {
                        return true;
                    }
                }
            }
        } catch (com.amazon.a.a.n.a.a.c e) {
            a.b("isPackageSignatureValid: caught exception while checking", e);
        }
        return false;
    }

    private boolean a(String str, Signature signature) throws com.amazon.a.a.o.b.a.a {
        try {
            return e.a(a(signature), str, this.c.a());
        } catch (CertificateException unused) {
            if (!c.b) {
                return false;
            }
            c cVar = a;
            cVar.b("Failed to extract fingerprint from signature: " + signature);
            return false;
        }
    }

    private boolean b(String str, Signature signature) {
        boolean z = false;
        try {
            z = str.equals(a(signature));
            c cVar = a;
            cVar.a("Signature valid: " + z);
            return z;
        } catch (CertificateException unused) {
            a.b("Failed to extract fingerprint from signature");
            return z;
        }
    }

    private PackageInfo a(String str) throws com.amazon.a.a.n.a.a.c {
        try {
            return this.b.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            c cVar = a;
            cVar.a("getPackageInfo() caught exception" + e);
            throw new com.amazon.a.a.n.a.a.c();
        }
    }

    private String a(Signature signature) throws CertificateException {
        return com.amazon.c.a.a.c.a(b(signature).getSignature());
    }

    private X509Certificate b(Signature signature) throws CertificateException {
        return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
    }
}
