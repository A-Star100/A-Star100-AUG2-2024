package androidx.camera.core;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.processing.SurfaceEdge;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Preview$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Preview f$0;
    public final /* synthetic */ SurfaceEdge f$1;
    public final /* synthetic */ CameraInternal f$2;

    public /* synthetic */ Preview$$ExternalSyntheticLambda2(Preview preview, SurfaceEdge surfaceEdge, CameraInternal cameraInternal) {
        this.f$0 = preview;
        this.f$1 = surfaceEdge;
        this.f$2 = cameraInternal;
    }

    public final void run() {
        this.f$0.m145lambda$createPipeline$0$androidxcameracorePreview(this.f$1, this.f$2);
    }
}
