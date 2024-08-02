package org.apache.commons.pool2.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.apache.commons.pool2.PooledObjectFactory;

class PoolImplUtils {
    PoolImplUtils() {
    }

    static Class<?> getFactoryType(Class<? extends PooledObjectFactory> factory) {
        return (Class) getGenericType(PooledObjectFactory.class, factory);
    }

    private static <T> Object getGenericType(Class<T> type, Class<? extends T> clazz) {
        for (Type iface : clazz.getGenericInterfaces()) {
            if (iface instanceof ParameterizedType) {
                ParameterizedType pi = (ParameterizedType) iface;
                if ((pi.getRawType() instanceof Class) && type.isAssignableFrom((Class) pi.getRawType())) {
                    return getTypeParameter(clazz, pi.getActualTypeArguments()[0]);
                }
            }
        }
        Object result = getGenericType(type, clazz.getSuperclass());
        if (result instanceof Class) {
            return result;
        }
        if (result instanceof Integer) {
            return getTypeParameter(clazz, ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[((Integer) result).intValue()]);
        }
        return null;
    }

    private static Object getTypeParameter(Class<?> clazz, Type argType) {
        if (argType instanceof Class) {
            return argType;
        }
        TypeVariable<?>[] tvs = clazz.getTypeParameters();
        for (int i = 0; i < tvs.length; i++) {
            if (tvs[i].equals(argType)) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }
}
