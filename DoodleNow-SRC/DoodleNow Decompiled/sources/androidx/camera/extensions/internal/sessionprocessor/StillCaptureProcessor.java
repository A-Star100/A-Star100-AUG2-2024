package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.ProcessResultImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StillCaptureProcessor {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "StillCaptureProcessor";
    final CaptureProcessorImpl mCaptureProcessorImpl;
    final CaptureResultImageMatcher mCaptureResultImageMatcher;
    HashMap<Integer, Pair<ImageReference, TotalCaptureResult>> mCaptureResults;
    boolean mIsClosed;
    private boolean mIsPostviewConfigured;
    final Object mLock;
    OnCaptureResultCallback mOnCaptureResultCallback;
    final ImageReaderProxy mProcessedYuvImageReader;
    TotalCaptureResult mSourceCaptureResult;
    YuvToJpegConverter mYuvToJpegConverter;

    interface OnCaptureResultCallback {
        void onCaptureProcessProgressed(int i);

        void onCaptureResult(long j, List<Pair<CaptureResult.Key, Object>> list);

        void onCompleted();

        void onError(Exception exc);
    }

    StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size, OutputSurface outputSurface) {
        this.mCaptureResultImageMatcher = new CaptureResultImageMatcher();
        this.mLock = new Object();
        this.mCaptureResults = new HashMap<>();
        this.mOnCaptureResultCallback = null;
        this.mSourceCaptureResult = null;
        boolean z = false;
        this.mIsClosed = false;
        this.mCaptureProcessorImpl = captureProcessorImpl;
        ImageReaderProxy createIsolatedReader = ImageReaderProxys.createIsolatedReader(size.getWidth(), size.getHeight(), 35, 2);
        this.mProcessedYuvImageReader = createIsolatedReader;
        this.mYuvToJpegConverter = new YuvToJpegConverter(100, surface);
        createIsolatedReader.setOnImageAvailableListener(new StillCaptureProcessor$$ExternalSyntheticLambda1(this), CameraXExecutors.ioExecutor());
        captureProcessorImpl.onOutputSurface(createIsolatedReader.getSurface(), 35);
        captureProcessorImpl.onImageFormatUpdate(35);
        this.mIsPostviewConfigured = outputSurface != null;
        if (outputSurface == null || !ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) || !ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4)) {
            captureProcessorImpl.onResolutionUpdate(size);
            return;
        }
        Preconditions.checkArgument(outputSurface.getImageFormat() == 35 ? true : z);
        captureProcessorImpl.onResolutionUpdate(size, outputSurface.getSize());
        captureProcessorImpl.onPostviewOutputSurface(outputSurface.getSurface());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r7 == null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        r2.onError(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        r2.onCompleted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* renamed from: lambda$new$0$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void m212lambda$new$0$androidxcameraextensionsinternalsessionprocessorStillCaptureProcessor(androidx.camera.core.impl.ImageReaderProxy r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mIsClosed     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0010
            java.lang.String r7 = "StillCaptureProcessor"
            java.lang.String r1 = "Ignore JPEG processing in closed state"
            androidx.camera.core.Logger.d(r7, r1)     // Catch:{ all -> 0x0054 }
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x0010:
            androidx.camera.core.ImageProxy r7 = r7.acquireNextImage()     // Catch:{ all -> 0x0054 }
            android.hardware.camera2.TotalCaptureResult r1 = r6.mSourceCaptureResult     // Catch:{ all -> 0x0054 }
            r2 = 0
            if (r1 == 0) goto L_0x002d
            androidx.camera.core.SettableImageProxy r1 = new androidx.camera.core.SettableImageProxy     // Catch:{ all -> 0x0054 }
            androidx.camera.core.internal.CameraCaptureResultImageInfo r3 = new androidx.camera.core.internal.CameraCaptureResultImageInfo     // Catch:{ all -> 0x0054 }
            androidx.camera.extensions.internal.Camera2CameraCaptureResult r4 = new androidx.camera.extensions.internal.Camera2CameraCaptureResult     // Catch:{ all -> 0x0054 }
            android.hardware.camera2.TotalCaptureResult r5 = r6.mSourceCaptureResult     // Catch:{ all -> 0x0054 }
            r4.<init>(r5)     // Catch:{ all -> 0x0054 }
            r3.<init>(r4)     // Catch:{ all -> 0x0054 }
            r1.<init>(r7, r2, r3)     // Catch:{ all -> 0x0054 }
            r6.mSourceCaptureResult = r2     // Catch:{ all -> 0x0054 }
            r7 = r1
        L_0x002d:
            java.lang.String r1 = "StillCaptureProcessor"
            java.lang.String r3 = "Start converting YUV to JPEG"
            androidx.camera.core.Logger.d(r1, r3)     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x0046
            androidx.camera.extensions.internal.sessionprocessor.YuvToJpegConverter r1 = r6.mYuvToJpegConverter     // Catch:{ ConversionFailedException -> 0x003d }
            r1.writeYuvImage(r7)     // Catch:{ ConversionFailedException -> 0x003d }
            r7 = r2
            goto L_0x003e
        L_0x003d:
            r7 = move-exception
        L_0x003e:
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback r1 = r6.mOnCaptureResultCallback     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0047
            r6.mOnCaptureResultCallback = r2     // Catch:{ all -> 0x0054 }
            r2 = r1
            goto L_0x0047
        L_0x0046:
            r7 = r2
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            if (r2 == 0) goto L_0x0053
            if (r7 == 0) goto L_0x0050
            r2.onError(r7)
            goto L_0x0053
        L_0x0050:
            r2.onCompleted()
        L_0x0053:
            return
        L_0x0054:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.m212lambda$new$0$androidxcameraextensionsinternalsessionprocessorStillCaptureProcessor(androidx.camera.core.impl.ImageReaderProxy):void");
    }

    StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size, OutputSurface outputSurface, YuvToJpegConverter yuvToJpegConverter) {
        this(captureProcessorImpl, surface, size, outputSurface);
        this.mYuvToJpegConverter = yuvToJpegConverter;
    }

    /* access modifiers changed from: package-private */
    public void clearCaptureResults() {
        synchronized (this.mLock) {
            for (Pair<ImageReference, TotalCaptureResult> pair : this.mCaptureResults.values()) {
                ((ImageReference) pair.first).decrement();
            }
            this.mCaptureResults.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void startCapture(boolean z, List<Integer> list, OnCaptureResultCallback onCaptureResultCallback) {
        Logger.d(TAG, "Start the capture: enablePostview=" + z);
        synchronized (this.mLock) {
            Preconditions.checkState(!this.mIsClosed, "StillCaptureProcessor is closed. Can't invoke startCapture()");
            this.mOnCaptureResultCallback = onCaptureResultCallback;
            clearCaptureResults();
        }
        this.mCaptureResultImageMatcher.clear();
        this.mCaptureResultImageMatcher.setImageReferenceListener(new StillCaptureProcessor$$ExternalSyntheticLambda0(this, list, onCaptureResultCallback, z));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        return;
     */
    /* renamed from: lambda$startCapture$1$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void m214lambda$startCapture$1$androidxcameraextensionsinternalsessionprocessorStillCaptureProcessor(java.util.List r6, androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback r7, boolean r8, androidx.camera.extensions.internal.sessionprocessor.ImageReference r9, android.hardware.camera2.TotalCaptureResult r10, int r11) {
        /*
            r5 = this;
            java.lang.String r0 = "mCaptureResult has capture stage Id: "
            java.lang.String r1 = "onImageReferenceIncoming  captureStageId="
            java.lang.Object r2 = r5.mLock
            monitor-enter(r2)
            boolean r3 = r5.mIsClosed     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0017
            r9.decrement()     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "StillCaptureProcessor"
            java.lang.String r7 = "Ignore image in closed state"
            androidx.camera.core.Logger.d(r6, r7)     // Catch:{ all -> 0x0060 }
            monitor-exit(r2)     // Catch:{ all -> 0x0060 }
            return
        L_0x0017:
            java.lang.String r3 = "StillCaptureProcessor"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r4.<init>(r1)     // Catch:{ all -> 0x0060 }
            r4.append(r11)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0060 }
            androidx.camera.core.Logger.d(r3, r1)     // Catch:{ all -> 0x0060 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r1 = r5.mCaptureResults     // Catch:{ all -> 0x0060 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0060 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0060 }
            r3.<init>(r9, r10)     // Catch:{ all -> 0x0060 }
            r1.put(r11, r3)     // Catch:{ all -> 0x0060 }
            java.lang.String r9 = "StillCaptureProcessor"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r10.<init>(r0)     // Catch:{ all -> 0x0060 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r11 = r5.mCaptureResults     // Catch:{ all -> 0x0060 }
            java.util.Set r11 = r11.keySet()     // Catch:{ all -> 0x0060 }
            r10.append(r11)     // Catch:{ all -> 0x0060 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0060 }
            androidx.camera.core.Logger.d(r9, r10)     // Catch:{ all -> 0x0060 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r9 = r5.mCaptureResults     // Catch:{ all -> 0x0060 }
            java.util.Set r9 = r9.keySet()     // Catch:{ all -> 0x0060 }
            boolean r6 = r9.containsAll(r6)     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x005e
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r6 = r5.mCaptureResults     // Catch:{ all -> 0x0060 }
            r5.process(r6, r7, r8)     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r2)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r6 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0060 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.m214lambda$startCapture$1$androidxcameraextensionsinternalsessionprocessorStillCaptureProcessor(java.util.List, androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback, boolean, androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult, int):void");
    }

    /* access modifiers changed from: package-private */
    public void process(Map<Integer, Pair<ImageReference, TotalCaptureResult>> map, OnCaptureResultCallback onCaptureResultCallback, boolean z) {
        HashMap hashMap = new HashMap();
        synchronized (this.mLock) {
            for (Integer next : map.keySet()) {
                Pair pair = map.get(next);
                hashMap.put(next, new Pair(((ImageReference) pair.first).get(), (TotalCaptureResult) pair.second));
            }
        }
        CameraXExecutors.ioExecutor().execute(new StillCaptureProcessor$$ExternalSyntheticLambda2(this, z, hashMap, onCaptureResultCallback));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$process$2$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor  reason: not valid java name */
    public /* synthetic */ void m213lambda$process$2$androidxcameraextensionsinternalsessionprocessorStillCaptureProcessor(boolean z, HashMap hashMap, final OnCaptureResultCallback onCaptureResultCallback) {
        synchronized (this.mLock) {
            try {
                if (this.mIsClosed) {
                    Logger.d(TAG, "Ignore process() in closed state.");
                    Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                    clearCaptureResults();
                    return;
                }
                Logger.d(TAG, "CaptureProcessorImpl.process() begin");
                if (ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && z && this.mIsPostviewConfigured) {
                    this.mCaptureProcessorImpl.processWithPostview(hashMap, new ProcessResultImpl() {
                        public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                            onCaptureResultCallback.onCaptureResult(j, list);
                        }

                        public void onCaptureProcessProgressed(int i) {
                            onCaptureResultCallback.onCaptureProcessProgressed(i);
                        }
                    }, CameraXExecutors.directExecutor());
                } else if (!ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_3) || !ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_3)) {
                    this.mCaptureProcessorImpl.process(hashMap);
                } else {
                    this.mCaptureProcessorImpl.process(hashMap, new ProcessResultImpl() {
                        public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                            onCaptureResultCallback.onCaptureResult(j, list);
                        }

                        public void onCaptureProcessProgressed(int i) {
                            onCaptureResultCallback.onCaptureProcessProgressed(i);
                        }
                    }, CameraXExecutors.directExecutor());
                }
                Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                clearCaptureResults();
            } catch (Exception e) {
                try {
                    Logger.e(TAG, "mCaptureProcessorImpl.process exception ", e);
                    this.mOnCaptureResultCallback = null;
                    if (onCaptureResultCallback != null) {
                        onCaptureResultCallback.onError(e);
                    }
                    Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                } catch (Throwable th) {
                    Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                    clearCaptureResults();
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyCaptureResult(TotalCaptureResult totalCaptureResult, int i) {
        this.mCaptureResultImageMatcher.captureResultIncoming(totalCaptureResult, i);
        synchronized (this.mLock) {
            if (this.mSourceCaptureResult == null) {
                this.mSourceCaptureResult = totalCaptureResult;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyImage(ImageReference imageReference) {
        this.mCaptureResultImageMatcher.imageIncoming(imageReference);
    }

    /* access modifiers changed from: package-private */
    public void setJpegQuality(int i) {
        this.mYuvToJpegConverter.setJpegQuality(i);
    }

    /* access modifiers changed from: package-private */
    public void setRotationDegrees(int i) {
        this.mYuvToJpegConverter.setRotationDegrees(i);
    }

    /* access modifiers changed from: package-private */
    public void close() {
        synchronized (this.mLock) {
            Logger.d(TAG, "Close the StillCaptureProcessor");
            this.mIsClosed = true;
            clearCaptureResults();
            this.mProcessedYuvImageReader.clearOnImageAvailableListener();
            this.mCaptureResultImageMatcher.clearImageReferenceListener();
            this.mCaptureResultImageMatcher.clear();
            this.mProcessedYuvImageReader.close();
        }
    }
}
