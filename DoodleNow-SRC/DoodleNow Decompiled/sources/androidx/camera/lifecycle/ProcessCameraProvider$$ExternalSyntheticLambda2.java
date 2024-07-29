package androidx.camera.lifecycle;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProcessCameraProvider$$ExternalSyntheticLambda2 implements AsyncFunction {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ProcessCameraProvider$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final ListenableFuture apply(Object obj) {
        return ProcessCameraProvider.getOrCreateCameraXInstance$lambda$8$lambda$7$lambda$6$lambda$5(this.f$0, obj);
    }
}
