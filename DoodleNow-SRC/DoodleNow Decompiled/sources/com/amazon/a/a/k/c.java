package com.amazon.a.a.k;

import com.amazon.a.a.o.a.a;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceManagerImpl */
public class c implements b {
    public static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ResourceManagerImpl");
    private List<Object> b = new ArrayList();
    private boolean c = false;

    public c() {
        a((Object) this);
    }

    public void a(Object obj) {
        if (com.amazon.a.a.o.c.a) {
            com.amazon.a.a.o.c cVar = a;
            cVar.a("Registering resource: " + obj);
        }
        a.a();
        if (!this.c) {
            boolean c2 = c(obj);
            a.b(c2, "Resource already registered: " + obj);
            this.b.add(obj);
            return;
        }
        throw new IllegalStateException("Attempt made to register resource after population has begun!");
    }

    private boolean c(Object obj) {
        a.a(obj, "resource");
        return a(obj.getClass()) != null;
    }

    private Object a(Class<?> cls) {
        for (Object next : this.b) {
            if (cls.isAssignableFrom(next.getClass())) {
                return next;
            }
        }
        return null;
    }

    public void b(Object obj) {
        a.a(obj, TouchesHelper.TARGET_KEY);
        if (com.amazon.a.a.o.c.a) {
            a.a("Populating: " + obj);
        }
        if (!d(obj)) {
            a.a("Ignoring: " + obj + ", not a kiwi class");
            return;
        }
        for (Class cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (a(field)) {
                    a(obj, field);
                }
            }
        }
        if (obj instanceof d) {
            ((d) obj).e();
        }
    }

    private boolean d(Object obj) {
        return obj.getClass().getName().startsWith("com.amazon.");
    }

    private boolean a(Field field) {
        return field.getAnnotation(a.class) != null;
    }

    private void a(Object obj, Field field) {
        Class<?> type = field.getType();
        Object a2 = a(type);
        a.b(a2, "no resource found for type: " + type);
        field.setAccessible(true);
        try {
            field.set(obj, a2);
        } catch (Exception e) {
            a.a("Failed to populate field: " + field, (Throwable) e);
        }
    }

    public void a() {
        for (Object b2 : this.b) {
            b(b2);
        }
    }
}
