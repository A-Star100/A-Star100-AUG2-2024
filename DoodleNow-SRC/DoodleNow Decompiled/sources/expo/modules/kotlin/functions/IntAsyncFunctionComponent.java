package expo.modules.kotlin.functions;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BH\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012+\u0010\b\u001a'\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\f\b\u000b\u0012\b\b\u0003\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/functions/IntAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/AsyncFunctionComponent;", "", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "body", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "args", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function1;)V", "callUserImplementation", "", "promise", "Lexpo/modules/kotlin/Promise;", "appContext", "Lexpo/modules/kotlin/AppContext;", "callUserImplementation$expo_modules_core_release", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;Lexpo/modules/kotlin/AppContext;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AsyncFunctionComponent.kt */
public final class IntAsyncFunctionComponent extends AsyncFunctionComponent<Integer> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntAsyncFunctionComponent(String str, AnyType[] anyTypeArr, Function1<? super Object[], Integer> function1) {
        super(str, anyTypeArr, function1);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
    }

    public void callUserImplementation$expo_modules_core_release(Object[] objArr, Promise promise, AppContext appContext) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        promise.resolve(((Number) getBody().invoke(convertArgs(objArr, appContext))).intValue());
    }
}
