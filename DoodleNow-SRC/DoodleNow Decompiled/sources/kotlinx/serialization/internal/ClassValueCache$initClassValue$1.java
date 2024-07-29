package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0014¨\u0006\u0006"}, d2 = {"kotlinx/serialization/internal/ClassValueCache$initClassValue$1", "Ljava/lang/ClassValue;", "Lkotlinx/serialization/internal/CacheEntry;", "computeValue", "type", "Ljava/lang/Class;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Caching.kt */
public final class ClassValueCache$initClassValue$1 extends ClassValue<CacheEntry<T>> {
    final /* synthetic */ ClassValueCache<T> this$0;

    ClassValueCache$initClassValue$1(ClassValueCache<T> classValueCache) {
        this.this$0 = classValueCache;
    }

    /* access modifiers changed from: protected */
    public CacheEntry<T> computeValue(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        return new CacheEntry<>((KSerializer) this.this$0.compute.invoke(JvmClassMappingKt.getKotlinClass(cls)));
    }
}
