package com.amazon.a.a.m;

import com.amazon.a.a.k.a;
import com.amazon.a.a.k.b;
import com.amazon.a.a.k.d;

/* compiled from: KiwiDataStore */
public class c implements d {
    public static final String a = "DATA_AUTHENTICATION_KEY";
    public static final String b = "APPLICATION_LICENSE";
    public static final String c = "LICENSE_FAILURE_CONTENT";
    public static final String d = "LICENSE_FAILURE_RAW_EXCEPTION";
    public static final String e = "TEST_MODE";
    public static final String f = "PACKAGE";
    public static final String g = "COMMAND";
    @a
    private b h;
    private b i = new b();

    public <T> void a(String str, a aVar) {
        this.i.a(str, aVar);
    }

    public <T> void a(String str, T t) {
        this.i.a(str, t);
    }

    public <T> T a(String str) {
        return this.i.b(str);
    }

    public boolean b(String str) {
        return this.i.a(str);
    }

    public void c(String str) {
        this.i.c(str);
    }

    public void e() {
        this.h.b(this.i);
    }

    public String toString() {
        return this.i.toString();
    }
}
