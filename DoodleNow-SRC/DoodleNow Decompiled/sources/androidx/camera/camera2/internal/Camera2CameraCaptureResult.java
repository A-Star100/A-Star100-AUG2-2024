package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import java.nio.BufferUnderflowException;

public class Camera2CameraCaptureResult implements CameraCaptureResult {
    private static final String TAG = "C2CameraCaptureResult";
    private final CaptureResult mCaptureResult;
    private final TagBundle mTagBundle;

    public CaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public Camera2CameraCaptureResult(TagBundle tagBundle, CaptureResult captureResult) {
        this.mTagBundle = tagBundle;
        this.mCaptureResult = captureResult;
    }

    public Camera2CameraCaptureResult(CaptureResult captureResult) {
        this(TagBundle.emptyBundle(), captureResult);
    }

    public CameraCaptureMetaData.AfMode getAfMode() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue == 1 || intValue == 2) {
                return CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO;
            }
            if (intValue == 3 || intValue == 4) {
                return CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO;
            }
            if (intValue != 5) {
                Logger.e(TAG, "Undefined af mode: " + num);
                return CameraCaptureMetaData.AfMode.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AfMode.OFF;
    }

    public CameraCaptureMetaData.AfState getAfState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData.AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData.AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData.AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData.AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED;
            default:
                Logger.e(TAG, "Undefined af state: " + num);
                return CameraCaptureMetaData.AfState.UNKNOWN;
        }
    }

    public CameraCaptureMetaData.AeState getAeState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData.AeState.INACTIVE;
        }
        if (intValue != 1) {
            if (intValue == 2) {
                return CameraCaptureMetaData.AeState.CONVERGED;
            }
            if (intValue == 3) {
                return CameraCaptureMetaData.AeState.LOCKED;
            }
            if (intValue == 4) {
                return CameraCaptureMetaData.AeState.FLASH_REQUIRED;
            }
            if (intValue != 5) {
                Logger.e(TAG, "Undefined ae state: " + num);
                return CameraCaptureMetaData.AeState.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AeState.SEARCHING;
    }

    public CameraCaptureMetaData.AwbState getAwbState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData.AwbState.INACTIVE;
        }
        if (intValue == 1) {
            return CameraCaptureMetaData.AwbState.METERING;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData.AwbState.CONVERGED;
        }
        if (intValue == 3) {
            return CameraCaptureMetaData.AwbState.LOCKED;
        }
        Logger.e(TAG, "Undefined awb state: " + num);
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    public CameraCaptureMetaData.FlashState getFlashState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 1) {
            return CameraCaptureMetaData.FlashState.NONE;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData.FlashState.READY;
        }
        if (intValue == 3 || intValue == 4) {
            return CameraCaptureMetaData.FlashState.FIRED;
        }
        Logger.e(TAG, "Undefined flash state: " + num);
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    public CameraCaptureMetaData.AeMode getAeMode() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AeMode.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData.AeMode.OFF;
        }
        if (intValue == 1) {
            return CameraCaptureMetaData.AeMode.ON;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData.AeMode.ON_AUTO_FLASH;
        }
        if (intValue == 3) {
            return CameraCaptureMetaData.AeMode.ON_ALWAYS_FLASH;
        }
        if (intValue == 4) {
            return CameraCaptureMetaData.AeMode.ON_AUTO_FLASH_REDEYE;
        }
        if (intValue != 5) {
            return CameraCaptureMetaData.AeMode.UNKNOWN;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return CameraCaptureMetaData.AeMode.ON_EXTERNAL_FLASH;
        }
        return CameraCaptureMetaData.AeMode.UNKNOWN;
    }

    public CameraCaptureMetaData.AwbMode getAwbMode() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AwbMode.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData.AwbMode.OFF;
            case 1:
                return CameraCaptureMetaData.AwbMode.AUTO;
            case 2:
                return CameraCaptureMetaData.AwbMode.INCANDESCENT;
            case 3:
                return CameraCaptureMetaData.AwbMode.FLUORESCENT;
            case 4:
                return CameraCaptureMetaData.AwbMode.WARM_FLUORESCENT;
            case 5:
                return CameraCaptureMetaData.AwbMode.DAYLIGHT;
            case 6:
                return CameraCaptureMetaData.AwbMode.CLOUDY_DAYLIGHT;
            case 7:
                return CameraCaptureMetaData.AwbMode.TWILIGHT;
            case 8:
                return CameraCaptureMetaData.AwbMode.SHADE;
            default:
                return CameraCaptureMetaData.AwbMode.UNKNOWN;
        }
    }

    public long getTimestamp() {
        Long l = (Long) this.mCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l == null) {
            return -1;
        }
        return l.longValue();
    }

    public void populateExifData(ExifData.Builder builder) {
        Integer num;
        CameraCaptureResult.CC.$default$populateExifData(this, builder);
        try {
            Integer num2 = (Integer) this.mCaptureResult.get(CaptureResult.JPEG_ORIENTATION);
            if (num2 != null) {
                builder.setOrientationDegrees(num2.intValue());
            }
        } catch (BufferUnderflowException unused) {
            Logger.w(TAG, "Failed to get JPEG orientation.");
        }
        Long l = (Long) this.mCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l != null) {
            builder.setExposureTimeNanos(l.longValue());
        }
        Float f = (Float) this.mCaptureResult.get(CaptureResult.LENS_APERTURE);
        if (f != null) {
            builder.setLensFNumber(f.floatValue());
        }
        Integer num3 = (Integer) this.mCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        if (num3 != null) {
            if (Build.VERSION.SDK_INT >= 24 && (num = (Integer) this.mCaptureResult.get(ComponentDialog$$ExternalSyntheticApiModelOutline0.m())) != null) {
                num3 = Integer.valueOf(num3.intValue() * ((int) (((float) num.intValue()) / 100.0f)));
            }
            builder.setIso(num3.intValue());
        }
        Float f2 = (Float) this.mCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f2 != null) {
            builder.setFocalLength(f2.floatValue());
        }
        Integer num4 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_MODE);
        if (num4 != null) {
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (num4.intValue() == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            builder.setWhiteBalanceMode(whiteBalanceMode);
        }
    }
}
