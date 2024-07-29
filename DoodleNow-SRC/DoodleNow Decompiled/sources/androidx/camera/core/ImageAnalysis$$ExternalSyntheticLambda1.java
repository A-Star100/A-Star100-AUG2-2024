package androidx.camera.core;

import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda1 implements SessionConfig.ErrorListener {
    public final /* synthetic */ ImageAnalysis f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ImageAnalysisConfig f$2;
    public final /* synthetic */ StreamSpec f$3;

    public /* synthetic */ ImageAnalysis$$ExternalSyntheticLambda1(ImageAnalysis imageAnalysis, String str, ImageAnalysisConfig imageAnalysisConfig, StreamSpec streamSpec) {
        this.f$0 = imageAnalysis;
        this.f$1 = str;
        this.f$2 = imageAnalysisConfig;
        this.f$3 = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.m135lambda$createPipeline$2$androidxcameracoreImageAnalysis(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
