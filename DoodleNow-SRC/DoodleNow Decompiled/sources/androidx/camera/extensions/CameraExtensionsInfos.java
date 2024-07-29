package androidx.camera.extensions;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.extensions.CameraExtensionsInfo;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;

class CameraExtensionsInfos {
    private static final CameraExtensionsInfo NORMAL_MODE_CAMERA_EXTENSIONS_INFO = new CameraExtensionsInfo() {
        public /* synthetic */ LiveData getCurrentExtensionMode() {
            return CameraExtensionsInfo.CC.$default$getCurrentExtensionMode(this);
        }

        public /* synthetic */ LiveData getExtensionStrength() {
            return CameraExtensionsInfo.CC.$default$getExtensionStrength(this);
        }

        public /* synthetic */ boolean isCurrentExtensionModeAvailable() {
            return CameraExtensionsInfo.CC.$default$isCurrentExtensionModeAvailable(this);
        }

        public /* synthetic */ boolean isExtensionStrengthAvailable() {
            return CameraExtensionsInfo.CC.$default$isExtensionStrengthAvailable(this);
        }
    };

    static CameraExtensionsInfo from(CameraInfo cameraInfo) {
        Preconditions.checkArgument(cameraInfo instanceof RestrictedCameraInfo, "The input camera info must be an instance retrieved from the camera that is returned by invoking CameraProvider#bindToLifecycle() with an extension enabled camera selector.");
        SessionProcessor sessionProcessor = ((RestrictedCameraInfo) cameraInfo).getSessionProcessor();
        return sessionProcessor instanceof CameraExtensionsInfo ? (CameraExtensionsInfo) sessionProcessor : NORMAL_MODE_CAMERA_EXTENSIONS_INFO;
    }

    private CameraExtensionsInfos() {
    }
}
