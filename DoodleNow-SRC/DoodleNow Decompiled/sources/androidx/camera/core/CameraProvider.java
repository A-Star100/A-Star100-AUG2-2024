package androidx.camera.core;

import java.util.List;

public interface CameraProvider {
    List<CameraInfo> getAvailableCameraInfos();

    CameraInfo getCameraInfo(CameraSelector cameraSelector);

    boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException;

    /* renamed from: androidx.camera.core.CameraProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static CameraInfo $default$getCameraInfo(CameraProvider _this, CameraSelector cameraSelector) {
            throw new UnsupportedOperationException("The camera provider is not implemented properly.");
        }
    }
}
