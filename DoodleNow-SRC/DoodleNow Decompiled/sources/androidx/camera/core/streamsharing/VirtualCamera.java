package androidx.camera.core.streamsharing;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.streamsharing.StreamSharing;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;

class VirtualCamera implements CameraInternal {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by VirtualCamera.";
    private final CameraInternal mParentCamera;
    private final UseCase.StateChangeCallback mStateChangeCallback;
    private final VirtualCameraControl mVirtualCameraControl;
    private final VirtualCameraInfo mVirtualCameraInfo;

    public /* synthetic */ CameraControl getCameraControl() {
        return CameraInternal.CC.$default$getCameraControl(this);
    }

    public CameraControlInternal getCameraControlInternal() {
        return this.mVirtualCameraControl;
    }

    public /* synthetic */ CameraInfo getCameraInfo() {
        return CameraInternal.CC.$default$getCameraInfo(this);
    }

    public CameraInfoInternal getCameraInfoInternal() {
        return this.mVirtualCameraInfo;
    }

    public /* synthetic */ CameraConfig getExtendedConfig() {
        return CameraInternal.CC.$default$getExtendedConfig(this);
    }

    public boolean getHasTransform() {
        return false;
    }

    public /* synthetic */ boolean isFrontFacing() {
        return CameraInternal.CC.$default$isFrontFacing(this);
    }

    public /* synthetic */ boolean isUseCasesCombinationSupported(boolean z, UseCase... useCaseArr) {
        return Camera.CC.$default$isUseCasesCombinationSupported(this, z, useCaseArr);
    }

    public /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return Camera.CC.$default$isUseCasesCombinationSupported(this, useCaseArr);
    }

    public /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return Camera.CC.$default$isUseCasesCombinationSupportedByFramework(this, useCaseArr);
    }

    public /* synthetic */ void setActiveResumingMode(boolean z) {
        CameraInternal.CC.$default$setActiveResumingMode(this, z);
    }

    public /* synthetic */ void setExtendedConfig(CameraConfig cameraConfig) {
        CameraInternal.CC.$default$setExtendedConfig(this, cameraConfig);
    }

    VirtualCamera(CameraInternal cameraInternal, UseCase.StateChangeCallback stateChangeCallback, StreamSharing.Control control) {
        this.mParentCamera = cameraInternal;
        this.mStateChangeCallback = stateChangeCallback;
        this.mVirtualCameraControl = new VirtualCameraControl(cameraInternal.getCameraControlInternal(), control);
        this.mVirtualCameraInfo = new VirtualCameraInfo(cameraInternal.getCameraInfoInternal());
    }

    /* access modifiers changed from: package-private */
    public void setRotationDegrees(int i) {
        this.mVirtualCameraInfo.setVirtualCameraRotationDegrees(i);
    }

    public void onUseCaseActive(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseActive(useCase);
    }

    public void onUseCaseInactive(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseInactive(useCase);
    }

    public void onUseCaseUpdated(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseUpdated(useCase);
    }

    public void onUseCaseReset(UseCase useCase) {
        Threads.checkMainThread();
        this.mStateChangeCallback.onUseCaseReset(useCase);
    }

    public Observable<CameraInternal.State> getCameraState() {
        return this.mParentCamera.getCameraState();
    }

    public void open() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void close() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public ListenableFuture<Void> release() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void attachUseCases(Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void detachUseCases(Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }
}
