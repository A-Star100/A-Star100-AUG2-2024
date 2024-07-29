package expo.modules.kotlin.views;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u0001\"\b\b\b\u0010\n*\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "P5", "P6", "T", "Landroid/view/View;", "<name for destructuring parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: ViewDefinitionBuilder.kt */
public final class ViewDefinitionBuilder$AsyncFunction$34 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ Function8<P0, P1, P2, P3, P4, P5, P6, Promise, R> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewDefinitionBuilder$AsyncFunction$34(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> function8) {
        super(2);
        this.$body = function8;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.$body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], promise);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
