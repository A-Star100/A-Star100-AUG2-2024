package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    private static final long serialVersionUID = 1;
    protected PropertySerializerMap _dynamicValueSerializers;
    protected final Object _filterId;
    protected final Set<String> _ignoredEntries;
    protected JsonSerializer<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _sortKeys;
    protected final Object _suppressableValue;
    protected JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final TypeSerializer _valueTypeSerializer;

    public JsonSerializer<?> getContentSerializer() {
        return this._valueSerializer;
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public JsonSerializer<?> getKeySerializer() {
        return this._keySerializer;
    }

    protected MapSerializer(Set<String> set, JavaType javaType, JavaType javaType2, boolean z, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        this._ignoredEntries = (set == null || set.isEmpty()) ? null : set;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
    }

    /* access modifiers changed from: protected */
    public void _ensureOverride() {
        if (getClass() != MapSerializer.class) {
            throw new IllegalStateException("Missing override in class " + getClass().getName());
        }
    }

    protected MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set) {
        super(Map.class, false);
        this._ignoredEntries = (set == null || set.isEmpty()) ? null : set;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = beanProperty;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    @Deprecated
    protected MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer) {
        this(mapSerializer, typeSerializer, mapSerializer._suppressableValue);
    }

    protected MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer, Object obj) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        JavaType javaType = mapSerializer._valueType;
        this._valueType = javaType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        if (obj == JsonInclude.Include.NON_ABSENT) {
            obj = javaType.isReferenceType() ? JsonInclude.Include.NON_EMPTY : JsonInclude.Include.NON_NULL;
        }
        this._suppressableValue = obj;
    }

    protected MapSerializer(MapSerializer mapSerializer, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = obj;
        this._sortKeys = z;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    public MapSerializer _withValueTypeSerializer(TypeSerializer typeSerializer) {
        if (this._valueTypeSerializer == typeSerializer) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, typeSerializer, (Object) null);
    }

    public MapSerializer withResolved(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set, boolean z) {
        _ensureOverride();
        MapSerializer mapSerializer = new MapSerializer(this, beanProperty, jsonSerializer, jsonSerializer2, set);
        return z != mapSerializer._sortKeys ? new MapSerializer(mapSerializer, this._filterId, z) : mapSerializer;
    }

    public MapSerializer withFilterId(Object obj) {
        if (this._filterId == obj) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, obj, this._sortKeys);
    }

    public MapSerializer withContentInclusion(Object obj) {
        if (obj == this._suppressableValue) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, this._valueTypeSerializer, obj);
    }

    @Deprecated
    public static MapSerializer construct(String[] strArr, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2, Object obj) {
        return construct((Set<String>) (strArr == null || strArr.length == 0) ? null : ArrayBuilders.arrayToSet(strArr), javaType, z, typeSerializer, jsonSerializer, jsonSerializer2, obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.databind.ser.std.MapSerializer construct(java.util.Set<java.lang.String> r9, com.fasterxml.jackson.databind.JavaType r10, boolean r11, com.fasterxml.jackson.databind.jsontype.TypeSerializer r12, com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r13, com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r14, java.lang.Object r15) {
        /*
            if (r10 != 0) goto L_0x0007
            com.fasterxml.jackson.databind.JavaType r10 = UNSPECIFIED_TYPE
            r3 = r10
            r4 = r3
            goto L_0x0011
        L_0x0007:
            com.fasterxml.jackson.databind.JavaType r0 = r10.getKeyType()
            com.fasterxml.jackson.databind.JavaType r10 = r10.getContentType()
            r4 = r10
            r3 = r0
        L_0x0011:
            r10 = 0
            if (r11 != 0) goto L_0x001f
            if (r4 == 0) goto L_0x001d
            boolean r11 = r4.isFinal()
            if (r11 == 0) goto L_0x001d
            r10 = 1
        L_0x001d:
            r11 = r10
            goto L_0x0029
        L_0x001f:
            java.lang.Class r0 = r4.getRawClass()
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            if (r0 != r1) goto L_0x0029
            r5 = r10
            goto L_0x002a
        L_0x0029:
            r5 = r11
        L_0x002a:
            com.fasterxml.jackson.databind.ser.std.MapSerializer r10 = new com.fasterxml.jackson.databind.ser.std.MapSerializer
            r1 = r10
            r2 = r9
            r6 = r12
            r7 = r13
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            if (r15 == 0) goto L_0x003a
            com.fasterxml.jackson.databind.ser.std.MapSerializer r10 = r10.withFilterId((java.lang.Object) r15)
        L_0x003a:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.construct(java.util.Set, com.fasterxml.jackson.databind.JavaType, boolean, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.JsonSerializer, java.lang.Object):com.fasterxml.jackson.databind.ser.std.MapSerializer");
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        AnnotatedMember annotatedMember;
        JsonSerializer jsonSerializer;
        JsonSerializer jsonSerializer2;
        AnnotatedMember member;
        Object findFilterId;
        Boolean feature;
        Set<String> findIgnoredForSerialization;
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        JsonSerializer jsonSerializer3 = null;
        if (beanProperty == null) {
            annotatedMember = null;
        } else {
            annotatedMember = beanProperty.getMember();
        }
        Object obj = this._suppressableValue;
        if (annotatedMember == null || annotationIntrospector == null) {
            jsonSerializer = null;
        } else {
            Object findKeySerializer = annotationIntrospector.findKeySerializer(annotatedMember);
            jsonSerializer = findKeySerializer != null ? serializerProvider.serializerInstance(annotatedMember, findKeySerializer) : null;
            Object findContentSerializer = annotationIntrospector.findContentSerializer(annotatedMember);
            if (findContentSerializer != null) {
                jsonSerializer3 = serializerProvider.serializerInstance(annotatedMember, findContentSerializer);
            }
        }
        JsonInclude.Include contentInclusion = findIncludeOverrides(serializerProvider, beanProperty, Map.class).getContentInclusion();
        if (!(contentInclusion == null || contentInclusion == JsonInclude.Include.USE_DEFAULTS)) {
            obj = contentInclusion;
        }
        if (jsonSerializer3 == null) {
            jsonSerializer3 = this._valueSerializer;
        }
        JsonSerializer findConvertingContentSerializer = findConvertingContentSerializer(serializerProvider, beanProperty, jsonSerializer3);
        if (findConvertingContentSerializer != null) {
            findConvertingContentSerializer = serializerProvider.handleSecondaryContextualization(findConvertingContentSerializer, beanProperty);
        } else if (this._valueTypeIsStatic && !this._valueType.isJavaLangObject()) {
            findConvertingContentSerializer = serializerProvider.findValueSerializer(this._valueType, beanProperty);
        }
        JsonSerializer jsonSerializer4 = findConvertingContentSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = this._keySerializer;
        }
        if (jsonSerializer == null) {
            jsonSerializer2 = serializerProvider.findKeySerializer(this._keyType, beanProperty);
        } else {
            jsonSerializer2 = serializerProvider.handleSecondaryContextualization(jsonSerializer, beanProperty);
        }
        JsonSerializer jsonSerializer5 = jsonSerializer2;
        Set<String> set = this._ignoredEntries;
        boolean z = false;
        if (!(annotationIntrospector == null || annotatedMember == null)) {
            JsonIgnoreProperties.Value findPropertyIgnorals = annotationIntrospector.findPropertyIgnorals(annotatedMember);
            if (!(findPropertyIgnorals == null || (findIgnoredForSerialization = findPropertyIgnorals.findIgnoredForSerialization()) == null || findIgnoredForSerialization.isEmpty())) {
                set = set == null ? new HashSet<>() : new HashSet<>(set);
                for (String add : findIgnoredForSerialization) {
                    set.add(add);
                }
            }
            Boolean findSerializationSortAlphabetically = annotationIntrospector.findSerializationSortAlphabetically(annotatedMember);
            if (findSerializationSortAlphabetically != null && findSerializationSortAlphabetically.booleanValue()) {
                z = true;
            }
        }
        Set<String> set2 = set;
        JsonFormat.Value findFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, Map.class);
        MapSerializer withResolved = withResolved(beanProperty, jsonSerializer5, jsonSerializer4, set2, (findFormatOverrides == null || (feature = findFormatOverrides.getFeature(JsonFormat.Feature.WRITE_SORTED_MAP_ENTRIES)) == null) ? z : feature.booleanValue());
        if (obj != this._suppressableValue) {
            withResolved = withResolved.withContentInclusion(obj);
        }
        return (beanProperty == null || (member = beanProperty.getMember()) == null || (findFilterId = annotationIntrospector.findFilterId(member)) == null) ? withResolved : withResolved.withFilterId(findFilterId);
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Object obj = this._suppressableValue;
        if (obj == null || obj == JsonInclude.Include.ALWAYS) {
            return false;
        }
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer != null) {
            for (Object next : map.values()) {
                if (next != null && !jsonSerializer.isEmpty(serializerProvider, next)) {
                    return false;
                }
            }
            return true;
        }
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Object next2 : map.values()) {
            if (next2 != null) {
                Class<?> cls = next2.getClass();
                JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                if (serializerFor == null) {
                    try {
                        serializerFor = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                        propertySerializerMap = this._dynamicValueSerializers;
                    } catch (JsonMappingException unused) {
                        return false;
                    }
                }
                if (!serializerFor.isEmpty(serializerProvider, next2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasSingleElement(Map<?, ?> map) {
        return map.size() == 1;
    }

    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        PropertyFilter findPropertyFilter;
        jsonGenerator.writeStartObject(map);
        if (!map.isEmpty()) {
            Object obj = this._suppressableValue;
            if (obj == JsonInclude.Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = JsonInclude.Include.NON_NULL;
            }
            Object obj2 = obj;
            if (this._sortKeys || serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = _orderEntries(map, jsonGenerator, serializerProvider, obj2);
            }
            Map<?, ?> map2 = map;
            Object obj3 = this._filterId;
            if (obj3 != null && (findPropertyFilter = findPropertyFilter(serializerProvider, obj3, map2)) != null) {
                serializeFilteredFields(map2, jsonGenerator, serializerProvider, findPropertyFilter, obj2);
            } else if (obj2 != null) {
                serializeOptionalFields(map2, jsonGenerator, serializerProvider, obj2);
            } else {
                JsonSerializer<Object> jsonSerializer = this._valueSerializer;
                if (jsonSerializer != null) {
                    serializeFieldsUsing(map2, jsonGenerator, serializerProvider, jsonSerializer);
                } else {
                    serializeFields(map2, jsonGenerator, serializerProvider);
                }
            }
        }
        jsonGenerator.writeEndObject();
    }

    public void serializeWithType(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        PropertyFilter findPropertyFilter;
        typeSerializer.writeTypePrefixForObject(map, jsonGenerator);
        jsonGenerator.setCurrentValue(map);
        if (!map.isEmpty()) {
            Object obj = this._suppressableValue;
            if (obj == JsonInclude.Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = JsonInclude.Include.NON_NULL;
            }
            Object obj2 = obj;
            if (this._sortKeys || serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = _orderEntries(map, jsonGenerator, serializerProvider, obj2);
            }
            Object obj3 = this._filterId;
            if (obj3 != null && (findPropertyFilter = findPropertyFilter(serializerProvider, obj3, map)) != null) {
                serializeFilteredFields(map, jsonGenerator, serializerProvider, findPropertyFilter, obj2);
            } else if (obj2 != null) {
                serializeOptionalFields(map, jsonGenerator, serializerProvider, obj2);
            } else {
                JsonSerializer<Object> jsonSerializer = this._valueSerializer;
                if (jsonSerializer != null) {
                    serializeFieldsUsing(map, jsonGenerator, serializerProvider, jsonSerializer);
                } else {
                    serializeFields(map, jsonGenerator, serializerProvider);
                }
            }
        }
        typeSerializer.writeTypeSuffixForObject(map, jsonGenerator);
    }

    public void serializeFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, (Object) null);
            return;
        }
        JsonSerializer<Object> jsonSerializer2 = this._keySerializer;
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            Object key = next.getKey();
            if (key == null) {
                serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
            } else if (set == null || !set.contains(key)) {
                jsonSerializer2.serialize(key, jsonGenerator, serializerProvider);
            }
            if (value == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            } else {
                JsonSerializer<Object> jsonSerializer3 = this._valueSerializer;
                if (jsonSerializer3 == null) {
                    Class<?> cls = value.getClass();
                    JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                    if (serializerFor == null) {
                        if (this._valueType.hasGenericTypes()) {
                            jsonSerializer = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                        } else {
                            jsonSerializer = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                        }
                        jsonSerializer3 = jsonSerializer;
                        propertySerializerMap = this._dynamicValueSerializers;
                    } else {
                        jsonSerializer3 = serializerFor;
                    }
                }
                try {
                    jsonSerializer3.serialize(value, jsonGenerator, serializerProvider);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, "" + key);
                }
            }
        }
    }

    public void serializeOptionalFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializer2;
        JsonSerializer<Object> jsonSerializer3;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, obj);
            return;
        }
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else if (set == null || !set.contains(key)) {
                jsonSerializer = this._keySerializer;
            }
            Object value = next.getValue();
            if (value != null) {
                jsonSerializer2 = this._valueSerializer;
                if (jsonSerializer2 == null) {
                    Class<?> cls = value.getClass();
                    JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                    if (serializerFor == null) {
                        if (this._valueType.hasGenericTypes()) {
                            jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                        } else {
                            jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                        }
                        jsonSerializer2 = jsonSerializer3;
                        propertySerializerMap = this._dynamicValueSerializers;
                    } else {
                        jsonSerializer2 = serializerFor;
                    }
                }
                if (obj == JsonInclude.Include.NON_EMPTY && jsonSerializer2.isEmpty(serializerProvider, value)) {
                }
            } else if (obj == null) {
                jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
            }
            try {
                jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
                jsonSerializer2.serialize(value, jsonGenerator, serializerProvider);
            } catch (Exception e) {
                wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, "" + key);
            }
        }
    }

    public void serializeFieldsUsing(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException {
        JsonSerializer<Object> jsonSerializer2 = this._keySerializer;
        Set<String> set = this._ignoredEntries;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (set == null || !set.contains(key)) {
                if (key == null) {
                    serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer2.serialize(key, jsonGenerator, serializerProvider);
                }
                Object value = next.getValue();
                if (value == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else if (typeSerializer == null) {
                    try {
                        jsonSerializer.serialize(value, jsonGenerator, serializerProvider);
                    } catch (Exception e) {
                        wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, "" + key);
                    }
                } else {
                    jsonSerializer.serializeWithType(value, jsonGenerator, serializerProvider, typeSerializer);
                }
            }
        }
    }

    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializer2;
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        MapProperty mapProperty = new MapProperty(this._valueTypeSerializer, this._property);
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (set == null || !set.contains(key)) {
                JsonSerializer<Object> findNullKeySerializer = key == null ? serializerProvider.findNullKeySerializer(this._keyType, this._property) : this._keySerializer;
                Object value = next.getValue();
                if (value != null) {
                    jsonSerializer = this._valueSerializer;
                    if (jsonSerializer == null) {
                        Class<?> cls = value.getClass();
                        JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                        if (serializerFor == null) {
                            if (this._valueType.hasGenericTypes()) {
                                jsonSerializer2 = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                            } else {
                                jsonSerializer2 = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                            }
                            jsonSerializer = jsonSerializer2;
                            propertySerializerMap = this._dynamicValueSerializers;
                        } else {
                            jsonSerializer = serializerFor;
                        }
                    }
                    if (obj == JsonInclude.Include.NON_EMPTY && jsonSerializer.isEmpty(serializerProvider, value)) {
                    }
                } else if (obj == null) {
                    jsonSerializer = serializerProvider.getDefaultNullValueSerializer();
                }
                mapProperty.reset(key, findNullKeySerializer, jsonSerializer);
                try {
                    propertyFilter.serializeAsField(value, jsonGenerator, serializerProvider, mapProperty);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, "" + key);
                }
            }
        }
    }

    @Deprecated
    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter) throws IOException {
        serializeFilteredFields(map, jsonGenerator, serializerProvider, propertyFilter, serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : JsonInclude.Include.NON_NULL);
    }

    public void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializer2;
        JsonSerializer<Object> jsonSerializer3;
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else if (set == null || !set.contains(key)) {
                jsonSerializer = this._keySerializer;
            }
            Object value = next.getValue();
            if (value != null) {
                Class<?> cls = value.getClass();
                JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                if (serializerFor == null) {
                    if (this._valueType.hasGenericTypes()) {
                        jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                    } else {
                        jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                    }
                    jsonSerializer2 = jsonSerializer3;
                    propertySerializerMap = this._dynamicValueSerializers;
                } else {
                    jsonSerializer2 = serializerFor;
                }
                if (obj == JsonInclude.Include.NON_EMPTY && jsonSerializer2.isEmpty(serializerProvider, value)) {
                }
            } else if (obj == null) {
                jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
            }
            jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
            try {
                jsonSerializer2.serializeWithType(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
            } catch (Exception e) {
                wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, "" + key);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializeTypedFields(map, jsonGenerator, serializerProvider, serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : JsonInclude.Include.NON_NULL);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("object", true);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonMapFormatVisitor expectMapFormat = jsonFormatVisitorWrapper == null ? null : jsonFormatVisitorWrapper.expectMapFormat(javaType);
        if (expectMapFormat != null) {
            expectMapFormat.keyFormat(this._keySerializer, this._keyType);
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            if (jsonSerializer == null) {
                jsonSerializer = _findAndAddDynamic(this._dynamicValueSerializers, this._valueType, jsonFormatVisitorWrapper.getProvider());
            }
            expectMapFormat.valueFormat(jsonSerializer, this._valueType);
        }
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(cls, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    /* access modifiers changed from: protected */
    public Map<?, ?> _orderEntries(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!_hasNullKey(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key == null) {
                _writeNullKeyedEntry(jsonGenerator, serializerProvider, obj, next.getValue());
            } else {
                treeMap.put(key, next.getValue());
            }
        }
        return treeMap;
    }

    /* access modifiers changed from: protected */
    public boolean _hasNullKey(Map<?, ?> map) {
        return (map instanceof HashMap) && map.containsKey((Object) null);
    }

    /* access modifiers changed from: protected */
    public void _writeNullKeyedEntry(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj, Object obj2) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> findNullKeySerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
        if (obj2 != null) {
            JsonSerializer<Object> jsonSerializer2 = this._valueSerializer;
            if (jsonSerializer2 == null) {
                Class<?> cls = obj2.getClass();
                JsonSerializer<Object> serializerFor = this._dynamicValueSerializers.serializerFor(cls);
                if (serializerFor == null) {
                    jsonSerializer2 = this._valueType.hasGenericTypes() ? _findAndAddDynamic(this._dynamicValueSerializers, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider) : _findAndAddDynamic(this._dynamicValueSerializers, cls, serializerProvider);
                } else {
                    jsonSerializer2 = serializerFor;
                }
            }
            if (obj != JsonInclude.Include.NON_EMPTY || !jsonSerializer2.isEmpty(serializerProvider, obj2)) {
                jsonSerializer = jsonSerializer2;
            } else {
                return;
            }
        } else if (obj == null) {
            jsonSerializer = serializerProvider.getDefaultNullValueSerializer();
        } else {
            return;
        }
        try {
            findNullKeySerializer.serialize(null, jsonGenerator, serializerProvider);
            jsonSerializer.serialize(obj2, jsonGenerator, serializerProvider);
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, (Throwable) e, obj2, "");
        }
    }
}
