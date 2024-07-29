package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.Executor;

public class ProcessingNode implements Node<In, Void> {
    private static final String TAG = "ProcessingNode";
    private Operation<Bitmap2JpegBytes.In, Packet<byte[]>> mBitmap2JpegBytes;
    private Operation<Packet<Bitmap>, Packet<Bitmap>> mBitmapEffect;
    final Executor mBlockingExecutor;
    private final boolean mHasIncorrectJpegMetadataQuirk;
    private Operation<Packet<ImageProxy>, Bitmap> mImage2Bitmap;
    private Operation<Image2JpegBytes.In, Packet<byte[]>> mImage2JpegBytes;
    final InternalImageProcessor mImageProcessor;
    private Operation<InputPacket, Packet<ImageProxy>> mInput2Packet;
    private In mInputEdge;
    private Operation<Packet<byte[]>, Packet<Bitmap>> mJpegBytes2CroppedBitmap;
    private Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> mJpegBytes2Disk;
    private Operation<Packet<byte[]>, Packet<ImageProxy>> mJpegBytes2Image;
    private Operation<Packet<ImageProxy>, ImageProxy> mJpegImage2Result;
    private final Quirks mQuirks;

    /* access modifiers changed from: package-private */
    public void injectProcessingInput2Packet(Operation<InputPacket, Packet<ImageProxy>> operation) {
        this.mInput2Packet = operation;
    }

    public void release() {
    }

    ProcessingNode(Executor executor) {
        this(executor, (InternalImageProcessor) null, DeviceQuirks.getAll());
    }

    ProcessingNode(Executor executor, Quirks quirks) {
        this(executor, (InternalImageProcessor) null, quirks);
    }

    ProcessingNode(Executor executor, InternalImageProcessor internalImageProcessor) {
        this(executor, internalImageProcessor, DeviceQuirks.getAll());
    }

    ProcessingNode(Executor executor, InternalImageProcessor internalImageProcessor, Quirks quirks) {
        if (DeviceQuirks.get(LowMemoryQuirk.class) != null) {
            this.mBlockingExecutor = CameraXExecutors.newSequentialExecutor(executor);
        } else {
            this.mBlockingExecutor = executor;
        }
        this.mImageProcessor = internalImageProcessor;
        this.mQuirks = quirks;
        this.mHasIncorrectJpegMetadataQuirk = quirks.contains(IncorrectJpegMetadataQuirk.class);
    }

