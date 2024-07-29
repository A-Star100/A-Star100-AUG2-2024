package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.impl.ErrorThrowingDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    protected static final Set<String> DEFAULT_NO_DESER_CLASS_NAMES;
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    private static final Class<?>[] NO_VIEWS = new Class[0];
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());
    private static final long serialVersionUID = 1;
    protected Set<String> _cfgIllegalClassNames = DEFAULT_NO_DESER_CLASS_NAMES;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            r2 = 0
            r0[r2] = r1
            INIT_CAUSE_PARAMS = r0
            java.lang.Class[] r0 = new java.lang.Class[r2]
            NO_VIEWS = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.String r1 = "org.apache.commons.collections.functors.InvokerTransformer"
            r0.add(r1)
            java.lang.String r1 = "org.apache.commons.collections.functors.InstantiateTransformer"
            r0.add(r1)
            java.lang.String r1 = "org.apache.commons.collections4.functors.InvokerTransformer"
            r0.add(r1)
            java.lang.String r1 = "org.apache.commons.collections4.functors.InstantiateTransformer"
            r0.add(r1)
            java.lang.String r1 = "org.codehaus.groovy.runtime.ConvertedClosure"
            r0.add(r1)
            java.lang.String r1 = "org.codehaus.groovy.runtime.MethodClosure"
            r0.add(r1)
            java.lang.String r1 = "org.springframework.beans.factory.ObjectFactory"
            r0.add(r1)
            java.lang.String r1 = "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl"
            r0.add(r1)
            java.lang.String r1 = "org.apache.xalan.xsltc.trax.TemplatesImpl"
            r0.add(r1)
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)
            DEFAULT_NO_DESER_CLASS_NAMES = r0
            com.fasterxml.jackson.databind.deser.BeanDeserializerFactory r0 = new com.fasterxml.jackson.databind.deser.BeanDeserializerFactory
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r1 = new com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig
            r1.<init>()
            r0.<init>(r1)
            instance = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializerFactory.<clinit>():void");
    }

    public BeanDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        super(deserializerFactoryConfig);
    }

    public DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig) {
        if (this._factoryConfig == deserializerFactoryConfig) {
            return this;
        }
        if (getClass() == BeanDeserializerFactory.class) {
            return new BeanDeserializerFactory(deserializerFactoryConfig);
        }
        throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with additional deserializer definitions");
    }

    public JsonDeserializer<Object> createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType materializeAbstractType;
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer<Object> _findCustomBeanDeserializer = _findCustomBeanDeserializer(javaType, config, beanDescription);
        if (_findCustomBeanDeserializer != null) {
            return _findCustomBeanDeserializer;
        }
        if (javaType.isThrowable()) {
            return buildThrowableDeserializer(deserializationContext, javaType, beanDescription);
        }
        if (javaType.isAbstract() && !javaType.isPrimitive() && !javaType.isEnumType() && (materializeAbstractType = materializeAbstractType(deserializationContext, javaType, beanDescription)) != null) {
            return buildBeanDeserializer(deserializationContext, materializeAbstractType, config.introspect(materializeAbstractType));
        }
        JsonDeserializer<?> findStdDeserializer = findStdDeserializer(deserializationContext, javaType, beanDescription);
        if (findStdDeserializer != null) {
            return findStdDeserializer;
        }
        if (!isPotentialBeanType(javaType.getRawClass())) {
            return null;
        }
        checkIllegalTypes(deserializationContext, javaType, beanDescription);
        return buildBeanDeserializer(deserializationContext, javaType, beanDescription);
    }

    public JsonDeserializer<Object> createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription, Class<?> cls) throws JsonMappingException {
        return buildBuilderBasedDeserializer(deserializationContext, javaType, deserializationContext.getConfig().introspectForBuilder(deserializationContext.constructType(cls)));
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> findStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JsonDeserializer<?> findDefaultDeserializer = findDefaultDeserializer(deserializationContext, javaType, beanDescription);
        if (findDefaultDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyDeserializer : this._factoryConfig.deserializerModifiers()) {
                findDefaultDeserializer = modifyDeserializer.modifyDeserializer(deserializationContext.getConfig(), beanDescription, findDefaultDeserializer);
            }
        }
        return findDefaultDeserializer;
    }

    /* access modifiers changed from: protected */
    public JavaType materializeAbstractType(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        for (AbstractTypeResolver resolveAbstractType : this._factoryConfig.abstractTypeResolvers()) {
            JavaType resolveAbstractType2 = resolveAbstractType.resolveAbstractType(deserializationContext.getConfig(), beanDescription);
            if (resolveAbstractType2 != null) {
                return resolveAbstractType2;
            }
        }
        return null;
    }

    public JsonDeserializer<Object> buildBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JsonDeserializer<?> jsonDeserializer;
        try {
            ValueInstantiator findValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
            BeanDeserializerBuilder constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
            constructBeanDeserializerBuilder.setValueInstantiator(findValueInstantiator);
            addBeanProps(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
            addObjectIdReader(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
            addReferenceProperties(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
            addInjectables(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                for (BeanDeserializerModifier updateBuilder : this._factoryConfig.deserializerModifiers()) {
                    constructBeanDeserializerBuilder = updateBuilder.updateBuilder(config, beanDescription, constructBeanDeserializerBuilder);
                }
            }
            if (!javaType.isAbstract() || findValueInstantiator.canInstantiate()) {
                jsonDeserializer = constructBeanDeserializerBuilder.build();
            } else {
                jsonDeserializer = constructBeanDeserializerBuilder.buildAbstract();
            }
            if (this._factoryConfig.hasDeserializerModifiers()) {
                for (BeanDeserializerModifier modifyDeserializer : this._factoryConfig.deserializerModifiers()) {
                    jsonDeserializer = modifyDeserializer.modifyDeserializer(config, beanDescription, jsonDeserializer);
                }
            }
            return jsonDeserializer;
        } catch (NoClassDefFoundError e) {
            return new ErrorThrowingDeserializer(e);
        }
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> buildBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        String str;
        ValueInstantiator findValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDeserializerBuilder constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        constructBeanDeserializerBuilder.setValueInstantiator(findValueInstantiator);
        addBeanProps(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
        addObjectIdReader(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
        addReferenceProperties(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
        addInjectables(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
        JsonPOJOBuilder.Value findPOJOBuilderConfig = beanDescription.findPOJOBuilderConfig();
        if (findPOJOBuilderConfig == null) {
            str = "build";
        } else {
            str = findPOJOBuilderConfig.buildMethodName;
        }
        AnnotatedMethod findMethod = beanDescription.findMethod(str, (Class<?>[]) null);
        if (findMethod != null && config.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(findMethod.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        constructBeanDeserializerBuilder.setPOJOBuilder(findMethod, findPOJOBuilderConfig);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier updateBuilder : this._factoryConfig.deserializerModifiers()) {
                constructBeanDeserializerBuilder = updateBuilder.updateBuilder(config, beanDescription, constructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> buildBuilderBased = constructBeanDeserializerBuilder.buildBuilderBased(javaType, str);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyDeserializer : this._factoryConfig.deserializerModifiers()) {
                buildBuilderBased = modifyDeserializer.modifyDeserializer(config, beanDescription, buildBuilderBased);
            }
        }
        return buildBuilderBased;
    }

    /* access modifiers changed from: protected */
    public void addObjectIdReader(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        PropertyBasedObjectIdGenerator propertyBasedObjectIdGenerator;
        JavaType javaType;
        SettableBeanProperty settableBeanProperty;
        ObjectIdInfo objectIdInfo = beanDescription.getObjectIdInfo();
        if (objectIdInfo != null) {
            Class<? extends ObjectIdGenerator<?>> generatorType = objectIdInfo.getGeneratorType();
            ObjectIdResolver objectIdResolverInstance = deserializationContext.objectIdResolverInstance(beanDescription.getClassInfo(), objectIdInfo);
            if (generatorType == ObjectIdGenerators.PropertyGenerator.class) {
                PropertyName propertyName = objectIdInfo.getPropertyName();
                settableBeanProperty = beanDeserializerBuilder.findProperty(propertyName);
                if (settableBeanProperty != null) {
                    JavaType type = settableBeanProperty.getType();
                    javaType = type;
                    propertyBasedObjectIdGenerator = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
                } else {
                    throw new IllegalArgumentException("Invalid Object Id definition for " + beanDescription.getBeanClass().getName() + ": can not find property with name '" + propertyName + "'");
                }
            } else {
                JavaType javaType2 = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType(generatorType), (Class<?>) ObjectIdGenerator.class)[0];
                settableBeanProperty = null;
                propertyBasedObjectIdGenerator = deserializationContext.objectIdGeneratorInstance(beanDescription.getClassInfo(), objectIdInfo);
                javaType = javaType2;
            }
            JsonDeserializer<Object> findRootValueDeserializer = deserializationContext.findRootValueDeserializer(javaType);
            beanDeserializerBuilder.setObjectIdReader(ObjectIdReader.construct(javaType, objectIdInfo.getPropertyName(), propertyBasedObjectIdGenerator, findRootValueDeserializer, settableBeanProperty, objectIdResolverInstance));
        }
    }

    public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        SettableBeanProperty constructSettableProperty;
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDeserializerBuilder constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        constructBeanDeserializerBuilder.setValueInstantiator(findValueInstantiator(deserializationContext, beanDescription));
        addBeanProps(deserializationContext, beanDescription, constructBeanDeserializerBuilder);
        AnnotatedMethod findMethod = beanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (!(findMethod == null || (constructSettableProperty = constructSettableProperty(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.construct((MapperConfig<?>) deserializationContext.getConfig(), (AnnotatedMember) findMethod, new PropertyName("cause")), findMethod.getParameterType(0))) == null)) {
            constructBeanDeserializerBuilder.addOrReplaceProperty(constructSettableProperty, true);
        }
        constructBeanDeserializerBuilder.addIgnorable("localizedMessage");
        constructBeanDeserializerBuilder.addIgnorable("suppressed");
        constructBeanDeserializerBuilder.addIgnorable(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier updateBuilder : this._factoryConfig.deserializerModifiers()) {
                constructBeanDeserializerBuilder = updateBuilder.updateBuilder(config, beanDescription, constructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> build = constructBeanDeserializerBuilder.build();
        if (build instanceof BeanDeserializer) {
            build = new ThrowableDeserializer((BeanDeserializer) build);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyDeserializer : this._factoryConfig.deserializerModifiers()) {
                build = modifyDeserializer.modifyDeserializer(config, beanDescription, build);
            }
        }
        return build;
    }

    /* access modifiers changed from: protected */
    public BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        return new BeanDeserializerBuilder(beanDescription, deserializationContext.getConfig());
    }

    /* JADX WARNING: type inference failed for: r0v22, types: [com.fasterxml.jackson.databind.deser.SettableBeanProperty[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addBeanProps(com.fasterxml.jackson.databind.DeserializationContext r17, com.fasterxml.jackson.databind.BeanDescription r18, com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder r19) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            com.fasterxml.jackson.databind.JavaType r0 = r18.getType()
            boolean r0 = r0.isAbstract()
            r10 = 1
            r0 = r0 ^ r10
            if (r0 == 0) goto L_0x0022
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r19.getValueInstantiator()
            com.fasterxml.jackson.databind.DeserializationConfig r1 = r17.getConfig()
            com.fasterxml.jackson.databind.deser.SettableBeanProperty[] r0 = r0.getFromObjectArguments(r1)
            r12 = r0
            goto L_0x0023
        L_0x0022:
            r12 = 0
        L_0x0023:
            r13 = 0
            if (r12 == 0) goto L_0x0028
            r14 = r10
            goto L_0x0029
        L_0x0028:
            r14 = r13
        L_0x0029:
            com.fasterxml.jackson.databind.DeserializationConfig r0 = r17.getConfig()
            java.lang.Class r1 = r18.getBeanClass()
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r2 = r18.getClassInfo()
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r0 = r0.getDefaultPropertyIgnorals(r1, r2)
            if (r0 == 0) goto L_0x005a
            boolean r1 = r0.getIgnoreUnknown()
            r9.setIgnoreUnknownProperties(r1)
            java.util.Set r0 = r0.findIgnoredForDeserialization()
            java.util.Iterator r1 = r0.iterator()
        L_0x004a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x005e
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r9.addIgnorable(r2)
            goto L_0x004a
        L_0x005a:
            java.util.Set r0 = java.util.Collections.emptySet()
        L_0x005e:
            r5 = r0
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r0 = r18.findAnySetter()
            if (r0 == 0) goto L_0x006e
            com.fasterxml.jackson.databind.deser.SettableAnyProperty r1 = r6.constructAnySetter(r7, r8, r0)
            r9.setAnySetter(r1)
            r1 = 0
            goto L_0x007b
        L_0x006e:
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r1 = r18.findAnySetterField()
            if (r1 == 0) goto L_0x007b
            com.fasterxml.jackson.databind.deser.SettableAnyProperty r2 = r6.constructAnySetter(r7, r8, r1)
            r9.setAnySetter(r2)
        L_0x007b:
            if (r0 != 0) goto L_0x0099
            if (r1 != 0) goto L_0x0099
            java.util.Set r0 = r18.getIgnoredPropertyNames()
            if (r0 == 0) goto L_0x0099
            java.util.Iterator r0 = r0.iterator()
        L_0x0089:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0099
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r9.addIgnorable(r1)
            goto L_0x0089
        L_0x0099:
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.USE_GETTERS_AS_SETTERS
            boolean r0 = r7.isEnabled((com.fasterxml.jackson.databind.MapperFeature) r0)
            if (r0 == 0) goto L_0x00ab
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_GETTERS
            boolean r0 = r7.isEnabled((com.fasterxml.jackson.databind.MapperFeature) r0)
            if (r0 == 0) goto L_0x00ab
            r15 = r10
            goto L_0x00ac
        L_0x00ab:
            r15 = r13
        L_0x00ac:
            java.util.List r4 = r18.findProperties()
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            java.util.List r0 = r0.filterBeanProps(r1, r2, r3, r4, r5)
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r1 = r6._factoryConfig
            boolean r1 = r1.hasDeserializerModifiers()
            if (r1 == 0) goto L_0x00e3
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r1 = r6._factoryConfig
            java.lang.Iterable r1 = r1.deserializerModifiers()
            java.util.Iterator r1 = r1.iterator()
        L_0x00ce:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00e3
            java.lang.Object r2 = r1.next()
            com.fasterxml.jackson.databind.deser.BeanDeserializerModifier r2 = (com.fasterxml.jackson.databind.deser.BeanDeserializerModifier) r2
            com.fasterxml.jackson.databind.DeserializationConfig r3 = r17.getConfig()
            java.util.List r0 = r2.updateProperties(r3, r8, r0)
            goto L_0x00ce
        L_0x00e3:
            java.util.Iterator r0 = r0.iterator()
        L_0x00e7:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01b4
            java.lang.Object r1 = r0.next()
            com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r1 = (com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition) r1
            boolean r2 = r1.hasSetter()
            if (r2 == 0) goto L_0x0106
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r2 = r1.getSetter()
            com.fasterxml.jackson.databind.JavaType r2 = r2.getParameterType(r13)
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r2 = r6.constructSettableProperty(r7, r8, r1, r2)
            goto L_0x013f
        L_0x0106:
            boolean r2 = r1.hasField()
            if (r2 == 0) goto L_0x0119
            com.fasterxml.jackson.databind.introspect.AnnotatedField r2 = r1.getField()
            com.fasterxml.jackson.databind.JavaType r2 = r2.getType()
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r2 = r6.constructSettableProperty(r7, r8, r1, r2)
            goto L_0x013f
        L_0x0119:
            if (r15 == 0) goto L_0x013e
            boolean r2 = r1.hasGetter()
            if (r2 == 0) goto L_0x013e
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r2 = r1.getGetter()
            java.lang.Class r2 = r2.getRawType()
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L_0x0139
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r2 = r3.isAssignableFrom(r2)
            if (r2 == 0) goto L_0x013e
        L_0x0139:
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r2 = r6.constructSetterlessProperty(r7, r8, r1)
            goto L_0x013f
        L_0x013e:
            r2 = 0
        L_0x013f:
            if (r14 == 0) goto L_0x0198
            boolean r3 = r1.hasConstructorParameter()
            if (r3 == 0) goto L_0x0198
            java.lang.String r3 = r1.getName()
            if (r12 == 0) goto L_0x0168
            int r4 = r12.length
            r5 = r13
        L_0x014f:
            if (r5 >= r4) goto L_0x0168
            r11 = r12[r5]
            java.lang.String r10 = r11.getName()
            boolean r10 = r3.equals(r10)
            if (r10 == 0) goto L_0x0164
            boolean r10 = r11 instanceof com.fasterxml.jackson.databind.deser.CreatorProperty
            if (r10 == 0) goto L_0x0164
            com.fasterxml.jackson.databind.deser.CreatorProperty r11 = (com.fasterxml.jackson.databind.deser.CreatorProperty) r11
            goto L_0x0169
        L_0x0164:
            int r5 = r5 + 1
            r10 = 1
            goto L_0x014f
        L_0x0168:
            r11 = 0
        L_0x0169:
            if (r11 != 0) goto L_0x018e
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r4 = r12.length
            r5 = r13
        L_0x0172:
            if (r5 >= r4) goto L_0x0180
            r10 = r12[r5]
            java.lang.String r10 = r10.getName()
            r2.add(r10)
            int r5 = r5 + 1
            goto L_0x0172
        L_0x0180:
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r13] = r3
            r3 = 1
            r4[r3] = r2
            java.lang.String r2 = "Could not find creator property with name '%s' (known Creator properties: %s)"
            r7.reportBadPropertyDefinition(r8, r1, r2, r4)
            goto L_0x01b1
        L_0x018e:
            r3 = 1
            if (r2 == 0) goto L_0x0194
            r11.setFallbackSetter(r2)
        L_0x0194:
            r9.addCreatorProperty(r11)
            goto L_0x01b1
        L_0x0198:
            r3 = r10
            if (r2 == 0) goto L_0x01b1
            java.lang.Class[] r1 = r1.findViews()
            if (r1 != 0) goto L_0x01ab
            com.fasterxml.jackson.databind.MapperFeature r4 = com.fasterxml.jackson.databind.MapperFeature.DEFAULT_VIEW_INCLUSION
            boolean r4 = r7.isEnabled((com.fasterxml.jackson.databind.MapperFeature) r4)
            if (r4 != 0) goto L_0x01ab
            java.lang.Class<?>[] r1 = NO_VIEWS
        L_0x01ab:
            r2.setViews(r1)
            r9.addProperty(r2)
        L_0x01b1:
            r10 = r3
            goto L_0x00e7
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializerFactory.addBeanProps(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanDescription, com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder):void");
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyDefinition> filterBeanProps(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder, List<BeanPropertyDefinition> list, Set<String> set) throws JsonMappingException {
        Class<?> cls;
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap hashMap = new HashMap();
        for (BeanPropertyDefinition next : list) {
            String name = next.getName();
            if (!set.contains(name)) {
                if (!next.hasConstructorParameter()) {
                    if (next.hasSetter()) {
                        cls = next.getSetter().getRawParameterType(0);
                    } else {
                        cls = next.hasField() ? next.getField().getRawType() : null;
                    }
                    if (cls != null && isIgnorableType(deserializationContext.getConfig(), beanDescription, cls, hashMap)) {
                        beanDeserializerBuilder.addIgnorable(name);
                    }
                }
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void addReferenceProperties(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        JavaType javaType;
        Map<String, AnnotatedMember> findBackReferenceProperties = beanDescription.findBackReferenceProperties();
        if (findBackReferenceProperties != null) {
            for (Map.Entry next : findBackReferenceProperties.entrySet()) {
                String str = (String) next.getKey();
                AnnotatedMember annotatedMember = (AnnotatedMember) next.getValue();
                if (annotatedMember instanceof AnnotatedMethod) {
                    javaType = ((AnnotatedMethod) annotatedMember).getParameterType(0);
                } else {
                    javaType = annotatedMember.getType();
                    if (annotatedMember instanceof AnnotatedParameter) {
                        deserializationContext.reportBadTypeDefinition(beanDescription, "Can not bind back references as Creator parameters: type %s (reference '%s', parameter index #%d)", beanDescription.getBeanClass().getName(), str, Integer.valueOf(((AnnotatedParameter) annotatedMember).getIndex()));
                    }
                }
                beanDeserializerBuilder.addBackReferenceProperty(str, constructSettableProperty(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.construct((MapperConfig<?>) deserializationContext.getConfig(), annotatedMember, PropertyName.construct(str)), javaType));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addInjectables(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        Map<Object, AnnotatedMember> findInjectables = beanDescription.findInjectables();
        if (findInjectables != null) {
            for (Map.Entry next : findInjectables.entrySet()) {
                AnnotatedMember annotatedMember = (AnnotatedMember) next.getValue();
                beanDeserializerBuilder.addInjectable(PropertyName.construct(annotatedMember.getName()), annotatedMember.getType(), beanDescription.getClassAnnotations(), annotatedMember, next.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    public SettableAnyProperty constructAnySetter(DeserializationContext deserializationContext, BeanDescription beanDescription, AnnotatedMember annotatedMember) throws JsonMappingException {
        JavaType javaType;
        if (annotatedMember instanceof AnnotatedMethod) {
            javaType = ((AnnotatedMethod) annotatedMember).getParameterType(1);
        } else {
            javaType = annotatedMember instanceof AnnotatedField ? ((AnnotatedField) annotatedMember).getType().getContentType() : null;
        }
        JavaType resolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, javaType);
        BeanProperty.Std std = new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), resolveMemberAndTypeAnnotations, (PropertyName) null, beanDescription.getClassAnnotations(), annotatedMember, PropertyMetadata.STD_OPTIONAL);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (findDeserializerFromAnnotation == null) {
            findDeserializerFromAnnotation = (JsonDeserializer) resolveMemberAndTypeAnnotations.getValueHandler();
        }
        return new SettableAnyProperty(std, annotatedMember, resolveMemberAndTypeAnnotations, findDeserializerFromAnnotation != null ? deserializationContext.handlePrimaryContextualization(findDeserializerFromAnnotation, std, resolveMemberAndTypeAnnotations) : findDeserializerFromAnnotation, (TypeDeserializer) resolveMemberAndTypeAnnotations.getTypeHandler());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.fasterxml.jackson.databind.deser.SettableBeanProperty} */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.fasterxml.jackson.databind.BeanProperty, com.fasterxml.jackson.databind.deser.SettableBeanProperty] */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.fasterxml.jackson.databind.deser.SettableBeanProperty] */
    /* JADX WARNING: type inference failed for: r3v2, types: [com.fasterxml.jackson.databind.deser.impl.FieldProperty] */
    /* JADX WARNING: type inference failed for: r3v3, types: [com.fasterxml.jackson.databind.deser.impl.MethodProperty] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.deser.SettableBeanProperty constructSettableProperty(com.fasterxml.jackson.databind.DeserializationContext r10, com.fasterxml.jackson.databind.BeanDescription r11, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r12, com.fasterxml.jackson.databind.JavaType r13) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r9 = this;
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = r12.getNonConstructorMutator()
            if (r0 != 0) goto L_0x000e
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "No non-constructor mutator available"
            r10.reportBadPropertyDefinition(r11, r12, r2, r1)
        L_0x000e:
            com.fasterxml.jackson.databind.JavaType r13 = r9.resolveMemberAndTypeAnnotations(r10, r0, r13)
            java.lang.Object r1 = r13.getTypeHandler()
            r6 = r1
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r6 = (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) r6
            boolean r1 = r0 instanceof com.fasterxml.jackson.databind.introspect.AnnotatedMethod
            if (r1 == 0) goto L_0x002d
            com.fasterxml.jackson.databind.deser.impl.MethodProperty r1 = new com.fasterxml.jackson.databind.deser.impl.MethodProperty
            com.fasterxml.jackson.databind.util.Annotations r7 = r11.getClassAnnotations()
            r8 = r0
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r8 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r8
            r3 = r1
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x003c
        L_0x002d:
            com.fasterxml.jackson.databind.deser.impl.FieldProperty r1 = new com.fasterxml.jackson.databind.deser.impl.FieldProperty
            com.fasterxml.jackson.databind.util.Annotations r7 = r11.getClassAnnotations()
            r8 = r0
            com.fasterxml.jackson.databind.introspect.AnnotatedField r8 = (com.fasterxml.jackson.databind.introspect.AnnotatedField) r8
            r3 = r1
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8)
        L_0x003c:
            com.fasterxml.jackson.databind.JsonDeserializer r11 = r9.findDeserializerFromAnnotation(r10, r0)
            if (r11 != 0) goto L_0x0048
            java.lang.Object r11 = r13.getValueHandler()
            com.fasterxml.jackson.databind.JsonDeserializer r11 = (com.fasterxml.jackson.databind.JsonDeserializer) r11
        L_0x0048:
            if (r11 == 0) goto L_0x0052
            com.fasterxml.jackson.databind.JsonDeserializer r10 = r10.handlePrimaryContextualization(r11, r1, r13)
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r1 = r1.withValueDeserializer(r10)
        L_0x0052:
            com.fasterxml.jackson.databind.AnnotationIntrospector$ReferenceProperty r10 = r12.findReferenceType()
            if (r10 == 0) goto L_0x0065
            boolean r11 = r10.isManagedReference()
            if (r11 == 0) goto L_0x0065
            java.lang.String r10 = r10.getName()
            r1.setManagedReferenceName(r10)
        L_0x0065:
            com.fasterxml.jackson.databind.introspect.ObjectIdInfo r10 = r12.findObjectIdInfo()
            if (r10 == 0) goto L_0x006e
            r1.setObjectIdInfo(r10)
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializerFactory.constructSettableProperty(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.BeanDescription, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition, com.fasterxml.jackson.databind.JavaType):com.fasterxml.jackson.databind.deser.SettableBeanProperty");
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructSetterlessProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition) throws JsonMappingException {
        AnnotatedMethod getter = beanPropertyDefinition.getGetter();
        JavaType resolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, getter, getter.getType());
        SetterlessProperty setterlessProperty = new SetterlessProperty(beanPropertyDefinition, resolveMemberAndTypeAnnotations, (TypeDeserializer) resolveMemberAndTypeAnnotations.getTypeHandler(), beanDescription.getClassAnnotations(), getter);
        JsonDeserializer<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, getter);
        if (findDeserializerFromAnnotation == null) {
            findDeserializerFromAnnotation = (JsonDeserializer) resolveMemberAndTypeAnnotations.getValueHandler();
        }
        return findDeserializerFromAnnotation != null ? setterlessProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(findDeserializerFromAnnotation, setterlessProperty, resolveMemberAndTypeAnnotations)) : setterlessProperty;
    }

    /* access modifiers changed from: protected */
    public boolean isPotentialBeanType(Class<?> cls) {
        String canBeABeanType = ClassUtil.canBeABeanType(cls);
        if (canBeABeanType != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + canBeABeanType + ") as a Bean");
        } else if (!ClassUtil.isProxyType(cls)) {
            String isLocalType = ClassUtil.isLocalType(cls, true);
            if (isLocalType == null) {
                return true;
            }
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + isLocalType + ") as a Bean");
        } else {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + cls.getName() + " as a Bean");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isIgnorableType(DeserializationConfig deserializationConfig, BeanDescription beanDescription, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean bool = map.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        ConfigOverride findConfigOverride = deserializationConfig.findConfigOverride(cls);
        if (findConfigOverride != null) {
            bool = findConfigOverride.getIsIgnoredType();
        }
        if (bool == null) {
            bool = deserializationConfig.getAnnotationIntrospector().isIgnorableType(deserializationConfig.introspectClassAnnotations(cls).getClassInfo());
            if (bool == null) {
                bool = Boolean.FALSE;
            }
        }
        map.put(cls, bool);
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void checkIllegalTypes(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        String name = javaType.getRawClass().getName();
        if (this._cfgIllegalClassNames.contains(name)) {
            deserializationContext.reportBadTypeDefinition(beanDescription, "Illegal type (%s) to deserialize: prevented for security reasons", name);
        }
    }
}
