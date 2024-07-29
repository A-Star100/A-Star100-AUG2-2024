package com.amazon.a.b;

import com.amazon.a.a.o.b.f;
import com.amazon.a.a.o.e;
import java.util.Date;

/* compiled from: ContentLicense */
public class b {
    private final String a;
    private final String b;
    private final String c;
    private final Date d;
    private final String e;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Date d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public b(f fVar) throws com.amazon.a.a.o.b.a.b {
        this.a = a("checksum", fVar);
        this.b = a("customerId", fVar);
        this.c = a("deviceId", fVar);
        this.e = a("packageName", fVar);
        this.d = b("expiration", fVar);
    }

    private String a(String str, f fVar) throws com.amazon.a.a.o.b.a.b {
        String a2 = fVar.a(str);
        if (!e.a(a2)) {
            return a2;
        }
        throw com.amazon.a.a.o.b.a.b.a(str);
    }

    private Date b(String str, f fVar) throws com.amazon.a.a.o.b.a.b {
        String a2 = a(str, fVar);
        try {
            return new Date(Long.parseLong(a2));
        } catch (NumberFormatException unused) {
            throw com.amazon.a.a.o.b.a.b.a(str, a2);
        }
    }
}
