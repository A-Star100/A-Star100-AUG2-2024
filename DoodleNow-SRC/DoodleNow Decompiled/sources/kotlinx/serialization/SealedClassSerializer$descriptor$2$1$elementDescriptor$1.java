package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SealedSerializer.kt */
final class SealedClassSerializer$descriptor$2$1$elementDescriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    final /* synthetic */ KSerializer<? extends T>[] $subclassSerializers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SealedClassSerializer$descriptor$2$1$elementDescriptor$1(KSerializer<? extends T>[] kSerializerArr) {
        super(1);
        this.$subclassSerializers = kSerializerArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        for (KSerializer descriptor : ArraysKt.distinct((T[]) this.$subclassSerializers)) {
            SerialDescriptor descriptor2 = descriptor.getDescriptor();
            ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, descriptor2.getSerialName(), descriptor2, (List) null, false, 12, (Object) null);
        }
    }
}
