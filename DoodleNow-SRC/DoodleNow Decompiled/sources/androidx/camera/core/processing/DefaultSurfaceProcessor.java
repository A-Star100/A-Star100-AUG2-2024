package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

public class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DefaultSurfaceProcessor";
    private final Executor mGlExecutor;
    final Handler mGlHandler;
    private final OpenGlRenderer mGlRenderer;
    final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private final List<PendingSnapshot> mPendingSnapshots;
    private final float[] mSurfaceOutputMatrix;
    private final float[] mTextureMatrix;

    static /* synthetic */ void lambda$executeSafely$10() {
    }

    DefaultSurfaceProcessor(DynamicRange dynamicRange) {
        this(dynamicRange, ShaderProvider.DEFAULT);
    }

    DefaultSurfaceProcessor(DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.mGlThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mGlHandler = handler;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mGlRenderer = new OpenGlRenderer();
        try {
            initGlRenderer(dynamicRange, shaderProvider);
        } catch (RuntimeException e) {
            release();
            throw e;
        }
    }

    public void onInputSurface(SurfaceRequest surfaceRequest) {
        if (this.mIsReleaseRequested.get()) {
            surfaceRequest.willNotProvideSurface();
            return;
        }
        DefaultSurfaceProcessor$$ExternalSyntheticLambda8 defaultSurfaceProcessor$$ExternalSyntheticLambda8 = new DefaultSurfaceProcessor$$ExternalSyntheticLambda8(this, surfaceRequest);
        Objects.requireNonNull(surfaceRequest);
        executeSafely(defaultSurfaceProcessor$$ExternalSyntheticLambda8, new DefaultSurfaceProcessor$$ExternalSyntheticLambda9(surfaceRequest));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onInputSurface$1$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m186lambda$onInputSurface$1$androidxcameracoreprocessingDefaultSurfaceProcessor(SurfaceRequest surfaceRequest) {
        this.mInputSurfaceCount++;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mGlRenderer.getTextureName());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, this.mGlExecutor, new DefaultSurfaceProcessor$$ExternalSyntheticLambda4(this, surfaceTexture, surface));
        surfaceTexture.setOnFrameAvailableListener(this, this.mGlHandler);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onInputSurface$0$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m185lambda$onInputSurface$0$androidxcameracoreprocessingDefaultSurfaceProcessor(SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.Result result) {
        surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
        surfaceTexture.release();
        surface.release();
        this.mInputSurfaceCount--;
        checkReadyToRelease();
    }

    public void onOutputSurface(SurfaceOutput surfaceOutput) {
        if (this.mIsReleaseRequested.get()) {
            surfaceOutput.close();
            return;
        }
        DefaultSurfaceProcessor$$ExternalSyntheticLambda5 defaultSurfaceProcessor$$ExternalSyntheticLambda5 = new DefaultSurfaceProcessor$$ExternalSyntheticLambda5(this, surfaceOutput);
        Objects.requireNonNull(surfaceOutput);
        executeSafely(defaultSurfaceProcessor$$ExternalSyntheticLambda5, new DefaultSurfaceProcessor$$ExternalSyntheticLambda6(surfaceOutput));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onOutputSurface$3$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m188lambda$onOutputSurface$3$androidxcameracoreprocessingDefaultSurfaceProcessor(SurfaceOutput surfaceOutput) {
        Surface surface = surfaceOutput.getSurface(this.mGlExecutor, new DefaultSurfaceProcessor$$ExternalSyntheticLambda2(this, surfaceOutput));
        this.mGlRenderer.registerOutputSurface(surface);
        this.mOutputSurfaces.put(surfaceOutput, surface);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onOutputSurface$2$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m187lambda$onOutputSurface$2$androidxcameracoreprocessingDefaultSurfaceProcessor(SurfaceOutput surfaceOutput, SurfaceOutput.Event event) {
        surfaceOutput.close();
        Surface remove = this.mOutputSurfaces.remove(surfaceOutput);
        if (remove != null) {
            this.mGlRenderer.unregisterOutputSurface(remove);
        }
    }

    public void release() {
        if (!this.mIsReleaseRequested.getAndSet(true)) {
            executeSafely(new DefaultSurfaceProcessor$$ExternalSyntheticLambda13(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$release$4$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m189lambda$release$4$androidxcameracoreprocessingDefaultSurfaceProcessor() {
        this.mIsReleased = true;
        checkReadyToRelease();
    }

    public ListenableFuture<Void> snapshot(int i, int i2) {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new DefaultSurfaceProcessor$$ExternalSyntheticLambda10(this, i, i2)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$snapshot$7$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ Object m191lambda$snapshot$7$androidxcameracoreprocessingDefaultSurfaceProcessor(int i, int i2, CallbackToFutureAdapter.Completer completer) throws Exception {
        executeSafely(new DefaultSurfaceProcessor$$ExternalSyntheticLambda11(this, PendingSnapshot.of(i, i2, completer)), new DefaultSurfaceProcessor$$ExternalSyntheticLambda12(completer));
        return "DefaultSurfaceProcessor#snapshot";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$snapshot$5$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m190lambda$snapshot$5$androidxcameracoreprocessingDefaultSurfaceProcessor(PendingSnapshot pendingSnapshot) {
        this.mPendingSnapshots.add(pendingSnapshot);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.mIsReleaseRequested.get()) {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(this.mTextureMatrix);
            Triple triple = null;
            for (Map.Entry next : this.mOutputSurfaces.entrySet()) {
                Surface surface = (Surface) next.getValue();
                SurfaceOutput surfaceOutput = (SurfaceOutput) next.getKey();
                surfaceOutput.updateTransformMatrix(this.mSurfaceOutputMatrix, this.mTextureMatrix);
                if (surfaceOutput.getFormat() == 34) {
                    try {
                        this.mGlRenderer.render(surfaceTexture.getTimestamp(), this.mSurfaceOutputMatrix, surface);
                    } catch (RuntimeException e) {
                        Logger.e(TAG, "Failed to render with OpenGL.", e);
                    }
                } else {
                    boolean z = true;
                    Preconditions.checkState(surfaceOutput.getFormat() == 256, "Unsupported format: " + surfaceOutput.getFormat());
                    if (triple != null) {
                        z = false;
                    }
                    Preconditions.checkState(z, "Only one JPEG output is supported.");
                    triple = new Triple(surface, surfaceOutput.getSize(), (float[]) this.mSurfaceOutputMatrix.clone());
                }
            }
            try {
                takeSnapshotAndDrawJpeg(triple);
            } catch (RuntimeException e2) {
                failAllPendingSnapshots(e2);
            }
        }
    }

    private void takeSnapshotAndDrawJpeg(Triple<Surface, Size, float[]> triple) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (!this.mPendingSnapshots.isEmpty()) {
            if (triple == null) {
                failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
                return;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                Iterator<PendingSnapshot> it = this.mPendingSnapshots.iterator();
                int i = -1;
                int i2 = -1;
                Bitmap bitmap = null;
                byte[] bArr = null;
                while (it.hasNext()) {
                    PendingSnapshot next = it.next();
                    if (i != next.getRotationDegrees() || bitmap == null) {
                        i = next.getRotationDegrees();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        bitmap = getBitmap(triple.getSecond(), triple.getThird(), i);
                        i2 = -1;
                    }
                    if (i2 != next.getJpegQuality()) {
                        byteArrayOutputStream.reset();
                        i2 = next.getJpegQuality();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    ImageProcessingUtil.writeJpegBytesToSurface(triple.getFirst(), (byte[]) Objects.requireNonNull(bArr));
                    next.getCompleter().set(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
                return;
            } catch (IOException e) {
                failAllPendingSnapshots(e);
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    private void failAllPendingSnapshots(Throwable th) {
        for (PendingSnapshot completer : this.mPendingSnapshots) {
            completer.getCompleter().setException(th);
        }
        this.mPendingSnapshots.clear();
    }

    private Bitmap getBitmap(Size size, float[] fArr, int i) {
        float[] fArr2 = (float[]) fArr.clone();
        MatrixExt.preRotate(fArr2, (float) i, 0.5f, 0.5f);
        MatrixExt.preVerticalFlip(fArr2, 0.5f);
        return this.mGlRenderer.snapshot(TransformUtils.rotateSize(size, i), fArr2);
    }

    private void checkReadyToRelease() {
        if (this.mIsReleased && this.mInputSurfaceCount == 0) {
            for (SurfaceOutput close : this.mOutputSurfaces.keySet()) {
                close.close();
            }
            for (PendingSnapshot completer : this.mPendingSnapshots) {
                completer.getCompleter().setException(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.mOutputSurfaces.clear();
            this.mGlRenderer.release();
            this.mGlThread.quit();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.RuntimeException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.RuntimeException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initGlRenderer(androidx.camera.core.DynamicRange r2, androidx.camera.core.processing.ShaderProvider r3) {
        /*
            r1 = this;
            androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda3 r0 = new androidx.camera.core.processing.DefaultSurfaceProcessor$$ExternalSyntheticLambda3
            r0.<init>(r1, r2, r3)
            com.google.common.util.concurrent.ListenableFuture r2 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r0)
            r2.get()     // Catch:{ ExecutionException -> 0x000f, InterruptedException -> 0x000d }
            return
        L_0x000d:
            r2 = move-exception
            goto L_0x0010
        L_0x000f:
            r2 = move-exception
        L_0x0010:
            boolean r3 = r2 instanceof java.util.concurrent.ExecutionException
            if (r3 == 0) goto L_0x0018
            java.lang.Throwable r2 = r2.getCause()
        L_0x0018:
            boolean r3 = r2 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x001f
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2
            throw r2
        L_0x001f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "Failed to create DefaultSurfaceProcessor"
            r3.<init>(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.processing.DefaultSurfaceProcessor.initGlRenderer(androidx.camera.core.DynamicRange, androidx.camera.core.processing.ShaderProvider):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initGlRenderer$9$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ Object m184lambda$initGlRenderer$9$androidxcameracoreprocessingDefaultSurfaceProcessor(DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.Completer completer) throws Exception {
        executeSafely(new DefaultSurfaceProcessor$$ExternalSyntheticLambda0(this, dynamicRange, shaderProvider, completer));
        return "Init GlRenderer";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initGlRenderer$8$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m183lambda$initGlRenderer$8$androidxcameracoreprocessingDefaultSurfaceProcessor(DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.Completer completer) {
        try {
            this.mGlRenderer.init(dynamicRange, shaderProvider);
            completer.set(null);
        } catch (RuntimeException e) {
            completer.setException(e);
        }
    }

    private void executeSafely(Runnable runnable) {
        executeSafely(runnable, new DefaultSurfaceProcessor$$ExternalSyntheticLambda1());
    }

    private void executeSafely(Runnable runnable, Runnable runnable2) {
        try {
            this.mGlExecutor.execute(new DefaultSurfaceProcessor$$ExternalSyntheticLambda7(this, runnable2, runnable));
        } catch (RejectedExecutionException e) {
            Logger.w(TAG, "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$executeSafely$11$androidx-camera-core-processing-DefaultSurfaceProcessor  reason: not valid java name */
    public /* synthetic */ void m182lambda$executeSafely$11$androidxcameracoreprocessingDefaultSurfaceProcessor(Runnable runnable, Runnable runnable2) {
        if (this.mIsReleased) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    static abstract class PendingSnapshot {
        /* access modifiers changed from: package-private */
        public abstract CallbackToFutureAdapter.Completer<Void> getCompleter();

        /* access modifiers changed from: package-private */
        public abstract int getJpegQuality();

        /* access modifiers changed from: package-private */
        public abstract int getRotationDegrees();

        PendingSnapshot() {
        }

        static AutoValue_DefaultSurfaceProcessor_PendingSnapshot of(int i, int i2, CallbackToFutureAdapter.Completer<Void> completer) {
            return new AutoValue_DefaultSurfaceProcessor_PendingSnapshot(i, i2, completer);
        }
    }

    public static class Factory {
        private static Function<DynamicRange, SurfaceProcessorInternal> sSupplier = new DefaultSurfaceProcessor$Factory$$ExternalSyntheticLambda0();

        public static void setSupplier(Function<DynamicRange, SurfaceProcessorInternal> function) {
            sSupplier = function;
        }

        private Factory() {
        }

        public static SurfaceProcessorInternal newInstance(DynamicRange dynamicRange) {
            return sSupplier.apply(dynamicRange);
        }
    }
}
