package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSurfaceProcessor$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ SurfaceOutput f$0;

    public /* synthetic */ DefaultSurfaceProcessor$$ExternalSyntheticLambda6(SurfaceOutput surfaceOutput) {
        this.f$0 = surfaceOutput;
    }

    public final void run() {
        this.f$0.close();
    }
}
