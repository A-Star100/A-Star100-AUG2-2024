package androidx.camera.video;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.video.impl.VideoCaptureConfig;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoCapture$$ExternalSyntheticLambda6 implements SessionConfig.ErrorListener {
    public final /* synthetic */ VideoCapture f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ VideoCaptureConfig f$2;
    public final /* synthetic */ StreamSpec f$3;

    public /* synthetic */ VideoCapture$$ExternalSyntheticLambda6(VideoCapture videoCapture, String str, VideoCaptureConfig videoCaptureConfig, StreamSpec streamSpec) {
        this.f$0 = videoCapture;
        this.f$1 = str;
        this.f$2 = videoCaptureConfig;
        this.f$3 = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.m233lambda$createPipeline$3$androidxcameravideoVideoCapture(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
