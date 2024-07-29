package com.amazon.a.a.g;

import com.amazon.a.a.o.c;

/* compiled from: KiwiLogHandler */
public class b implements c {
    private static c a = new c("Appstore SDK - Production Mode");

    public boolean a() {
        return c.a;
    }

    public boolean b() {
        return c.b;
    }

    public boolean c() {
        return c.b();
    }

    public void a(String str, String str2) {
        a.a(d(str, str2));
    }

    public void b(String str, String str2) {
        a.b(d(str, str2));
    }

    public void c(String str, String str2) {
        a.c(d(str, str2));
    }

    private static String d(String str, String str2) {
        return str + ": " + str2;
    }
}
