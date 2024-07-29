package expo.modules.av;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AVModule.kt */
final class AVModuleKt$sam$expo_modules_av_EmitEventWrapper$0 implements EmitEventWrapper {
    private final /* synthetic */ Function2 function;

    AVModuleKt$sam$expo_modules_av_EmitEventWrapper$0(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "function");
        this.function = function2;
    }

    public final /* synthetic */ void emit(String str, Bundle bundle) {
        this.function.invoke(str, bundle);
    }
}
