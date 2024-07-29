package expo.modules.sensors;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"<anonymous>", "", "R", "P0", "<anonymous parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$5", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class SensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$1 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ Function0 $listenerDecorator$inlined;
    final /* synthetic */ Function0 $sensorProxyGetter$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$1(Function0 function0, Function0 function02) {
        super(2);
        this.$listenerDecorator$inlined = function0;
        this.$sensorProxyGetter$inlined = function02;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String str = (String) promise;
        Function0 function0 = this.$listenerDecorator$inlined;
        if (function0 != null) {
            function0.invoke();
        }
        ((SensorProxy) this.$sensorProxyGetter$inlined.invoke()).stopObserving();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
