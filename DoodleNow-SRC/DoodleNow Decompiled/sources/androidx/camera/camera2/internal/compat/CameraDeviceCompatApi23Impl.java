package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;
import java.util.List;

class CameraDeviceCompatApi23Impl extends CameraDeviceCompatBaseImpl {
    CameraDeviceCompatApi23Impl(CameraDevice cameraDevice, Object obj) {
        super(cameraDevice, obj);
    }

    static CameraDeviceCompatApi23Impl create(CameraDevice cameraDevice, Handler handler) {
        return new CameraDeviceCompatApi23Impl(cameraDevice, new CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21(handler));
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        checkPreconditions(this.mCameraDevice, sessionConfigurationCompat);
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.getExecutor(), sessionConfigurationCompat.getStateCallback());
        List<Surface> unpackSurfaces = unpackSurfaces(sessionConfigurationCompat.getOutputConfigurations());
        Handler handler = ((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) Preconditions.checkNotNull((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) this.mImplParams)).mCompatHandler;
        InputConfigurationCompat inputConfiguration = sessionConfigurationCompat.getInputConfiguration();
        if (inputConfiguration != null) {
            try {
                InputConfiguration inputConfiguration2 = (InputConfiguration) inputConfiguration.unwrap();
                Preconditions.checkNotNull(inputConfiguration2);
                this.mCameraDevice.createReprocessableCaptureSession(inputConfiguration2, unpackSurfaces, stateCallbackExecutorWrapper, handler);
            } catch (CameraAccessException e) {
                throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
            }
        } else if (sessionConfigurationCompat.getSessionType() == 1) {
            this.mCameraDevice.createConstrainedHighSpeedCaptureSession(unpackSurfaces, stateCallbackExecutorWrapper, handler);
        } else {
            createBaseCaptureSession(this.mCameraDevice, unpackSurfaces, stateCallbackExecutorWrapper, handler);
        }
    }
}
