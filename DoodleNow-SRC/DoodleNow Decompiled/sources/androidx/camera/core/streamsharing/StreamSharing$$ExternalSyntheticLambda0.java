package androidx.camera.core.streamsharing;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class StreamSharing$$ExternalSyntheticLambda0 implements SessionConfig.ErrorListener {
    public final /* synthetic */ StreamSharing f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ UseCaseConfig f$2;
    public final /* synthetic */ StreamSpec f$3;

    public /* synthetic */ StreamSharing$$ExternalSyntheticLambda0(StreamSharing streamSharing, String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec) {
        this.f$0 = streamSharing;
        this.f$1 = str;
        this.f$2 = useCaseConfig;
        this.f$3 = streamSpec;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.m206lambda$addCameraErrorListener$1$androidxcameracorestreamsharingStreamSharing(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
