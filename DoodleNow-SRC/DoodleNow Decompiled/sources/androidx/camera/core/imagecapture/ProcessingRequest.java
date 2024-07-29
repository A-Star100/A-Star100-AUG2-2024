package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class ProcessingRequest {
    private final TakePictureCallback mCallback;
    final ListenableFuture<Void> mCaptureFuture;
    private final Rect mCropRect;
    private final int mJpegQuality;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final int mRequestId;
    private final int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private final List<Integer> mStageIds;
    private final String mTagBundleKey;

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> getCaptureFuture() {
        return this.mCaptureFuture;
    }

    /* access modifiers changed from: package-private */
    public Rect getCropRect() {
        return this.mCropRect;
    }

    /* access modifiers changed from: package-private */
    public int getJpegQuality() {
        return this.mJpegQuality;
    }

    /* access modifiers changed from: package-private */
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.mOutputFileOptions;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    /* access modifiers changed from: package-private */
    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    /* access modifiers changed from: package-private */
    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    /* access modifiers changed from: package-private */
    public List<Integer> getStageIds() {
        return this.mStageIds;
    }

    /* access modifiers changed from: package-private */
    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    ProcessingRequest(CaptureBundle captureBundle, ImageCapture.OutputFileOptions outputFileOptions, Rect rect, int i, int i2, Matrix matrix, TakePictureCallback takePictureCallback, ListenableFuture<Void> listenableFuture) {
        this(captureBundle, outputFileOptions, rect, i, i2, matrix, takePictureCallback, listenableFuture, 0);
    }

    ProcessingRequest(CaptureBundle captureBundle, ImageCapture.OutputFileOptions outputFileOptions, Rect rect, int i, int i2, Matrix matrix, TakePictureCallback takePictureCallback, ListenableFuture<Void> listenableFuture, int i3) {
        this.mRequestId = i3;
        this.mOutputFileOptions = outputFileOptions;
        this.mJpegQuality = i2;
        this.mRotationDegrees = i;
        this.mCropRect = rect;
        this.mSensorToBufferTransform = matrix;
        this.mCallback = takePictureCallback;
        this.mTagBundleKey = String.valueOf(captureBundle.hashCode());
        this.mStageIds = new ArrayList();
        for (CaptureStage id : (List) Objects.requireNonNull(captureBundle.getCaptureStages())) {
            this.mStageIds.add(Integer.valueOf(id.getId()));
        }
        this.mCaptureFuture = listenableFuture;
    }

    /* access modifiers changed from: package-private */
    public boolean isInMemoryCapture() {
        return getOutputFileOptions() == null;
    }

    /* access modifiers changed from: package-private */
    public void onCaptureStarted() {
        this.mCallback.onCaptureStarted();
    }

    /* access modifiers changed from: package-private */
    public void onCaptureProcessProgressed(int i) {
        this.mCallback.onCaptureProcessProgressed(i);
    }

    /* access modifiers changed from: package-private */
    public void onImageCaptured() {
        this.mCallback.onImageCaptured();
    }

    /* access modifiers changed from: package-private */
    public void onFinalResult(ImageCapture.OutputFileResults outputFileResults) {
        this.mCallback.onFinalResult(outputFileResults);
    }

    /* access modifiers changed from: package-private */
    public void onPostviewBitmapAvailable(Bitmap bitmap) {
        this.mCallback.onPostviewBitmapAvailable(bitmap);
    }

    /* access modifiers changed from: package-private */
    public void onFinalResult(ImageProxy imageProxy) {
        this.mCallback.onFinalResult(imageProxy);
    }

    /* access modifiers changed from: package-private */
    public void onProcessFailure(ImageCaptureException imageCaptureException) {
        this.mCallback.onProcessFailure(imageCaptureException);
    }

    /* access modifiers changed from: package-private */
    public void onCaptureFailure(ImageCaptureException imageCaptureException) {
        this.mCallback.onCaptureFailure(imageCaptureException);
    }

    /* access modifiers changed from: package-private */
    public boolean isAborted() {
        return this.mCallback.isAborted();
    }
}
