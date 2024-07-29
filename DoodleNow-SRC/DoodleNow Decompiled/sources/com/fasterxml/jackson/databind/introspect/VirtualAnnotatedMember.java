package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _declaringClass;
    protected final String _name;
    protected final JavaType _type;

    public Field getAnnotated() {
        return null;
    }

    public int getAnnotationCount() {
        return 0;
    }

    public Class<?> getDeclaringClass() {
        return this._declaringClass;
    }

    public Member getMember() {
        return null;
    }

    public int getModifiers() {
        return 0;
    }

    public String getName() {
        return this._name;
    }

    public JavaType getType() {
        return this._type;
    }

    public Annotated withAnnotations(AnnotationMap annotationMap) {
        return this;
    }

    public VirtualAnnotatedMember(TypeResolutionContext typeResolutionContext, Class<?> cls, String str, JavaType javaType) {
        super(typeResolutionContext, (AnnotationMap) null);
        this._declaringClass = cls;
        this._type = javaType;
        this._name = str;
    }

    @Deprecated
    public VirtualAnnotatedMember(TypeResolutionContext typeResolutionContext, Class<?> cls, String str, Class<?> cls2) {
        this(typeResolutionContext, cls, str, typeResolutionContext.resolveType(cls2));
    }

    public Class<?> getRawType() {
        return this._type.getRawClass();
    }

    public void setValue(Object obj, Object obj2) throws IllegalArgumentException {
        throw new IllegalArgumentException("Can not set virtual property '" + this._name + "'");
    }

    public Object getValue(Object obj) throws IllegalArgumentException {
        throw new IllegalArgumentException("Can not get virtual property '" + this._name + "'");
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName();
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        VirtualAnnotatedMember virtualAnnotatedMember = (VirtualAnnotatedMember) obj;
        if (virtualAnnotatedMember._declaringClass != this._declaringClass || !virtualAnnotatedMember._name.equals(this._name)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[field " + getFullName() + "]";
    }
}
