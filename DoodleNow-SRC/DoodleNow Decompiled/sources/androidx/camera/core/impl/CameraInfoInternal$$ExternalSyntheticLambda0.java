package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CameraInfoInternal$$ExternalSyntheticLambda0 implements CameraFilter {
    public final /* synthetic */ CameraInfoInternal f$0;

    public /* synthetic */ CameraInfoInternal$$ExternalSyntheticLambda0(CameraInfoInternal cameraInfoInternal) {
        this.f$0 = cameraInfoInternal;
    }

    public final List filter(List list) {
        return CameraInfoInternal.CC.$private$lambda$getCameraSelector$0(this.f$0, list);
    }

    public /* synthetic */ Identifier getIdentifier() {
        return CameraFilter.CC.$default$getIdentifier(this);
    }
}
