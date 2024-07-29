package com.amazon.device.drm.a.d;

import com.amazon.device.drm.a.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SandboxImplementationRegistry */
public final class b implements com.amazon.device.drm.a.b {
    private static final Map<Class, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(c.class, c.class);
    }

    public <T> Class<T> a(Class<T> cls) {
        return a.get(cls);
    }
}
