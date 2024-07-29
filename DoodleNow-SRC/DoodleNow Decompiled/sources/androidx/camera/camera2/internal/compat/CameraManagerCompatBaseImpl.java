package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

class CameraManagerCompatBaseImpl implements CameraManagerCompat.CameraManagerCompatImpl {
    final CameraManager mCameraManager;
    final Object mObject;

    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    CameraManagerCompatBaseImpl(Context context, Object obj) {
        this.mCameraManager = (CameraManager) context.getSystemService("camera");
        this.mObject = obj;
    }

    static CameraManagerCompatBaseImpl create(Context context, Handler handler) {
        return new CameraManagerCompatBaseImpl(context, new CameraManagerCompatParamsApi21(handler));
    }

    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        try {
            return this.mCameraManager.getCameraIdList();
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        return Collections.emptySet();
    }

    public void registerAvailabilityCallback(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
        if (executor != null) {
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.mObject;
            if (availabilityCallback != null) {
                synchronized (cameraManagerCompatParamsApi21.mWrapperMap) {
                    availabilityCallbackExecutorWrapper = cameraManagerCompatParamsApi21.mWrapperMap.get(availabilityCallback);
                    if (availabilityCallbackExecutorWrapper == null) {
                        availabilityCallbackExecutorWrapper = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(executor, availabilityCallback);
                        cameraManagerCompatParamsApi21.mWrapperMap.put(availabilityCallback, availabilityCallbackExecutorWrapper);
                    }
                }
            } else {
                availabilityCallbackExecutorWrapper = null;
            }
            this.mCameraManager.registerAvailabilityCallback(availabilityCallbackExecutorWrapper, cameraManagerCompatParamsApi21.mCompatHandler);
            return;
        }
        throw new IllegalArgumentException("executor was null");
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
        if (availabilityCallback != null) {
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.mObject;
            synchronized (cameraManagerCompatParamsApi21.mWrapperMap) {
                availabilityCallbackExecutorWrapper = cameraManagerCompatParamsApi21.mWrapperMap.remove(availabilityCallback);
            }
        } else {
            availabilityCallbackExecutorWrapper = null;
        }
        if (availabilityCallbackExecutorWrapper != null) {
            availabilityCallbackExecutorWrapper.setDisabled();
        }
        this.mCameraManager.unregisterAvailabilityCallback(availabilityCallbackExecutorWrapper);
    }

    public CameraCharacteristics getCameraCharacteristics(String str) throws CameraAccessExceptionCompat {
        try {
            return this.mCameraManager.getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    public void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(stateCallback);
        try {
            this.mCameraManager.openCamera(str, new CameraDeviceCompat.StateCallbackExecutorWrapper(executor, stateCallback), ((CameraManagerCompatParamsApi21) this.mObject).mCompatHandler);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    static final class CameraManagerCompatParamsApi21 {
        final Handler mCompatHandler;
        final Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> mWrapperMap = new HashMap();

        CameraManagerCompatParamsApi21(Handler handler) {
            this.mCompatHandler = handler;
        }
    }
}
