package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class PropertyBuilder {
    private static final Object NO_DEFAULT_MARKER = Boolean.FALSE;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final BeanDescription _beanDesc;
    protected final SerializationConfig _config;
    protected Object _defaultBean;
    protected final JsonInclude.Value _defaultInclusion;
    protected final boolean _useRealPropertyDefaults;

    public PropertyBuilder(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        this._config = serializationConfig;
        this._beanDesc = beanDescription;
        JsonInclude.Value merge = JsonInclude.Value.merge(beanDescription.findPropertyInclusion(JsonInclude.Value.empty()), serializationConfig.getDefaultPropertyInclusion(beanDescription.getBeanClass(), JsonInclude.Value.empty()));
        this._defaultInclusion = JsonInclude.Value.merge(serializationConfig.getDefaultPropertyInclusion(), merge);
        this._useRealPropertyDefaults = merge.getValueInclusion() == JsonInclude.Include.NON_DEFAULT;
        this._annotationIntrospector = serializationConfig.getAnnotationIntrospector();
    }

    public Annotations getClassAnnotations() {
        return this._beanDesc.getClassAnnotations();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.ser.BeanPropertyWriter buildWriter(com.fasterxml.jackson.databind.SerializerProvider r15, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r16, com.fasterxml.jackson.databind.JavaType r17, com.fasterxml.jackson.databind.JsonSerializer<?> r18, com.fasterxml.jackson.databind.jsontype.TypeSerializer r19, com.fasterxml.jackson.databind.jsontype.TypeSerializer r20, com.fasterxml.jackson.databind.introspect.AnnotatedMember r21, boolean r22) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r14 = this;
            r1 = r14
            r2 = r15
            r4 = r16
            r0 = r20
            r13 = r21
            r3 = 0
            r7 = r17
            r5 = r22
            com.fasterxml.jackson.databind.JavaType r5 = r14.findSerializationType(r13, r5, r7)     // Catch:{ JsonMappingException -> 0x0117 }
            if (r0 == 0) goto L_0x003f
            if (r5 != 0) goto L_0x0016
            r5 = r7
        L_0x0016:
            com.fasterxml.jackson.databind.JavaType r6 = r5.getContentType()
            if (r6 != 0) goto L_0x0036
            com.fasterxml.jackson.databind.BeanDescription r6 = r1._beanDesc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "serialization type "
            r8.<init>(r9)
            r8.append(r5)
            java.lang.String r9 = " has no content"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r3]
            r15.reportBadPropertyDefinition(r6, r4, r8, r9)
        L_0x0036:
            com.fasterxml.jackson.databind.JavaType r0 = r5.withContentTypeHandler(r0)
            r0.getContentType()
            r10 = r0
            goto L_0x0040
        L_0x003f:
            r10 = r5
        L_0x0040:
            if (r10 != 0) goto L_0x0044
            r0 = r7
            goto L_0x0045
        L_0x0044:
            r0 = r10
        L_0x0045:
            com.fasterxml.jackson.databind.SerializationConfig r5 = r1._config
            java.lang.Class r6 = r0.getRawClass()
            com.fasterxml.jackson.annotation.JsonInclude$Value r8 = r1._defaultInclusion
            com.fasterxml.jackson.annotation.JsonInclude$Value r5 = r5.getDefaultPropertyInclusion(r6, r8)
            com.fasterxml.jackson.annotation.JsonInclude$Value r6 = r16.findInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Value r5 = r5.withOverrides(r6)
            com.fasterxml.jackson.annotation.JsonInclude$Include r5 = r5.getValueInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Include r6 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS
            if (r5 != r6) goto L_0x0063
            com.fasterxml.jackson.annotation.JsonInclude$Include r5 = com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS
        L_0x0063:
            int[] r6 = com.fasterxml.jackson.databind.ser.PropertyBuilder.AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include
            int r5 = r5.ordinal()
            r5 = r6[r5]
            r6 = 1
            r8 = 0
            if (r5 == r6) goto L_0x00a2
            r9 = 2
            if (r5 == r9) goto L_0x0097
            r9 = 3
            if (r5 == r9) goto L_0x0092
            r9 = 4
            if (r5 == r9) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r3 = r6
        L_0x007a:
            boolean r0 = r0.isContainerType()
            if (r0 == 0) goto L_0x008f
            com.fasterxml.jackson.databind.SerializationConfig r0 = r1._config
            com.fasterxml.jackson.databind.SerializationFeature r5 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS
            boolean r0 = r0.isEnabled(r5)
            if (r0 != 0) goto L_0x008f
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
        L_0x008c:
            r12 = r0
            r11 = r3
            goto L_0x00e5
        L_0x008f:
            r11 = r3
        L_0x0090:
            r12 = r8
            goto L_0x00e5
        L_0x0092:
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
        L_0x0094:
            r12 = r0
            r11 = r6
            goto L_0x00e5
        L_0x0097:
            boolean r0 = r0.isReferenceType()
            if (r0 == 0) goto L_0x00a0
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
            goto L_0x0094
        L_0x00a0:
            r11 = r6
            goto L_0x0090
        L_0x00a2:
            boolean r5 = r1._useRealPropertyDefaults
            if (r5 == 0) goto L_0x00ce
            java.lang.Object r5 = r14.getDefaultBean()
            if (r5 == 0) goto L_0x00ce
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r0 = r15.isEnabled((com.fasterxml.jackson.databind.MapperFeature) r0)
            if (r0 == 0) goto L_0x00bf
            com.fasterxml.jackson.databind.SerializationConfig r0 = r1._config
            com.fasterxml.jackson.databind.MapperFeature r9 = com.fasterxml.jackson.databind.MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r0 = r0.isEnabled(r9)
            r13.fixAccess(r0)
        L_0x00bf:
            java.lang.Object r8 = r13.getValue(r5)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00d3
        L_0x00c4:
            r0 = move-exception
            r9 = r0
            java.lang.String r0 = r16.getName()
            r14._throwWrapped(r9, r0, r5)
            goto L_0x00d3
        L_0x00ce:
            java.lang.Object r8 = r14.getDefaultValue(r0)
            r3 = r6
        L_0x00d3:
            if (r8 != 0) goto L_0x00d6
            goto L_0x00a0
        L_0x00d6:
            java.lang.Class r0 = r8.getClass()
            boolean r0 = r0.isArray()
            if (r0 == 0) goto L_0x008f
            java.lang.Object r0 = com.fasterxml.jackson.databind.util.ArrayBuilders.getArrayComparator(r8)
            goto L_0x008c
        L_0x00e5:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r0 = new com.fasterxml.jackson.databind.ser.BeanPropertyWriter
            com.fasterxml.jackson.databind.BeanDescription r3 = r1._beanDesc
            com.fasterxml.jackson.databind.util.Annotations r6 = r3.getClassAnnotations()
            r3 = r0
            r4 = r16
            r5 = r21
            r7 = r17
            r8 = r18
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.fasterxml.jackson.databind.AnnotationIntrospector r3 = r1._annotationIntrospector
            java.lang.Object r3 = r3.findNullSerializer(r13)
            if (r3 == 0) goto L_0x010a
            com.fasterxml.jackson.databind.JsonSerializer r2 = r15.serializerInstance(r13, r3)
            r0.assignNullSerializer(r2)
        L_0x010a:
            com.fasterxml.jackson.databind.AnnotationIntrospector r2 = r1._annotationIntrospector
            com.fasterxml.jackson.databind.util.NameTransformer r2 = r2.findUnwrappingNameTransformer(r13)
            if (r2 == 0) goto L_0x0116
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r0 = r0.unwrappingWriter(r2)
        L_0x0116:
            return r0
        L_0x0117:
            r0 = move-exception
            r5 = r0
            com.fasterxml.jackson.databind.BeanDescription r0 = r1._beanDesc
            java.lang.String r5 = r5.getMessage()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Object r0 = r15.reportBadPropertyDefinition(r0, r4, r5, r3)
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r0 = (com.fasterxml.jackson.databind.ser.BeanPropertyWriter) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.PropertyBuilder.buildWriter(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.introspect.AnnotatedMember, boolean):com.fasterxml.jackson.databind.ser.BeanPropertyWriter");
    }

    /* renamed from: com.fasterxml.jackson.databind.ser.PropertyBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.annotation.JsonInclude$Include[] r0 = com.fasterxml.jackson.annotation.JsonInclude.Include.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include = r0
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.JsonInclude$Include r1 = com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.PropertyBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public JavaType findSerializationType(Annotated annotated, boolean z, JavaType javaType) throws JsonMappingException {
        JavaType refineSerializationType = this._annotationIntrospector.refineSerializationType(this._config, annotated, javaType);
        if (refineSerializationType != javaType) {
            Class<?> rawClass = refineSerializationType.getRawClass();
            Class<?> rawClass2 = javaType.getRawClass();
            if (!rawClass.isAssignableFrom(rawClass2) && !rawClass2.isAssignableFrom(rawClass)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + annotated.getName() + "': class " + rawClass.getName() + " not a super-type of (declared) class " + rawClass2.getName());
            }
            z = true;
            javaType = refineSerializationType;
        }
        JsonSerialize.Typing findSerializationTyping = this._annotationIntrospector.findSerializationTyping(annotated);
        if (findSerializationTyping == null || findSerializationTyping == JsonSerialize.Typing.DEFAULT_TYPING) {
            if (!z) {
                return null;
            }
        } else if (findSerializationTyping != JsonSerialize.Typing.STATIC) {
            return null;
        }
        return javaType.withStaticTyping();
    }

    /* access modifiers changed from: protected */
    public Object getDefaultBean() {
        Object obj = this._defaultBean;
        if (obj == null) {
            obj = this._beanDesc.instantiateBean(this._config.canOverrideAccessModifiers());
            if (obj == null) {
                obj = NO_DEFAULT_MARKER;
            }
            this._defaultBean = obj;
        }
        if (obj == NO_DEFAULT_MARKER) {
            return null;
        }
        return this._defaultBean;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Object getPropertyDefaultValue(String str, AnnotatedMember annotatedMember, JavaType javaType) {
        Object defaultBean = getDefaultBean();
        if (defaultBean == null) {
            return getDefaultValue(javaType);
        }
        try {
            return annotatedMember.getValue(defaultBean);
        } catch (Exception e) {
            return _throwWrapped(e, str, defaultBean);
        }
    }

    /* access modifiers changed from: protected */
    public Object getDefaultValue(JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        Class<?> primitiveType = ClassUtil.primitiveType(rawClass);
        if (primitiveType != null) {
            return ClassUtil.defaultValue(primitiveType);
        }
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return JsonInclude.Include.NON_EMPTY;
        }
        if (rawClass == String.class) {
            return "";
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object _throwWrapped(Exception exc, String str, Object obj) {
        Throwable th;
        while (true) {
            Throwable cause = th.getCause();
            th = exc;
            if (cause == null) {
                break;
            }
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
        }
    }
}
