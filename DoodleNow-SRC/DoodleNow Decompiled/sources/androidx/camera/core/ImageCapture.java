package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.imagecapture.ImageCaptureControl;
import androidx.camera.core.imagecapture.ImagePipeline;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.ScreenFlashWrapper;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.OutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class ImageCapture extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    public static final int CAPTURE_MODE_ZERO_SHUTTER_LAG = 2;
    private static final int DEFAULT_CAPTURE_MODE = 1;
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int DEFAULT_FLASH_MODE = 2;
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    public static final int FLASH_MODE_SCREEN = 3;
    private static final int FLASH_MODE_UNKNOWN = -1;
    public static final int FLASH_TYPE_ONE_SHOT_FLASH = 0;
    public static final int FLASH_TYPE_USE_TORCH_AS_FLASH = 1;
    private static final byte JPEG_QUALITY_MAXIMIZE_QUALITY_MODE = 100;
    private static final byte JPEG_QUALITY_MINIMIZE_LATENCY_MODE = 95;
    private static final int MAX_IMAGES = 2;
    public static final int OUTPUT_FORMAT_JPEG = 0;
    public static final int OUTPUT_FORMAT_JPEG_ULTRA_HDR = 1;
    public static final long SCREEN_FLASH_UI_APPLY_TIMEOUT_SECONDS = 3;
    private static final String TAG = "ImageCapture";
    private final int mCaptureMode;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener = new ImageCapture$$ExternalSyntheticLambda0();
    private Rational mCropAspectRatio = null;
    private int mFlashMode = -1;
    private final int mFlashType;
    private final ImageCaptureControl mImageCaptureControl = new ImageCaptureControl() {
        public void lockFlashMode() {
            ImageCapture.this.lockFlashMode();
        }

        public void unlockFlashMode() {
            ImageCapture.this.unlockFlashMode();
        }

        public ListenableFuture<Void> submitStillCaptureRequests(List<CaptureConfig> list) {
            return ImageCapture.this.submitStillCaptureRequest(list);
        }
    };
    private ImagePipeline mImagePipeline;
    private final AtomicReference<Integer> mLockedFlashMode = new AtomicReference<>((Object) null);
    private ScreenFlashWrapper mScreenFlashWrapper;
    SessionConfig.Builder mSessionConfigBuilder;
    private TakePictureManager mTakePictureManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageCaptureError {
    }

    public static abstract class OnImageCapturedCallback {
        public void onCaptureProcessProgressed(int i) {
        }

        public void onCaptureStarted() {
        }

        public void onCaptureSuccess(ImageProxy imageProxy) {
        }

        public void onError(ImageCaptureException imageCaptureException) {
        }

        public void onPostviewBitmapAvailable(Bitmap bitmap) {
        }
    }

    public interface OnImageSavedCallback {

        /* renamed from: androidx.camera.core.ImageCapture$OnImageSavedCallback$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureProcessProgressed(OnImageSavedCallback _this, int i) {
            }

            public static void $default$onCaptureStarted(OnImageSavedCallback _this) {
            }

            public static void $default$onPostviewBitmapAvailable(OnImageSavedCallback _this, Bitmap bitmap) {
            }
        }

        void onCaptureProcessProgressed(int i);

        void onCaptureStarted();

        void onError(ImageCaptureException imageCaptureException);

        void onImageSaved(OutputFileResults outputFileResults);

        void onPostviewBitmapAvailable(Bitmap bitmap);
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputFormat {
    }

    public interface ScreenFlash {
        void apply(long j, ScreenFlashListener screenFlashListener);

        void clear();
    }

    public interface ScreenFlashListener {
        void onCompleted();
    }

    static /* synthetic */ Void lambda$submitStillCaptureRequest$4(List list) {
        return null;
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    /* access modifiers changed from: package-private */
    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    /* access modifiers changed from: package-private */
    public boolean isProcessingPipelineEnabled() {
        return (this.mImagePipeline == null || this.mTakePictureManager == null) ? false : true;
    }

    public void setCropAspectRatio(Rational rational) {
        this.mCropAspectRatio = rational;
    }

    static /* synthetic */ void lambda$new$0(ImageReaderProxy imageReaderProxy) {
        ImageProxy acquireLatestImage;
        try {
            acquireLatestImage = imageReaderProxy.acquireLatestImage();
            Log.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + acquireLatestImage);
            if (acquireLatestImage != null) {
                acquireLatestImage.close();
                return;
            }
            return;
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to acquire latest image.", e);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    ImageCapture(ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        ImageCaptureConfig imageCaptureConfig2 = (ImageCaptureConfig) getCurrentConfig();
        if (imageCaptureConfig2.containsOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE)) {
            this.mCaptureMode = imageCaptureConfig2.getCaptureMode();
        } else {
            this.mCaptureMode = 1;
        }
        this.mFlashType = imageCaptureConfig2.getFlashType(0);
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(imageCaptureConfig2.getScreenFlash());
    }

    private boolean isSessionProcessorEnabledInCurrentCamera() {
        if (getCamera() == null || getCamera().getExtendedConfig().getSessionProcessor((SessionProcessor) null) == null) {
            return false;
        }
        return true;
    }

    public UseCaseConfig<?> getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = DEFAULT_CONFIG;
        Config config = useCaseConfigFactory.getConfig(defaults.getConfig().getCaptureType(), getCaptureMode());
        if (z) {
            config = Config.CC.mergeConfigs(config, defaults.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [androidx.camera.core.impl.UseCaseConfig$Builder, androidx.camera.core.impl.UseCaseConfig$Builder<?, ?, ?>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.UseCaseConfig<?> onMergeConfig(androidx.camera.core.impl.CameraInfoInternal r6, androidx.camera.core.impl.UseCaseConfig.Builder<?, ?, ?> r7) {
        /*
            r5 = this;
            androidx.camera.core.impl.Quirks r6 = r6.getCameraQuirks()
            java.lang.Class<androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk> r0 = androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk.class
            boolean r6 = r6.contains(r0)
            r0 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            if (r6 == 0) goto L_0x0039
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            androidx.camera.core.impl.MutableConfig r2 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Boolean> r3 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER
            java.lang.Object r2 = r2.retrieveOption(r3, r1)
            boolean r6 = r6.equals(r2)
            java.lang.String r2 = "ImageCapture"
            if (r6 == 0) goto L_0x002b
            java.lang.String r6 = "Device quirk suggests software JPEG encoder, but it has been explicitly disabled."
            androidx.camera.core.Logger.w(r2, r6)
            goto L_0x0039
        L_0x002b:
            java.lang.String r6 = "Requesting software JPEG due to device quirk."
            androidx.camera.core.Logger.i(r2, r6)
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Boolean> r2 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER
            r6.insertOption(r2, r1)
        L_0x0039:
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            boolean r6 = r5.enforceSoftwareJpegConstraints(r6)
            androidx.camera.core.impl.MutableConfig r1 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r2 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_BUFFER_FORMAT
            r3 = 0
            java.lang.Object r1 = r1.retrieveOption(r2, r3)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r2 = 35
            r4 = 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x007d
            boolean r3 = r5.isSessionProcessorEnabledInCurrentCamera()
            if (r3 == 0) goto L_0x0062
            int r3 = r1.intValue()
            if (r3 != r4) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            java.lang.String r3 = "Cannot set non-JPEG buffer format with Extensions enabled."
            androidx.core.util.Preconditions.checkArgument(r0, r3)
            androidx.camera.core.impl.MutableConfig r0 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r3 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            if (r6 == 0) goto L_0x0070
            goto L_0x0074
        L_0x0070:
            int r2 = r1.intValue()
        L_0x0074:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r0.insertOption(r3, r6)
            goto L_0x00f5
        L_0x007d:
            androidx.camera.core.impl.MutableConfig r0 = r7.getMutableConfig()
            boolean r0 = isOutputFormatUltraHdr(r0)
            if (r0 == 0) goto L_0x00a2
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            r1 = 4101(0x1005, float:5.747E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.insertOption(r0, r1)
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<androidx.camera.core.DynamicRange> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE
            androidx.camera.core.DynamicRange r1 = androidx.camera.core.DynamicRange.HDR_UNSPECIFIED_10_BIT
            r6.insertOption(r0, r1)
            goto L_0x00f5
        L_0x00a2:
            if (r6 == 0) goto L_0x00b2
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r6.insertOption(r0, r1)
            goto L_0x00f5
        L_0x00b2:
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option r0 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_SUPPORTED_RESOLUTIONS
            java.lang.Object r6 = r6.retrieveOption(r0, r3)
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L_0x00ce
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r6.insertOption(r0, r1)
            goto L_0x00f5
        L_0x00ce:
            boolean r0 = isImageFormatSupported(r6, r4)
            if (r0 == 0) goto L_0x00e2
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r6.insertOption(r0, r1)
            goto L_0x00f5
        L_0x00e2:
            boolean r6 = isImageFormatSupported(r6, r2)
            if (r6 == 0) goto L_0x00f5
            androidx.camera.core.impl.MutableConfig r6 = r7.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r6.insertOption(r0, r1)
        L_0x00f5:
            androidx.camera.core.impl.UseCaseConfig r6 = r7.getUseCaseConfig()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageCapture.onMergeConfig(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.UseCaseConfig$Builder):androidx.camera.core.impl.UseCaseConfig");
    }

    private static boolean isImageFormatSupported(List<Pair<Integer, Size[]>> list, int i) {
        if (list == null) {
            return false;
        }
        for (Pair<Integer, Size[]> pair : list) {
            if (((Integer) pair.first).equals(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean isOutputFormatUltraHdr(MutableConfig mutableConfig) {
        return Objects.equals(mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, null), 1);
    }

    public void onCameraControlReady() {
        trySetFlashModeToCameraControl();
        setScreenFlashToCameraControl();
    }

    private int getCameraLens() {
        CameraInternal camera = getCamera();
        if (camera != null) {
            return camera.getCameraInfo().getLensFacing();
        }
        return -1;
    }

    public int getFlashMode() {
        int i;
        synchronized (this.mLockedFlashMode) {
            i = this.mFlashMode;
            if (i == -1) {
                i = ((ImageCaptureConfig) getCurrentConfig()).getFlashMode(2);
            }
        }
        return i;
    }

    public void setFlashMode(int i) {
        if (!(i == 0 || i == 1 || i == 2)) {
            if (i != 3) {
                throw new IllegalArgumentException("Invalid flash mode: " + i);
            } else if (this.mScreenFlashWrapper.getBaseScreenFlash() == null) {
                throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
            } else if (!(getCamera() == null || getCameraLens() == 0)) {
                throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
            }
        }
        synchronized (this.mLockedFlashMode) {
            this.mFlashMode = i;
            trySetFlashModeToCameraControl();
        }
    }

    public void setScreenFlash(ScreenFlash screenFlash) {
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(screenFlash);
        setScreenFlashToCameraControl();
    }

    public ScreenFlash getScreenFlash() {
        return this.mScreenFlashWrapper.getBaseScreenFlash();
    }

    private void setScreenFlashToCameraControl() {
        setScreenFlashToCameraControl(this.mScreenFlashWrapper);
    }

    private void setScreenFlashToCameraControl(ScreenFlash screenFlash) {
        getCameraControl().setScreenFlash(screenFlash);
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public void setTargetRotation(int i) {
        int targetRotation = getTargetRotation();
        if (setTargetRotationInternal(i) && this.mCropAspectRatio != null) {
            this.mCropAspectRatio = ImageUtil.getRotatedAspectRatio(Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(i) - CameraOrientationUtil.surfaceRotationToDegrees(targetRotation)), this.mCropAspectRatio);
        }
    }

    public int getJpegQuality() {
        return getJpegQualityInternal();
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    /* access modifiers changed from: protected */
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        if (camera == null || attachedSurfaceResolution == null) {
            return null;
        }
        Rect viewPortCropRect = getViewPortCropRect();
        Rational rational = this.mCropAspectRatio;
        if (viewPortCropRect == null) {
            if (rational != null) {
                viewPortCropRect = ImageUtil.computeCropRectFromAspectRatio(attachedSurfaceResolution, rational);
            } else {
                viewPortCropRect = new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
            }
        }
        return new ResolutionInfo(attachedSurfaceResolution, (Rect) Objects.requireNonNull(viewPortCropRect), getRelativeRotation(camera));
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector((ResolutionSelector) null);
    }

    public int getOutputFormat() {
        return ((Integer) Preconditions.checkNotNull((Integer) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, 0))).intValue();
    }

    /* renamed from: takePicture */
    public void m140lambda$takePicture$1$androidxcameracoreImageCapture(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new ImageCapture$$ExternalSyntheticLambda4(this, executor, onImageCapturedCallback));
        } else {
            takePictureInternal(executor, onImageCapturedCallback, (OnImageSavedCallback) null, (OutputFileOptions) null);
        }
    }

    /* renamed from: takePicture */
    public void m141lambda$takePicture$2$androidxcameracoreImageCapture(OutputFileOptions outputFileOptions, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new ImageCapture$$ExternalSyntheticLambda1(this, outputFileOptions, executor, onImageSavedCallback));
        } else {
            takePictureInternal(executor, (OnImageCapturedCallback) null, onImageSavedCallback, outputFileOptions);
        }
    }

    public static ImageCaptureCapabilities getImageCaptureCapabilities(CameraInfo cameraInfo) {
        return new ImageCaptureCapabilitiesImpl(cameraInfo);
    }

    private static class ImageCaptureCapabilitiesImpl implements ImageCaptureCapabilities {
        private final CameraInfo mCameraInfo;

        ImageCaptureCapabilitiesImpl(CameraInfo cameraInfo) {
            this.mCameraInfo = cameraInfo;
        }

        public boolean isPostviewSupported() {
            CameraInfo cameraInfo = this.mCameraInfo;
            if (cameraInfo instanceof CameraInfoInternal) {
                return ((CameraInfoInternal) cameraInfo).isPostviewSupported();
            }
            return false;
        }

        public boolean isCaptureProcessProgressSupported() {
            CameraInfo cameraInfo = this.mCameraInfo;
            if (cameraInfo instanceof CameraInfoInternal) {
                return ((CameraInfoInternal) cameraInfo).isCaptureProcessProgressSupported();
            }
            return false;
        }

        public Set<Integer> getSupportedOutputFormats() {
            HashSet hashSet = new HashSet();
            hashSet.add(0);
            if (isUltraHdrSupported()) {
                hashSet.add(1);
            }
            return hashSet;
        }

        private boolean isUltraHdrSupported() {
            CameraInfo cameraInfo = this.mCameraInfo;
            if (cameraInfo instanceof CameraInfoInternal) {
                return ((CameraInfoInternal) cameraInfo).getSupportedOutputFormats().contains(4101);
            }
            return false;
        }
    }

    static Rect computeDispatchCropRect(Rect rect, Rational rational, int i, Size size, int i2) {
        if (rect != null) {
            return ImageUtil.computeCropRectFromDispatchInfo(rect, i, size, i2);
        }
        if (rational != null) {
            if (i2 % RotationOptions.ROTATE_180 != 0) {
                rational = new Rational(rational.getDenominator(), rational.getNumerator());
            }
            if (ImageUtil.isAspectRatioValid(size, rational)) {
                return (Rect) Objects.requireNonNull(ImageUtil.computeCropRectFromAspectRatio(size, rational));
            }
        }
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    public void onStateDetached() {
        abortImageCaptureRequests();
    }

    private void abortImageCaptureRequests() {
        this.mScreenFlashWrapper.completePendingTasks();
        TakePictureManager takePictureManager = this.mTakePictureManager;
        if (takePictureManager != null) {
            takePictureManager.abortRequests();
        }
    }

    /* access modifiers changed from: package-private */
    public void lockFlashMode() {
        synchronized (this.mLockedFlashMode) {
            if (this.mLockedFlashMode.get() == null) {
                this.mLockedFlashMode.set(Integer.valueOf(getFlashMode()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unlockFlashMode() {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r0 = r3.mLockedFlashMode
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r1 = r3.mLockedFlashMode     // Catch:{ all -> 0x001f }
            r2 = 0
            java.lang.Object r1 = r1.getAndSet(r2)     // Catch:{ all -> 0x001f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x0010:
            int r1 = r1.intValue()     // Catch:{ all -> 0x001f }
            int r2 = r3.getFlashMode()     // Catch:{ all -> 0x001f }
            if (r1 == r2) goto L_0x001d
            r3.trySetFlashModeToCameraControl()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageCapture.unlockFlashMode():void");
    }

    private void trySetFlashModeToCameraControl() {
        synchronized (this.mLockedFlashMode) {
            if (this.mLockedFlashMode.get() == null) {
                getCameraControl().setFlashMode(getFlashMode());
            }
        }
    }

    private int getJpegQualityInternal() {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) getCurrentConfig();
        if (imageCaptureConfig.containsOption(ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY)) {
            return imageCaptureConfig.getJpegQuality();
        }
        int i = this.mCaptureMode;
        if (i == 0) {
            return 100;
        }
        if (i == 1 || i == 2) {
            return 95;
        }
        throw new IllegalStateException("CaptureMode " + this.mCaptureMode + " is invalid");
    }

    public String toString() {
        return "ImageCapture:" + getName();
    }

    static int getError(Throwable th) {
        if (th instanceof CameraClosedException) {
            return 3;
        }
        if (th instanceof ImageCaptureException) {
            return ((ImageCaptureException) th).getImageCaptureError();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean enforceSoftwareJpegConstraints(MutableConfig mutableConfig) {
        boolean z;
        boolean z2 = false;
        if (Boolean.TRUE.equals(mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, false))) {
            if (isSessionProcessorEnabledInCurrentCamera()) {
                Logger.w(TAG, "Software JPEG cannot be used with Extensions.");
                z = false;
            } else {
                z = true;
            }
            Integer num = (Integer) mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (num == null || num.intValue() == 256) {
                z2 = z;
            } else {
                Logger.w(TAG, "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z2) {
                Logger.w(TAG, "Unable to support software JPEG. Disabling.");
                mutableConfig.insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, false);
            }
        }
        return z2;
    }

    public void onUnbind() {
        abortImageCaptureRequests();
        clearPipeline();
        setScreenFlashToCameraControl((ScreenFlash) null);
    }

    public void onBind() {
        Preconditions.checkNotNull(getCamera(), "Attached camera cannot be null");
        if (getFlashMode() == 3 && getCameraLens() != 0) {
            throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
        }
    }

    private SessionProcessor getSessionProcessor() {
        return getCamera().getExtendedConfig().getSessionProcessor((SessionProcessor) null);
    }

    /* access modifiers changed from: protected */
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec) {
        SessionConfig.Builder createPipeline = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), streamSpec);
        this.mSessionConfigBuilder = createPipeline;
        updateSessionConfig(createPipeline.build());
        notifyActive();
        return streamSpec;
    }

    /* access modifiers changed from: protected */
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.camera.core.impl.SessionConfig.Builder createPipeline(java.lang.String r21, androidx.camera.core.impl.ImageCaptureConfig r22, androidx.camera.core.impl.StreamSpec r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            androidx.camera.core.impl.utils.Threads.checkMainThread()
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r1
            r6 = 1
            r4[r6] = r2
            java.lang.String r7 = "createPipeline(cameraId: %s, streamSpec: %s)"
            java.lang.String r4 = java.lang.String.format(r7, r4)
            java.lang.String r7 = "ImageCapture"
            android.util.Log.d(r7, r4)
            android.util.Size r10 = r23.getResolution()
            androidx.camera.core.impl.CameraInternal r4 = r20.getCamera()
            java.lang.Object r4 = java.util.Objects.requireNonNull(r4)
            androidx.camera.core.impl.CameraInternal r4 = (androidx.camera.core.impl.CameraInternal) r4
            boolean r4 = r4.getHasTransform()
            if (r4 == 0) goto L_0x003a
            boolean r4 = r20.isSessionProcessorEnabledInCurrentCamera()
            if (r4 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r12 = r5
            goto L_0x003b
        L_0x003a:
            r12 = r6
        L_0x003b:
            androidx.camera.core.imagecapture.ImagePipeline r4 = r0.mImagePipeline
            if (r4 == 0) goto L_0x0047
            androidx.core.util.Preconditions.checkState(r12)
            androidx.camera.core.imagecapture.ImagePipeline r4 = r0.mImagePipeline
            r4.close()
        L_0x0047:
            androidx.camera.core.impl.UseCaseConfig r4 = r20.getCurrentConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Boolean> r7 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_POSTVIEW_ENABLED
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r5)
            java.lang.Object r4 = r4.retrieveOption(r7, r8)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r7 = 35
            r8 = 0
            if (r4 == 0) goto L_0x00fe
            androidx.camera.core.impl.SessionProcessor r4 = r20.getSessionProcessor()
            if (r4 == 0) goto L_0x00fe
            androidx.camera.core.impl.UseCaseConfig r9 = r20.getCurrentConfig()
            androidx.camera.core.impl.Config$Option<androidx.camera.core.resolutionselector.ResolutionSelector> r11 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR
            java.lang.Object r9 = r9.retrieveOption(r11, r8)
            r13 = r9
            androidx.camera.core.resolutionselector.ResolutionSelector r13 = (androidx.camera.core.resolutionselector.ResolutionSelector) r13
            java.util.Map r4 = r4.getSupportedPostviewSize(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            java.lang.Object r9 = r4.get(r9)
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x008c
            boolean r11 = r9.isEmpty()
            if (r11 == 0) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r14 = r9
            goto L_0x0099
        L_0x008c:
            r7 = 256(0x100, float:3.59E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            java.lang.Object r4 = r4.get(r9)
            java.util.List r4 = (java.util.List) r4
            r14 = r4
        L_0x0099:
            if (r14 == 0) goto L_0x00fe
            boolean r4 = r14.isEmpty()
            if (r4 != 0) goto L_0x00fe
            if (r13 == 0) goto L_0x00f0
            androidx.camera.core.impl.utils.CompareSizesByArea r4 = new androidx.camera.core.impl.utils.CompareSizesByArea
            r4.<init>(r6)
            java.util.Collections.sort(r14, r4)
            androidx.camera.core.impl.CameraInternal r4 = r20.getCamera()
            androidx.camera.core.impl.CameraControlInternal r6 = r4.getCameraControlInternal()
            android.graphics.Rect r6 = r6.getSensorRect()
            androidx.camera.core.impl.CameraInfoInternal r4 = r4.getCameraInfoInternal()
            android.util.Rational r8 = new android.util.Rational
            int r9 = r6.width()
            int r6 = r6.height()
            r8.<init>(r9, r6)
            r15 = 0
            int r16 = r20.getTargetRotation()
            int r18 = r4.getSensorRotationDegrees()
            int r19 = r4.getLensFacing()
            r17 = r8
            java.util.List r4 = androidx.camera.core.internal.SupportedOutputSizesSorter.sortSupportedOutputSizesByResolutionSelector(r13, r14, r15, r16, r17, r18, r19)
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L_0x00e8
            java.lang.Object r4 = r4.get(r5)
            android.util.Size r4 = (android.util.Size) r4
            goto L_0x00fb
        L_0x00e8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "The postview ResolutionSelector cannot select a valid size for the postview."
            r1.<init>(r2)
            throw r1
        L_0x00f0:
            androidx.camera.core.impl.utils.CompareSizesByArea r4 = new androidx.camera.core.impl.utils.CompareSizesByArea
            r4.<init>()
            java.lang.Object r4 = java.util.Collections.max(r14, r4)
            android.util.Size r4 = (android.util.Size) r4
        L_0x00fb:
            r13 = r4
            r14 = r7
            goto L_0x0100
        L_0x00fe:
            r14 = r7
            r13 = r8
        L_0x0100:
            androidx.camera.core.imagecapture.ImagePipeline r4 = new androidx.camera.core.imagecapture.ImagePipeline
            androidx.camera.core.CameraEffect r11 = r20.getEffect()
            r8 = r4
            r9 = r22
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0.mImagePipeline = r4
            androidx.camera.core.imagecapture.TakePictureManager r4 = r0.mTakePictureManager
            if (r4 != 0) goto L_0x011b
            androidx.camera.core.imagecapture.TakePictureManager r4 = new androidx.camera.core.imagecapture.TakePictureManager
            androidx.camera.core.imagecapture.ImageCaptureControl r5 = r0.mImageCaptureControl
            r4.<init>(r5)
            r0.mTakePictureManager = r4
        L_0x011b:
            androidx.camera.core.imagecapture.TakePictureManager r4 = r0.mTakePictureManager
            androidx.camera.core.imagecapture.ImagePipeline r5 = r0.mImagePipeline
            r4.setImagePipeline(r5)
            androidx.camera.core.imagecapture.ImagePipeline r4 = r0.mImagePipeline
            android.util.Size r5 = r23.getResolution()
            androidx.camera.core.impl.SessionConfig$Builder r4 = r4.createSessionConfigBuilder(r5)
            int r5 = r20.getCaptureMode()
            if (r5 != r3) goto L_0x0139
            androidx.camera.core.impl.CameraControlInternal r3 = r20.getCameraControl()
            r3.addZslConfig(r4)
        L_0x0139:
            androidx.camera.core.impl.Config r3 = r23.getImplementationOptions()
            if (r3 == 0) goto L_0x0146
            androidx.camera.core.impl.Config r3 = r23.getImplementationOptions()
            r4.addImplementationOptions(r3)
        L_0x0146:
            androidx.camera.core.ImageCapture$$ExternalSyntheticLambda3 r3 = new androidx.camera.core.ImageCapture$$ExternalSyntheticLambda3
            r5 = r22
            r3.<init>(r0, r1, r5, r2)
            r4.addErrorListener(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageCapture.createPipeline(java.lang.String, androidx.camera.core.impl.ImageCaptureConfig, androidx.camera.core.impl.StreamSpec):androidx.camera.core.impl.SessionConfig$Builder");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createPipeline$3$androidx-camera-core-ImageCapture  reason: not valid java name */
    public /* synthetic */ void m139lambda$createPipeline$3$androidxcameracoreImageCapture(String str, ImageCaptureConfig imageCaptureConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (isCurrentCamera(str)) {
            this.mTakePictureManager.pause();
            clearPipeline(true);
            SessionConfig.Builder createPipeline = createPipeline(str, imageCaptureConfig, streamSpec);
            this.mSessionConfigBuilder = createPipeline;
            updateSessionConfig(createPipeline.build());
            notifyReset();
            this.mTakePictureManager.resume();
            return;
        }
        clearPipeline();
    }

    private void takePictureInternal(Executor executor, OnImageCapturedCallback onImageCapturedCallback, OnImageSavedCallback onImageSavedCallback, OutputFileOptions outputFileOptions) {
        Threads.checkMainThread();
        if (getFlashMode() == 3 && this.mScreenFlashWrapper.getBaseScreenFlash() == null) {
            throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
        }
        Log.d(TAG, "takePictureInternal");
        CameraInternal camera = getCamera();
        if (camera == null) {
            sendInvalidCameraError(executor, onImageCapturedCallback, onImageSavedCallback);
            return;
        }
        ((TakePictureManager) Objects.requireNonNull(this.mTakePictureManager)).offerRequest(TakePictureRequest.of(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, getTakePictureCropRect(), getSensorToBufferTransformMatrix(), getRelativeRotation(camera), getJpegQualityInternal(), getCaptureMode(), this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks()));
    }

    private void sendInvalidCameraError(Executor executor, OnImageCapturedCallback onImageCapturedCallback, OnImageSavedCallback onImageSavedCallback) {
        ImageCaptureException imageCaptureException = new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", (Throwable) null);
        if (onImageCapturedCallback != null) {
            onImageCapturedCallback.onError(imageCaptureException);
        } else if (onImageSavedCallback != null) {
            onImageSavedCallback.onError(imageCaptureException);
        } else {
            throw new IllegalArgumentException("Must have either in-memory or on-disk callback.");
        }
    }

    private Rect getTakePictureCropRect() {
        Rect viewPortCropRect = getViewPortCropRect();
        Size size = (Size) Objects.requireNonNull(getAttachedSurfaceResolution());
        if (viewPortCropRect != null) {
            return viewPortCropRect;
        }
        if (!ImageUtil.isAspectRatioValid(this.mCropAspectRatio)) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        int relativeRotation = getRelativeRotation((CameraInternal) Objects.requireNonNull(getCamera()));
        Rational rational = new Rational(this.mCropAspectRatio.getDenominator(), this.mCropAspectRatio.getNumerator());
        if (!TransformUtils.is90or270(relativeRotation)) {
            rational = this.mCropAspectRatio;
        }
        return (Rect) Objects.requireNonNull(ImageUtil.computeCropRectFromAspectRatio(size, rational));
    }

    private void clearPipeline() {
        clearPipeline(false);
    }

    private void clearPipeline(boolean z) {
        TakePictureManager takePictureManager;
        Log.d(TAG, "clearPipeline");
        Threads.checkMainThread();
        ImagePipeline imagePipeline = this.mImagePipeline;
        if (imagePipeline != null) {
            imagePipeline.close();
            this.mImagePipeline = null;
        }
        if (!z && (takePictureManager = this.mTakePictureManager) != null) {
            takePictureManager.abortRequests();
            this.mTakePictureManager = null;
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> submitStillCaptureRequest(List<CaptureConfig> list) {
        Threads.checkMainThread();
        return Futures.transform(getCameraControl().submitStillCaptureRequests(list, this.mCaptureMode, this.mFlashType), new ImageCapture$$ExternalSyntheticLambda2(), CameraXExecutors.directExecutor());
    }

    /* access modifiers changed from: package-private */
    public TakePictureManager getTakePictureManager() {
        return (TakePictureManager) Objects.requireNonNull(this.mTakePictureManager);
    }

    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    public ImageCaptureLatencyEstimate getRealtimeCaptureLatencyEstimate() {
        CameraInternal camera = getCamera();
        if (camera == null) {
            return ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY;
        }
        Pair<Long, Long> realtimeCaptureLatency = camera.getExtendedConfig().getSessionProcessor().getRealtimeCaptureLatency();
        if (realtimeCaptureLatency == null) {
            return ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY;
        }
        return new ImageCaptureLatencyEstimate(((Long) realtimeCaptureLatency.first).longValue(), ((Long) realtimeCaptureLatency.second).longValue());
    }

    public boolean isPostviewEnabled() {
        return ((Boolean) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, false)).booleanValue();
    }

    public ResolutionSelector getPostviewResolutionSelector() {
        return (ResolutionSelector) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
    }

    public static final class Defaults implements ConfigProvider<ImageCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageCaptureConfig DEFAULT_CONFIG;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE;
        private static final int DEFAULT_OUTPUT_FORMAT = 0;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

        public ImageCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }

        static {
            ResolutionSelector build = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build();
            DEFAULT_RESOLUTION_SELECTOR = build;
            DynamicRange dynamicRange = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = dynamicRange;
            DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(4).setTargetAspectRatio(0).setResolutionSelector(build).setOutputFormat(0).setDynamicRange(dynamicRange).getUseCaseConfig();
        }
    }

    public static final class OutputFileOptions {
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final Metadata mMetadata;
        private final OutputStream mOutputStream;
        private final Uri mSaveCollection;

        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        public File getFile() {
            return this.mFile;
        }

        public Metadata getMetadata() {
            return this.mMetadata;
        }

        public OutputStream getOutputStream() {
            return this.mOutputStream;
        }

        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, Metadata metadata) {
            this.mFile = file;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = uri;
            this.mContentValues = contentValues;
            this.mOutputStream = outputStream;
            this.mMetadata = metadata == null ? new Metadata() : metadata;
        }

        public String toString() {
            return "OutputFileOptions{mFile=" + this.mFile + ", mContentResolver=" + this.mContentResolver + ", mSaveCollection=" + this.mSaveCollection + ", mContentValues=" + this.mContentValues + ", mOutputStream=" + this.mOutputStream + ", mMetadata=" + this.mMetadata + "}";
        }

        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private Metadata mMetadata;
            private OutputStream mOutputStream;
            private Uri mSaveCollection;

            public Builder setMetadata(Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public Builder(File file) {
                this.mFile = file;
            }

            public Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = uri;
                this.mContentValues = contentValues;
            }

            public Builder(OutputStream outputStream) {
                this.mOutputStream = outputStream;
            }

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
            }
        }
    }

    public static class OutputFileResults {
        private final Uri mSavedUri;

        public Uri getSavedUri() {
            return this.mSavedUri;
        }

        public OutputFileResults(Uri uri) {
            this.mSavedUri = uri;
        }
    }

    public static final class Metadata {
        private boolean mIsReversedHorizontal;
        private boolean mIsReversedHorizontalSet = false;
        private boolean mIsReversedVertical;
        private Location mLocation;

        public Location getLocation() {
            return this.mLocation;
        }

        public boolean isReversedHorizontal() {
            return this.mIsReversedHorizontal;
        }

        public boolean isReversedHorizontalSet() {
            return this.mIsReversedHorizontalSet;
        }

        public boolean isReversedVertical() {
            return this.mIsReversedVertical;
        }

        public void setLocation(Location location) {
            this.mLocation = location;
        }

        public void setReversedHorizontal(boolean z) {
            this.mIsReversedHorizontal = z;
            this.mIsReversedHorizontalSet = true;
        }

        public void setReversedVertical(boolean z) {
            this.mIsReversedVertical = z;
        }

        public String toString() {
            return "Metadata{mIsReversedHorizontal=" + this.mIsReversedHorizontal + ", mIsReversedVertical=" + this.mIsReversedVertical + ", mLocation=" + this.mLocation + "}";
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, IoConfig.Builder<Builder>, ImageInputConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(ImageCapture.class)) {
                setCaptureType(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
                setTargetClass((Class<ImageCapture>) ImageCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        public static Builder fromConfig(Config config) {
            return new Builder(MutableOptionsBundle.from(config));
        }

        static Builder fromConfig(ImageCaptureConfig imageCaptureConfig) {
            return new Builder(MutableOptionsBundle.from(imageCaptureConfig));
        }

        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public ImageCapture build() {
            Integer num = (Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (num != null) {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, num);
            } else if (ImageCapture.isOutputFormatUltraHdr(getMutableConfig())) {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.HDR_UNSPECIFIED_10_BIT);
            } else {
                getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            }
            ImageCaptureConfig useCaseConfig = getUseCaseConfig();
            ImageOutputConfig.CC.validateConfig(useCaseConfig);
            ImageCapture imageCapture = new ImageCapture(useCaseConfig);
            Size size = (Size) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, null);
            if (size != null) {
                imageCapture.setCropAspectRatio(new Rational(size.getWidth(), size.getHeight()));
            }
            Preconditions.checkNotNull((Executor) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_IO_EXECUTOR, CameraXExecutors.ioExecutor()), "The IO executor can't be null");
            if (getMutableConfig().containsOption(ImageCaptureConfig.OPTION_FLASH_MODE)) {
                Integer num2 = (Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_FLASH_MODE);
                if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set: " + num2);
                } else if (num2.intValue() == 3 && getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, null) == null) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
                }
            }
            return imageCapture;
        }

        public Builder setCaptureMode(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, Integer.valueOf(i));
            return this;
        }

        public Builder setFlashMode(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, Integer.valueOf(i));
            return this;
        }

        public Builder setScreenFlash(ScreenFlash screenFlash) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, screenFlash);
            return this;
        }

        public Builder setBufferFormat(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, Integer.valueOf(i));
            return this;
        }

        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        public Builder setCustomOrderedResolutions(List<Size> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
            return this;
        }

        public Builder setTargetClass(Class<ImageCapture> cls) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        @Deprecated
        public Builder setTargetAspectRatio(int i) {
            if (i == -1) {
                i = 0;
            }
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetRotation(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i));
            return this;
        }

        public Builder setMirrorMode(int i) {
            throw new UnsupportedOperationException("setMirrorMode is not supported.");
        }

        @Deprecated
        public Builder setTargetResolution(Size size) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, size);
            return this;
        }

        public Builder setDefaultResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        public Builder setMaxResolution(Size size) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        public Builder setResolutionSelector(ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        public Builder setPostviewEnabled(boolean z) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.valueOf(z));
            return this;
        }

        public Builder setPostviewResolutionSelector(ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        public Builder setImageReaderProxyProvider(ImageReaderProxyProvider imageReaderProxyProvider) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, imageReaderProxyProvider);
            return this;
        }

        public Builder setSoftwareJpegEncoderRequested(boolean z) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.valueOf(z));
            return this;
        }

        public Builder setFlashType(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_TYPE, Integer.valueOf(i));
            return this;
        }

        public Builder setJpegQuality(int i) {
            Preconditions.checkArgumentInRange(i, 1, 100, "jpegQuality");
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(i));
            return this;
        }

        public Builder setIoExecutor(Executor executor) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IO_EXECUTOR, executor);
            return this;
        }

        public Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        public Builder setOutputFormat(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, Integer.valueOf(i));
            return this;
        }

        public Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setSurfaceOccupancyPriority(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i));
            return this;
        }

        public Builder setZslDisabled(boolean z) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z));
            return this;
        }

        public Builder setHighResolutionDisabled(boolean z) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z));
            return this;
        }

        public Builder setCaptureType(UseCaseConfigFactory.CaptureType captureType) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
            return this;
        }

        public Builder setDynamicRange(DynamicRange dynamicRange) {
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            return this;
        }
    }
}
