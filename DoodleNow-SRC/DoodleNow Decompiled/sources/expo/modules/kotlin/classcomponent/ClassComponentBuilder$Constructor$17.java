package expo.modules.kotlin.classcomponent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u0001\"\b\b\b\u0010\n*\u00020\u00012\u0010\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\fH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"<anonymous>", "", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "SharedObjectType", "<name for destructuring parameter 0>", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: ClassComponentBuilder.kt */
public final class ClassComponentBuilder$Constructor$17 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ Function8<P0, P1, P2, P3, P4, P5, P6, P7, SharedObjectType> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassComponentBuilder$Constructor$17(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends SharedObjectType> function8) {
        super(1);
        this.$body = function8;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        return this.$body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
    }
}
