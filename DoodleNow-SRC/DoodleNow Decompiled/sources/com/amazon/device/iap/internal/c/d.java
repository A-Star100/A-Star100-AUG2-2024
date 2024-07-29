package com.amazon.device.iap.internal.c;

import com.amazon.device.iap.internal.c;
import com.amazon.device.iap.internal.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SandboxImplementationRegistry */
public final class d implements c {
    private static final Map<Class, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(e.class, e.class);
    }

    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
