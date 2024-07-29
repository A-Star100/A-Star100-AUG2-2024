package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012,\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0002\u0010\nJB\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u000b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\fX\u0004¢\u0006\u0002\n\u0000R4\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/jvm/functions/Function2;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Caching.kt */
final class ConcurrentHashMapParametrizedCache<T> implements ParametrizedSerializerCache<T> {
    private final ConcurrentHashMap<Class<?>, ParametrizedCacheEntry<T>> cache = new ConcurrentHashMap<>();
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;

    public ConcurrentHashMapParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> function2) {
        Intrinsics.checkNotNullParameter(function2, "compute");
        this.compute = function2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry();
     */
    /* renamed from: get-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2820getgIAlus(kotlin.reflect.KClass<java.lang.Object> r4, java.util.List<? extends kotlin.reflect.KType> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "types"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, kotlinx.serialization.internal.ParametrizedCacheEntry<T>> r0 = r3.cache
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.Class r1 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r4)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0025
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry
            r2.<init>()
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = r0
        L_0x0025:
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = (kotlinx.serialization.internal.ParametrizedCacheEntry) r2
            java.util.concurrent.ConcurrentHashMap r0 = r2.serializers
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.Object r1 = r0.get(r5)
            if (r1 != 0) goto L_0x005a
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0042 }
            kotlin.jvm.functions.Function2<kotlin.reflect.KClass<java.lang.Object>, java.util.List<? extends kotlin.reflect.KType>, kotlinx.serialization.KSerializer<T>> r1 = r3.compute     // Catch:{ all -> 0x0042 }
            java.lang.Object r4 = r1.invoke(r4, r5)     // Catch:{ all -> 0x0042 }
            kotlinx.serialization.KSerializer r4 = (kotlinx.serialization.KSerializer) r4     // Catch:{ all -> 0x0042 }
            java.lang.Object r4 = kotlin.Result.m1230constructorimpl(r4)     // Catch:{ all -> 0x0042 }
            goto L_0x004d
        L_0x0042:
            r4 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m1230constructorimpl(r4)
        L_0x004d:
            kotlin.Result r4 = kotlin.Result.m1229boximpl(r4)
            java.lang.Object r5 = r0.putIfAbsent(r5, r4)
            if (r5 != 0) goto L_0x0059
            r1 = r4
            goto L_0x005a
        L_0x0059:
            r1 = r5
        L_0x005a:
            java.lang.String r4 = "serializers.getOrPut(typ… { producer() }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r4 = r1.m1239unboximpl()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.ConcurrentHashMapParametrizedCache.m2820getgIAlus(kotlin.reflect.KClass, java.util.List):java.lang.Object");
    }
}
