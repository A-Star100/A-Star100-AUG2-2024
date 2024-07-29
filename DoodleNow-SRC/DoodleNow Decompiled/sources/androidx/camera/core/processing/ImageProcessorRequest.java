package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;

public class ImageProcessorRequest implements ImageProcessor.Request {
    private final ImageProxy mImageProxy;
    private final int mOutputFormat;

    public ImageProxy getInputImage() {
        return this.mImageProxy;
    }

    public int getOutputFormat() {
        return this.mOutputFormat;
    }

    public ImageProcessorRequest(ImageProxy imageProxy, int i) {
        this.mImageProxy = imageProxy;
        this.mOutputFormat = i;
    }
}
