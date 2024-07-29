package expo.modules.sensors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class SensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ Function0 $listenerDecorator$inlined;
    final /* synthetic */ Function0 $sensorProxyGetter$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3(Function0 function0, Function0 function02) {
        super(1);
        this.$listenerDecorator$inlined = function0;
        this.$sensorProxyGetter$inlined = function02;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        String str = objArr[0];
        Function0 function0 = this.$listenerDecorator$inlined;
        if (function0 != null) {
            function0.invoke();
        }
        ((SensorProxy) this.$sensorProxyGetter$inlined.invoke()).startObserving();
        return Unit.INSTANCE;
    }
}
