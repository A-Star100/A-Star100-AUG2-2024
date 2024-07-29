package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@JacksonStdImpl
public class CollectionDeserializer extends ContainerDeserializerBase<Collection<Object>> implements ContextualDeserializer {
    private static final long serialVersionUID = -1;
    protected final JavaType _collectionType;
    protected final JsonDeserializer<Object> _delegateDeserializer;
    protected final Boolean _unwrapSingle;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public boolean isCachable() {
        return this._valueDeserializer == null && this._valueTypeDeserializer == null && this._delegateDeserializer == null;
    }

    public CollectionDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, ValueInstantiator valueInstantiator) {
        this(javaType, jsonDeserializer, typeDeserializer, valueInstantiator, (JsonDeserializer<Object>) null, (Boolean) null);
    }

    protected CollectionDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, ValueInstantiator valueInstantiator, JsonDeserializer<Object> jsonDeserializer2, Boolean bool) {
        super(javaType);
        this._collectionType = javaType;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = jsonDeserializer2;
        this._unwrapSingle = bool;
    }

    protected CollectionDeserializer(CollectionDeserializer collectionDeserializer) {
        super(collectionDeserializer._collectionType);
        this._collectionType = collectionDeserializer._collectionType;
        this._valueDeserializer = collectionDeserializer._valueDeserializer;
        this._valueTypeDeserializer = collectionDeserializer._valueTypeDeserializer;
        this._valueInstantiator = collectionDeserializer._valueInstantiator;
        this._delegateDeserializer = collectionDeserializer._delegateDeserializer;
        this._unwrapSingle = collectionDeserializer._unwrapSingle;
    }

    /* access modifiers changed from: protected */
    public CollectionDeserializer withResolved(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, TypeDeserializer typeDeserializer, Boolean bool) {
        if (jsonDeserializer == this._delegateDeserializer && jsonDeserializer2 == this._valueDeserializer && typeDeserializer == this._valueTypeDeserializer && this._unwrapSingle == bool) {
            return this;
        }
        return new CollectionDeserializer(this._collectionType, jsonDeserializer2, typeDeserializer, this._valueInstantiator, jsonDeserializer, bool);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public CollectionDeserializer withResolved(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, TypeDeserializer typeDeserializer) {
        return withResolved(jsonDeserializer, jsonDeserializer2, typeDeserializer, this._unwrapSingle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.deser.std.CollectionDeserializer createContextual(com.fasterxml.jackson.databind.DeserializationContext r5, com.fasterxml.jackson.databind.BeanProperty r6) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r4 = this;
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r4._valueInstantiator
            if (r0 == 0) goto L_0x008c
            boolean r0 = r0.canCreateUsingDelegate()
            java.lang.String r1 = ": value instantiator ("
            if (r0 == 0) goto L_0x0048
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r4._valueInstantiator
            com.fasterxml.jackson.databind.DeserializationConfig r2 = r5.getConfig()
            com.fasterxml.jackson.databind.JavaType r0 = r0.getDelegateType(r2)
            if (r0 == 0) goto L_0x001d
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r4.findDeserializer(r5, r0, r6)
            goto L_0x008d
        L_0x001d:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid delegate-creator definition for "
            r6.<init>(r0)
            com.fasterxml.jackson.databind.JavaType r0 = r4._collectionType
            r6.append(r0)
            r6.append(r1)
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r4._valueInstantiator
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r6.append(r0)
            java.lang.String r0 = ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x0048:
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r4._valueInstantiator
            boolean r0 = r0.canCreateUsingArrayDelegate()
            if (r0 == 0) goto L_0x008c
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r4._valueInstantiator
            com.fasterxml.jackson.databind.DeserializationConfig r2 = r5.getConfig()
            com.fasterxml.jackson.databind.JavaType r0 = r0.getArrayDelegateType(r2)
            if (r0 == 0) goto L_0x0061
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r4.findDeserializer(r5, r0, r6)
            goto L_0x008d
        L_0x0061:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid array-delegate-creator definition for "
            r6.<init>(r0)
            com.fasterxml.jackson.databind.JavaType r0 = r4._collectionType
            r6.append(r0)
            r6.append(r1)
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r4._valueInstantiator
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r6.append(r0)
            java.lang.String r0 = ") returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x008c:
            r0 = 0
        L_0x008d:
            java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
            com.fasterxml.jackson.annotation.JsonFormat$Feature r2 = com.fasterxml.jackson.annotation.JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
            java.lang.Boolean r1 = r4.findFormatFeature(r5, r6, r1, r2)
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> r2 = r4._valueDeserializer
            com.fasterxml.jackson.databind.JsonDeserializer r2 = r4.findConvertingContentDeserializer(r5, r6, r2)
            com.fasterxml.jackson.databind.JavaType r3 = r4._collectionType
            com.fasterxml.jackson.databind.JavaType r3 = r3.getContentType()
            if (r2 != 0) goto L_0x00a8
            com.fasterxml.jackson.databind.JsonDeserializer r5 = r5.findContextualValueDeserializer(r3, r6)
            goto L_0x00ac
        L_0x00a8:
            com.fasterxml.jackson.databind.JsonDeserializer r5 = r5.handleSecondaryContextualization(r2, r6, r3)
        L_0x00ac:
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r2 = r4._valueTypeDeserializer
            if (r2 == 0) goto L_0x00b4
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r2 = r2.forProperty(r6)
        L_0x00b4:
            com.fasterxml.jackson.databind.deser.std.CollectionDeserializer r5 = r4.withResolved(r0, r5, r2, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.createContextual(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.deser.std.CollectionDeserializer");
    }

    public JavaType getContentType() {
        return this._collectionType.getContentType();
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return (Collection) this._valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();
            if (text.length() == 0) {
                return (Collection) this._valueInstantiator.createFromString(deserializationContext, text);
            }
        }
        return deserialize(jsonParser, deserializationContext, (Collection<Object>) (Collection) this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    public Collection<Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        Object obj;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        jsonParser.setCurrentValue(collection);
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        CollectionReferringAccumulator collectionReferringAccumulator = jsonDeserializer.getObjectIdReader() == null ? null : new CollectionReferringAccumulator(this._collectionType.getContentType().getRawClass(), collection);
        while (true) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == JsonToken.END_ARRAY) {
                return collection;
            }
            try {
                if (nextToken == JsonToken.VALUE_NULL) {
                    obj = jsonDeserializer.getNullValue(deserializationContext);
                } else if (typeDeserializer == null) {
                    obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                } else {
                    obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
                }
                if (collectionReferringAccumulator != null) {
                    collectionReferringAccumulator.add(obj);
                } else {
                    collection.add(obj);
                }
            } catch (UnresolvedForwardReference e) {
                if (collectionReferringAccumulator != null) {
                    e.getRoid().appendReferring(collectionReferringAccumulator.handleUnresolvedReference(e));
                } else {
                    throw JsonMappingException.from(jsonParser, "Unresolved forward reference but no identity info", (Throwable) e);
                }
            } catch (Exception e2) {
                if (deserializationContext == null || deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS) || !(e2 instanceof RuntimeException)) {
                    throw JsonMappingException.wrapWithPath((Throwable) e2, (Object) collection, collection.size());
                }
                throw ((RuntimeException) e2);
            }
        }
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    public final Collection<Object> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        Object obj;
        if (this._unwrapSingle != Boolean.TRUE && (this._unwrapSingle != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return (Collection) deserializationContext.handleUnexpectedToken(this._collectionType.getRawClass(), jsonParser);
        }
        JsonDeserializer<Object> jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        try {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
                obj = jsonDeserializer.getNullValue(deserializationContext);
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.deserialize(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            }
            collection.add(obj);
            return collection;
        } catch (Exception e) {
            throw JsonMappingException.wrapWithPath((Throwable) e, (Object) Object.class, collection.size());
        }
    }

    public static final class CollectionReferringAccumulator {
        private List<CollectionReferring> _accumulator = new ArrayList();
        private final Class<?> _elementType;
        private final Collection<Object> _result;

        public CollectionReferringAccumulator(Class<?> cls, Collection<Object> collection) {
            this._elementType = cls;
            this._result = collection;
        }

        public void add(Object obj) {
            if (this._accumulator.isEmpty()) {
                this._result.add(obj);
                return;
            }
            List<CollectionReferring> list = this._accumulator;
            list.get(list.size() - 1).next.add(obj);
        }

        public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference unresolvedForwardReference) {
            CollectionReferring collectionReferring = new CollectionReferring(this, unresolvedForwardReference, this._elementType);
            this._accumulator.add(collectionReferring);
            return collectionReferring;
        }

        public void resolveForwardReference(Object obj, Object obj2) throws IOException {
            Iterator<CollectionReferring> it = this._accumulator.iterator();
            Collection collection = this._result;
            while (it.hasNext()) {
                CollectionReferring next = it.next();
                if (next.hasId(obj)) {
                    it.remove();
                    collection.add(obj2);
                    collection.addAll(next.next);
                    return;
                }
                collection = next.next;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    private static final class CollectionReferring extends ReadableObjectId.Referring {
        private final CollectionReferringAccumulator _parent;
        public final List<Object> next = new ArrayList();

        CollectionReferring(CollectionReferringAccumulator collectionReferringAccumulator, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls) {
            super(unresolvedForwardReference, cls);
            this._parent = collectionReferringAccumulator;
        }

        public void handleResolvedForwardReference(Object obj, Object obj2) throws IOException {
            this._parent.resolveForwardReference(obj, obj2);
        }
    }
}
