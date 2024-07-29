package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoOutput;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoCapture$Defaults$$ExternalSyntheticLambda0 implements VideoOutput {
    public /* synthetic */ VideoCapabilities getMediaCapabilities(CameraInfo cameraInfo) {
        return VideoOutput.CC.$default$getMediaCapabilities(this, cameraInfo);
    }

    public /* synthetic */ Observable getMediaSpec() {
        return VideoOutput.CC.$default$getMediaSpec(this);
    }

    public /* synthetic */ Observable getStreamInfo() {
        return VideoOutput.CC.$default$getStreamInfo(this);
    }

    public /* synthetic */ void onSourceStateChanged(VideoOutput.SourceState sourceState) {
        VideoOutput.CC.$default$onSourceStateChanged(this, sourceState);
    }

    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        surfaceRequest.willNotProvideSurface();
    }

    public /* synthetic */ void onSurfaceRequested(SurfaceRequest surfaceRequest, Timebase timebase) {
        VideoOutput.CC.$default$onSurfaceRequested(this, surfaceRequest, timebase);
    }
}
