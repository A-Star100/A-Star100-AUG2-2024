package androidx.camera.video;

import androidx.camera.core.impl.DeferrableSurface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoCapture$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ VideoCapture f$0;
    public final /* synthetic */ DeferrableSurface f$1;

    public /* synthetic */ VideoCapture$$ExternalSyntheticLambda5(VideoCapture videoCapture, DeferrableSurface deferrableSurface) {
        this.f$0 = videoCapture;
        this.f$1 = deferrableSurface;
    }

    public final void run() {
        this.f$0.m232lambda$createPipeline$2$androidxcameravideoVideoCapture(this.f$1);
    }
}
