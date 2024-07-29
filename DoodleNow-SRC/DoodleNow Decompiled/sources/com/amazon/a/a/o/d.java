package com.amazon.a.a.o;

import com.amazon.a.a.o.a.a;
import java.lang.reflect.Method;

/* compiled from: ReflectionUtils */
public class d {
    private static final c a = new c("Reflection");

    public static Class<?> a(String str) {
        a.a((Object) str, "String className");
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(str);
        } catch (ClassNotFoundException unused) {
            if (c.a) {
                c cVar = a;
                cVar.a("ClassNoFound: " + str);
            }
            return null;
        }
    }

    public static boolean a(Method method) {
        a.a((Object) method, "Method m");
        return method.getParameterTypes().length > 0;
    }

    public static boolean b(Method method) {
        a.a((Object) method, "Method m");
        return method.getReturnType().equals(Void.TYPE);
    }

    public static boolean c(Method method) {
        a.a((Object) method, "Method m");
        return (method.getModifiers() & 8) != 0;
    }
}
