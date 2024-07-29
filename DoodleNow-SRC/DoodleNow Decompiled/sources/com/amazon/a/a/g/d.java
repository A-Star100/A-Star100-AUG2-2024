package com.amazon.a.a.g;

import android.util.Log;

/* compiled from: SandboxLogHandler */
public class d implements c {
    private static final boolean a = true;
    private static final boolean b = true;
    private static final boolean c = true;

    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return true;
    }

    public void a(String str, String str2) {
        Log.d(str, a(str2));
    }

    public void b(String str, String str2) {
        Log.e(str, a(str2));
    }

    public void c(String str, String str2) {
        Log.v(str, a(str2));
    }

    private static String a(String str) {
        return "Appstore SDK - Sandbox Mode: " + str;
    }
}
