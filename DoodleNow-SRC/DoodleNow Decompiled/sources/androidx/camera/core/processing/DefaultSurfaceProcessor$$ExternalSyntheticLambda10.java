package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSurfaceProcessor$$ExternalSyntheticLambda10 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ DefaultSurfaceProcessor f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DefaultSurfaceProcessor$$ExternalSyntheticLambda10(DefaultSurfaceProcessor defaultSurfaceProcessor, int i, int i2) {
        this.f$0 = defaultSurfaceProcessor;
        this.f$1 = i;
        this.f$2 = i2;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.m191lambda$snapshot$7$androidxcameracoreprocessingDefaultSurfaceProcessor(this.f$1, this.f$2, completer);
    }
}
