package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;

public abstract class ConcreteBeanPropertyBase implements BeanProperty, Serializable {
    private static final long serialVersionUID = 1;
    protected final PropertyMetadata _metadata;
    protected transient JsonFormat.Value _propertyFormat;

    public PropertyMetadata getMetadata() {
        return this._metadata;
    }

    public boolean isVirtual() {
        return false;
    }

    protected ConcreteBeanPropertyBase(PropertyMetadata propertyMetadata) {
        this._metadata = propertyMetadata == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : propertyMetadata;
    }

    protected ConcreteBeanPropertyBase(ConcreteBeanPropertyBase concreteBeanPropertyBase) {
        this._metadata = concreteBeanPropertyBase._metadata;
        this._propertyFormat = concreteBeanPropertyBase._propertyFormat;
    }

    public boolean isRequired() {
        return this._metadata.isRequired();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = getMember();
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.fasterxml.jackson.annotation.JsonFormat.Value findFormatOverrides(com.fasterxml.jackson.databind.AnnotationIntrospector r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x000d
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = r1.getMember()
            if (r0 == 0) goto L_0x000d
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = r2.findFormat(r0)
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            if (r2 != 0) goto L_0x0012
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = EMPTY_FORMAT
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase.findFormatOverrides(com.fasterxml.jackson.databind.AnnotationIntrospector):com.fasterxml.jackson.annotation.JsonFormat$Value");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = getMember();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.annotation.JsonFormat.Value findPropertyFormat(com.fasterxml.jackson.databind.cfg.MapperConfig<?> r2, java.lang.Class<?> r3) {
        /*
            r1 = this;
            com.fasterxml.jackson.annotation.JsonFormat$Value r0 = r1._propertyFormat
            if (r0 != 0) goto L_0x002c
            com.fasterxml.jackson.annotation.JsonFormat$Value r3 = r2.getDefaultPropertyFormat(r3)
            com.fasterxml.jackson.databind.AnnotationIntrospector r2 = r2.getAnnotationIntrospector()
            if (r2 == 0) goto L_0x0019
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = r1.getMember()
            if (r0 == 0) goto L_0x0019
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = r2.findFormat(r0)
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r3 != 0) goto L_0x0022
            if (r2 != 0) goto L_0x0020
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = EMPTY_FORMAT
        L_0x0020:
            r0 = r2
            goto L_0x002a
        L_0x0022:
            if (r2 != 0) goto L_0x0025
            goto L_0x0029
        L_0x0025:
            com.fasterxml.jackson.annotation.JsonFormat$Value r3 = r3.withOverrides(r2)
        L_0x0029:
            r0 = r3
        L_0x002a:
            r1._propertyFormat = r0
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase.findPropertyFormat(com.fasterxml.jackson.databind.cfg.MapperConfig, java.lang.Class):com.fasterxml.jackson.annotation.JsonFormat$Value");
    }

    public JsonInclude.Value findPropertyInclusion(MapperConfig<?> mapperConfig, Class<?> cls) {
        JsonInclude.Value findPropertyInclusion;
        JsonInclude.Value defaultPropertyInclusion = mapperConfig.getDefaultPropertyInclusion(cls);
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        AnnotatedMember member = getMember();
        if (annotationIntrospector == null || member == null || (findPropertyInclusion = annotationIntrospector.findPropertyInclusion(member)) == null) {
            return defaultPropertyInclusion;
        }
        return defaultPropertyInclusion.withOverrides(findPropertyInclusion);
    }
}
