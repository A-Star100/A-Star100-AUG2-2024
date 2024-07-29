package expo.modules.kotlin.defaultmodules;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.PromiseKt;
import expo.modules.kotlin.exception.UnexpectedException;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "<name for destructuring parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$18"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$4 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ NativeModulesProxyModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$4(NativeModulesProxyModule nativeModulesProxyModule) {
        super(2);
        this.this$0 = nativeModulesProxyModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        NativeModulesProxy nativeModulesProxy;
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String str = objArr[0];
        String str2 = objArr[1];
        ReadableArray readableArray = objArr[2];
        String str3 = str2;
        String str4 = str;
        com.facebook.react.bridge.Promise bridgePromise = PromiseKt.toBridgePromise(promise);
        WeakReference<NativeModulesProxy> legacyModulesProxyHolder$expo_modules_core_release = this.this$0.getAppContext().getLegacyModulesProxyHolder$expo_modules_core_release();
        if (legacyModulesProxyHolder$expo_modules_core_release == null || (nativeModulesProxy = (NativeModulesProxy) legacyModulesProxyHolder$expo_modules_core_release.get()) == null) {
            throw new UnexpectedException("The legacy modules proxy holder has been lost");
        }
        Intrinsics.checkNotNull(nativeModulesProxy);
        nativeModulesProxy.callMethod(str4, str3, readableArray, bridgePromise);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
