package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.utils.ExifData;

public interface CameraCaptureResult {
    CameraCaptureMetaData.AeMode getAeMode();

    CameraCaptureMetaData.AeState getAeState();

    CameraCaptureMetaData.AfMode getAfMode();

    CameraCaptureMetaData.AfState getAfState();

    CameraCaptureMetaData.AwbMode getAwbMode();

    CameraCaptureMetaData.AwbState getAwbState();

    CaptureResult getCaptureResult();

    CameraCaptureMetaData.FlashState getFlashState();

    TagBundle getTagBundle();

    long getTimestamp();

    void populateExifData(ExifData.Builder builder);

    /* renamed from: androidx.camera.core.impl.CameraCaptureResult$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$populateExifData(CameraCaptureResult _this, ExifData.Builder builder) {
            builder.setFlashState(_this.getFlashState());
        }

        public static CaptureResult $default$getCaptureResult(CameraCaptureResult _this) {
            return EmptyCameraCaptureResult.create().getCaptureResult();
        }
    }

    public static final class EmptyCameraCaptureResult implements CameraCaptureResult {
        public /* synthetic */ CaptureResult getCaptureResult() {
            return CC.$default$getCaptureResult(this);
        }

        public long getTimestamp() {
            return -1;
        }

        public /* synthetic */ void populateExifData(ExifData.Builder builder) {
            CC.$default$populateExifData(this, builder);
        }

        public static CameraCaptureResult create() {
            return new EmptyCameraCaptureResult();
        }

        public CameraCaptureMetaData.AfMode getAfMode() {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }

        public CameraCaptureMetaData.AfState getAfState() {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }

        public CameraCaptureMetaData.AeState getAeState() {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }

        public CameraCaptureMetaData.AwbState getAwbState() {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }

        public CameraCaptureMetaData.FlashState getFlashState() {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }

        public CameraCaptureMetaData.AeMode getAeMode() {
            return CameraCaptureMetaData.AeMode.UNKNOWN;
        }

        public CameraCaptureMetaData.AwbMode getAwbMode() {
            return CameraCaptureMetaData.AwbMode.UNKNOWN;
        }

        public TagBundle getTagBundle() {
            return TagBundle.emptyBundle();
        }
    }
}
