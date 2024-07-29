package com.amazon.a.a.o.b;

import com.amazon.a.a.o.a.a;
import com.amazon.a.a.o.b.a.b;
import com.amazon.a.a.o.c;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.IOException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: SignedToken */
public class f {
    public static final String a = ",";
    public static final String b = "=";
    public static final String c = "|";
    private static final c d = new c("SignedToken");
    private final Map<String, String> e = new HashMap();

    public f(String str, PublicKey publicKey) throws b, com.amazon.a.a.o.b.a.c {
        String b2 = b(str);
        int lastIndexOf = b2.lastIndexOf(c);
        if (lastIndexOf != -1) {
            String substring = b2.substring(0, lastIndexOf);
            String substring2 = b2.substring(lastIndexOf + 1);
            if (c.a) {
                c cVar = d;
                cVar.a("Token data: " + substring);
                cVar.a("Signature: " + substring2);
            }
            a(substring, substring2, publicKey);
            c(substring);
            return;
        }
        throw b.d();
    }

    private String b(String str) throws b {
        try {
            return new String(com.amazon.c.a.a.c.c(str.getBytes()));
        } catch (IOException e2) {
            throw b.a((Throwable) e2);
        }
    }

    private void a(String str, String str2, PublicKey publicKey) throws com.amazon.a.a.o.b.a.c {
        if (!e.a(str, str2, publicKey)) {
            throw new com.amazon.a.a.o.b.a.c();
        }
    }

    private void c(String str) throws b {
        StringTokenizer stringTokenizer = new StringTokenizer(str, a);
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            c cVar = d;
            cVar.a("Field: " + nextToken);
            int indexOf = nextToken.indexOf(b);
            if (indexOf != -1) {
                String substring = nextToken.substring(0, indexOf);
                String substring2 = nextToken.substring(indexOf + 1);
                cVar.a("FieldName: " + substring);
                cVar.a("FieldValue: " + substring2);
                this.e.put(substring, substring2);
            } else {
                throw b.d();
            }
        }
    }

    public String a(String str) {
        a.a((Object) str, SubscriberAttributeKt.JSON_NAME_KEY);
        return this.e.get(str);
    }

    public String toString() {
        return "Signed Token: " + this.e;
    }
}
