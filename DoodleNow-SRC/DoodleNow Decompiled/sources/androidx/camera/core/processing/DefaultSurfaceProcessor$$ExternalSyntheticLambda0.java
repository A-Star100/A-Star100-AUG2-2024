package androidx.camera.core.processing;

import androidx.camera.core.DynamicRange;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSurfaceProcessor$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DefaultSurfaceProcessor f$0;
    public final /* synthetic */ DynamicRange f$1;
    public final /* synthetic */ ShaderProvider f$2;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$3;

    public /* synthetic */ DefaultSurfaceProcessor$$ExternalSyntheticLambda0(DefaultSurfaceProcessor defaultSurfaceProcessor, DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = defaultSurfaceProcessor;
        this.f$1 = dynamicRange;
        this.f$2 = shaderProvider;
        this.f$3 = completer;
    }

    public final void run() {
        this.f$0.m183lambda$initGlRenderer$8$androidxcameracoreprocessingDefaultSurfaceProcessor(this.f$1, this.f$2, this.f$3);
    }
}
