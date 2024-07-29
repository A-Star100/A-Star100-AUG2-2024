package androidx.camera.extensions.internal.sessionprocessor;

import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;

class YuvToJpegConverter {
    private static final String TAG = "YuvToJpegConverter";
    private volatile int mJpegQuality;
    private final Surface mOutputJpegSurface;
    private volatile int mRotationDegrees = 0;

    /* access modifiers changed from: package-private */
    public void setJpegQuality(int i) {
        this.mJpegQuality = i;
    }

    public void setRotationDegrees(int i) {
        this.mRotationDegrees = i;
    }

    YuvToJpegConverter(int i, Surface surface) {
        this.mJpegQuality = i;
        this.mOutputJpegSurface = surface;
    }

    static class ConversionFailedException extends Exception {
        ConversionFailedException(String str) {
            super(str);
        }

        ConversionFailedException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeYuvImage(ImageProxy imageProxy) throws ConversionFailedException {
        Preconditions.checkState(imageProxy.getFormat() == 35, "Input image is not expected YUV_420_888 image format");
        try {
            if (ImageProcessingUtil.convertYuvToJpegBytesIntoSurface(imageProxy, this.mJpegQuality, this.mRotationDegrees, this.mOutputJpegSurface)) {
                imageProxy.close();
                return;
            }
            throw new ConversionFailedException("Failed to process YUV -> JPEG");
        } catch (Exception e) {
            Logger.e(TAG, "Failed to process YUV -> JPEG", e);
            throw new ConversionFailedException("Failed to process YUV -> JPEG", e);
        } catch (Throwable th) {
            imageProxy.close();
            throw th;
        }
    }
}
