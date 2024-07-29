package androidx.camera.core.processing;

import androidx.camera.core.SurfaceRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSurfaceProcessor$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ SurfaceRequest f$0;

    public /* synthetic */ DefaultSurfaceProcessor$$ExternalSyntheticLambda9(SurfaceRequest surfaceRequest) {
        this.f$0 = surfaceRequest;
    }

    public final void run() {
        this.f$0.willNotProvideSurface();
    }
}
