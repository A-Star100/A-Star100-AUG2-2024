package expo.modules.kotlin.views;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u0001\"\u0006\b\u0004\u0010\u0005\u0018\u0001\"\b\b\u0005\u0010\u0006*\u00020\u00072\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\tH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "R", "P0", "P1", "P2", "P3", "T", "Landroid/view/View;", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: ViewDefinitionBuilder.kt */
public final class ViewDefinitionBuilder$AsyncFunction$16 extends Lambda implements Function1<Object[], R> {
    final /* synthetic */ Function4<P0, P1, P2, P3, R> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewDefinitionBuilder$AsyncFunction$16(Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        super(1);
        this.$body = function4;
    }

    public final R invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        return this.$body.invoke(objArr[0], objArr[1], objArr[2], objArr[3]);
    }
}
