package expo.modules.kotlin.functions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u0001\"\u0006\b\u0004\u0010\u0005\u0018\u0001\"\u0006\b\u0005\u0010\u0006\u0018\u00012\u0010\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\bH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "R", "P0", "P1", "P2", "P3", "P4", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: AsyncFunctionBuilder.kt */
public final class AsyncFunctionBuilder$AsyncBody$20 extends Lambda implements Function1<Object[], R> {
    final /* synthetic */ Function5<P0, P1, P2, P3, P4, R> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFunctionBuilder$AsyncBody$20(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        super(1);
        this.$body = function5;
    }

    public final R invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        return this.$body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
    }
}
