package com.amazon.device.iap.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.d;

/* compiled from: CursorUtil */
public class a {
    private static final String a = (a.class.getName() + "_PREFS");

    public static String a(String str) {
        f.a((Object) str, "userId");
        Context b = d.e().b();
        f.a((Object) b, "context");
        return b.getSharedPreferences(a, 0).getString(str, (String) null);
    }

    public static void a(String str, String str2) {
        f.a((Object) str, "userId");
        Context b = d.e().b();
        f.a((Object) b, "context");
        SharedPreferences.Editor edit = b.getSharedPreferences(a, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
