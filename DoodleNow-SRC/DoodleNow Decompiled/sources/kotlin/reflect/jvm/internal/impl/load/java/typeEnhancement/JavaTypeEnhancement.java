package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;

/* compiled from: typeEnhancement.kt */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* compiled from: typeEnhancement.kt */
    private static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }

        public Result(KotlinType kotlinType, int i) {
            this.type = kotlinType;
            this.subtreeSize = i;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings2) {
        Intrinsics.checkNotNullParameter(javaResolverSettings2, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings2;
    }

    /* compiled from: typeEnhancement.kt */
    private static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }

        public SimpleResult(SimpleType simpleType, int i, boolean z) {
            this.type = simpleType;
            this.subtreeSize = i;
            this.forWarnings = z;
        }
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> function1, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), function1, 0, z).getType();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
        if (r13 == null) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r13, int r14, boolean r15) {
        /*
            r11 = this;
            r0 = r12
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0011
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r13 = 1
            r12.<init>(r1, r13)
            return r12
        L_0x0011:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto L_0x00b9
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.RawType
            r9 = r12
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r9 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r9
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getLowerBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r2 = r11
            r4 = r13
            r5 = r14
            r7 = r0
            r8 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r10 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getUpperBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            r10.getSubtreeSize()
            r13.getSubtreeSize()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0046
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r13.getType()
            if (r14 != 0) goto L_0x0046
            goto L_0x00ad
        L_0x0046:
            boolean r14 = r10.getForWarnings()
            if (r14 != 0) goto L_0x008b
            boolean r14 = r13.getForWarnings()
            if (r14 == 0) goto L_0x0053
            goto L_0x008b
        L_0x0053:
            if (r0 == 0) goto L_0x0072
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r12 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0061
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r9.getLowerBound()
        L_0x0061:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L_0x006b
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L_0x006b:
            r12.<init>(r14, r13)
            r1 = r12
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r1
            goto L_0x00ad
        L_0x0072:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L_0x007c
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L_0x007c:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L_0x0086
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L_0x0086:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r12, r13)
            goto L_0x00ad
        L_0x008b:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 == 0) goto L_0x009e
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0098
            r14 = r13
        L_0x0098:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r14, r13)
            if (r13 != 0) goto L_0x00a7
        L_0x009e:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r10.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r13 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r13
        L_0x00a7:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r13
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r13)
        L_0x00ad:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            int r13 = r10.getSubtreeSize()
            r12.<init>(r1, r13)
            goto L_0x00f1
        L_0x00b9:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x00f2
            r2 = r12
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r6 = 0
            r8 = 8
            r9 = 0
            r1 = r11
            r3 = r13
            r4 = r14
            r7 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = enhanceInflexible$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r14 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            boolean r15 = r13.getForWarnings()
            if (r15 == 0) goto L_0x00e1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = r13.getType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r15
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r15)
            goto L_0x00e7
        L_0x00e1:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r13.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r12
        L_0x00e7:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r12
            int r13 = r13.getSubtreeSize()
            r14.<init>(r12, r13)
            r12 = r14
        L_0x00f1:
            return r12
        L_0x00f2:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result");
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.SimpleResult enhanceInflexible(kotlin.reflect.jvm.internal.impl.types.SimpleType r19, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r20, int r21, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r22, boolean r23, boolean r24) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r22
            r3 = r24
            boolean r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPositionKt.shouldEnhance(r22)
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0015
            if (r23 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r7 = r5
            goto L_0x0016
        L_0x0015:
            r7 = r6
        L_0x0016:
            r8 = 0
            if (r4 != 0) goto L_0x0029
            java.util.List r4 = r19.getArguments()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0029
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r1.<init>(r8, r6, r5)
            return r1
        L_0x0029:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r19.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
            if (r4 != 0) goto L_0x0039
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r1.<init>(r8, r6, r5)
            return r1
        L_0x0039:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r21)
            java.lang.Object r9 = r1.invoke(r9)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r9 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r9
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.enhanceMutability(r4, r9, r2)
            java.lang.Boolean r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.getEnhancedNullability(r9, r2)
            if (r4 == 0) goto L_0x0053
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r4.getTypeConstructor()
            if (r10 != 0) goto L_0x0057
        L_0x0053:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r19.getConstructor()
        L_0x0057:
            r12 = r10
            java.lang.String r10 = "enhancedClassifier?.typeConstructor ?: constructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r10)
            int r10 = r21 + 1
            java.util.List r11 = r19.getArguments()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.List r13 = r12.getParameters()
            java.lang.String r14 = "typeConstructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r14 = r11.iterator()
            java.util.Iterator r15 = r13.iterator()
            java.util.ArrayList r6 = new java.util.ArrayList
            r5 = 10
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r5)
            int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r5)
            int r11 = java.lang.Math.min(r11, r13)
            r6.<init>(r11)
        L_0x008b:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L_0x0154
            boolean r11 = r15.hasNext()
            if (r11 == 0) goto L_0x0154
            java.lang.Object r11 = r14.next()
            java.lang.Object r13 = r15.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r13
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r11 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r11
            if (r7 != 0) goto L_0x00ae
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r23 = r7
            r7 = 0
            r5.<init>(r8, r7)
            goto L_0x0106
        L_0x00ae:
            r23 = r7
            boolean r5 = r11.isStarProjection()
            if (r5 != 0) goto L_0x00c3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r11.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5 = r5.unwrap()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r5 = r0.enhancePossiblyFlexible(r5, r1, r10, r3)
            goto L_0x0106
        L_0x00c3:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            java.lang.Object r5 = r1.invoke(r5)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = r5.getNullability()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            if (r5 != r7) goto L_0x00fe
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r11.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r5 = r5.unwrap()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(r5)
            r1 = 0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r8.makeNullableAsSpecified(r1)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(r5)
            r5 = 1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.makeNullableAsSpecified(r5)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r8, r1)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            r7.<init>(r1, r5)
            r5 = r7
            goto L_0x0106
        L_0x00fe:
            r5 = 1
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r7 = 0
            r1.<init>(r7, r5)
            r5 = r1
        L_0x0106:
            int r1 = r5.getSubtreeSize()
            int r10 = r10 + r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r5.getType()
            java.lang.String r7 = "arg.projectionKind"
            if (r1 == 0) goto L_0x0123
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r5.getType()
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r11.getProjectionKind()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(r1, r5, r13)
            goto L_0x0148
        L_0x0123:
            if (r4 == 0) goto L_0x0140
            boolean r1 = r11.isStarProjection()
            if (r1 != 0) goto L_0x0140
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r11.getType()
            java.lang.String r5 = "arg.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r11.getProjectionKind()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(r1, r5, r13)
            goto L_0x0148
        L_0x0140:
            if (r4 == 0) goto L_0x0147
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r7 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(r13)
            goto L_0x0148
        L_0x0147:
            r7 = 0
        L_0x0148:
            r6.add(r7)
            r1 = r20
            r7 = r23
            r5 = 10
            r8 = 0
            goto L_0x008b
        L_0x0154:
            java.util.List r6 = (java.util.List) r6
            int r10 = r10 - r21
            if (r4 != 0) goto L_0x0188
            if (r2 != 0) goto L_0x0188
            r1 = r6
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            if (r3 == 0) goto L_0x016d
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x016d
            goto L_0x0180
        L_0x016d:
            java.util.Iterator r1 = r1.iterator()
        L_0x0171:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0180
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r3 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r3
            if (r3 != 0) goto L_0x0188
            goto L_0x0171
        L_0x0180:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r3 = 0
            r7 = 0
            r1.<init>(r7, r10, r3)
            return r1
        L_0x0188:
            r3 = 0
            r7 = 0
            r1 = 3
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[] r1 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[r1]
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = r19.getAnnotations()
            r1[r3] = r5
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS
            if (r4 == 0) goto L_0x019a
            goto L_0x019b
        L_0x019a:
            r5 = r7
        L_0x019b:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r5
            r4 = 1
            r1[r4] = r5
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS()
            if (r2 == 0) goto L_0x01a8
            r8 = r5
            goto L_0x01a9
        L_0x01a8:
            r8 = r7
        L_0x01a9:
            r5 = 2
            r1[r5] = r8
            java.util.List r1 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r1)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.compositeAnnotationsOrSingle(r1)
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes r11 = kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.toDefaultAttributes(r1)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r1 = r19.getArguments()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r5 = r6.iterator()
            java.util.Iterator r7 = r1.iterator()
            java.util.ArrayList r8 = new java.util.ArrayList
            r13 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r13)
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r13)
            int r1 = java.lang.Math.min(r6, r1)
            r8.<init>(r1)
        L_0x01db:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x01fb
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x01fb
            java.lang.Object r1 = r5.next()
            java.lang.Object r6 = r7.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r6 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r6
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r1 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r1
            if (r1 != 0) goto L_0x01f6
            goto L_0x01f7
        L_0x01f6:
            r6 = r1
        L_0x01f7:
            r8.add(r6)
            goto L_0x01db
        L_0x01fb:
            r13 = r8
            java.util.List r13 = (java.util.List) r13
            if (r2 == 0) goto L_0x0205
            boolean r1 = r2.booleanValue()
            goto L_0x0209
        L_0x0205:
            boolean r1 = r19.isMarkedNullable()
        L_0x0209:
            r14 = r1
            r15 = 0
            r16 = 16
            r17 = 0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default((kotlin.reflect.jvm.internal.impl.types.TypeAttributes) r11, (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r12, (java.util.List) r13, (boolean) r14, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) r15, (int) r16, (java.lang.Object) r17)
            boolean r5 = r9.getDefinitelyNotNull()
            if (r5 == 0) goto L_0x021d
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r0.notNullTypeParameter(r1)
        L_0x021d:
            if (r2 == 0) goto L_0x0227
            boolean r2 = r9.isNullabilityQualifierForWarning()
            if (r2 == 0) goto L_0x0227
            r5 = r4
            goto L_0x0228
        L_0x0227:
            r5 = r3
        L_0x0228:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r2 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult
            r2.<init>(r1, r10, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhanceInflexible(kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.jvm.functions.Function1, int, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition, boolean, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult");
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameterImpl(simpleType);
    }
}
