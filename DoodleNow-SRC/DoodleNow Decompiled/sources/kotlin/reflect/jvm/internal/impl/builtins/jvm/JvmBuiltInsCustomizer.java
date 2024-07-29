package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final NotNullLazyValue cloneableType$delegate;
    /* access modifiers changed from: private */
    public final JavaToKotlinClassMapper j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    /* access modifiers changed from: private */
    public final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    /* compiled from: JvmBuiltInsCustomizer.kt */
    private enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus[] r0 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.NOT_CONSIDERED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.DROP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus.VISIBLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.WhenMappings.<clinit>():void");
        }
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor moduleDescriptor2, StorageManager storageManager, Function0<JvmBuiltIns.Settings> function0) {
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor2;
        this.settings$delegate = storageManager.createLazyValue(function0);
        this.mockSerializableType = createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, storageManager));
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    static {
        Class<JvmBuiltInsCustomizer> cls = JvmBuiltInsCustomizer.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    /* access modifiers changed from: private */
    public final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager storageManager) {
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(this.moduleDescriptor, new FqName("java.io")), Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsKt.listOf(new LazyWrappedType(storageManager, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this))), SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), (ClassConstructorDescriptor) null);
        SimpleType defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "mockSerializableClass.defaultType");
        return defaultType;
    }

    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            SimpleType cloneableType = getCloneableType();
            Intrinsics.checkNotNullExpressionValue(cloneableType, "cloneableType");
            return CollectionsKt.listOf(cloneableType, this.mockSerializableType);
        } else if (JvmBuiltInsSignatures.INSTANCE.isSerializableInJava(fqNameUnsafe)) {
            return CollectionsKt.listOf(this.mockSerializableType);
        } else {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0112, code lost:
        if (r1 != 3) goto L_0x0127;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00be A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions(kotlin.reflect.jvm.internal.impl.name.Name r6, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r7) {
        /*
            r5 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "classDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope$Companion r0 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getCLONE_NAME()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0095
            boolean r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            if (r0 == 0) goto L_0x0095
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArrayOrPrimitiveArray((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r7)
            if (r0 == 0) goto L_0x0095
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r7 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r7
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r7.getClassProto()
            java.util.List r0 = r0.getFunctionList()
            java.lang.String r1 = "classDescriptor.classProto.functionList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x003f
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x003f
            goto L_0x0072
        L_0x003f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0043:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0072
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r1
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r7.getC()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r2 = r2.getNameResolver()
            int r1 = r1.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r2, r1)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope$Companion r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r2.getCLONE_NAME()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0043
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Collection r6 = (java.util.Collection) r6
            return r6
        L_0x0072:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r5.getCloneableType()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getMemberScope()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r1 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r1
            java.util.Collection r6 = r0.getContributedFunctions(r6, r1)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.lang.Object r6 = kotlin.collections.CollectionsKt.single(r6)
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = r5.createCloneForArray(r7, r6)
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r6)
            java.util.Collection r6 = (java.util.Collection) r6
            return r6
        L_0x0095:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Settings r0 = r5.getSettings()
            boolean r0 = r0.isAdditionalBuiltInsFeatureSupported()
            if (r0 != 0) goto L_0x00a6
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Collection r6 = (java.util.Collection) r6
            return r6
        L_0x00a6:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2 r0 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2
            r0.<init>(r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.util.Collection r6 = r5.getAdditionalFunctions(r7, r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r6 = r6.iterator()
        L_0x00be:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0137
            java.lang.Object r1 = r6.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r1
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r1.getContainingDeclaration()
            java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt.createMappedTypeParametersSubstitution(r2, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r2 = r2.buildSubstitutor()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r1.substitute(r2)
            java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r2 = r2.newCopyBuilder()
            r3 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            r2.setOwner(r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r3 = r7.getThisAsReceiverParameter()
            r2.setDispatchReceiverParameter(r3)
            r2.setPreserveSourceElement()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r1
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r1 = r5.getJdkMethodStatus(r1)
            int[] r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
            r3 = 1
            r4 = 0
            if (r1 == r3) goto L_0x011d
            r3 = 2
            if (r1 == r3) goto L_0x0115
            r3 = 3
            if (r1 == r3) goto L_0x0131
            goto L_0x0127
        L_0x0115:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r5.getNotConsideredDeprecation()
            r2.setAdditionalAnnotations(r1)
            goto L_0x0127
        L_0x011d:
            boolean r1 = kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt.isFinalClass(r7)
            if (r1 == 0) goto L_0x0124
            goto L_0x0131
        L_0x0124:
            r2.setHiddenForResolutionEverywhereBesideSupercalls()
        L_0x0127:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = r2.build()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r4 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r4
        L_0x0131:
            if (r4 == 0) goto L_0x00be
            r0.add(r4)
            goto L_0x00be
        L_0x0137:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctions(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r2 = (r2 = r2.getUnsubstitutedMemberScope()).getFunctionNames();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionsNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2) {
        /*
            r1 = this;
            java.lang.String r0 = "classDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Settings r0 = r1.getSettings()
            boolean r0 = r0.isAdditionalBuiltInsFeatureSupported()
            if (r0 != 0) goto L_0x0014
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
            return r2
        L_0x0014:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r2 = r1.getJavaAnalogue(r2)
            if (r2 == 0) goto L_0x0026
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r2 = r2.getUnsubstitutedMemberScope()
            if (r2 == 0) goto L_0x0026
            java.util.Set r2 = r2.getFunctionNames()
            if (r2 != 0) goto L_0x002a
        L_0x0026:
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctionsNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Set");
    }

    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor classDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null) {
            return CollectionsKt.emptyList();
        }
        DeclarationDescriptor declarationDescriptor = javaAnalogue;
        Iterable<ClassDescriptor> mapPlatformClass = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(declarationDescriptor), FallbackBuiltIns.Companion.getInstance());
        ClassDescriptor classDescriptor2 = (ClassDescriptor) CollectionsKt.lastOrNull(mapPlatformClass);
        if (classDescriptor2 == null) {
            return CollectionsKt.emptyList();
        }
        SmartSet.Companion companion = SmartSet.Companion;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mapPlatformClass, 10));
        for (ClassDescriptor fqNameSafe : mapPlatformClass) {
            arrayList.add(DescriptorUtilsKt.getFqNameSafe(fqNameSafe));
        }
        SmartSet create = companion.create((List) arrayList);
        boolean isMutable = this.j2kClassMapper.isMutable(classDescriptor);
        MemberScope unsubstitutedMemberScope = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(declarationDescriptor), new JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(javaAnalogue, classDescriptor2)).getUnsubstitutedMemberScope();
        Intrinsics.checkNotNullExpressionValue(unsubstitutedMemberScope, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection arrayList2 = new ArrayList();
        for (Object next : (Iterable) function1.invoke(unsubstitutedMemberScope)) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) next;
            if (simpleFunctionDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION && simpleFunctionDescriptor.getVisibility().isPublicAPI() && !KotlinBuiltIns.isDeprecated(simpleFunctionDescriptor)) {
                Collection<? extends FunctionDescriptor> overriddenDescriptors = simpleFunctionDescriptor.getOverriddenDescriptors();
                Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "analogueMember.overriddenDescriptors");
                Iterable iterable = overriddenDescriptors;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DeclarationDescriptor containingDeclaration = ((FunctionDescriptor) it.next()).getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "it.containingDeclaration");
                        if (create.contains(DescriptorUtilsKt.getFqNameSafe(containingDeclaration))) {
                            break;
                        }
                    }
                }
                if (!isMutabilityViolation(simpleFunctionDescriptor, isMutable)) {
                    arrayList2.add(next);
                }
            }
        }
        return (List) arrayList2;
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setOwner(deserializedClassDescriptor);
        newCopyBuilder.setVisibility(DescriptorVisibilities.PUBLIC);
        newCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        newCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        Object build = newCopyBuilder.build();
        Intrinsics.checkNotNull(build);
        return (SimpleFunctionDescriptor) build;
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z) {
        DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, (Object) null);
        if (z ^ JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, (ClassDescriptor) containingDeclaration, computeJvmDescriptor$default))) {
            return true;
        }
        Boolean ifAny = DFS.ifAny(CollectionsKt.listOf(simpleFunctionDescriptor), JvmBuiltInsCustomizer$$Lambda$0.INSTANCE, new JvmBuiltInsCustomizer$isMutabilityViolation$2(this));
        Intrinsics.checkNotNullExpressionValue(ifAny, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return ifAny.booleanValue();
    }

    /* access modifiers changed from: private */
    public static final Iterable isMutabilityViolation$lambda$7(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor functionDescriptor) {
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Object dfs = DFS.dfs(CollectionsKt.listOf((ClassDescriptor) containingDeclaration), new JvmBuiltInsCustomizer$$Lambda$1(this), new JvmBuiltInsCustomizer$getJdkMethodStatus$2(MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, (Object) null), new Ref.ObjectRef()));
        Intrinsics.checkNotNullExpressionValue(dfs, "jvmDescriptor = computeJ…CONSIDERED\n            })");
        return (JDKMemberStatus) dfs;
    }

    /* access modifiers changed from: private */
    public static final Iterable getJdkMethodStatus$lambda$9(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(jvmBuiltInsCustomizer, "this$0");
        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        Collection arrayList = new ArrayList();
        for (KotlinType constructor : supertypes) {
            ClassifierDescriptor declarationDescriptor = constructor.getConstructor().getDeclarationDescriptor();
            LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
            ClassifierDescriptor original = declarationDescriptor != null ? declarationDescriptor.getOriginal() : null;
            ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
            if (classDescriptor2 != null) {
                lazyJavaClassDescriptor = jvmBuiltInsCustomizer.getJavaAnalogue(classDescriptor2);
            }
            if (lazyJavaClassDescriptor != null) {
                arrayList.add(lazyJavaClassDescriptor);
            }
        }
        return (List) arrayList;
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor classDescriptor) {
        ClassId mapKotlinToJava;
        FqName asSingleFqName;
        if (KotlinBuiltIns.isAny(classDescriptor)) {
            return null;
        }
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        if (!KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe() || (mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe)) == null || (asSingleFqName = mapKotlinToJava.asSingleFqName()) == null) {
            return null;
        }
        ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), asSingleFqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
            return (LazyJavaClassDescriptor) resolveClassByFqName;
        }
        return null;
    }

    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null) {
            return CollectionsKt.emptyList();
        }
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(javaAnalogue), FallbackBuiltIns.Companion.getInstance(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            return CollectionsKt.emptyList();
        }
        ClassDescriptor classDescriptor2 = javaAnalogue;
        TypeSubstitutor buildSubstitutor = MappingUtilKt.createMappedTypeParametersSubstitution(mapJavaToKotlin$default, classDescriptor2).buildSubstitutor();
        Collection arrayList = new ArrayList();
        for (Object next : javaAnalogue.getConstructors()) {
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) next;
            if (classConstructorDescriptor.getVisibility().isPublicAPI()) {
                Collection<ClassConstructorDescriptor> constructors = mapJavaToKotlin$default.getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors, "defaultKotlinVersion.constructors");
                Iterable iterable = constructors;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ClassConstructorDescriptor classConstructorDescriptor2 = (ClassConstructorDescriptor) it.next();
                        Intrinsics.checkNotNullExpressionValue(classConstructorDescriptor2, "it");
                        if (getConstructors$isEffectivelyTheSameAs(classConstructorDescriptor2, buildSubstitutor, classConstructorDescriptor)) {
                            break;
                        }
                    }
                }
                if (!isTrivialCopyConstructorFor(classConstructorDescriptor, classDescriptor) && !KotlinBuiltIns.isDeprecated(classConstructorDescriptor) && !JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, classDescriptor2, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, (Object) null)))) {
                    arrayList.add(next);
                }
            }
        }
        Iterable<ClassConstructorDescriptor> iterable2 = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (ClassConstructorDescriptor classConstructorDescriptor3 : iterable2) {
            FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = classConstructorDescriptor3.newCopyBuilder();
            newCopyBuilder.setOwner(classDescriptor);
            newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
            newCopyBuilder.setPreserveSourceElement();
            newCopyBuilder.setSubstitution(buildSubstitutor.getSubstitution());
            if (!JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, classDescriptor2, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor3, false, false, 3, (Object) null)))) {
                newCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
            }
            Object build = newCopyBuilder.build();
            Intrinsics.checkNotNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((ClassConstructorDescriptor) build);
        }
        return (List) arrayList2;
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor constructorDescriptor, TypeSubstitutor typeSubstitutor, ConstructorDescriptor constructorDescriptor2) {
        return OverridingUtil.getBothWaysOverridability(constructorDescriptor, constructorDescriptor2.substitute(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, (Object) null);
        LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "functionDescriptor.name");
        Iterable<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !((Collection) contributedFunctions).isEmpty()) {
            for (SimpleFunctionDescriptor computeJvmDescriptor$default2 : contributedFunctions) {
                if (Intrinsics.areEqual((Object) MethodSignatureMappingKt.computeJvmDescriptor$default(computeJvmDescriptor$default2, false, false, 3, (Object) null), (Object) computeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor constructorDescriptor, ClassDescriptor classDescriptor) {
        if (constructorDescriptor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) CollectionsKt.single(valueParameters)).getType().getConstructor().getDeclarationDescriptor();
            if (Intrinsics.areEqual((Object) declarationDescriptor != null ? DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor) : null, (Object) DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) {
                return true;
            }
        }
        return false;
    }
}
