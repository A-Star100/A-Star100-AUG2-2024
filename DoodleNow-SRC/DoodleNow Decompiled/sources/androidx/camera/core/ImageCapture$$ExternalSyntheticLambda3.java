package androidx.camera.core;

import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda3 implements SessionConfig.ErrorListener {
    public final /* synthetic */ ImageCapture f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ImageCaptureConfig f$2;
    public final /* synthetic */ StreamSpec f$3;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda3(ImageCapture imageCapture, String str, ImageCaptureConfig imageCaptureConfig, StreamSpec streamSpec) {
        this.f$0 = imageCapture;
        this.f$1 = str;
        this.f$2 = imageCaptureConfig;
        this.f$3 = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.m139lambda$createPipeline$3$androidxcameracoreImageCapture(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
