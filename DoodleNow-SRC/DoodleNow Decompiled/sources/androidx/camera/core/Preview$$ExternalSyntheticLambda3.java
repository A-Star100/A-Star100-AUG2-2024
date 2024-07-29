package androidx.camera.core;

import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Preview$$ExternalSyntheticLambda3 implements SessionConfig.ErrorListener {
    public final /* synthetic */ Preview f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ PreviewConfig f$2;
    public final /* synthetic */ StreamSpec f$3;

    public /* synthetic */ Preview$$ExternalSyntheticLambda3(Preview preview, String str, PreviewConfig previewConfig, StreamSpec streamSpec) {
        this.f$0 = preview;
        this.f$1 = str;
        this.f$2 = previewConfig;
        this.f$3 = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.m144lambda$addCameraSurfaceAndErrorListener$1$androidxcameracorePreview(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
