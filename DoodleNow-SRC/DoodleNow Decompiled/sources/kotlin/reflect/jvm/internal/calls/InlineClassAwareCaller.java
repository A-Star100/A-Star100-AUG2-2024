package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InlineClassAwareCaller.kt */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        if ((r0 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r9, kotlin.reflect.jvm.internal.calls.Caller<? extends M> r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "caller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r8.<init>()
            r8.caller = r10
            r8.isDefault = r11
            r10 = r8
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller r10 = (kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r9.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Class r10 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r10)
            r11 = 0
            if (r10 == 0) goto L_0x0027
            java.lang.reflect.Method r10 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getBoxMethod(r10, r9)
            goto L_0x0028
        L_0x0027:
            r10 = r11
        L_0x0028:
            r0 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r0
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0041
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r9 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            kotlin.ranges.IntRange$Companion r11 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r11 = r11.getEMPTY()
            java.lang.reflect.Method[] r0 = new java.lang.reflect.Method[r1]
            r9.<init>(r11, r0, r10)
            goto L_0x0160
        L_0x0041:
            kotlin.reflect.jvm.internal.calls.Caller<M> r0 = r8.caller
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            java.lang.String r3 = "descriptor.containingDeclaration"
            r4 = -1
            r5 = 1
            if (r2 == 0) goto L_0x004c
            goto L_0x0072
        L_0x004c:
            boolean r2 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r2 == 0) goto L_0x0055
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r0 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0055:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r9.getDispatchReceiverParameter()
            if (r0 == 0) goto L_0x0071
            kotlin.reflect.jvm.internal.calls.Caller<M> r0 = r8.caller
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r0 != 0) goto L_0x0071
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r0)
            if (r0 == 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r4 = r5
            goto L_0x0072
        L_0x0071:
            r4 = r1
        L_0x0072:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r2 = r9.getExtensionReceiverParameter()
            if (r2 == 0) goto L_0x0082
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            goto L_0x0083
        L_0x0082:
            r2 = r11
        L_0x0083:
            if (r2 == 0) goto L_0x0089
            r0.add(r2)
            goto L_0x00cc
        L_0x0089:
            boolean r2 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r2 == 0) goto L_0x00b2
            r2 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r2.getConstructedClass()
            java.lang.String r3 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r3 = r2.isInner()
            if (r3 == 0) goto L_0x00cc
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r2.getContainingDeclaration()
            java.lang.String r3 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r2.getDefaultType()
            r0.add(r2)
            goto L_0x00cc
        L_0x00b2:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x00cc
            boolean r3 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r2)
            if (r3 == 0) goto L_0x00cc
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r2.getDefaultType()
            r0.add(r2)
        L_0x00cc:
            java.util.List r2 = r9.getValueParameters()
            java.lang.String r3 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00db:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00f2
            java.lang.Object r3 = r2.next()
            r6 = r0
            java.util.Collection r6 = (java.util.Collection) r6
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            r6.add(r3)
            goto L_0x00db
        L_0x00f2:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.List r0 = (java.util.List) r0
            boolean r2 = r8.isDefault
            if (r2 == 0) goto L_0x0105
            int r2 = r0.size()
            int r2 = r2 + 31
            int r2 = r2 / 32
            int r2 = r2 + r5
            goto L_0x0106
        L_0x0105:
            r2 = r1
        L_0x0106:
            boolean r3 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r3 == 0) goto L_0x0114
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3
            boolean r3 = r3.isSuspend()
            if (r3 == 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r5 = r1
        L_0x0115:
            int r2 = r2 + r5
            int r3 = r0.size()
            int r3 = r3 + r4
            int r3 = r3 + r2
            r2 = r8
            kotlin.reflect.jvm.internal.calls.Caller r2 = (kotlin.reflect.jvm.internal.calls.Caller) r2
            int r5 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r2)
            if (r5 != r3) goto L_0x0163
            int r2 = java.lang.Math.max(r4, r1)
            int r5 = r0.size()
            int r5 = r5 + r4
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r2, (int) r5)
            java.lang.reflect.Method[] r5 = new java.lang.reflect.Method[r3]
        L_0x0134:
            if (r1 >= r3) goto L_0x015b
            int r6 = r2.getFirst()
            int r7 = r2.getLast()
            if (r1 > r7) goto L_0x0155
            if (r6 > r1) goto L_0x0155
            int r6 = r1 - r4
            java.lang.Object r6 = r0.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            java.lang.Class r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r6)
            if (r6 == 0) goto L_0x0155
            java.lang.reflect.Method r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getUnboxMethod(r6, r9)
            goto L_0x0156
        L_0x0155:
            r6 = r11
        L_0x0156:
            r5[r1] = r6
            int r1 = r1 + 1
            goto L_0x0134
        L_0x015b:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r9 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r9.<init>(r2, r5, r10)
        L_0x0160:
            r8.data = r9
            return
        L_0x0163:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r10 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            r11.<init>(r0)
            int r0 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r2)
            r11.append(r0)
            java.lang.String r0 = " != "
            r11.append(r0)
            r11.append(r3)
            java.lang.String r0 = "\nCalling: "
            r11.append(r0)
            r11.append(r9)
            java.lang.String r9 = "\nParameter types: "
            r11.append(r9)
            java.util.List r9 = r8.getParameterTypes()
            r11.append(r9)
            java.lang.String r9 = ")\nDefault: "
            r11.append(r9)
            boolean r9 = r8.isDefault
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    public M getMember() {
        return this.caller.getMember();
    }

    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InlineClassAwareCaller.kt */
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            Intrinsics.checkNotNullParameter(intRange, "argumentRange");
            Intrinsics.checkNotNullParameter(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        r0 = r0.invoke((java.lang.Object) null, new java.lang.Object[]{r10});
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call(java.lang.Object[] r10) {
        /*
            r9 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = r9.data
            kotlin.ranges.IntRange r1 = r0.component1()
            java.lang.reflect.Method[] r2 = r0.component2()
            java.lang.reflect.Method r0 = r0.component3()
            int r3 = r10.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r10, r3)
            java.lang.String r4 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r4 = r1.getFirst()
            int r1 = r1.getLast()
            r5 = 0
            if (r4 > r1) goto L_0x004d
        L_0x0028:
            r6 = r2[r4]
            r7 = r10[r4]
            if (r6 == 0) goto L_0x0046
            if (r7 == 0) goto L_0x0037
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r7 = r6.invoke(r7, r8)
            goto L_0x0046
        L_0x0037:
            java.lang.Class r6 = r6.getReturnType()
            java.lang.String r7 = "method.returnType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.reflect.Type r6 = (java.lang.reflect.Type) r6
            java.lang.Object r7 = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(r6)
        L_0x0046:
            r3[r4] = r7
            if (r4 == r1) goto L_0x004d
            int r4 = r4 + 1
            goto L_0x0028
        L_0x004d:
            kotlin.reflect.jvm.internal.calls.Caller<M> r10 = r9.caller
            java.lang.Object r10 = r10.call(r3)
            if (r0 == 0) goto L_0x0063
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r5] = r10
            r2 = 0
            java.lang.Object r0 = r0.invoke(r2, r1)
            if (r0 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r10 = r0
        L_0x0063:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.call(java.lang.Object[]):java.lang.Object");
    }
}
