package com.fasterxml.jackson.databind.ext;

import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.beans.ConstructorProperties;
import java.beans.Transient;

public class Java7SupportImpl extends Java7Support {
    private final Class<?> _bogus = ConstructorProperties.class;

    public Java7SupportImpl() {
        Class<Transient> cls = Transient.class;
    }

    public Class<?> getClassJavaNioFilePath() {
        return ReactTextView$$ExternalSyntheticApiModelOutline0.m();
    }

    public JsonDeserializer<?> getDeserializerForJavaNioFilePath(Class<?> cls) {
        if (cls == ReactTextView$$ExternalSyntheticApiModelOutline0.m()) {
            return new NioPathDeserializer();
        }
        return null;
    }

    public JsonSerializer<?> getSerializerForJavaNioFilePath(Class<?> cls) {
        if (ReactTextView$$ExternalSyntheticApiModelOutline0.m().isAssignableFrom(cls)) {
            return new NioPathSerializer();
        }
        return null;
    }

    public Boolean findTransient(Annotated annotated) {
        Transient annotation = annotated.getAnnotation(Transient.class);
        if (annotation != null) {
            return Boolean.valueOf(annotation.value());
        }
        return null;
    }

    public Boolean hasCreatorAnnotation(Annotated annotated) {
        if (annotated.getAnnotation(ConstructorProperties.class) != null) {
            return Boolean.TRUE;
        }
        return null;
    }

    public PropertyName findConstructorName(AnnotatedParameter annotatedParameter) {
        ConstructorProperties annotation;
        AnnotatedWithParams owner = annotatedParameter.getOwner();
        if (owner == null || (annotation = owner.getAnnotation(ConstructorProperties.class)) == null) {
            return null;
        }
        String[] value = annotation.value();
        int index = annotatedParameter.getIndex();
        if (index < value.length) {
            return PropertyName.construct(value[index]);
        }
        return null;
    }
}
