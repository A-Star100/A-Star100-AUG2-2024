package expo.modules.kotlin;

import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Lexpo/modules/kotlin/modules/Module;", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleHolder.kt */
final class ModuleHolder$jsObject$2$1$1$1 implements JNIFunctionBody {
    final /* synthetic */ JavaScriptModuleObject $this_apply;

    ModuleHolder$jsObject$2$1$1$1(JavaScriptModuleObject javaScriptModuleObject) {
        this.$this_apply = javaScriptModuleObject;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        return this.$this_apply.getName();
    }
}
