package io.jsonwebtoken.lang;

import java.io.InputStream;
import java.lang.reflect.Constructor;

public final class Classes {
    private static final ClassLoaderAccessor CLASS_CL_ACCESSOR = new ExceptionIgnoringAccessor() {
        /* access modifiers changed from: protected */
        public ClassLoader doGetClassLoader() throws Throwable {
            return Classes.class.getClassLoader();
        }
    };
    private static final Classes INSTANCE = new Classes();
    private static final ClassLoaderAccessor SYSTEM_CL_ACCESSOR = new ExceptionIgnoringAccessor() {
        /* access modifiers changed from: protected */
        public ClassLoader doGetClassLoader() throws Throwable {
            return ClassLoader.getSystemClassLoader();
        }
    };
    private static final ClassLoaderAccessor THREAD_CL_ACCESSOR = new ExceptionIgnoringAccessor() {
        /* access modifiers changed from: protected */
        public ClassLoader doGetClassLoader() throws Throwable {
            return Thread.currentThread().getContextClassLoader();
        }
    };

    private interface ClassLoaderAccessor {
        InputStream getResourceStream(String str);

        Class loadClass(String str);
    }

    private Classes() {
    }

    public static Class forName(String str) throws UnknownClassException {
        Class loadClass = THREAD_CL_ACCESSOR.loadClass(str);
        if (loadClass == null) {
            loadClass = CLASS_CL_ACCESSOR.loadClass(str);
        }
        if (loadClass == null) {
            loadClass = SYSTEM_CL_ACCESSOR.loadClass(str);
        }
        if (loadClass != null) {
            return loadClass;
        }
        String str2 = "Unable to load class named [" + str + "] from the thread context, current, or system/application ClassLoaders.  All heuristics have been exhausted.  Class could not be found.";
        if (str != null && str.startsWith("com.stormpath.sdk.impl")) {
            str2 = str2 + "  Have you remembered to include the stormpath-sdk-impl .jar in your runtime classpath?";
        }
        throw new UnknownClassException(str2);
    }

    public static InputStream getResourceAsStream(String str) {
        InputStream resourceStream = THREAD_CL_ACCESSOR.getResourceStream(str);
        if (resourceStream == null) {
            resourceStream = CLASS_CL_ACCESSOR.getResourceStream(str);
        }
        return resourceStream == null ? SYSTEM_CL_ACCESSOR.getResourceStream(str) : resourceStream;
    }

    public static boolean isAvailable(String str) {
        try {
            forName(str);
            return true;
        } catch (UnknownClassException unused) {
            return false;
        }
    }

    public static Object newInstance(String str) {
        return newInstance(forName(str));
    }

    public static Object newInstance(String str, Object... objArr) {
        return newInstance(forName(str), objArr);
    }

    public static <T> T newInstance(Class<T> cls) {
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new InstantiationException("Unable to instantiate class [" + cls.getName() + "]", e);
            }
        } else {
            throw new IllegalArgumentException("Class method parameter cannot be null.");
        }
    }

    public static <T> T newInstance(Class<T> cls, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return instantiate(getConstructor(cls, clsArr), objArr);
    }

    public static <T> Constructor<T> getConstructor(Class<T> cls, Class... clsArr) {
        try {
            return cls.getConstructor(clsArr);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> T instantiate(Constructor<T> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            throw new InstantiationException("Unable to instantiate instance with constructor [" + constructor + "]", e);
        }
    }

    private static abstract class ExceptionIgnoringAccessor implements ClassLoaderAccessor {
        /* access modifiers changed from: protected */
        public abstract ClassLoader doGetClassLoader() throws Throwable;

        private ExceptionIgnoringAccessor() {
        }

        public Class loadClass(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                try {
                    return classLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            return null;
        }

        public InputStream getResourceStream(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                return classLoader.getResourceAsStream(str);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public final ClassLoader getClassLoader() {
            try {
                return doGetClassLoader();
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
