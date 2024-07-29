package com.fasterxml.jackson.databind.deser.impl;

import com.facebook.hermes.intl.Constants;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CreatorCollector {
    protected static final int C_ARRAY_DELEGATE = 8;
    protected static final int C_BOOLEAN = 5;
    protected static final int C_DEFAULT = 0;
    protected static final int C_DELEGATE = 6;
    protected static final int C_DOUBLE = 4;
    protected static final int C_INT = 2;
    protected static final int C_LONG = 3;
    protected static final int C_PROPS = 7;
    protected static final int C_STRING = 1;
    protected static final String[] TYPE_DESCS = {Constants.COLLATION_DEFAULT, "from-String", "from-int", "from-long", "from-double", "from-boolean", "delegate", "property-based"};
    protected SettableBeanProperty[] _arrayDelegateArgs;
    protected final BeanDescription _beanDesc;
    protected final boolean _canFixAccess;
    protected final AnnotatedWithParams[] _creators = new AnnotatedWithParams[9];
    protected SettableBeanProperty[] _delegateArgs;
    protected int _explicitCreators = 0;
    protected final boolean _forceAccess;
    protected boolean _hasNonDefaultCreator = false;
    protected AnnotatedParameter _incompleteParameter;
    protected SettableBeanProperty[] _propertyBasedArgs;

    public void addIncompeteParameter(AnnotatedParameter annotatedParameter) {
        if (this._incompleteParameter == null) {
            this._incompleteParameter = annotatedParameter;
        }
    }

    public CreatorCollector(BeanDescription beanDescription, MapperConfig<?> mapperConfig) {
        this._beanDesc = beanDescription;
        this._canFixAccess = mapperConfig.canOverrideAccessModifiers();
        this._forceAccess = mapperConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    }

    public ValueInstantiator constructValueInstantiator(DeserializationConfig deserializationConfig) {
        JavaType _computeDelegateType = _computeDelegateType(this._creators[6], this._delegateArgs);
        JavaType _computeDelegateType2 = _computeDelegateType(this._creators[8], this._arrayDelegateArgs);
        JavaType type = this._beanDesc.getType();
        AnnotatedWithParams tryToOptimize = StdTypeConstructor.tryToOptimize(this._creators[0]);
        StdValueInstantiator stdValueInstantiator = new StdValueInstantiator(deserializationConfig, type);
        AnnotatedWithParams[] annotatedWithParamsArr = this._creators;
        stdValueInstantiator.configureFromObjectSettings(tryToOptimize, annotatedWithParamsArr[6], _computeDelegateType, this._delegateArgs, annotatedWithParamsArr[7], this._propertyBasedArgs);
        stdValueInstantiator.configureFromArraySettings(this._creators[8], _computeDelegateType2, this._arrayDelegateArgs);
        stdValueInstantiator.configureFromStringCreator(this._creators[1]);
        stdValueInstantiator.configureFromIntCreator(this._creators[2]);
        stdValueInstantiator.configureFromLongCreator(this._creators[3]);
        stdValueInstantiator.configureFromDoubleCreator(this._creators[4]);
        stdValueInstantiator.configureFromBooleanCreator(this._creators[5]);
        stdValueInstantiator.configureIncompleteParameter(this._incompleteParameter);
        return stdValueInstantiator;
    }

    public void setDefaultCreator(AnnotatedWithParams annotatedWithParams) {
        this._creators[0] = (AnnotatedWithParams) _fixAccess(annotatedWithParams);
    }

    public void addStringCreator(AnnotatedWithParams annotatedWithParams, boolean z) {
        verifyNonDup(annotatedWithParams, 1, z);
    }

    public void addIntCreator(AnnotatedWithParams annotatedWithParams, boolean z) {
        verifyNonDup(annotatedWithParams, 2, z);
    }

    public void addLongCreator(AnnotatedWithParams annotatedWithParams, boolean z) {
        verifyNonDup(annotatedWithParams, 3, z);
    }

    public void addDoubleCreator(AnnotatedWithParams annotatedWithParams, boolean z) {
        verifyNonDup(annotatedWithParams, 4, z);
    }

    public void addBooleanCreator(AnnotatedWithParams annotatedWithParams, boolean z) {
        verifyNonDup(annotatedWithParams, 5, z);
    }

    public void addDelegatingCreator(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr) {
        if (annotatedWithParams.getParameterType(0).isCollectionLikeType()) {
            if (verifyNonDup(annotatedWithParams, 8, z)) {
                this._arrayDelegateArgs = settableBeanPropertyArr;
            }
        } else if (verifyNonDup(annotatedWithParams, 6, z)) {
            this._delegateArgs = settableBeanPropertyArr;
        }
    }

    public void addPropertyCreator(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr) {
        Integer num;
        if (verifyNonDup(annotatedWithParams, 7, z)) {
            if (settableBeanPropertyArr.length > 1) {
                HashMap hashMap = new HashMap();
                int length = settableBeanPropertyArr.length;
                for (int i = 0; i < length; i++) {
                    String name = settableBeanPropertyArr[i].getName();
                    if ((name.length() != 0 || settableBeanPropertyArr[i].getInjectableValueId() == null) && (num = (Integer) hashMap.put(name, Integer.valueOf(i))) != null) {
                        throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d)", new Object[]{name, num, Integer.valueOf(i)}));
                    }
                }
            }
            this._propertyBasedArgs = settableBeanPropertyArr;
        }
    }

    @Deprecated
    public void addStringCreator(AnnotatedWithParams annotatedWithParams) {
        addStringCreator(annotatedWithParams, false);
    }

    @Deprecated
    public void addIntCreator(AnnotatedWithParams annotatedWithParams) {
        addBooleanCreator(annotatedWithParams, false);
    }

    @Deprecated
    public void addLongCreator(AnnotatedWithParams annotatedWithParams) {
        addBooleanCreator(annotatedWithParams, false);
    }

    @Deprecated
    public void addDoubleCreator(AnnotatedWithParams annotatedWithParams) {
        addBooleanCreator(annotatedWithParams, false);
    }

    @Deprecated
    public void addBooleanCreator(AnnotatedWithParams annotatedWithParams) {
        addBooleanCreator(annotatedWithParams, false);
    }

    @Deprecated
    public void addDelegatingCreator(AnnotatedWithParams annotatedWithParams, CreatorProperty[] creatorPropertyArr) {
        addDelegatingCreator(annotatedWithParams, false, creatorPropertyArr);
    }

    @Deprecated
    public void addPropertyCreator(AnnotatedWithParams annotatedWithParams, CreatorProperty[] creatorPropertyArr) {
        addPropertyCreator(annotatedWithParams, false, creatorPropertyArr);
    }

    public boolean hasDefaultCreator() {
        return this._creators[0] != null;
    }

    public boolean hasDelegatingCreator() {
        return this._creators[6] != null;
    }

    public boolean hasPropertyBasedCreator() {
        return this._creators[7] != null;
    }

    private JavaType _computeDelegateType(AnnotatedWithParams annotatedWithParams, SettableBeanProperty[] settableBeanPropertyArr) {
        if (!this._hasNonDefaultCreator || annotatedWithParams == null) {
            return null;
        }
        int i = 0;
        if (settableBeanPropertyArr != null) {
            int length = settableBeanPropertyArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (settableBeanPropertyArr[i2] == null) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return annotatedWithParams.getParameterType(i);
    }

    private <T extends AnnotatedMember> T _fixAccess(T t) {
        if (t != null && this._canFixAccess) {
            ClassUtil.checkAndFixAccess((Member) t.getAnnotated(), this._forceAccess);
        }
        return t;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        if ((!r9) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean verifyNonDup(com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r7, int r8, boolean r9) {
        /*
            r6 = this;
            r0 = 1
            int r1 = r0 << r8
            r6._hasNonDefaultCreator = r0
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams[] r2 = r6._creators
            r2 = r2[r8]
            if (r2 == 0) goto L_0x0065
            int r3 = r6._explicitCreators
            r3 = r3 & r1
            r4 = 0
            if (r3 == 0) goto L_0x0014
            if (r9 != 0) goto L_0x0018
            return r4
        L_0x0014:
            r3 = r9 ^ 1
            if (r3 == 0) goto L_0x0065
        L_0x0018:
            java.lang.Class r3 = r2.getClass()
            java.lang.Class r5 = r7.getClass()
            if (r3 != r5) goto L_0x0065
            java.lang.Class r3 = r2.getRawParameterType(r4)
            java.lang.Class r5 = r7.getRawParameterType(r4)
            if (r3 != r5) goto L_0x005e
            boolean r3 = r6._isEnumValueOf(r7)
            if (r3 == 0) goto L_0x0033
            return r4
        L_0x0033:
            boolean r3 = r6._isEnumValueOf(r2)
            if (r3 == 0) goto L_0x003a
            goto L_0x0065
        L_0x003a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String[] r5 = TYPE_DESCS
            r8 = r5[r8]
            r3[r4] = r8
            if (r9 == 0) goto L_0x004a
            java.lang.String r8 = "explicitly marked"
            goto L_0x004c
        L_0x004a:
            java.lang.String r8 = "implicitly discovered"
        L_0x004c:
            r3[r0] = r8
            r8 = 2
            r3[r8] = r2
            r8 = 3
            r3[r8] = r7
            java.lang.String r7 = "Conflicting %s creators: already had %s creator %s, encountered another: %s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            r1.<init>(r7)
            throw r1
        L_0x005e:
            boolean r2 = r5.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0065
            return r4
        L_0x0065:
            if (r9 == 0) goto L_0x006c
            int r9 = r6._explicitCreators
            r9 = r9 | r1
            r6._explicitCreators = r9
        L_0x006c:
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams[] r9 = r6._creators
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r7 = r6._fixAccess(r7)
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r7 = (com.fasterxml.jackson.databind.introspect.AnnotatedWithParams) r7
            r9[r8] = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.impl.CreatorCollector.verifyNonDup(com.fasterxml.jackson.databind.introspect.AnnotatedWithParams, int, boolean):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean _isEnumValueOf(AnnotatedWithParams annotatedWithParams) {
        return annotatedWithParams.getDeclaringClass().isEnum() && "valueOf".equals(annotatedWithParams.getName());
    }

    protected static final class StdTypeConstructor extends AnnotatedWithParams implements Serializable {
        public static final int TYPE_ARRAY_LIST = 1;
        public static final int TYPE_HASH_MAP = 2;
        public static final int TYPE_LINKED_HASH_MAP = 3;
        private static final long serialVersionUID = 1;
        private final AnnotatedWithParams _base;
        private final int _type;

        public boolean equals(Object obj) {
            return obj == this;
        }

        public StdTypeConstructor(AnnotatedWithParams annotatedWithParams, int i) {
            super(annotatedWithParams, (AnnotationMap[]) null);
            this._base = annotatedWithParams;
            this._type = i;
        }

        public static AnnotatedWithParams tryToOptimize(AnnotatedWithParams annotatedWithParams) {
            if (annotatedWithParams != null) {
                Class<?> declaringClass = annotatedWithParams.getDeclaringClass();
                if (declaringClass == List.class || declaringClass == ArrayList.class) {
                    return new StdTypeConstructor(annotatedWithParams, 1);
                }
                if (declaringClass == LinkedHashMap.class) {
                    return new StdTypeConstructor(annotatedWithParams, 3);
                }
                if (declaringClass == HashMap.class) {
                    return new StdTypeConstructor(annotatedWithParams, 2);
                }
            }
            return annotatedWithParams;
        }

        /* access modifiers changed from: protected */
        public final Object _construct() {
            int i = this._type;
            if (i == 1) {
                return new ArrayList();
            }
            if (i == 2) {
                return new HashMap();
            }
            if (i == 3) {
                return new LinkedHashMap();
            }
            throw new IllegalStateException("Unknown type " + this._type);
        }

        public int getParameterCount() {
            return this._base.getParameterCount();
        }

        public Class<?> getRawParameterType(int i) {
            return this._base.getRawParameterType(i);
        }

        public JavaType getParameterType(int i) {
            return this._base.getParameterType(i);
        }

        @Deprecated
        public Type getGenericParameterType(int i) {
            return this._base.getGenericParameterType(i);
        }

        public Object call() throws Exception {
            return _construct();
        }

        public Object call(Object[] objArr) throws Exception {
            return _construct();
        }

        public Object call1(Object obj) throws Exception {
            return _construct();
        }

        public Class<?> getDeclaringClass() {
            return this._base.getDeclaringClass();
        }

        public Member getMember() {
            return this._base.getMember();
        }

        public void setValue(Object obj, Object obj2) throws UnsupportedOperationException, IllegalArgumentException {
            throw new UnsupportedOperationException();
        }

        public Object getValue(Object obj) throws UnsupportedOperationException, IllegalArgumentException {
            throw new UnsupportedOperationException();
        }

        public Annotated withAnnotations(AnnotationMap annotationMap) {
            throw new UnsupportedOperationException();
        }

        public AnnotatedElement getAnnotated() {
            return this._base.getAnnotated();
        }

        /* access modifiers changed from: protected */
        public int getModifiers() {
            return this._base.getMember().getModifiers();
        }

        public String getName() {
            return this._base.getName();
        }

        public JavaType getType() {
            return this._base.getType();
        }

        public Class<?> getRawType() {
            return this._base.getRawType();
        }

        public int hashCode() {
            return this._base.hashCode();
        }

        public String toString() {
            return this._base.toString();
        }
    }
}
