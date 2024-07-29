package com.amazon.a.b;

import android.os.Build;
import com.amazon.a.a.n.a.a.d;
import com.amazon.a.a.n.a.a.g;
import com.amazon.a.a.n.a.a.h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LicenseFailurePromptContentMapper */
public class f {
    private final Map<Class<? extends com.amazon.a.a.d.b>, c<? extends com.amazon.a.a.d.b>> a = new HashMap();

    /* compiled from: LicenseFailurePromptContentMapper */
    private interface c<T extends com.amazon.a.a.d.b> {
        com.amazon.a.a.i.c a(T t);
    }

    /* compiled from: LicenseFailurePromptContentMapper */
    private static final class a implements c<com.amazon.a.a.n.a.a.f> {
        final Map<String, com.amazon.a.a.i.c> a;

        private a() {
            this.a = new HashMap<String, com.amazon.a.a.i.c>() {
                {
                    put("NO_INTERNET", e.d);
                    put("INVALID_CONTENT_ID", e.e);
                    put("INTERNAL_SERVICE_ERROR", e.f);
                }
            };
        }

        public com.amazon.a.a.i.c a(com.amazon.a.a.n.a.a.f fVar) {
            com.amazon.a.a.i.c cVar = this.a.get(fVar.b());
            if (cVar != null) {
                return cVar;
            }
            return e.e;
        }
    }

    /* compiled from: LicenseFailurePromptContentMapper */
    private static final class b implements c<com.amazon.a.b.a.a> {
        private b() {
        }

        public com.amazon.a.a.i.c a(com.amazon.a.b.a.a aVar) {
            if (aVar.d().a(h.EXPIRATION)) {
                return e.d;
            }
            return e.e;
        }
    }

    public f() {
        if ("Amazon".equals(Build.MANUFACTURER)) {
            a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.n.a.a.c.class, e.b);
        } else {
            a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.n.a.a.c.class, e.a);
        }
        a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.n.a.a.b.class, e.b);
        a((Class<? extends com.amazon.a.a.d.b>) d.class, e.b);
        a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.n.a.a.a.class, e.c);
        a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.n.a.a.f.class, (c<? extends com.amazon.a.a.d.b>) new a());
        a((Class<? extends com.amazon.a.a.d.b>) g.class, e.e);
        a((Class<? extends com.amazon.a.a.d.b>) h.class, e.e);
        a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.b.a.a.class, (c<? extends com.amazon.a.a.d.b>) new b());
        a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.o.b.a.a.class, e.g);
        a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.o.b.a.b.class, e.e);
        a((Class<? extends com.amazon.a.a.d.b>) com.amazon.a.a.o.b.a.c.class, e.e);
    }

    private void a(Class<? extends com.amazon.a.a.d.b> cls, final com.amazon.a.a.i.c cVar) {
        a(cls, (c<? extends com.amazon.a.a.d.b>) new c<com.amazon.a.a.d.b>() {
            public com.amazon.a.a.i.c a(com.amazon.a.a.d.b bVar) {
                return cVar;
            }
        });
    }

    private void a(Class<? extends com.amazon.a.a.d.b> cls, c<? extends com.amazon.a.a.d.b> cVar) {
        boolean containsKey = this.a.containsKey(cls);
        com.amazon.a.a.o.a.a.b(containsKey, "mapping exists for type: " + cls);
        this.a.put(cls, cVar);
    }

    public com.amazon.a.a.i.c a(com.amazon.a.a.d.b bVar) {
        c cVar = this.a.get(bVar.getClass());
        if (cVar == null) {
            return null;
        }
        return cVar.a(bVar);
    }
}
