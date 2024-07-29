package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class EnumResolver implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Enum<?> _defaultValue;
    protected final Class<Enum<?>> _enumClass;
    protected final Enum<?>[] _enums;
    protected final HashMap<String, Enum<?>> _enumsById;

    public Enum<?> getDefaultValue() {
        return this._defaultValue;
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }

    public Enum<?>[] getRawEnums() {
        return this._enums;
    }

    protected EnumResolver(Class<Enum<?>> cls, Enum<?>[] enumArr, HashMap<String, Enum<?>> hashMap, Enum<?> enumR) {
        this._enumClass = cls;
        this._enums = enumArr;
        this._enumsById = hashMap;
        this._defaultValue = enumR;
    }

    public static EnumResolver constructFor(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        if (enumArr != null) {
            String[] findEnumValues = annotationIntrospector.findEnumValues(cls, enumArr, new String[enumArr.length]);
            HashMap hashMap = new HashMap();
            int length = enumArr.length;
            for (int i = 0; i < length; i++) {
                String str = findEnumValues[i];
                if (str == null) {
                    str = enumArr[i].name();
                }
                hashMap.put(str, enumArr[i]);
            }
            return new EnumResolver(cls, enumArr, hashMap, annotationIntrospector.findDefaultEnumValue(cls));
        }
        throw new IllegalArgumentException("No enum constants for class " + cls.getName());
    }

    @Deprecated
    public static EnumResolver constructUsingToString(Class<Enum<?>> cls) {
        return constructUsingToString(cls, (AnnotationIntrospector) null);
    }

    public static EnumResolver constructUsingToString(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum<?> enumR;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int length = enumArr.length;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            Enum enumR2 = enumArr[length];
            hashMap.put(enumR2.toString(), enumR2);
        }
        if (annotationIntrospector == null) {
            enumR = null;
        } else {
            enumR = annotationIntrospector.findDefaultEnumValue(cls);
        }
        return new EnumResolver(cls, enumArr, hashMap, enumR);
    }

    @Deprecated
    public static EnumResolver constructUsingMethod(Class<Enum<?>> cls, Method method) {
        return constructUsingMethod(cls, method, (AnnotationIntrospector) null);
    }

    public static EnumResolver constructUsingMethod(Class<Enum<?>> cls, Method method, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int length = enumArr.length;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            Enum enumR = enumArr[length];
            try {
                Object invoke = method.invoke(enumR, new Object[0]);
                if (invoke != null) {
                    hashMap.put(invoke.toString(), enumR);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + enumR + ": " + e.getMessage());
            }
        }
        return new EnumResolver(cls, enumArr, hashMap, annotationIntrospector != null ? annotationIntrospector.findDefaultEnumValue(cls) : null);
    }

    public static EnumResolver constructUnsafe(Class<?> cls, AnnotationIntrospector annotationIntrospector) {
        return constructFor(cls, annotationIntrospector);
    }

    @Deprecated
    public static EnumResolver constructUnsafeUsingToString(Class<?> cls) {
        return constructUnsafeUsingToString(cls, (AnnotationIntrospector) null);
    }

    public static EnumResolver constructUnsafeUsingToString(Class<?> cls, AnnotationIntrospector annotationIntrospector) {
        return constructUsingToString(cls, annotationIntrospector);
    }

    @Deprecated
    public static EnumResolver constructUnsafeUsingMethod(Class<?> cls, Method method) {
        return constructUnsafeUsingMethod(cls, method, (AnnotationIntrospector) null);
    }

    public static EnumResolver constructUnsafeUsingMethod(Class<?> cls, Method method, AnnotationIntrospector annotationIntrospector) {
        return constructUsingMethod(cls, method, annotationIntrospector);
    }

    public CompactStringObjectMap constructLookup() {
        return CompactStringObjectMap.construct(this._enumsById);
    }

    public Enum<?> findEnum(String str) {
        return this._enumsById.get(str);
    }

    public Enum<?> getEnum(int i) {
        if (i < 0) {
            return null;
        }
        Enum<?>[] enumArr = this._enums;
        if (i >= enumArr.length) {
            return null;
        }
        return enumArr[i];
    }

    public List<Enum<?>> getEnums() {
        ArrayList arrayList = new ArrayList(this._enums.length);
        for (Enum<?> add : this._enums) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public Collection<String> getEnumIds() {
        return this._enumsById.keySet();
    }

    public int lastValidIndex() {
        return this._enums.length - 1;
    }
}
