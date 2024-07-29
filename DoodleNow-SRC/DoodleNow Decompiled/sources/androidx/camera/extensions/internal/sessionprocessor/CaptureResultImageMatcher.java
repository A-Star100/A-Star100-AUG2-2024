package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.LongSparseArray;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CaptureResultImageMatcher {
    private static final int INVALID_TIMESTAMP = -1;
    Map<TotalCaptureResult, Integer> mCaptureStageIdMap = new HashMap();
    ImageReferenceListener mImageReferenceListener;
    private final Object mLock = new Object();
    private final LongSparseArray<List<TotalCaptureResult>> mPendingCaptureResults = new LongSparseArray<>();
    private final LongSparseArray<List<ImageReference>> mPendingImages = new LongSparseArray<>();

    interface ImageReferenceListener {
        void onImageReferenceIncoming(ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i);
    }

    CaptureResultImageMatcher() {
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        synchronized (this.mLock) {
            this.mPendingCaptureResults.clear();
            for (int i = 0; i < this.mPendingImages.size(); i++) {
                for (ImageReference decrement : this.mPendingImages.get(this.mPendingImages.keyAt(i))) {
                    decrement.decrement();
                }
            }
            this.mPendingImages.clear();
            this.mCaptureStageIdMap.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void setImageReferenceListener(ImageReferenceListener imageReferenceListener) {
        synchronized (this.mLock) {
            this.mImageReferenceListener = imageReferenceListener;
        }
    }

    /* access modifiers changed from: package-private */
    public void clearImageReferenceListener() {
        synchronized (this.mLock) {
            this.mImageReferenceListener = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void imageIncoming(ImageReference imageReference) {
        synchronized (this.mLock) {
            addToList(this.mPendingImages, imageReference.get().getTimestamp(), imageReference);
        }
        matchImages();
    }

    private <T> void addToList(LongSparseArray<List<T>> longSparseArray, long j, T t) {
        List list = longSparseArray.get(j);
        if (list == null) {
            list = new ArrayList();
            longSparseArray.put(j, list);
        }
        list.add(t);
    }

    private <T> void removeFromList(LongSparseArray<List<T>> longSparseArray, long j, T t) {
        List list = longSparseArray.get(j);
        if (list != null) {
            list.remove(t);
            if (list.isEmpty()) {
                longSparseArray.remove(j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void captureResultIncoming(TotalCaptureResult totalCaptureResult) {
        captureResultIncoming(totalCaptureResult, 0);
    }

    /* access modifiers changed from: package-private */
    public void captureResultIncoming(TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
            if (timeStampFromCaptureResult != -1) {
                addToList(this.mPendingCaptureResults, timeStampFromCaptureResult, totalCaptureResult);
                this.mCaptureStageIdMap.put(totalCaptureResult, Integer.valueOf(i));
                matchImages();
            }
        }
    }

    private long getTimeStampFromCaptureResult(TotalCaptureResult totalCaptureResult) {
        Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l != null) {
            return l.longValue();
        }
        return -1;
    }

    private void notifyImage(ImageReference imageReference, TotalCaptureResult totalCaptureResult) {
        ImageReferenceListener imageReferenceListener;
        Integer num;
        synchronized (this.mLock) {
            imageReferenceListener = this.mImageReferenceListener;
            if (imageReferenceListener != null) {
                num = this.mCaptureStageIdMap.get(totalCaptureResult);
            } else {
                imageReference.decrement();
                imageReferenceListener = null;
                num = null;
            }
        }
        if (imageReferenceListener != null) {
            imageReferenceListener.onImageReferenceIncoming(imageReference, totalCaptureResult, num.intValue());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeStaleData() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r1 = r7.mPendingImages     // Catch:{ all -> 0x009f }
            int r1 = r1.size()     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x009d
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r1 = r7.mPendingCaptureResults     // Catch:{ all -> 0x009f }
            int r1 = r1.size()     // Catch:{ all -> 0x009f }
            if (r1 != 0) goto L_0x0015
            goto L_0x009d
        L_0x0015:
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r1 = r7.mPendingImages     // Catch:{ all -> 0x009f }
            r2 = 0
            long r3 = r1.keyAt(r2)     // Catch:{ all -> 0x009f }
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x009f }
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r3 = r7.mPendingCaptureResults     // Catch:{ all -> 0x009f }
            long r2 = r3.keyAt(r2)     // Catch:{ all -> 0x009f }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x009f }
            boolean r3 = r2.equals(r1)     // Catch:{ all -> 0x009f }
            r3 = r3 ^ 1
            androidx.core.util.Preconditions.checkArgument(r3)     // Catch:{ all -> 0x009f }
            long r3 = r2.longValue()     // Catch:{ all -> 0x009f }
            long r5 = r1.longValue()     // Catch:{ all -> 0x009f }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x007b
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r1 = r7.mPendingImages     // Catch:{ all -> 0x009f }
            int r1 = r1.size()     // Catch:{ all -> 0x009f }
            int r1 = r1 + -1
        L_0x0047:
            if (r1 < 0) goto L_0x009b
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r3 = r7.mPendingImages     // Catch:{ all -> 0x009f }
            long r3 = r3.keyAt(r1)     // Catch:{ all -> 0x009f }
            long r5 = r2.longValue()     // Catch:{ all -> 0x009f }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0078
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r3 = r7.mPendingImages     // Catch:{ all -> 0x009f }
            java.lang.Object r3 = r3.valueAt(r1)     // Catch:{ all -> 0x009f }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x009f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x009f }
        L_0x0063:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x0073
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x009f }
            androidx.camera.extensions.internal.sessionprocessor.ImageReference r4 = (androidx.camera.extensions.internal.sessionprocessor.ImageReference) r4     // Catch:{ all -> 0x009f }
            r4.decrement()     // Catch:{ all -> 0x009f }
            goto L_0x0063
        L_0x0073:
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r3 = r7.mPendingImages     // Catch:{ all -> 0x009f }
            r3.removeAt(r1)     // Catch:{ all -> 0x009f }
        L_0x0078:
            int r1 = r1 + -1
            goto L_0x0047
        L_0x007b:
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r2 = r7.mPendingCaptureResults     // Catch:{ all -> 0x009f }
            int r2 = r2.size()     // Catch:{ all -> 0x009f }
            int r2 = r2 + -1
        L_0x0083:
            if (r2 < 0) goto L_0x009b
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r3 = r7.mPendingCaptureResults     // Catch:{ all -> 0x009f }
            long r3 = r3.keyAt(r2)     // Catch:{ all -> 0x009f }
            long r5 = r1.longValue()     // Catch:{ all -> 0x009f }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0098
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r3 = r7.mPendingCaptureResults     // Catch:{ all -> 0x009f }
            r3.removeAt(r2)     // Catch:{ all -> 0x009f }
        L_0x0098:
            int r2 = r2 + -1
            goto L_0x0083
        L_0x009b:
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            return
        L_0x009d:
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            return
        L_0x009f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher.removeStaleData():void");
    }

    private void matchImages() {
        TotalCaptureResult totalCaptureResult;
        ImageReference imageReference;
        synchronized (this.mLock) {
            int size = this.mPendingCaptureResults.size() - 1;
            while (true) {
                if (size < 0) {
                    totalCaptureResult = null;
                    imageReference = null;
                    break;
                }
                List valueAt = this.mPendingCaptureResults.valueAt(size);
                if (!valueAt.isEmpty()) {
                    totalCaptureResult = (TotalCaptureResult) valueAt.get(0);
                    long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
                    Preconditions.checkState(timeStampFromCaptureResult == this.mPendingCaptureResults.keyAt(size));
                    List list = this.mPendingImages.get(timeStampFromCaptureResult);
                    if (list != null && !list.isEmpty()) {
                        imageReference = (ImageReference) list.get(0);
                        removeFromList(this.mPendingImages, timeStampFromCaptureResult, imageReference);
                        valueAt.remove(totalCaptureResult);
                        if (valueAt.isEmpty()) {
                            this.mPendingCaptureResults.removeAt(size);
                        }
                    }
                }
                size--;
            }
            removeStaleData();
        }
        if (imageReference != null && totalCaptureResult != null) {
            notifyImage(imageReference, totalCaptureResult);
        }
    }
}
