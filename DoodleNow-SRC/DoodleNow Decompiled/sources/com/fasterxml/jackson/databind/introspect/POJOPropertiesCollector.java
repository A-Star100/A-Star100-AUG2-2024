package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class POJOPropertiesCollector {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected LinkedList<AnnotatedMember> _anyGetters;
    protected LinkedList<AnnotatedMember> _anySetterField;
    protected LinkedList<AnnotatedMethod> _anySetters;
    protected final AnnotatedClass _classDef;
    protected boolean _collected;
    protected final MapperConfig<?> _config;
    protected LinkedList<POJOPropertyBuilder> _creatorProperties;
    protected final boolean _forSerialization;
    protected HashSet<String> _ignoredPropertyNames;
    protected LinkedHashMap<Object, AnnotatedMember> _injectables;
    protected LinkedList<AnnotatedMethod> _jsonValueGetters;
    protected final String _mutatorPrefix;
    protected LinkedHashMap<String, POJOPropertyBuilder> _properties;
    protected final boolean _stdBeanNaming;
    protected final JavaType _type;
    protected final VisibilityChecker<?> _visibilityChecker;

    @Deprecated
    public POJOPropertiesCollector collect() {
        return this;
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        return this._annotationIntrospector;
    }

    public AnnotatedClass getClassDef() {
        return this._classDef;
    }

    public MapperConfig<?> getConfig() {
        return this._config;
    }

    public Set<String> getIgnoredPropertyNames() {
        return this._ignoredPropertyNames;
    }

    public JavaType getType() {
        return this._type;
    }

    protected POJOPropertiesCollector(MapperConfig<?> mapperConfig, boolean z, JavaType javaType, AnnotatedClass annotatedClass, String str) {
        this._config = mapperConfig;
        this._stdBeanNaming = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this._forSerialization = z;
        this._type = javaType;
        this._classDef = annotatedClass;
        this._mutatorPrefix = str == null ? "set" : str;
        AnnotationIntrospector annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
        this._annotationIntrospector = annotationIntrospector;
        if (annotationIntrospector == null) {
            this._visibilityChecker = mapperConfig.getDefaultVisibilityChecker();
        } else {
            this._visibilityChecker = annotationIntrospector.findAutoDetectVisibility(annotatedClass, mapperConfig.getDefaultVisibilityChecker());
        }
    }

    public List<BeanPropertyDefinition> getProperties() {
        return new ArrayList(getPropertyMap().values());
    }

    public Map<Object, AnnotatedMember> getInjectables() {
        if (!this._collected) {
            collectAll();
        }
        return this._injectables;
    }

    public AnnotatedMethod getJsonValueMethod() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMethod> linkedList = this._jsonValueGetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple value properties defined (" + this._jsonValueGetters.get(0) + " vs " + this._jsonValueGetters.get(1) + ")");
        }
        return this._jsonValueGetters.get(0);
    }

    public AnnotatedMember getAnyGetter() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMember> linkedList = this._anyGetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple 'any-getters' defined (" + this._anyGetters.get(0) + " vs " + this._anyGetters.get(1) + ")");
        }
        return this._anyGetters.getFirst();
    }

    public AnnotatedMember getAnySetterField() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMember> linkedList = this._anySetterField;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple 'any-Setters' defined (" + this._anySetters.get(0) + " vs " + this._anySetterField.get(1) + ")");
        }
        return this._anySetterField.getFirst();
    }

    public AnnotatedMethod getAnySetterMethod() {
        if (!this._collected) {
            collectAll();
        }
        LinkedList<AnnotatedMethod> linkedList = this._anySetters;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            reportProblem("Multiple 'any-setters' defined (" + this._anySetters.get(0) + " vs " + this._anySetters.get(1) + ")");
        }
        return this._anySetters.getFirst();
    }

    public ObjectIdInfo getObjectIdInfo() {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector == null) {
            return null;
        }
        ObjectIdInfo findObjectIdInfo = annotationIntrospector.findObjectIdInfo(this._classDef);
        return findObjectIdInfo != null ? this._annotationIntrospector.findObjectReferenceInfo(this._classDef, findObjectIdInfo) : findObjectIdInfo;
    }

    public Class<?> findPOJOBuilderClass() {
        return this._annotationIntrospector.findPOJOBuilder(this._classDef);
    }

    /* access modifiers changed from: protected */
    public Map<String, POJOPropertyBuilder> getPropertyMap() {
        if (!this._collected) {
            collectAll();
        }
        return this._properties;
    }

    /* access modifiers changed from: protected */
    public void collectAll() {
        LinkedHashMap<String, POJOPropertyBuilder> linkedHashMap = new LinkedHashMap<>();
        _addFields(linkedHashMap);
        _addMethods(linkedHashMap);
        if (!this._classDef.isNonStaticInnerClass()) {
            _addCreators(linkedHashMap);
        }
        _addInjectables(linkedHashMap);
        _removeUnwantedProperties(linkedHashMap);
        for (POJOPropertyBuilder mergeAnnotations : linkedHashMap.values()) {
            mergeAnnotations.mergeAnnotations(this._forSerialization);
        }
        _removeUnwantedAccessor(linkedHashMap);
        _renameProperties(linkedHashMap);
        PropertyNamingStrategy _findNamingStrategy = _findNamingStrategy();
        if (_findNamingStrategy != null) {
            _renameUsing(linkedHashMap, _findNamingStrategy);
        }
        for (POJOPropertyBuilder trimByVisibility : linkedHashMap.values()) {
            trimByVisibility.trimByVisibility();
        }
        if (this._config.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            _renameWithWrappers(linkedHashMap);
        }
        _sortProperties(linkedHashMap);
        this._properties = linkedHashMap;
        this._collected = true;
    }

    /* access modifiers changed from: protected */
    public void _addFields(Map<String, POJOPropertyBuilder> map) {
        String str;
        boolean z;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        boolean z2 = !this._forSerialization && !this._config.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
        boolean isEnabled = this._config.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField next : this._classDef.fields()) {
            PropertyName propertyName = null;
            if (annotationIntrospector == null) {
                str = null;
            } else {
                str = annotationIntrospector.findImplicitPropertyName(next);
            }
            if (str == null) {
                str = next.getName();
            }
            if (annotationIntrospector != null) {
                if (this._forSerialization) {
                    propertyName = annotationIntrospector.findNameForSerialization(next);
                } else {
                    propertyName = annotationIntrospector.findNameForDeserialization(next);
                }
            }
            boolean z3 = propertyName != null;
            if (!z3 || !propertyName.isEmpty()) {
                z = z3;
            } else {
                propertyName = _propNameFromSimple(str);
                z = false;
            }
            boolean z4 = propertyName != null;
            if (!z4) {
                z4 = this._visibilityChecker.isFieldVisible(next);
            }
            boolean z5 = annotationIntrospector != null && annotationIntrospector.hasIgnoreMarker(next);
            if (next.isTransient() && !z3) {
                if (isEnabled) {
                    z5 = true;
                }
                z4 = false;
            }
            if (!z2 || propertyName != null || z5 || !Modifier.isFinal(next.getModifiers())) {
                if (next.hasAnnotation(JsonAnySetter.class)) {
                    if (this._anySetterField == null) {
                        this._anySetterField = new LinkedList<>();
                    }
                    this._anySetterField.add(next);
                }
                _property(map, str).addField(next, propertyName, z, z4, z5);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addCreators(Map<String, POJOPropertyBuilder> map) {
        if (this._annotationIntrospector != null) {
            Iterator<AnnotatedConstructor> it = this._classDef.getConstructors().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AnnotatedConstructor next = it.next();
                if (this._creatorProperties == null) {
                    this._creatorProperties = new LinkedList<>();
                }
                int parameterCount = next.getParameterCount();
                for (int i = 0; i < parameterCount; i++) {
                    _addCreatorParam(map, next.getParameter(i));
                }
            }
            for (AnnotatedMethod next2 : this._classDef.getStaticMethods()) {
                if (this._creatorProperties == null) {
                    this._creatorProperties = new LinkedList<>();
                }
                int parameterCount2 = next2.getParameterCount();
                for (int i2 = 0; i2 < parameterCount2; i2++) {
                    _addCreatorParam(map, next2.getParameter(i2));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addCreatorParam(Map<String, POJOPropertyBuilder> map, AnnotatedParameter annotatedParameter) {
        String findImplicitPropertyName = this._annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        if (findImplicitPropertyName == null) {
            findImplicitPropertyName = "";
        }
        PropertyName findNameForDeserialization = this._annotationIntrospector.findNameForDeserialization(annotatedParameter);
        boolean z = findNameForDeserialization != null && !findNameForDeserialization.isEmpty();
        if (!z) {
            if (!findImplicitPropertyName.isEmpty() && this._annotationIntrospector.hasCreatorAnnotation(annotatedParameter.getOwner())) {
                findNameForDeserialization = PropertyName.construct(findImplicitPropertyName);
            } else {
                return;
            }
        }
        PropertyName propertyName = findNameForDeserialization;
        POJOPropertyBuilder _property = (!z || !findImplicitPropertyName.isEmpty()) ? _property(map, findImplicitPropertyName) : _property(map, propertyName);
        _property.addCtor(annotatedParameter, propertyName, z, true, false);
        this._creatorProperties.add(_property);
    }

    /* access modifiers changed from: protected */
    public void _addMethods(Map<String, POJOPropertyBuilder> map) {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        for (AnnotatedMethod next : this._classDef.memberMethods()) {
            int parameterCount = next.getParameterCount();
            if (parameterCount == 0) {
                _addGetterMethod(map, next, annotationIntrospector);
            } else if (parameterCount == 1) {
                _addSetterMethod(map, next, annotationIntrospector);
            } else if (parameterCount == 2 && annotationIntrospector != null && annotationIntrospector.hasAnySetterAnnotation(next)) {
                if (this._anySetters == null) {
                    this._anySetters = new LinkedList<>();
                }
                this._anySetters.add(next);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addGetterMethod(Map<String, POJOPropertyBuilder> map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        PropertyName propertyName;
        if (annotatedMethod.hasReturnType()) {
            if (annotationIntrospector != null) {
                if (annotationIntrospector.hasAnyGetterAnnotation(annotatedMethod)) {
                    if (this._anyGetters == null) {
                        this._anyGetters = new LinkedList<>();
                    }
                    this._anyGetters.add(annotatedMethod);
                    return;
                } else if (annotationIntrospector.hasAsValueAnnotation(annotatedMethod)) {
                    if (this._jsonValueGetters == null) {
                        this._jsonValueGetters = new LinkedList<>();
                    }
                    this._jsonValueGetters.add(annotatedMethod);
                    return;
                }
            }
            String str = null;
            if (annotationIntrospector == null) {
                propertyName = null;
            } else {
                propertyName = annotationIntrospector.findNameForSerialization(annotatedMethod);
            }
            boolean z = true;
            boolean z2 = false;
            boolean z3 = propertyName != null;
            if (!z3) {
                if (annotationIntrospector != null) {
                    str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
                }
                if (str == null) {
                    str = BeanUtil.okNameForRegularGetter(annotatedMethod, annotatedMethod.getName(), this._stdBeanNaming);
                }
                if (str == null) {
                    str = BeanUtil.okNameForIsGetter(annotatedMethod, annotatedMethod.getName(), this._stdBeanNaming);
                    if (str != null) {
                        z = this._visibilityChecker.isIsGetterVisible(annotatedMethod);
                    } else {
                        return;
                    }
                } else {
                    z = this._visibilityChecker.isGetterVisible(annotatedMethod);
                }
            } else {
                if (annotationIntrospector != null) {
                    str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
                }
                if (str == null) {
                    str = BeanUtil.okNameForGetter(annotatedMethod, this._stdBeanNaming);
                }
                if (str == null) {
                    str = annotatedMethod.getName();
                }
                if (propertyName.isEmpty()) {
                    propertyName = _propNameFromSimple(str);
                    z3 = false;
                }
            }
            PropertyName propertyName2 = propertyName;
            boolean z4 = z;
            boolean z5 = z3;
            if (annotationIntrospector != null) {
                z2 = annotationIntrospector.hasIgnoreMarker(annotatedMethod);
            }
            _property(map, str).addGetter(annotatedMethod, propertyName2, z5, z4, z2);
        }
    }

    /* access modifiers changed from: protected */
    public void _addSetterMethod(Map<String, POJOPropertyBuilder> map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        String str = null;
        PropertyName findNameForDeserialization = annotationIntrospector == null ? null : annotationIntrospector.findNameForDeserialization(annotatedMethod);
        boolean z = true;
        boolean z2 = false;
        boolean z3 = findNameForDeserialization != null;
        if (!z3) {
            if (annotationIntrospector != null) {
                str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
            }
            if (str == null) {
                str = BeanUtil.okNameForMutator(annotatedMethod, this._mutatorPrefix, this._stdBeanNaming);
            }
            if (str != null) {
                z = this._visibilityChecker.isSetterVisible(annotatedMethod);
            } else {
                return;
            }
        } else {
            if (annotationIntrospector != null) {
                str = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
            }
            if (str == null) {
                str = BeanUtil.okNameForMutator(annotatedMethod, this._mutatorPrefix, this._stdBeanNaming);
            }
            if (str == null) {
                str = annotatedMethod.getName();
            }
            if (findNameForDeserialization.isEmpty()) {
                findNameForDeserialization = _propNameFromSimple(str);
                z3 = false;
            }
        }
        PropertyName propertyName = findNameForDeserialization;
        boolean z4 = z;
        boolean z5 = z3;
        if (annotationIntrospector != null) {
            z2 = annotationIntrospector.hasIgnoreMarker(annotatedMethod);
        }
        _property(map, str).addSetter(annotatedMethod, propertyName, z5, z4, z2);
    }

    /* access modifiers changed from: protected */
    public void _addInjectables(Map<String, POJOPropertyBuilder> map) {
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector != null) {
            for (AnnotatedField next : this._classDef.fields()) {
                _doAddInjectable(annotationIntrospector.findInjectableValueId(next), next);
            }
            for (AnnotatedMethod next2 : this._classDef.memberMethods()) {
                if (next2.getParameterCount() == 1) {
                    _doAddInjectable(annotationIntrospector.findInjectableValueId(next2), next2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _doAddInjectable(Object obj, AnnotatedMember annotatedMember) {
        if (obj != null) {
            if (this._injectables == null) {
                this._injectables = new LinkedHashMap<>();
            }
            if (((AnnotatedMember) this._injectables.put(obj, annotatedMember)) != null) {
                String name = obj.getClass().getName();
                throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(obj) + "' (of type " + name + ")");
            }
        }
    }

    private PropertyName _propNameFromSimple(String str) {
        return PropertyName.construct(str, (String) null);
    }

    /* access modifiers changed from: protected */
    public void _removeUnwantedProperties(Map<String, POJOPropertyBuilder> map) {
        Iterator<POJOPropertyBuilder> it = map.values().iterator();
        while (it.hasNext()) {
            POJOPropertyBuilder next = it.next();
            if (!next.anyVisible()) {
                it.remove();
            } else if (next.anyIgnorals()) {
                if (!next.isExplicitlyIncluded()) {
                    it.remove();
                    _collectIgnorals(next.getName());
                } else {
                    next.removeIgnored();
                    if (!this._forSerialization && !next.couldDeserialize()) {
                        _collectIgnorals(next.getName());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _removeUnwantedAccessor(Map<String, POJOPropertyBuilder> map) {
        boolean isEnabled = this._config.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
        for (POJOPropertyBuilder next : map.values()) {
            JsonProperty.Access removeNonVisible = next.removeNonVisible(isEnabled);
            if (!this._forSerialization && removeNonVisible == JsonProperty.Access.READ_ONLY) {
                _collectIgnorals(next.getName());
            }
        }
    }

    private void _collectIgnorals(String str) {
        if (!this._forSerialization) {
            if (this._ignoredPropertyNames == null) {
                this._ignoredPropertyNames = new HashSet<>();
            }
            this._ignoredPropertyNames.add(str);
        }
    }

    /* access modifiers changed from: protected */
    public void _renameProperties(Map<String, POJOPropertyBuilder> map) {
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) it.next().getValue();
            Set<PropertyName> findExplicitNames = pOJOPropertyBuilder.findExplicitNames();
            if (!findExplicitNames.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (findExplicitNames.size() == 1) {
                    linkedList.add(pOJOPropertyBuilder.withName(findExplicitNames.iterator().next()));
                } else {
                    linkedList.addAll(pOJOPropertyBuilder.explode(findExplicitNames));
                }
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                POJOPropertyBuilder pOJOPropertyBuilder2 = (POJOPropertyBuilder) it2.next();
                String name = pOJOPropertyBuilder2.getName();
                POJOPropertyBuilder pOJOPropertyBuilder3 = map.get(name);
                if (pOJOPropertyBuilder3 == null) {
                    map.put(name, pOJOPropertyBuilder2);
                } else {
                    pOJOPropertyBuilder3.addAll(pOJOPropertyBuilder2);
                }
                _updateCreatorProperty(pOJOPropertyBuilder2, this._creatorProperties);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _renameUsing(java.util.Map<java.lang.String, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder> r9, com.fasterxml.jackson.databind.PropertyNamingStrategy r10) {
        /*
            r8 = this;
            java.util.Collection r0 = r9.values()
            int r1 = r9.size()
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[] r1 = new com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[] r0 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder[]) r0
            r9.clear()
            int r1 = r0.length
            r2 = 0
        L_0x0015:
            if (r2 >= r1) goto L_0x00d9
            r3 = r0[r2]
            com.fasterxml.jackson.databind.PropertyName r4 = r3.getFullName()
            boolean r5 = r3.isExplicitlyNamed()
            if (r5 == 0) goto L_0x002d
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.MapperFeature r6 = com.fasterxml.jackson.databind.MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING
            boolean r5 = r5.isEnabled(r6)
            if (r5 == 0) goto L_0x00af
        L_0x002d:
            boolean r5 = r8._forSerialization
            if (r5 == 0) goto L_0x005b
            boolean r5 = r3.hasGetter()
            if (r5 == 0) goto L_0x0046
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r6 = r3.getGetter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForGetterMethod(r5, r6, r7)
            goto L_0x00b0
        L_0x0046:
            boolean r5 = r3.hasField()
            if (r5 == 0) goto L_0x00af
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedField r6 = r3.getField()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForField(r5, r6, r7)
            goto L_0x00b0
        L_0x005b:
            boolean r5 = r3.hasSetter()
            if (r5 == 0) goto L_0x0070
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r6 = r3.getSetter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForSetterMethod(r5, r6, r7)
            goto L_0x00b0
        L_0x0070:
            boolean r5 = r3.hasConstructorParameter()
            if (r5 == 0) goto L_0x0085
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedParameter r6 = r3.getConstructorParameter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForConstructorParameter(r5, r6, r7)
            goto L_0x00b0
        L_0x0085:
            boolean r5 = r3.hasField()
            if (r5 == 0) goto L_0x009a
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedField r6 = r3.getField()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForField(r5, r6, r7)
            goto L_0x00b0
        L_0x009a:
            boolean r5 = r3.hasGetter()
            if (r5 == 0) goto L_0x00af
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r8._config
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r6 = r3.getGetter()
            java.lang.String r7 = r4.getSimpleName()
            java.lang.String r5 = r10.nameForGetterMethod(r5, r6, r7)
            goto L_0x00b0
        L_0x00af:
            r5 = 0
        L_0x00b0:
            if (r5 == 0) goto L_0x00bd
            boolean r6 = r4.hasSimpleName(r5)
            if (r6 != 0) goto L_0x00bd
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r3 = r3.withSimpleName((java.lang.String) r5)
            goto L_0x00c1
        L_0x00bd:
            java.lang.String r5 = r4.getSimpleName()
        L_0x00c1:
            java.lang.Object r4 = r9.get(r5)
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r4 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder) r4
            if (r4 != 0) goto L_0x00cd
            r9.put(r5, r3)
            goto L_0x00d0
        L_0x00cd:
            r4.addAll(r3)
        L_0x00d0:
            java.util.LinkedList<com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder> r4 = r8._creatorProperties
            r8._updateCreatorProperty(r3, r4)
            int r2 = r2 + 1
            goto L_0x0015
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector._renameUsing(java.util.Map, com.fasterxml.jackson.databind.PropertyNamingStrategy):void");
    }

    /* access modifiers changed from: protected */
    public void _renameWithWrappers(Map<String, POJOPropertyBuilder> map) {
        PropertyName findWrapperName;
        Iterator<Map.Entry<String, POJOPropertyBuilder>> it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) it.next().getValue();
            AnnotatedMember primaryMember = pOJOPropertyBuilder.getPrimaryMember();
            if (primaryMember != null && (findWrapperName = this._annotationIntrospector.findWrapperName(primaryMember)) != null && findWrapperName.hasSimpleName() && !findWrapperName.equals(pOJOPropertyBuilder.getFullName())) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(pOJOPropertyBuilder.withName(findWrapperName));
                it.remove();
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                POJOPropertyBuilder pOJOPropertyBuilder2 = (POJOPropertyBuilder) it2.next();
                String name = pOJOPropertyBuilder2.getName();
                POJOPropertyBuilder pOJOPropertyBuilder3 = map.get(name);
                if (pOJOPropertyBuilder3 == null) {
                    map.put(name, pOJOPropertyBuilder2);
                } else {
                    pOJOPropertyBuilder3.addAll(pOJOPropertyBuilder2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _sortProperties(Map<String, POJOPropertyBuilder> map) {
        boolean z;
        Map map2;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        String[] strArr = null;
        Boolean findSerializationSortAlphabetically = annotationIntrospector == null ? null : annotationIntrospector.findSerializationSortAlphabetically(this._classDef);
        if (findSerializationSortAlphabetically == null) {
            z = this._config.shouldSortPropertiesAlphabetically();
        } else {
            z = findSerializationSortAlphabetically.booleanValue();
        }
        if (annotationIntrospector != null) {
            strArr = annotationIntrospector.findSerializationPropertyOrder(this._classDef);
        }
        if (z || this._creatorProperties != null || strArr != null) {
            int size = map.size();
            if (z) {
                map2 = new TreeMap();
            } else {
                map2 = new LinkedHashMap(size + size);
            }
            for (POJOPropertyBuilder next : map.values()) {
                map2.put(next.getName(), next);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size + size);
            if (strArr != null) {
                for (String str : strArr) {
                    POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) map2.get(str);
                    if (pOJOPropertyBuilder == null) {
                        Iterator<POJOPropertyBuilder> it = map.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            POJOPropertyBuilder next2 = it.next();
                            if (str.equals(next2.getInternalName())) {
                                str = next2.getName();
                                pOJOPropertyBuilder = next2;
                                break;
                            }
                        }
                    }
                    if (pOJOPropertyBuilder != null) {
                        linkedHashMap.put(str, pOJOPropertyBuilder);
                    }
                }
            }
            Collection<POJOPropertyBuilder> collection = this._creatorProperties;
            if (collection != null) {
                if (z) {
                    TreeMap treeMap = new TreeMap();
                    Iterator it2 = this._creatorProperties.iterator();
                    while (it2.hasNext()) {
                        POJOPropertyBuilder pOJOPropertyBuilder2 = (POJOPropertyBuilder) it2.next();
                        treeMap.put(pOJOPropertyBuilder2.getName(), pOJOPropertyBuilder2);
                    }
                    collection = treeMap.values();
                }
                for (POJOPropertyBuilder pOJOPropertyBuilder3 : collection) {
                    String name = pOJOPropertyBuilder3.getName();
                    if (map2.containsKey(name)) {
                        linkedHashMap.put(name, pOJOPropertyBuilder3);
                    }
                }
            }
            linkedHashMap.putAll(map2);
            map.clear();
            map.putAll(linkedHashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void reportProblem(String str) {
        throw new IllegalArgumentException("Problem with definition of " + this._classDef + ": " + str);
    }

    /* access modifiers changed from: protected */
    public POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> map, PropertyName propertyName) {
        return _property(map, propertyName.getSimpleName());
    }

    /* access modifiers changed from: protected */
    public POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> map, String str) {
        POJOPropertyBuilder pOJOPropertyBuilder = map.get(str);
        if (pOJOPropertyBuilder != null) {
            return pOJOPropertyBuilder;
        }
        POJOPropertyBuilder pOJOPropertyBuilder2 = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, PropertyName.construct(str));
        map.put(str, pOJOPropertyBuilder2);
        return pOJOPropertyBuilder2;
    }

    private PropertyNamingStrategy _findNamingStrategy() {
        PropertyNamingStrategy namingStrategyInstance;
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        Object findNamingStrategy = annotationIntrospector == null ? null : annotationIntrospector.findNamingStrategy(this._classDef);
        if (findNamingStrategy == null) {
            return this._config.getPropertyNamingStrategy();
        }
        if (findNamingStrategy instanceof PropertyNamingStrategy) {
            return (PropertyNamingStrategy) findNamingStrategy;
        }
        if (findNamingStrategy instanceof Class) {
            Class<PropertyNamingStrategy> cls = (Class) findNamingStrategy;
            if (cls == PropertyNamingStrategy.class) {
                return null;
            }
            if (PropertyNamingStrategy.class.isAssignableFrom(cls)) {
                HandlerInstantiator handlerInstantiator = this._config.getHandlerInstantiator();
                if (handlerInstantiator == null || (namingStrategyInstance = handlerInstantiator.namingStrategyInstance(this._config, this._classDef, cls)) == null) {
                    return (PropertyNamingStrategy) ClassUtil.createInstance(cls, this._config.canOverrideAccessModifiers());
                }
                return namingStrategyInstance;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + findNamingStrategy.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
    }

    /* access modifiers changed from: protected */
    public void _updateCreatorProperty(POJOPropertyBuilder pOJOPropertyBuilder, List<POJOPropertyBuilder> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).getInternalName().equals(pOJOPropertyBuilder.getInternalName())) {
                    list.set(i, pOJOPropertyBuilder);
                    return;
                }
            }
        }
    }
}
