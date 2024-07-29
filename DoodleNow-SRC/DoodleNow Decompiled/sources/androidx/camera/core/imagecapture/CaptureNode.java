package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Preconditions;
import java.util.Objects;

class CaptureNode implements Node<In, ProcessingNode.In> {
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";
    ProcessingRequest mCurrentRequest = null;
    private In mInputEdge;
    /* access modifiers changed from: private */
    public NoMetadataImageReader mNoMetadataImageReader = null;
    private ProcessingNode.In mOutputEdge;
    SafeCloseImageReaderProxy mSafeCloseImageReaderForPostview;
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    CaptureNode() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: androidx.camera.core.MetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.imagecapture.ProcessingNode.In transform(androidx.camera.core.imagecapture.CaptureNode.In r9) {
        /*
            r8 = this;
            androidx.camera.core.imagecapture.CaptureNode$In r0 = r8.mInputEdge
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000c
            androidx.camera.core.SafeCloseImageReaderProxy r0 = r8.mSafeCloseImageReaderProxy
            if (r0 != 0) goto L_0x000c
            r0 = r2
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            java.lang.String r3 = "CaptureNode does not support recreation yet."
            androidx.core.util.Preconditions.checkState(r0, r3)
            r8.mInputEdge = r9
            android.util.Size r0 = r9.getSize()
            int r3 = r9.getInputFormat()
            boolean r4 = r9.isVirtualCamera()
            r4 = r4 ^ r2
            androidx.camera.core.imagecapture.CaptureNode$1 r5 = new androidx.camera.core.imagecapture.CaptureNode$1
            r5.<init>()
            if (r4 == 0) goto L_0x0051
            androidx.camera.core.ImageReaderProxyProvider r4 = r9.getImageReaderProxyProvider()
            if (r4 != 0) goto L_0x0051
            androidx.camera.core.MetadataImageReader r4 = new androidx.camera.core.MetadataImageReader
            int r6 = r0.getWidth()
            int r0 = r0.getHeight()
            r7 = 4
            r4.<init>(r6, r0, r3, r7)
            r0 = 2
            androidx.camera.core.impl.CameraCaptureCallback[] r0 = new androidx.camera.core.impl.CameraCaptureCallback[r0]
            r0[r1] = r5
            androidx.camera.core.impl.CameraCaptureCallback r1 = r4.getCameraCaptureCallback()
            r0[r2] = r1
            androidx.camera.core.impl.CameraCaptureCallback r5 = androidx.camera.core.impl.CameraCaptureCallbacks.createComboCallback((androidx.camera.core.impl.CameraCaptureCallback[]) r0)
            androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda0 r0 = new androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda0
            r0.<init>(r8)
            goto L_0x006d
        L_0x0051:
            androidx.camera.core.imagecapture.NoMetadataImageReader r4 = new androidx.camera.core.imagecapture.NoMetadataImageReader
            androidx.camera.core.ImageReaderProxyProvider r1 = r9.getImageReaderProxyProvider()
            int r2 = r0.getWidth()
            int r0 = r0.getHeight()
            androidx.camera.core.impl.ImageReaderProxy r0 = createImageReaderProxy(r1, r2, r0, r3)
            r4.<init>(r0)
            r8.mNoMetadataImageReader = r4
            androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda1 r0 = new androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda1
            r0.<init>(r8)
        L_0x006d:
            r9.setCameraCaptureCallback(r5)
            android.view.Surface r1 = r4.getSurface()
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            android.view.Surface r1 = (android.view.Surface) r1
            r9.setSurface(r1)
            androidx.camera.core.SafeCloseImageReaderProxy r1 = new androidx.camera.core.SafeCloseImageReaderProxy
            r1.<init>(r4)
            r8.mSafeCloseImageReaderProxy = r1
            androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda2 r1 = new androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda2
            r1.<init>(r8)
            java.util.concurrent.ScheduledExecutorService r2 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            r4.setOnImageAvailableListener(r1, r2)
            android.util.Size r1 = r9.getPostviewSize()
            if (r1 == 0) goto L_0x00d4
            androidx.camera.core.ImageReaderProxyProvider r1 = r9.getImageReaderProxyProvider()
            android.util.Size r2 = r9.getPostviewSize()
            int r2 = r2.getWidth()
            android.util.Size r3 = r9.getPostviewSize()
            int r3 = r3.getHeight()
            int r4 = r9.getPostviewImageFormat()
            androidx.camera.core.impl.ImageReaderProxy r1 = createImageReaderProxy(r1, r2, r3, r4)
            androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3 r2 = new androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda3
            r2.<init>(r8)
            java.util.concurrent.ScheduledExecutorService r3 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            r1.setOnImageAvailableListener(r2, r3)
            androidx.camera.core.SafeCloseImageReaderProxy r2 = new androidx.camera.core.SafeCloseImageReaderProxy
            r2.<init>(r1)
            r8.mSafeCloseImageReaderForPostview = r2
            android.view.Surface r1 = r1.getSurface()
            android.util.Size r2 = r9.getPostviewSize()
            int r3 = r9.getPostviewImageFormat()
            r9.setPostviewSurface(r1, r2, r3)
        L_0x00d4:
            androidx.camera.core.processing.Edge r1 = r9.getRequestEdge()
            r1.setListener(r0)
            androidx.camera.core.processing.Edge r0 = r9.getErrorEdge()
            androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda4 r1 = new androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda4
            r1.<init>(r8)
            r0.setListener(r1)
            int r0 = r9.getInputFormat()
            int r9 = r9.getOutputFormat()
            androidx.camera.core.imagecapture.ProcessingNode$In r9 = androidx.camera.core.imagecapture.ProcessingNode.In.of(r0, r9)
            r8.mOutputEdge = r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.CaptureNode.transform(androidx.camera.core.imagecapture.CaptureNode$In):androidx.camera.core.imagecapture.ProcessingNode$In");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$transform$0$androidx-camera-core-imagecapture-CaptureNode  reason: not valid java name */
    public /* synthetic */ void m150lambda$transform$0$androidxcameracoreimagecaptureCaptureNode(ProcessingRequest processingRequest) {
        onRequestAvailable(processingRequest);
        this.mNoMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$transform$1$androidx-camera-core-imagecapture-CaptureNode  reason: not valid java name */
    public /* synthetic */ void m151lambda$transform$1$androidxcameracoreimagecaptureCaptureNode(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                onImageProxyAvailable(acquireLatestImage);
                return;
            }
            ProcessingRequest processingRequest = this.mCurrentRequest;
            if (processingRequest != null) {
                sendCaptureError(TakePictureManager.CaptureError.of(processingRequest.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", (Throwable) null)));
            }
        } catch (IllegalStateException e) {
            ProcessingRequest processingRequest2 = this.mCurrentRequest;
            if (processingRequest2 != null) {
                sendCaptureError(TakePictureManager.CaptureError.of(processingRequest2.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", e)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$transform$2$androidx-camera-core-imagecapture-CaptureNode  reason: not valid java name */
    public /* synthetic */ void m152lambda$transform$2$androidxcameracoreimagecaptureCaptureNode(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                propagatePostviewImage(acquireLatestImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire latest image of postview", e);
        }
    }

    private static ImageReaderProxy createImageReaderProxy(ImageReaderProxyProvider imageReaderProxyProvider, int i, int i2, int i3) {
        if (imageReaderProxyProvider != null) {
            return imageReaderProxyProvider.newInstance(i, i2, i3, 4, 0);
        }
        return ImageReaderProxys.createIsolatedReader(i, i2, i3, 4);
    }

    /* access modifiers changed from: package-private */
    public void onImageProxyAvailable(ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest == null) {
            Logger.w(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
            imageProxy.close();
        } else if (((Integer) imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey())) == null) {
            Logger.w(TAG, "Discarding ImageProxy which was acquired for aborted request");
            imageProxy.close();
        } else {
            matchAndPropagateImage(imageProxy);
        }
    }

    private void matchAndPropagateImage(ImageProxy imageProxy) {
        Threads.checkMainThread();
        ((ProcessingNode.In) Objects.requireNonNull(this.mOutputEdge)).getEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, imageProxy));
        ProcessingRequest processingRequest = this.mCurrentRequest;
        this.mCurrentRequest = null;
        processingRequest.onImageCaptured();
    }

    private void propagatePostviewImage(ImageProxy imageProxy) {
        if (this.mCurrentRequest == null) {
            imageProxy.close();
        } else {
            ((ProcessingNode.In) Objects.requireNonNull(this.mOutputEdge)).getPostviewEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, imageProxy));
        }
    }

    /* access modifiers changed from: package-private */
    public void onRequestAvailable(final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        boolean z = false;
        Preconditions.checkState(processingRequest.getStageIds().size() == 1, "only one capture stage is supported.");
        if (getCapacity() > 0) {
            z = true;
        }
        Preconditions.checkState(z, "Too many acquire images. Close image to be able to process next.");
        this.mCurrentRequest = processingRequest;
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() {
            public void onSuccess(Void voidR) {
            }

            public void onFailure(Throwable th) {
                Threads.checkMainThread();
                if (processingRequest == CaptureNode.this.mCurrentRequest) {
                    Logger.w(CaptureNode.TAG, "request aborted, id=" + CaptureNode.this.mCurrentRequest.getRequestId());
                    if (CaptureNode.this.mNoMetadataImageReader != null) {
                        CaptureNode.this.mNoMetadataImageReader.clearProcessingRequest();
                    }
                    CaptureNode.this.mCurrentRequest = null;
                }
            }
        }, CameraXExecutors.directExecutor());
    }

    /* access modifiers changed from: package-private */
    public void sendCaptureError(TakePictureManager.CaptureError captureError) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null && processingRequest.getRequestId() == captureError.getRequestId()) {
            this.mCurrentRequest.onCaptureFailure(captureError.getImageCaptureException());
        }
    }

    public void release() {
        Threads.checkMainThread();
        releaseInputResources((In) Objects.requireNonNull(this.mInputEdge), (SafeCloseImageReaderProxy) Objects.requireNonNull(this.mSafeCloseImageReaderProxy), this.mSafeCloseImageReaderForPostview);
    }

    private void releaseInputResources(In in, SafeCloseImageReaderProxy safeCloseImageReaderProxy, SafeCloseImageReaderProxy safeCloseImageReaderProxy2) {
        in.getSurface().close();
        in.getSurface().getTerminationFuture().addListener(new CaptureNode$$ExternalSyntheticLambda5(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
        if (in.getPostviewSurface() != null) {
            in.getPostviewSurface().close();
            in.getPostviewSurface().getTerminationFuture().addListener(new CaptureNode$$ExternalSyntheticLambda6(safeCloseImageReaderProxy2), CameraXExecutors.mainThreadExecutor());
        }
    }

    static /* synthetic */ void lambda$releaseInputResources$4(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.safeClose();
        }
    }

    /* access modifiers changed from: package-private */
    public In getInputEdge() {
        return (In) Objects.requireNonNull(this.mInputEdge);
    }

    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        return (SafeCloseImageReaderProxy) Objects.requireNonNull(this.mSafeCloseImageReaderProxy);
    }

    public int getCapacity() {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() {
        };
        private DeferrableSurface mPostviewSurface = null;
        private DeferrableSurface mSurface;

        /* access modifiers changed from: package-private */
        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        /* access modifiers changed from: package-private */
        public abstract Edge<TakePictureManager.CaptureError> getErrorEdge();

        /* access modifiers changed from: package-private */
        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        /* access modifiers changed from: package-private */
        public abstract int getInputFormat();

        /* access modifiers changed from: package-private */
        public abstract int getOutputFormat();

        /* access modifiers changed from: package-private */
        public abstract int getPostviewImageFormat();

        /* access modifiers changed from: package-private */
        public abstract Size getPostviewSize();

        /* access modifiers changed from: package-private */
        public DeferrableSurface getPostviewSurface() {
            return this.mPostviewSurface;
        }

        /* access modifiers changed from: package-private */
        public abstract Edge<ProcessingRequest> getRequestEdge();

        /* access modifiers changed from: package-private */
        public abstract Size getSize();

        /* access modifiers changed from: package-private */
        public abstract boolean isVirtualCamera();

        /* access modifiers changed from: package-private */
        public void setCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        In() {
        }

        /* access modifiers changed from: package-private */
        public DeferrableSurface getSurface() {
            return (DeferrableSurface) Objects.requireNonNull(this.mSurface);
        }

        /* access modifiers changed from: package-private */
        public void setSurface(Surface surface) {
            Preconditions.checkState(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }

        /* access modifiers changed from: package-private */
        public void setPostviewSurface(Surface surface, Size size, int i) {
            this.mPostviewSurface = new ImmediateSurface(surface, size, i);
        }

        static In of(Size size, int i, int i2, boolean z, ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i, i2, z, imageReaderProxyProvider, (Size) null, 35, new Edge(), new Edge());
        }

        static In of(Size size, int i, int i2, boolean z, ImageReaderProxyProvider imageReaderProxyProvider, Size size2, int i3) {
            return new AutoValue_CaptureNode_In(size, i, i2, z, imageReaderProxyProvider, size2, i3, new Edge(), new Edge());
        }
    }
}