    public Void transform(In in) {
        this.mInputEdge = in;
        in.getEdge().setListener(new ProcessingNode$$ExternalSyntheticLambda1(this));
        in.getPostviewEdge().setListener(new ProcessingNode$$ExternalSyntheticLambda2(this));
        this.mInput2Packet = new ProcessingInput2Packet();
        this.mImage2JpegBytes = new Image2JpegBytes(this.mQuirks);
        this.mJpegBytes2CroppedBitmap = new JpegBytes2CroppedBitmap();
        this.mBitmap2JpegBytes = new Bitmap2JpegBytes();
        this.mJpegBytes2Disk = new JpegBytes2Disk();
        this.mJpegImage2Result = new JpegImage2Result();
        this.mImage2Bitmap = new Image2Bitmap();
        if (in.getInputFormat() == 35 || this.mImageProcessor != null || this.mHasIncorrectJpegMetadataQuirk) {
            this.mJpegBytes2Image = new JpegBytes2Image();
        }
        InternalImageProcessor internalImageProcessor = this.mImageProcessor;
        if (internalImageProcessor == null) {
            return null;
        }
        this.mBitmapEffect = new BitmapEffect(internalImageProcessor);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$transform$1$androidx-camera-core-imagecapture-ProcessingNode  reason: not valid java name */
    public /* synthetic */ void m157lambda$transform$1$androidxcameracoreimagecaptureProcessingNode(InputPacket inputPacket) {
        if (inputPacket.getProcessingRequest().isAborted()) {
            inputPacket.getImageProxy().close();
        } else {
            this.mBlockingExecutor.execute(new ProcessingNode$$ExternalSyntheticLambda5(this, inputPacket));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$transform$3$androidx-camera-core-imagecapture-ProcessingNode  reason: not valid java name */
    public /* synthetic */ void m159lambda$transform$3$androidxcameracoreimagecaptureProcessingNode(InputPacket inputPacket) {
        if (inputPacket.getProcessingRequest().isAborted()) {
            inputPacket.getImageProxy().close();
        } else {
            this.mBlockingExecutor.execute(new ProcessingNode$$ExternalSyntheticLambda4(this, inputPacket));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: processInputPacket */
    public void m156lambda$transform$0$androidxcameracoreimagecaptureProcessingNode(InputPacket inputPacket) {
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        try {
            if (inputPacket.getProcessingRequest().isInMemoryCapture()) {
                CameraXExecutors.mainThreadExecutor().execute(new ProcessingNode$$ExternalSyntheticLambda6(processingRequest, processInMemoryCapture(inputPacket)));
                return;
            }
            CameraXExecutors.mainThreadExecutor().execute(new ProcessingNode$$ExternalSyntheticLambda7(processingRequest, processOnDiskCapture(inputPacket)));
        } catch (ImageCaptureException e) {
            sendError(processingRequest, e);
        } catch (OutOfMemoryError e2) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed due to low memory.", e2));
        } catch (RuntimeException e3) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed.", e3));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: processPostviewInputPacket */
    public void m158lambda$transform$2$androidxcameracoreimagecaptureProcessingNode(InputPacket inputPacket) {
        int outputFormat = this.mInputEdge.getOutputFormat();
        Preconditions.checkArgument(outputFormat == 35 || outputFormat == 256, String.format("Postview only support YUV and JPEG output formats. Output format: %s", new Object[]{Integer.valueOf(outputFormat)}));
        try {
            CameraXExecutors.mainThreadExecutor().execute(new ProcessingNode$$ExternalSyntheticLambda0(inputPacket.getProcessingRequest(), this.mImage2Bitmap.apply(this.mInput2Packet.apply(inputPacket))));
        } catch (Exception e) {
            inputPacket.getImageProxy().close();
            Logger.e(TAG, "process postview input packet failed.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public ImageCapture.OutputFileResults processOnDiskCapture(InputPacket inputPacket) throws ImageCaptureException {
        int outputFormat = this.mInputEdge.getOutputFormat();
        Preconditions.checkArgument(ImageUtil.isJpegFormats(outputFormat), String.format("On-disk capture only support JPEG and JPEG/R output formats. Output format: %s", new Object[]{Integer.valueOf(outputFormat)}));
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet<byte[]> apply = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(this.mInput2Packet.apply(inputPacket), processingRequest.getJpegQuality()));
        if (apply.hasCropping() || this.mBitmapEffect != null) {
            apply = cropAndMaybeApplyEffect(apply, processingRequest.getJpegQuality());
        }
        return this.mJpegBytes2Disk.apply(JpegBytes2Disk.In.of(apply, (ImageCapture.OutputFileOptions) Objects.requireNonNull(processingRequest.getOutputFileOptions())));
    }

    /* access modifiers changed from: package-private */
    public ImageProxy processInMemoryCapture(InputPacket inputPacket) throws ImageCaptureException {
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet apply = this.mInput2Packet.apply(inputPacket);
        if ((apply.getFormat() == 35 || this.mBitmapEffect != null || this.mHasIncorrectJpegMetadataQuirk) && this.mInputEdge.getOutputFormat() == 256) {
            Packet<byte[]> apply2 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(apply, processingRequest.getJpegQuality()));
            if (this.mBitmapEffect != null) {
                apply2 = cropAndMaybeApplyEffect(apply2, processingRequest.getJpegQuality());
            }
            apply = this.mJpegBytes2Image.apply(apply2);
        }
        return this.mJpegImage2Result.apply(apply);
    }

    private Packet<byte[]> cropAndMaybeApplyEffect(Packet<byte[]> packet, int i) throws ImageCaptureException {
        Preconditions.checkState(ImageUtil.isJpegFormats(packet.getFormat()));
        Packet apply = this.mJpegBytes2CroppedBitmap.apply(packet);
        Operation<Packet<Bitmap>, Packet<Bitmap>> operation = this.mBitmapEffect;
        if (operation != null) {
            apply = operation.apply(apply);
        }
        return this.mBitmap2JpegBytes.apply(Bitmap2JpegBytes.In.of(apply, i));
    }

    private static void sendError(ProcessingRequest processingRequest, ImageCaptureException imageCaptureException) {
        CameraXExecutors.mainThreadExecutor().execute(new ProcessingNode$$ExternalSyntheticLambda3(processingRequest, imageCaptureException));
    }

    static abstract class InputPacket {
        /* access modifiers changed from: package-private */
        public abstract ImageProxy getImageProxy();

        /* access modifiers changed from: package-private */
        public abstract ProcessingRequest getProcessingRequest();

        InputPacket() {
        }

        static InputPacket of(ProcessingRequest processingRequest, ImageProxy imageProxy) {
            return new AutoValue_ProcessingNode_InputPacket(processingRequest, imageProxy);
        }
    }

    static abstract class In {
        /* access modifiers changed from: package-private */
        public abstract Edge<InputPacket> getEdge();

        /* access modifiers changed from: package-private */
        public abstract int getInputFormat();

        /* access modifiers changed from: package-private */
        public abstract int getOutputFormat();

        /* access modifiers changed from: package-private */
        public abstract Edge<InputPacket> getPostviewEdge();

        In() {
        }

        static In of(int i, int i2) {
            return new AutoValue_ProcessingNode_In(new Edge(), new Edge(), i, i2);
        }
    }
}
