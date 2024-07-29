package expo.modules.kotlin.objects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ObjectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ Function0 $body$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3(Function0 function0) {
        super(1);
        this.$body$inlined = function0;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        String str = objArr[0];
        this.$body$inlined.invoke();
        return Unit.INSTANCE;
    }
}
