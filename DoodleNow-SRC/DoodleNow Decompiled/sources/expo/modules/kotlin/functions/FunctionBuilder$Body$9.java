package expo.modules.kotlin.functions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "<name for destructuring parameter 0>", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: FunctionBuilder.kt */
public final class FunctionBuilder$Body$9 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ Function3<P0, P1, P2, R> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionBuilder$Body$9(Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        super(1);
        this.$body = function3;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        return this.$body.invoke(objArr[0], objArr[1], objArr[2]);
    }
}
