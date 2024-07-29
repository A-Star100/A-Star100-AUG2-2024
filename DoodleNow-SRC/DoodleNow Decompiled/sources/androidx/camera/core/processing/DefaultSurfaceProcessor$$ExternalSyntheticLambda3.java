package androidx.camera.core.processing;

import androidx.camera.core.DynamicRange;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSurfaceProcessor$$ExternalSyntheticLambda3 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ DefaultSurfaceProcessor f$0;
    public final /* synthetic */ DynamicRange f$1;
    public final /* synthetic */ ShaderProvider f$2;

    public /* synthetic */ DefaultSurfaceProcessor$$ExternalSyntheticLambda3(DefaultSurfaceProcessor defaultSurfaceProcessor, DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        this.f$0 = defaultSurfaceProcessor;
        this.f$1 = dynamicRange;
        this.f$2 = shaderProvider;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.m184lambda$initGlRenderer$9$androidxcameracoreprocessingDefaultSurfaceProcessor(this.f$1, this.f$2, completer);
    }
}
