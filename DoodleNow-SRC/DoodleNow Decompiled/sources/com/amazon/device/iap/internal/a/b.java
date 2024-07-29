package com.amazon.device.iap.internal.a;

import com.amazon.device.iap.internal.c;
import com.amazon.device.iap.internal.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: KiwiImplementationRegistry */
public final class b implements c {
    private static final Map<Class, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(e.class, d.class);
    }

    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
