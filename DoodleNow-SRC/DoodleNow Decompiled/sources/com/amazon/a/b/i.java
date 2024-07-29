package com.amazon.a.b;

import com.amazon.a.a.n.a;
import com.amazon.a.a.o.c;
import com.amazon.a.a.o.d;
import java.lang.reflect.Method;

/* compiled from: NotifyDeveloperOfDRMSuccessTask */
public class i implements a {
    private static final c a = new c("DRMSuccessTask");
    private static final String b = "com.amazon.drm.AmazonLicenseVerificationCallback";
    private static final String c = "onDRMSuccess";

    public void a() {
        Method a2;
        Class<?> a3 = d.a(b);
        if (a3 != null && (a2 = a(a3, c)) != null) {
            if (c.a) {
                c cVar = a;
                cVar.a("Invoking callback: " + a2.getName());
            }
            try {
                a2.invoke((Object) null, new Object[0]);
                if (c.a) {
                    a.a("Callback invoked.");
                }
            } catch (Exception unused) {
            }
        }
    }

    private static Method a(Class<?> cls, String str) {
        com.amazon.a.a.o.a.a.a((Object) cls, "Class<?> target");
        com.amazon.a.a.o.a.a.a((Object) str, "String methodName");
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            if (declaredMethod == null) {
                if (c.a) {
                    c cVar = a;
                    cVar.a("No exception thrown, but method '" + str + "' was not found, this should not happen. ");
                }
                return null;
            }
            declaredMethod.setAccessible(true);
            if (!d.c(declaredMethod)) {
                if (c.a) {
                    c cVar2 = a;
                    cVar2.a("Callback " + str + " isn't static, ignoring...");
                }
                return null;
            } else if (!d.b(declaredMethod)) {
                if (c.a) {
                    c cVar3 = a;
                    cVar3.a("Callback " + str + " returns a value, ignoring...");
                }
                return null;
            } else if (!d.a(declaredMethod)) {
                return declaredMethod;
            } else {
                if (c.a) {
                    c cVar4 = a;
                    cVar4.a("Callback " + str + " takes parameters, ignoring...");
                }
                return null;
            }
        } catch (NoSuchMethodException unused) {
            if (c.a) {
                c cVar5 = a;
                cVar5.a("Did not find method " + str);
            }
            return null;
        }
    }
}
