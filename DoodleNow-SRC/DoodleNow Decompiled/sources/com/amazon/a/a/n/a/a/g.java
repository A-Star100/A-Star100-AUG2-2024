package com.amazon.a.a.n.a.a;

import com.amazon.a.a.d.b;

/* compiled from: MalformedResponseException */
public class g extends b {
    public static final String a = "EMPTY";
    public static final String b = "MISSING_FIELD";
    private static final long c = 1;

    private g(String str, String str2) {
        super("MALFORMED_RESPONSE", str, str2);
    }

    public static final g d() {
        return new g(a, (String) null);
    }

    public static final g a(String str) {
        return new g(b, str);
    }
}
