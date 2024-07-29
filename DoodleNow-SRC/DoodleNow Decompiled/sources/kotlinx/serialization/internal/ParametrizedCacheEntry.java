package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JN\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\rH\bø\u0001\u0001ø\u0001\u0002ø\u0001\u0003ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR1\u0010\u0004\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\b0\u0005X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0016\n\u0002\b\u0019\n\u0005\b20\u0001\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "T", "", "()V", "serializers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/reflect/KType;", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "computeIfAbsent", "types", "producer", "Lkotlin/Function0;", "computeIfAbsent-gIAlu-s", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Caching.kt */
final class ParametrizedCacheEntry<T> {
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<List<KType>, Result<KSerializer<T>>> serializers = new ConcurrentHashMap<>();

    /* renamed from: computeIfAbsent-gIAlu-s  reason: not valid java name */
    public final Object m2823computeIfAbsentgIAlus(List<? extends KType> list, Function0<? extends KSerializer<T>> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "types");
        Intrinsics.checkNotNullParameter(function0, "producer");
        ConcurrentMap access$getSerializers$p = this.serializers;
        Object obj2 = access$getSerializers$p.get(list);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m1230constructorimpl((KSerializer) function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1230constructorimpl(ResultKt.createFailure(th));
            }
            Result r4 = Result.m1229boximpl(obj);
            Object putIfAbsent = access$getSerializers$p.putIfAbsent(list, r4);
            obj2 = putIfAbsent == null ? r4 : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj2).m1239unboximpl();
    }
}
