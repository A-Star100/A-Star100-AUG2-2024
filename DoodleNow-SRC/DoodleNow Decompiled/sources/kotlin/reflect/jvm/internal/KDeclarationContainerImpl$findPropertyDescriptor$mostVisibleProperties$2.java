package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "kotlin.jvm.PlatformType", "first", "second", "", "invoke", "(Lorg/jetbrains/kotlin/descriptors/DescriptorVisibility;Lorg/jetbrains/kotlin/descriptors/DescriptorVisibility;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
/* compiled from: KDeclarationContainerImpl.kt */
final class KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 extends Lambda implements Function2<DescriptorVisibility, DescriptorVisibility, Integer> {
    public static final KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 INSTANCE = new KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2();

    KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2() {
        super(2);
    }

    public final Integer invoke(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
        Integer compare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
        return Integer.valueOf(compare == null ? 0 : compare.intValue());
    }
}
