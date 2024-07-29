package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;

class CameraDeviceCompatApi28Impl extends CameraDeviceCompatApi24Impl {
    CameraDeviceCompatApi28Impl(CameraDevice cameraDevice) {
        super((CameraDevice) Preconditions.checkNotNull(cameraDevice), (Object) null);
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) sessionConfigurationCompat.unwrap();
        Preconditions.checkNotNull(sessionConfiguration);
        try {
            this.mCameraDevice.createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
