package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$2 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$2 INSTANCE = new OperatorChecks$checks$2();

    OperatorChecks$checks$2() {
        super(1);
    }

    private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) declarationDescriptor);
    }

    public final String invoke(FunctionDescriptor functionDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(functionDescriptor, "$this$$receiver");
        AbstractModifierChecks abstractModifierChecks = OperatorChecks.INSTANCE;
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        if (!invoke$isAny(containingDeclaration)) {
            Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            Iterable iterable = overriddenDescriptors;
            if (!((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DeclarationDescriptor containingDeclaration2 = ((FunctionDescriptor) it.next()).getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "it.containingDeclaration");
                    if (invoke$isAny(containingDeclaration2)) {
                        break;
                    }
                }
                z = true;
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return "must override ''equals()'' in Any";
        }
        return null;
    }
}
