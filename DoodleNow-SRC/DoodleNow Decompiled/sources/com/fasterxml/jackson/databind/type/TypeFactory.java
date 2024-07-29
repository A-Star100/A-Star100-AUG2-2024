package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public final class TypeFactory implements Serializable {
    private static final Class<?> CLS_BOOL;
    private static final Class<?> CLS_CLASS;
    private static final Class<?> CLS_COMPARABLE;
    private static final Class<?> CLS_ENUM;
    private static final Class<?> CLS_INT;
    private static final Class<?> CLS_LONG;
    private static final Class<?> CLS_OBJECT;
    private static final Class<?> CLS_STRING;
    protected static final SimpleType CORE_TYPE_BOOL;
    protected static final SimpleType CORE_TYPE_CLASS;
    protected static final SimpleType CORE_TYPE_COMPARABLE;
    protected static final SimpleType CORE_TYPE_ENUM;
    protected static final SimpleType CORE_TYPE_INT;
    protected static final SimpleType CORE_TYPE_LONG;
    protected static final SimpleType CORE_TYPE_OBJECT;
    protected static final SimpleType CORE_TYPE_STRING;
    protected static final TypeBindings EMPTY_BINDINGS = TypeBindings.emptyBindings();
    private static final JavaType[] NO_TYPES = new JavaType[0];
    protected static final TypeFactory instance = new TypeFactory();
    private static final long serialVersionUID = 1;
    protected final ClassLoader _classLoader;
    protected final TypeModifier[] _modifiers;
    protected final TypeParser _parser;
    protected final LRUMap<Object, JavaType> _typeCache;

    public static TypeFactory defaultInstance() {
        return instance;
    }

    /* access modifiers changed from: protected */
    public JavaType _unknownType() {
        return CORE_TYPE_OBJECT;
    }

    public ClassLoader getClassLoader() {
        return this._classLoader;
    }

    static {
        Class<String> cls = String.class;
        CLS_STRING = cls;
        Class<Object> cls2 = Object.class;
        CLS_OBJECT = cls2;
        Class<Comparable> cls3 = Comparable.class;
        CLS_COMPARABLE = cls3;
        Class<Class> cls4 = Class.class;
        CLS_CLASS = cls4;
        Class<Enum> cls5 = Enum.class;
        CLS_ENUM = cls5;
        Class<?> cls6 = Boolean.TYPE;
        CLS_BOOL = cls6;
        Class<?> cls7 = Integer.TYPE;
        CLS_INT = cls7;
        Class<?> cls8 = Long.TYPE;
        CLS_LONG = cls8;
        CORE_TYPE_BOOL = new SimpleType(cls6);
        CORE_TYPE_INT = new SimpleType(cls7);
        CORE_TYPE_LONG = new SimpleType(cls8);
        CORE_TYPE_STRING = new SimpleType((Class<?>) cls);
        CORE_TYPE_OBJECT = new SimpleType((Class<?>) cls2);
        CORE_TYPE_COMPARABLE = new SimpleType((Class<?>) cls3);
        CORE_TYPE_ENUM = new SimpleType((Class<?>) cls5);
        CORE_TYPE_CLASS = new SimpleType((Class<?>) cls4);
    }

    private TypeFactory() {
        this((LRUMap<Object, JavaType>) null);
    }

    protected TypeFactory(LRUMap<Object, JavaType> lRUMap) {
        this._typeCache = lRUMap == null ? new LRUMap<>(16, 200) : lRUMap;
        this._parser = new TypeParser(this);
        this._modifiers = null;
        this._classLoader = null;
    }

    protected TypeFactory(LRUMap<Object, JavaType> lRUMap, TypeParser typeParser, TypeModifier[] typeModifierArr, ClassLoader classLoader) {
        this._typeCache = lRUMap == null ? new LRUMap<>(16, 200) : lRUMap;
        this._parser = typeParser.withFactory(this);
        this._modifiers = typeModifierArr;
        this._classLoader = classLoader;
    }

    public TypeFactory withModifier(TypeModifier typeModifier) {
        TypeModifier[] typeModifierArr;
        LRUMap<Object, JavaType> lRUMap = this._typeCache;
        if (typeModifier == null) {
            lRUMap = null;
            typeModifierArr = null;
        } else {
            TypeModifier[] typeModifierArr2 = this._modifiers;
            if (typeModifierArr2 == null) {
                typeModifierArr = new TypeModifier[]{typeModifier};
            } else {
                typeModifierArr = (TypeModifier[]) ArrayBuilders.insertInListNoDup(typeModifierArr2, typeModifier);
            }
        }
        return new TypeFactory(lRUMap, this._parser, typeModifierArr, this._classLoader);
    }

    public TypeFactory withClassLoader(ClassLoader classLoader) {
        return new TypeFactory(this._typeCache, this._parser, this._modifiers, classLoader);
    }

    public TypeFactory withCache(LRUMap<Object, JavaType> lRUMap) {
        return new TypeFactory(lRUMap, this._parser, this._modifiers, this._classLoader);
    }

    public void clearCache() {
        this._typeCache.clear();
    }

    public static JavaType unknownType() {
        return defaultInstance()._unknownType();
    }

    public static Class<?> rawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        return defaultInstance().constructType(type).getRawClass();
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        Throwable th;
        Class<?> _findPrimitive;
        if (str.indexOf(46) < 0 && (_findPrimitive = _findPrimitive(str)) != null) {
            return _findPrimitive;
        }
        ClassLoader classLoader = getClassLoader();
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        if (classLoader != null) {
            try {
                return classForName(str, true, classLoader);
            } catch (Exception e) {
                th = ClassUtil.getRootCause(e);
            }
        } else {
            th = null;
            try {
                return classForName(str);
            } catch (Exception e2) {
                if (th == null) {
                    th = ClassUtil.getRootCause(e2);
                }
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw new ClassNotFoundException(th.getMessage(), th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> classForName(String str, boolean z, ClassLoader classLoader) throws ClassNotFoundException {
        return Class.forName(str, true, classLoader);
    }

    /* access modifiers changed from: protected */
    public Class<?> classForName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    /* access modifiers changed from: protected */
    public Class<?> _findPrimitive(String str) {
        if ("int".equals(str)) {
            return Integer.TYPE;
        }
        if ("long".equals(str)) {
            return Long.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if ("double".equals(str)) {
            return Double.TYPE;
        }
        if ("boolean".equals(str)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(str)) {
            return Byte.TYPE;
        }
        if ("char".equals(str)) {
            return Character.TYPE;
        }
        if ("short".equals(str)) {
            return Short.TYPE;
        }
        if ("void".equals(str)) {
            return Void.TYPE;
        }
        return null;
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) {
        JavaType javaType2;
        JavaType javaType3;
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == cls) {
            return javaType;
        }
        if (rawClass == Object.class) {
            javaType2 = _fromClass((ClassStack) null, cls, TypeBindings.emptyBindings());
        } else if (!rawClass.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(String.format("Class %s not subtype of %s", new Object[]{cls.getName(), javaType}));
        } else if (javaType.getBindings().isEmpty()) {
            javaType2 = _fromClass((ClassStack) null, cls, TypeBindings.emptyBindings());
        } else {
            if (javaType.isContainerType()) {
                if (javaType.isMapLikeType()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        javaType2 = _fromClass((ClassStack) null, cls, TypeBindings.create(cls, javaType.getKeyType(), javaType.getContentType()));
                    }
                } else if (javaType.isCollectionLikeType()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        javaType2 = _fromClass((ClassStack) null, cls, TypeBindings.create(cls, javaType.getContentType()));
                    } else if (rawClass == EnumSet.class) {
                        return javaType;
                    }
                }
            }
            int length = cls.getTypeParameters().length;
            if (length == 0) {
                javaType2 = _fromClass((ClassStack) null, cls, TypeBindings.emptyBindings());
            } else {
                TypeBindings _bindingsForSubtype = _bindingsForSubtype(javaType, length, cls);
                if (javaType.isInterface()) {
                    javaType3 = javaType.refine(cls, _bindingsForSubtype, (JavaType) null, new JavaType[]{javaType});
                } else {
                    javaType3 = javaType.refine(cls, _bindingsForSubtype, javaType, NO_TYPES);
                }
                javaType2 = javaType3 == null ? _fromClass((ClassStack) null, cls, _bindingsForSubtype) : javaType3;
            }
        }
        return javaType2.withHandlersFrom(javaType);
    }

    private TypeBindings _bindingsForSubtype(JavaType javaType, int i, Class<?> cls) {
        int containedTypeCount = javaType.containedTypeCount();
        if (containedTypeCount != i) {
            return TypeBindings.emptyBindings();
        }
        if (i == 1) {
            return TypeBindings.create(cls, javaType.containedType(0));
        }
        if (i == 2) {
            return TypeBindings.create(cls, javaType.containedType(0), javaType.containedType(1));
        }
        ArrayList arrayList = new ArrayList(containedTypeCount);
        for (int i2 = 0; i2 < containedTypeCount; i2++) {
            arrayList.add(javaType.containedType(i2));
        }
        return TypeBindings.create(cls, (List<JavaType>) arrayList);
    }

    public JavaType constructGeneralizedType(JavaType javaType, Class<?> cls) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == cls) {
            return javaType;
        }
        JavaType findSuperType = javaType.findSuperType(cls);
        if (findSuperType != null) {
            return findSuperType;
        }
        if (!cls.isAssignableFrom(rawClass)) {
            throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", new Object[]{cls.getName(), javaType}));
        }
        throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", new Object[]{cls.getName(), javaType}));
    }

    public JavaType constructFromCanonical(String str) throws IllegalArgumentException {
        return this._parser.parse(str);
    }

    public JavaType[] findTypeParameters(JavaType javaType, Class<?> cls) {
        JavaType findSuperType = javaType.findSuperType(cls);
        if (findSuperType == null) {
            return NO_TYPES;
        }
        return findSuperType.getBindings().typeParameterArray();
    }

    @Deprecated
    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2, TypeBindings typeBindings) {
        return findTypeParameters(constructType((Type) cls, typeBindings), cls2);
    }

    @Deprecated
    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2) {
        return findTypeParameters(constructType((Type) cls), cls2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r0 = r3.getRawClass();
        r1 = r4.getRawClass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JavaType moreSpecificType(com.fasterxml.jackson.databind.JavaType r3, com.fasterxml.jackson.databind.JavaType r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return r4
        L_0x0003:
            if (r4 != 0) goto L_0x0006
            return r3
        L_0x0006:
            java.lang.Class r0 = r3.getRawClass()
            java.lang.Class r1 = r4.getRawClass()
            if (r0 != r1) goto L_0x0011
            return r3
        L_0x0011:
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L_0x0018
            return r4
        L_0x0018:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.type.TypeFactory.moreSpecificType(com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JavaType):com.fasterxml.jackson.databind.JavaType");
    }

    public JavaType constructType(Type type) {
        return _fromAny((ClassStack) null, type, EMPTY_BINDINGS);
    }

    public JavaType constructType(Type type, TypeBindings typeBindings) {
        return _fromAny((ClassStack) null, type, typeBindings);
    }

    public JavaType constructType(TypeReference<?> typeReference) {
        return _fromAny((ClassStack) null, typeReference.getType(), EMPTY_BINDINGS);
    }

    @Deprecated
    public JavaType constructType(Type type, Class<?> cls) {
        return constructType(type, cls == null ? null : constructType((Type) cls));
    }

    @Deprecated
    public JavaType constructType(Type type, JavaType javaType) {
        TypeBindings typeBindings;
        if (javaType == null) {
            typeBindings = TypeBindings.emptyBindings();
        } else {
            TypeBindings bindings = javaType.getBindings();
            if (type.getClass() != Class.class) {
                TypeBindings typeBindings2 = bindings;
                JavaType javaType2 = javaType;
                typeBindings = typeBindings2;
                while (typeBindings.isEmpty() && (javaType2 = javaType2.getSuperClass()) != null) {
                    typeBindings = javaType2.getBindings();
                }
            } else {
                typeBindings = bindings;
            }
        }
        return _fromAny((ClassStack) null, type, typeBindings);
    }

    public ArrayType constructArrayType(Class<?> cls) {
        return ArrayType.construct(_fromAny((ClassStack) null, cls, (TypeBindings) null), (TypeBindings) null);
    }

    public ArrayType constructArrayType(JavaType javaType) {
        return ArrayType.construct(javaType, (TypeBindings) null);
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, Class<?> cls2) {
        return constructCollectionType(cls, _fromClass((ClassStack) null, cls2, EMPTY_BINDINGS));
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, JavaType javaType) {
        return (CollectionType) _fromClass((ClassStack) null, cls, TypeBindings.create((Class<?>) cls, javaType));
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, Class<?> cls2) {
        return constructCollectionLikeType(cls, _fromClass((ClassStack) null, cls2, EMPTY_BINDINGS));
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, JavaType javaType) {
        JavaType _fromClass = _fromClass((ClassStack) null, cls, TypeBindings.createIfNeeded(cls, javaType));
        if (_fromClass instanceof CollectionLikeType) {
            return (CollectionLikeType) _fromClass;
        }
        return CollectionLikeType.upgradeFrom(_fromClass, javaType);
    }

    public MapType constructMapType(Class<? extends Map> cls, Class<?> cls2, Class<?> cls3) {
        JavaType javaType;
        JavaType javaType2;
        if (cls == Properties.class) {
            javaType2 = CORE_TYPE_STRING;
            javaType = javaType2;
        } else {
            TypeBindings typeBindings = EMPTY_BINDINGS;
            javaType2 = _fromClass((ClassStack) null, cls2, typeBindings);
            javaType = _fromClass((ClassStack) null, cls3, typeBindings);
        }
        return constructMapType(cls, javaType2, javaType);
    }

    public MapType constructMapType(Class<? extends Map> cls, JavaType javaType, JavaType javaType2) {
        return (MapType) _fromClass((ClassStack) null, cls, TypeBindings.create(cls, javaType, javaType2));
    }

    public MapLikeType constructMapLikeType(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        TypeBindings typeBindings = EMPTY_BINDINGS;
        return constructMapLikeType(cls, _fromClass((ClassStack) null, cls2, typeBindings), _fromClass((ClassStack) null, cls3, typeBindings));
    }

    public MapLikeType constructMapLikeType(Class<?> cls, JavaType javaType, JavaType javaType2) {
        JavaType _fromClass = _fromClass((ClassStack) null, cls, TypeBindings.createIfNeeded(cls, new JavaType[]{javaType, javaType2}));
        if (_fromClass instanceof MapLikeType) {
            return (MapLikeType) _fromClass;
        }
        return MapLikeType.upgradeFrom(_fromClass, javaType, javaType2);
    }

    public JavaType constructSimpleType(Class<?> cls, JavaType[] javaTypeArr) {
        return _fromClass((ClassStack) null, cls, TypeBindings.create(cls, javaTypeArr));
    }

    @Deprecated
    public JavaType constructSimpleType(Class<?> cls, Class<?> cls2, JavaType[] javaTypeArr) {
        return constructSimpleType(cls, javaTypeArr);
    }

    public JavaType constructReferenceType(Class<?> cls, JavaType javaType) {
        return ReferenceType.construct(cls, (TypeBindings) null, (JavaType) null, (JavaType[]) null, javaType);
    }

    @Deprecated
    public JavaType uncheckedSimpleType(Class<?> cls) {
        return _constructSimple(cls, EMPTY_BINDINGS, (JavaType) null, (JavaType[]) null);
    }

    public JavaType constructParametricType(Class<?> cls, Class<?>... clsArr) {
        int length = clsArr.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i = 0; i < length; i++) {
            javaTypeArr[i] = _fromClass((ClassStack) null, clsArr[i], (TypeBindings) null);
        }
        return constructParametricType(cls, javaTypeArr);
    }

    public JavaType constructParametricType(Class<?> cls, JavaType... javaTypeArr) {
        return _fromClass((ClassStack) null, cls, TypeBindings.create(cls, javaTypeArr));
    }

    public JavaType constructParametrizedType(Class<?> cls, Class<?> cls2, JavaType... javaTypeArr) {
        return constructParametricType(cls, javaTypeArr);
    }

    public JavaType constructParametrizedType(Class<?> cls, Class<?> cls2, Class<?>... clsArr) {
        return constructParametricType(cls, clsArr);
    }

    public CollectionType constructRawCollectionType(Class<? extends Collection> cls) {
        return constructCollectionType(cls, unknownType());
    }

    public CollectionLikeType constructRawCollectionLikeType(Class<?> cls) {
        return constructCollectionLikeType(cls, unknownType());
    }

    public MapType constructRawMapType(Class<? extends Map> cls) {
        return constructMapType(cls, unknownType(), unknownType());
    }

    public MapLikeType constructRawMapLikeType(Class<?> cls) {
        return constructMapLikeType(cls, unknownType(), unknownType());
    }

    private JavaType _mapType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType javaType2;
        JavaType javaType3;
        JavaType _unknownType;
        if (cls == Properties.class) {
            _unknownType = CORE_TYPE_STRING;
        } else {
            List<JavaType> typeParameters = typeBindings.getTypeParameters();
            int size = typeParameters.size();
            if (size == 0) {
                _unknownType = _unknownType();
            } else if (size == 2) {
                javaType2 = typeParameters.get(1);
                javaType3 = typeParameters.get(0);
                return MapType.construct(cls, typeBindings, javaType, javaTypeArr, javaType3, javaType2);
            } else {
                throw new IllegalArgumentException("Strange Map type " + cls.getName() + ": can not determine type parameters");
            }
        }
        javaType3 = _unknownType;
        javaType2 = javaType3;
        return MapType.construct(cls, typeBindings, javaType, javaTypeArr, javaType3, javaType2);
    }

    private JavaType _collectionType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType javaType2;
        List<JavaType> typeParameters = typeBindings.getTypeParameters();
        if (typeParameters.isEmpty()) {
            javaType2 = _unknownType();
        } else if (typeParameters.size() == 1) {
            javaType2 = typeParameters.get(0);
        } else {
            throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": can not determine type parameters");
        }
        return CollectionType.construct(cls, typeBindings, javaType, javaTypeArr, javaType2);
    }

    private JavaType _referenceType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType javaType2;
        List<JavaType> typeParameters = typeBindings.getTypeParameters();
        if (typeParameters.isEmpty()) {
            javaType2 = _unknownType();
        } else if (typeParameters.size() == 1) {
            javaType2 = typeParameters.get(0);
        } else {
            throw new IllegalArgumentException("Strange Reference type " + cls.getName() + ": can not determine type parameters");
        }
        return ReferenceType.construct(cls, typeBindings, javaType, javaTypeArr, javaType2);
    }

    /* access modifiers changed from: protected */
    public JavaType _constructSimple(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        JavaType _findWellKnownSimple;
        if (!typeBindings.isEmpty() || (_findWellKnownSimple = _findWellKnownSimple(cls)) == null) {
            return _newSimpleType(cls, typeBindings, javaType, javaTypeArr);
        }
        return _findWellKnownSimple;
    }

    /* access modifiers changed from: protected */
    public JavaType _newSimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new SimpleType(cls, typeBindings, javaType, javaTypeArr);
    }

    /* access modifiers changed from: protected */
    public JavaType _findWellKnownSimple(Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == CLS_BOOL) {
                return CORE_TYPE_BOOL;
            }
            if (cls == CLS_INT) {
                return CORE_TYPE_INT;
            }
            if (cls == CLS_LONG) {
                return CORE_TYPE_LONG;
            }
            return null;
        } else if (cls == CLS_STRING) {
            return CORE_TYPE_STRING;
        } else {
            if (cls == CLS_OBJECT) {
                return CORE_TYPE_OBJECT;
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public JavaType _fromAny(ClassStack classStack, Type type, TypeBindings typeBindings) {
        JavaType javaType;
        if (type instanceof Class) {
            javaType = _fromClass(classStack, (Class) type, EMPTY_BINDINGS);
        } else if (type instanceof ParameterizedType) {
            javaType = _fromParamType(classStack, (ParameterizedType) type, typeBindings);
        } else if (type instanceof JavaType) {
            return (JavaType) type;
        } else {
            if (type instanceof GenericArrayType) {
                javaType = _fromArrayType(classStack, (GenericArrayType) type, typeBindings);
            } else if (type instanceof TypeVariable) {
                javaType = _fromVariable(classStack, (TypeVariable) type, typeBindings);
            } else if (type instanceof WildcardType) {
                javaType = _fromWildcard(classStack, (WildcardType) type, typeBindings);
            } else {
                StringBuilder sb = new StringBuilder("Unrecognized Type: ");
                sb.append(type == null ? "[null]" : type.toString());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (this._modifiers != null) {
            TypeBindings bindings = javaType.getBindings();
            if (bindings == null) {
                bindings = EMPTY_BINDINGS;
            }
            TypeModifier[] typeModifierArr = this._modifiers;
            int length = typeModifierArr.length;
            int i = 0;
            while (i < length) {
                TypeModifier typeModifier = typeModifierArr[i];
                JavaType modifyType = typeModifier.modifyType(javaType, type, bindings, this);
                if (modifyType != null) {
                    i++;
                    javaType = modifyType;
                } else {
                    throw new IllegalStateException(String.format("TypeModifier %s (of type %s) return null for type %s", new Object[]{typeModifier, typeModifier.getClass().getName(), javaType}));
                }
            }
        }
        return javaType;
    }

    /* access modifiers changed from: protected */
    public JavaType _fromClass(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        ClassStack classStack2;
        JavaType javaType;
        JavaType javaType2;
        JavaType[] javaTypeArr;
        JavaType _findWellKnownSimple = _findWellKnownSimple(cls);
        if (_findWellKnownSimple != null) {
            return _findWellKnownSimple;
        }
        Object asKey = (typeBindings == null || typeBindings.isEmpty()) ? cls : typeBindings.asKey(cls);
        JavaType javaType3 = this._typeCache.get(asKey);
        if (javaType3 != null) {
            return javaType3;
        }
        if (classStack == null) {
            classStack2 = new ClassStack(cls);
        } else {
            ClassStack find = classStack.find(cls);
            if (find != null) {
                ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(cls, EMPTY_BINDINGS);
                find.addSelfReference(resolvedRecursiveType);
                return resolvedRecursiveType;
            }
            classStack2 = classStack.child(cls);
        }
        if (cls.isArray()) {
            javaType = ArrayType.construct(_fromAny(classStack2, cls.getComponentType(), typeBindings), typeBindings);
        } else {
            if (cls.isInterface()) {
                javaTypeArr = _resolveSuperInterfaces(classStack2, cls, typeBindings);
                javaType2 = null;
            } else {
                javaType2 = _resolveSuperClass(classStack2, cls, typeBindings);
                javaTypeArr = _resolveSuperInterfaces(classStack2, cls, typeBindings);
            }
            JavaType[] javaTypeArr2 = javaTypeArr;
            JavaType javaType4 = javaType2;
            if (cls == Properties.class) {
                SimpleType simpleType = CORE_TYPE_STRING;
                javaType3 = MapType.construct(cls, typeBindings, javaType4, javaTypeArr2, simpleType, simpleType);
            } else if (javaType4 != null) {
                javaType3 = javaType4.refine(cls, typeBindings, javaType4, javaTypeArr2);
            }
            javaType = (javaType3 == null && (javaType3 = _fromWellKnownClass(classStack2, cls, typeBindings, javaType4, javaTypeArr2)) == null && (javaType3 = _fromWellKnownInterface(classStack2, cls, typeBindings, javaType4, javaTypeArr2)) == null) ? _newSimpleType(cls, typeBindings, javaType4, javaTypeArr2) : javaType3;
        }
        classStack2.resolveSelfReferences(javaType);
        if (!javaType.hasHandlers()) {
            this._typeCache.putIfAbsent(asKey, javaType);
        }
        return javaType;
    }

    /* access modifiers changed from: protected */
    public JavaType _resolveSuperClass(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        Type genericSuperclass = ClassUtil.getGenericSuperclass(cls);
        if (genericSuperclass == null) {
            return null;
        }
        return _fromAny(classStack, genericSuperclass, typeBindings);
    }

    /* access modifiers changed from: protected */
    public JavaType[] _resolveSuperInterfaces(ClassStack classStack, Class<?> cls, TypeBindings typeBindings) {
        Type[] genericInterfaces = ClassUtil.getGenericInterfaces(cls);
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return NO_TYPES;
        }
        int length = genericInterfaces.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i = 0; i < length; i++) {
            javaTypeArr[i] = _fromAny(classStack, genericInterfaces[i], typeBindings);
        }
        return javaTypeArr;
    }

    /* access modifiers changed from: protected */
    public JavaType _fromWellKnownClass(ClassStack classStack, Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        if (typeBindings == null) {
            typeBindings = TypeBindings.emptyBindings();
        }
        if (cls == Map.class) {
            return _mapType(cls, typeBindings, javaType, javaTypeArr);
        }
        if (cls == Collection.class) {
            return _collectionType(cls, typeBindings, javaType, javaTypeArr);
        }
        if (cls == AtomicReference.class) {
            return _referenceType(cls, typeBindings, javaType, javaTypeArr);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JavaType _fromWellKnownInterface(ClassStack classStack, Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        for (JavaType refine : javaTypeArr) {
            JavaType refine2 = refine.refine(cls, typeBindings, javaType, javaTypeArr);
            if (refine2 != null) {
                return refine2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JavaType _fromParamType(ClassStack classStack, ParameterizedType parameterizedType, TypeBindings typeBindings) {
        int i;
        TypeBindings typeBindings2;
        Class<?> cls = (Class) parameterizedType.getRawType();
        if (cls == CLS_ENUM) {
            return CORE_TYPE_ENUM;
        }
        if (cls == CLS_COMPARABLE) {
            return CORE_TYPE_COMPARABLE;
        }
        if (cls == CLS_CLASS) {
            return CORE_TYPE_CLASS;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments == null) {
            i = 0;
        } else {
            i = actualTypeArguments.length;
        }
        if (i == 0) {
            typeBindings2 = EMPTY_BINDINGS;
        } else {
            JavaType[] javaTypeArr = new JavaType[i];
            for (int i2 = 0; i2 < i; i2++) {
                javaTypeArr[i2] = _fromAny(classStack, actualTypeArguments[i2], typeBindings);
            }
            typeBindings2 = TypeBindings.create(cls, javaTypeArr);
        }
        return _fromClass(classStack, cls, typeBindings2);
    }

    /* access modifiers changed from: protected */
    public JavaType _fromArrayType(ClassStack classStack, GenericArrayType genericArrayType, TypeBindings typeBindings) {
        return ArrayType.construct(_fromAny(classStack, genericArrayType.getGenericComponentType(), typeBindings), typeBindings);
    }

    /* access modifiers changed from: protected */
    public JavaType _fromVariable(ClassStack classStack, TypeVariable<?> typeVariable, TypeBindings typeBindings) {
        String name = typeVariable.getName();
        JavaType findBoundType = typeBindings.findBoundType(name);
        if (findBoundType != null) {
            return findBoundType;
        }
        if (typeBindings.hasUnbound(name)) {
            return CORE_TYPE_OBJECT;
        }
        return _fromAny(classStack, typeVariable.getBounds()[0], typeBindings.withUnboundVariable(name));
    }

    /* access modifiers changed from: protected */
    public JavaType _fromWildcard(ClassStack classStack, WildcardType wildcardType, TypeBindings typeBindings) {
        return _fromAny(classStack, wildcardType.getUpperBounds()[0], typeBindings);
    }
}
