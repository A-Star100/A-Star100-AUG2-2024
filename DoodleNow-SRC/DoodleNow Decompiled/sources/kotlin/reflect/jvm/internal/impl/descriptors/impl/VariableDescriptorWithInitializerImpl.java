package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected NullableLazyValue<ConstantValue<?>> compileTimeInitializer;
    protected Function0<NullableLazyValue<ConstantValue<?>>> compileTimeInitializerFactory;
    private final boolean isVar;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i != 5) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public boolean isVar() {
        return this.isVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, KotlinType kotlinType, boolean z, SourceElement sourceElement) {
        super(declarationDescriptor, annotations, name, kotlinType, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(3);
        }
        this.isVar = z;
    }

    public ConstantValue<?> getCompileTimeInitializer() {
        NullableLazyValue<ConstantValue<?>> nullableLazyValue = this.compileTimeInitializer;
        if (nullableLazyValue != null) {
            return (ConstantValue) nullableLazyValue.invoke();
        }
        return null;
    }

    public void setCompileTimeInitializerFactory(Function0<NullableLazyValue<ConstantValue<?>>> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(4);
        }
        setCompileTimeInitializer((NullableLazyValue<ConstantValue<?>>) null, function0);
    }

    public void setCompileTimeInitializer(NullableLazyValue<ConstantValue<?>> nullableLazyValue, Function0<NullableLazyValue<ConstantValue<?>>> function0) {
        if (function0 == null) {
            $$$reportNull$$$0(5);
        }
        this.compileTimeInitializerFactory = function0;
        if (nullableLazyValue == null) {
            nullableLazyValue = function0.invoke();
        }
        this.compileTimeInitializer = nullableLazyValue;
    }
}
