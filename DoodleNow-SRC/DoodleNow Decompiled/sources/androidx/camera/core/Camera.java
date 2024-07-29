package androidx.camera.core;

import androidx.camera.core.impl.CameraConfig;

public interface Camera {
    CameraControl getCameraControl();

    CameraInfo getCameraInfo();

    CameraConfig getExtendedConfig();

    boolean isUseCasesCombinationSupported(boolean z, UseCase... useCaseArr);

    boolean isUseCasesCombinationSupported(UseCase... useCaseArr);

    boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr);

    /* renamed from: androidx.camera.core.Camera$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isUseCasesCombinationSupported(Camera _this, boolean z, UseCase... useCaseArr) {
            return true;
        }

        public static boolean $default$isUseCasesCombinationSupported(Camera _this, UseCase... useCaseArr) {
            return _this.isUseCasesCombinationSupported(true, useCaseArr);
        }

        public static boolean $default$isUseCasesCombinationSupportedByFramework(Camera _this, UseCase... useCaseArr) {
            return _this.isUseCasesCombinationSupported(false, useCaseArr);
        }
    }
}
