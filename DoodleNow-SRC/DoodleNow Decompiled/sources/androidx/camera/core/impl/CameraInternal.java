package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;

public interface CameraInternal extends Camera, UseCase.StateChangeCallback {
    void attachUseCases(Collection<UseCase> collection);

    void close();

    void detachUseCases(Collection<UseCase> collection);

    CameraControl getCameraControl();

    CameraControlInternal getCameraControlInternal();

    CameraInfo getCameraInfo();

    CameraInfoInternal getCameraInfoInternal();

    Observable<State> getCameraState();

    CameraConfig getExtendedConfig();

    boolean getHasTransform();

    boolean isFrontFacing();

    void open();

    ListenableFuture<Void> release();

    void setActiveResumingMode(boolean z);

    void setExtendedConfig(CameraConfig cameraConfig);

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);
        
        private final boolean mHoldsCameraSlot;

        /* access modifiers changed from: package-private */
        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }

        private State(boolean z) {
            this.mHoldsCameraSlot = z;
        }
    }

    /* renamed from: androidx.camera.core.impl.CameraInternal$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getHasTransform(CameraInternal _this) {
            return true;
        }

        public static void $default$setActiveResumingMode(CameraInternal _this, boolean z) {
        }

        public static void $default$setExtendedConfig(CameraInternal _this, CameraConfig cameraConfig) {
        }

        public static boolean $default$isFrontFacing(CameraInternal _this) {
            return _this.getCameraInfo().getLensFacing() == 0;
        }

        public static CameraControl $default$getCameraControl(CameraInternal _this) {
            return _this.getCameraControlInternal();
        }

        public static CameraInfo $default$getCameraInfo(CameraInternal _this) {
            return _this.getCameraInfoInternal();
        }

        public static CameraConfig $default$getExtendedConfig(CameraInternal _this) {
            return CameraConfigs.defaultConfig();
        }
    }
}
