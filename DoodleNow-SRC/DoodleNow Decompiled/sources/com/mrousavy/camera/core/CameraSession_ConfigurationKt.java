package com.mrousavy.camera.core;

import android.util.Log;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.ZoomState;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.lifecycle.Lifecycle;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.extensions.ImageAnalysis_Builder_setTargetFrameRateKt;
import com.mrousavy.camera.core.extensions.ResolutionSelector_forAspectRatioKt;
import com.mrousavy.camera.core.extensions.ResolutionSelector_forSizeKt;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\f0\tH\u0000\u001a\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\"\u0010\u0012\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0011H\u0000¨\u0006\u001b"}, d2 = {"assertFormatRequirement", "", "propName", "", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "throwIfNotMet", "Lcom/mrousavy/camera/core/CameraError;", "requirement", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getTargetFpsRange", "Landroid/util/Range;", "", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration;", "configureCamera", "Lcom/mrousavy/camera/core/CameraSession;", "provider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "(Lcom/mrousavy/camera/core/CameraSession;Landroidx/camera/lifecycle/ProcessCameraProvider;Lcom/mrousavy/camera/core/CameraConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureIsActive", "config", "configureOutputs", "configureSideProps", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraSession+Configuration.kt */
public final class CameraSession_ConfigurationKt {
    public static final Range<Integer> getTargetFpsRange(CameraConfiguration cameraConfiguration) {
        Intrinsics.checkNotNullParameter(cameraConfiguration, "configuration");
        Integer fps = cameraConfiguration.getFps();
        if (fps == null) {
            return null;
        }
        int intValue = fps.intValue();
        if (cameraConfiguration.getEnableLowLightBoost()) {
            return new Range<>(Integer.valueOf(intValue / 2), Integer.valueOf(intValue));
        }
        return new Range<>(Integer.valueOf(intValue), Integer.valueOf(intValue));
    }

    public static final void assertFormatRequirement(String str, CameraDeviceFormat cameraDeviceFormat, CameraError cameraError, Function1<? super CameraDeviceFormat, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "propName");
        Intrinsics.checkNotNullParameter(cameraError, "throwIfNotMet");
        Intrinsics.checkNotNullParameter(function1, "requirement");
        if (cameraDeviceFormat == null) {
            throw new PropRequiresFormatToBeNonNullError(str);
        } else if (!function1.invoke(cameraDeviceFormat).booleanValue()) {
            throw cameraError;
        }
    }

    public static final void configureOutputs(CameraSession cameraSession, CameraConfiguration cameraConfiguration) {
        CameraSession cameraSession2 = cameraSession;
        CameraConfiguration cameraConfiguration2 = cameraConfiguration;
        Intrinsics.checkNotNullParameter(cameraSession2, "<this>");
        Intrinsics.checkNotNullParameter(cameraConfiguration2, "configuration");
        String cameraId = cameraConfiguration.getCameraId();
        Log.i(CameraSession.TAG, "Creating new Outputs for Camera #" + cameraId + "...");
        Range<Integer> targetFpsRange = getTargetFpsRange(cameraConfiguration);
        CameraDeviceFormat format = cameraConfiguration.getFormat();
        Log.i(CameraSession.TAG, "Using FPS Range: " + targetFpsRange);
        CameraConfiguration.Output<CameraConfiguration.Photo> photo = cameraConfiguration.getPhoto();
        CameraConfiguration.Output.Enabled enabled = photo instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) photo : null;
        CameraConfiguration.Output<CameraConfiguration.Video> video = cameraConfiguration.getVideo();
        CameraConfiguration.Output.Enabled enabled2 = video instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) video : null;
        CameraConfiguration.Output<CameraConfiguration.Preview> preview = cameraConfiguration.getPreview();
        CameraConfiguration.Output.Enabled enabled3 = preview instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) preview : null;
        if (enabled3 != null) {
            Log.i(CameraSession.TAG, "Creating Preview output...");
            Preview.Builder builder = new Preview.Builder();
            if (cameraConfiguration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.CINEMATIC)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(cameraConfiguration.getVideoStabilizationMode()), new CameraSession_ConfigurationKt$configureOutputs$preview$1$1(cameraConfiguration2));
                builder.setPreviewStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Integer upper = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(upper.intValue()), new CameraSession_ConfigurationKt$configureOutputs$preview$1$2(targetFpsRange));
                builder.setTargetFrameRate(targetFpsRange);
            }
            Float targetPreviewAspectRatio = cameraConfiguration.getTargetPreviewAspectRatio();
            if (targetPreviewAspectRatio != null) {
                Log.i(CameraSession.TAG, "Preview aspect ratio: " + targetPreviewAspectRatio);
                ResolutionSelector build = ResolutionSelector_forAspectRatioKt.forAspectRatio(new ResolutionSelector.Builder(), targetPreviewAspectRatio.floatValue()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                builder.setResolutionSelector(build);
            }
            Preview build2 = builder.build();
            Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
            build2.setSurfaceProvider(((CameraConfiguration.Preview) enabled3.getConfig()).getSurfaceProvider());
            cameraSession2.setPreviewOutput$react_native_vision_camera_release(build2);
        } else {
            cameraSession2.setPreviewOutput$react_native_vision_camera_release((Preview) null);
        }
        if (enabled != null) {
            Log.i(CameraSession.TAG, "Creating Photo output...");
            ImageCapture.Builder builder2 = new ImageCapture.Builder();
            builder2.setCaptureMode(((CameraConfiguration.Photo) enabled.getConfig()).getPhotoQualityBalance().toCaptureMode());
            if (format != null) {
                Size photoSize = format.getPhotoSize();
                Log.i(CameraSession.TAG, "Photo size: " + photoSize);
                ResolutionSelector build3 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getPhotoSize()).setAllowedResolutionMode(1).build();
                Intrinsics.checkNotNullExpressionValue(build3, "build(...)");
                builder2.setResolutionSelector(build3);
            }
            ImageCapture build4 = builder2.build();
            Intrinsics.checkNotNullExpressionValue(build4, "build(...)");
            cameraSession2.setPhotoOutput$react_native_vision_camera_release(build4);
        } else {
            cameraSession2.setPhotoOutput$react_native_vision_camera_release((ImageCapture) null);
        }
        if (enabled2 != null) {
            Log.i(CameraSession.TAG, "Creating Video output...");
            Recorder recorderOutput$react_native_vision_camera_release = cameraSession.getRecorderOutput$react_native_vision_camera_release();
            if (cameraSession.getRecording$react_native_vision_camera_release() == null || recorderOutput$react_native_vision_camera_release == null) {
                Log.i(CameraSession.TAG, "Creating new Recorder...");
                Recorder.Builder builder3 = new Recorder.Builder();
                CameraDeviceFormat format2 = cameraConfiguration.getFormat();
                if (format2 != null) {
                    builder3.setQualitySelector(format2.getVideoQualitySelector());
                }
                recorderOutput$react_native_vision_camera_release = builder3.build();
                Intrinsics.checkNotNull(recorderOutput$react_native_vision_camera_release);
            } else {
                Log.i(CameraSession.TAG, "Re-using active Recorder because we are currently recording...");
            }
            VideoCapture.Builder builder4 = new VideoCapture.Builder(recorderOutput$react_native_vision_camera_release);
            builder4.setMirrorMode(2);
            if (cameraConfiguration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.STANDARD)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(cameraConfiguration.getVideoStabilizationMode()), new CameraSession_ConfigurationKt$configureOutputs$video$1$1(cameraConfiguration2));
                builder4.setVideoStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Integer upper2 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper2, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(upper2.intValue()), new CameraSession_ConfigurationKt$configureOutputs$video$1$2(targetFpsRange));
                builder4.setTargetFrameRate(targetFpsRange);
            }
            if (((CameraConfiguration.Video) enabled2.getConfig()).getEnableHdr()) {
                assertFormatRequirement("videoHdr", format, new InvalidVideoHdrError(), CameraSession_ConfigurationKt$configureOutputs$video$1$3.INSTANCE);
                builder4.setDynamicRange(DynamicRange.HDR_UNSPECIFIED_10_BIT);
            }
            if (format != null) {
                Size videoSize = format.getVideoSize();
                Log.i(CameraSession.TAG, "Video size: " + videoSize);
                ResolutionSelector build5 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(build5, "build(...)");
                builder4.setResolutionSelector(build5);
            }
            VideoCapture build6 = builder4.build();
            Intrinsics.checkNotNullExpressionValue(build6, "build(...)");
            cameraSession2.setVideoOutput$react_native_vision_camera_release(build6);
            cameraSession2.setRecorderOutput$react_native_vision_camera_release(recorderOutput$react_native_vision_camera_release);
        } else {
            cameraSession2.setVideoOutput$react_native_vision_camera_release((VideoCapture<Recorder>) null);
            cameraSession2.setRecorderOutput$react_native_vision_camera_release((Recorder) null);
        }
        CameraConfiguration.Output<CameraConfiguration.FrameProcessor> frameProcessor = cameraConfiguration.getFrameProcessor();
        CameraConfiguration.Output.Enabled enabled4 = frameProcessor instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) frameProcessor : null;
        if (enabled4 != null) {
            PixelFormat pixelFormat = ((CameraConfiguration.FrameProcessor) enabled4.getConfig()).getPixelFormat();
            Log.i(CameraSession.TAG, "Creating " + pixelFormat + " Frame Processor output...");
            ImageAnalysis.Builder builder5 = new ImageAnalysis.Builder();
            builder5.setBackpressureStrategy(1);
            builder5.setOutputImageFormat(pixelFormat.toImageAnalysisFormat());
            if (targetFpsRange != null) {
                Integer upper3 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper3, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(upper3.intValue()), new CameraSession_ConfigurationKt$configureOutputs$analyzer$1$1(targetFpsRange));
                ImageAnalysis_Builder_setTargetFrameRateKt.setTargetFrameRate(builder5, targetFpsRange);
            }
            if (format != null) {
                Size videoSize2 = format.getVideoSize();
                Log.i(CameraSession.TAG, "Frame Processor size: " + videoSize2);
                ResolutionSelector build7 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(build7, "build(...)");
                builder5.setResolutionSelector(build7);
            }
            ImageAnalysis build8 = builder5.build();
            Intrinsics.checkNotNullExpressionValue(build8, "build(...)");
            build8.setAnalyzer(CameraQueues.Companion.getVideoQueue().getExecutor(), new FrameProcessorPipeline(cameraSession.getCallback$react_native_vision_camera_release()));
            cameraSession2.setFrameProcessorOutput$react_native_vision_camera_release(build8);
        } else {
            cameraSession2.setFrameProcessorOutput$react_native_vision_camera_release((ImageAnalysis) null);
        }
        CameraConfiguration.Output<CameraConfiguration.CodeScanner> codeScanner = cameraConfiguration.getCodeScanner();
        CameraConfiguration.Output.Enabled enabled5 = codeScanner instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) codeScanner : null;
        if (enabled5 != null) {
            Log.i(CameraSession.TAG, "Creating CodeScanner output...");
            ImageAnalysis.Builder builder6 = new ImageAnalysis.Builder();
            ResolutionSelector build9 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), new Size(1280, 720)).build();
            Intrinsics.checkNotNullExpressionValue(build9, "build(...)");
            builder6.setResolutionSelector(build9);
            ImageAnalysis build10 = builder6.build();
            Intrinsics.checkNotNullExpressionValue(build10, "build(...)");
            build10.setAnalyzer(CameraQueues.Companion.getAnalyzerExecutor(), new CodeScannerPipeline((CameraConfiguration.CodeScanner) enabled5.getConfig(), cameraSession.getCallback$react_native_vision_camera_release()));
            cameraSession2.setCodeScannerOutput$react_native_vision_camera_release(build10);
        } else {
            cameraSession2.setCodeScannerOutput$react_native_vision_camera_release((ImageAnalysis) null);
        }
        String cameraId2 = cameraConfiguration.getCameraId();
        Log.i(CameraSession.TAG, "Successfully created new Outputs for Camera #" + cameraId2 + "!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fe, code lost:
        r3 = r3.getCameraInfo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object configureCamera(com.mrousavy.camera.core.CameraSession r20, androidx.camera.lifecycle.ProcessCameraProvider r21, com.mrousavy.camera.core.CameraConfiguration r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1 r1 = (com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1 r1 = new com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            java.lang.String r11 = "..."
            r12 = 2
            java.lang.String r13 = "CameraSession"
            r14 = 0
            r15 = 1
            if (r2 == 0) goto L_0x0068
            if (r2 == r15) goto L_0x004d
            if (r2 != r12) goto L_0x0045
            java.lang.Object r2 = r1.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r1.L$2
            com.mrousavy.camera.core.CameraConfiguration r3 = (com.mrousavy.camera.core.CameraConfiguration) r3
            java.lang.Object r4 = r1.L$1
            androidx.camera.lifecycle.ProcessCameraProvider r4 = (androidx.camera.lifecycle.ProcessCameraProvider) r4
            java.lang.Object r1 = r1.L$0
            com.mrousavy.camera.core.CameraSession r1 = (com.mrousavy.camera.core.CameraSession) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x01cc
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            int r2 = r1.I$2
            int r3 = r1.I$1
            int r4 = r1.I$0
            java.lang.Object r5 = r1.L$3
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r1.L$2
            com.mrousavy.camera.core.CameraConfiguration r6 = (com.mrousavy.camera.core.CameraConfiguration) r6
            java.lang.Object r7 = r1.L$1
            androidx.camera.lifecycle.ProcessCameraProvider r7 = (androidx.camera.lifecycle.ProcessCameraProvider) r7
            java.lang.Object r8 = r1.L$0
            com.mrousavy.camera.core.CameraSession r8 = (com.mrousavy.camera.core.CameraSession) r8
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0171
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = r22.getCameraId()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Binding Camera #"
            r2.<init>(r3)
            r2.append(r0)
            r2.append(r11)
            java.lang.String r0 = r2.toString()
            android.util.Log.i(r13, r0)
            r20.checkCameraPermission$react_native_vision_camera_release()
            r0 = 5
            androidx.camera.core.UseCase[] r0 = new androidx.camera.core.UseCase[r0]
            androidx.camera.core.Preview r2 = r20.getPreviewOutput$react_native_vision_camera_release()
            r0[r14] = r2
            androidx.camera.core.ImageCapture r2 = r20.getPhotoOutput$react_native_vision_camera_release()
            r0[r15] = r2
            androidx.camera.video.VideoCapture r2 = r20.getVideoOutput$react_native_vision_camera_release()
            r0[r12] = r2
            r2 = 3
            androidx.camera.core.ImageAnalysis r3 = r20.getFrameProcessorOutput$react_native_vision_camera_release()
            r0[r2] = r3
            r2 = 4
            androidx.camera.core.ImageAnalysis r3 = r20.getCodeScannerOutput$react_native_vision_camera_release()
            r0[r2] = r3
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull((T[]) r0)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x02c4
            java.lang.String r2 = r22.getCameraId()
            if (r2 == 0) goto L_0x02be
            androidx.camera.core.CameraSelector$Builder r3 = new androidx.camera.core.CameraSelector$Builder
            r3.<init>()
            androidx.camera.core.CameraSelector$Builder r2 = com.mrousavy.camera.core.extensions.CameraSelector_byIdKt.byId(r3, r2)
            androidx.camera.core.CameraSelector r2 = r2.build()
            java.lang.String r3 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L_0x00dd
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00dd
        L_0x00db:
            r8 = r14
            goto L_0x0102
        L_0x00dd:
            java.util.Iterator r3 = r3.iterator()
        L_0x00e1:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00db
            java.lang.Object r4 = r3.next()
            androidx.camera.core.UseCase r4 = (androidx.camera.core.UseCase) r4
            androidx.camera.core.impl.UseCaseConfig r4 = r4.getCurrentConfig()
            androidx.camera.core.DynamicRange r4 = r4.getDynamicRange()
            java.lang.String r5 = "getDynamicRange(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r4 = com.mrousavy.camera.core.extensions.DynamicRange_isSDRKt.isSDR(r4)
            r4 = r4 ^ r15
            if (r4 == 0) goto L_0x00e1
            r8 = r15
        L_0x0102:
            androidx.camera.core.ImageAnalysis r3 = r20.getCodeScannerOutput$react_native_vision_camera_release()
            if (r3 != 0) goto L_0x0111
            androidx.camera.core.ImageAnalysis r3 = r20.getFrameProcessorOutput$react_native_vision_camera_release()
            if (r3 == 0) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r7 = r14
            goto L_0x0112
        L_0x0111:
            r7 = r15
        L_0x0112:
            com.mrousavy.camera.core.CameraConfiguration$Output r3 = r22.getPhoto()
            boolean r4 = r3 instanceof com.mrousavy.camera.core.CameraConfiguration.Output.Enabled
            if (r4 == 0) goto L_0x011d
            com.mrousavy.camera.core.CameraConfiguration$Output$Enabled r3 = (com.mrousavy.camera.core.CameraConfiguration.Output.Enabled) r3
            goto L_0x011e
        L_0x011d:
            r3 = 0
        L_0x011e:
            if (r3 == 0) goto L_0x012e
            java.lang.Object r3 = r3.getConfig()
            com.mrousavy.camera.core.CameraConfiguration$Photo r3 = (com.mrousavy.camera.core.CameraConfiguration.Photo) r3
            boolean r3 = r3.getEnableHdr()
            if (r3 == 0) goto L_0x012e
            r6 = r15
            goto L_0x012f
        L_0x012e:
            r6 = r14
        L_0x012f:
            if (r6 == 0) goto L_0x0187
            if (r8 != 0) goto L_0x0181
            android.content.Context r3 = r20.getContext$react_native_vision_camera_release()
            r16 = 2
            java.lang.String r17 = "HDR"
            r5 = r20
            r1.L$0 = r5
            r4 = r21
            r1.L$1 = r4
            r10 = r22
            r1.L$2 = r10
            r1.L$3 = r0
            r1.I$0 = r8
            r1.I$1 = r7
            r1.I$2 = r6
            r1.label = r15
            r5 = r7
            r18 = r6
            r6 = r16
            r16 = r7
            r7 = r17
            r17 = r8
            r8 = r1
            java.lang.Object r2 = com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt.withExtension(r2, r3, r4, r5, r6, r7, r8)
            if (r2 != r9) goto L_0x0164
            return r9
        L_0x0164:
            r8 = r20
            r7 = r21
            r5 = r0
            r0 = r2
            r6 = r10
            r3 = r16
            r4 = r17
            r2 = r18
        L_0x0171:
            androidx.camera.core.CameraSelector r0 = (androidx.camera.core.CameraSelector) r0
            r16 = r3
            r17 = r4
            r10 = r7
            r7 = r5
            r19 = r2
            r2 = r0
            r0 = r8
            r8 = r6
            r6 = r19
            goto L_0x0195
        L_0x0181:
            com.mrousavy.camera.core.PhotoHdrAndVideoHdrNotSupportedSimultaneously r0 = new com.mrousavy.camera.core.PhotoHdrAndVideoHdrNotSupportedSimultaneously
            r0.<init>()
            throw r0
        L_0x0187:
            r10 = r22
            r18 = r6
            r16 = r7
            r17 = r8
            r7 = r0
            r8 = r10
            r0 = r20
            r10 = r21
        L_0x0195:
            boolean r3 = r8.getEnableLowLightBoost()
            if (r3 == 0) goto L_0x01e0
            if (r17 != 0) goto L_0x01da
            if (r6 != 0) goto L_0x01d4
            android.content.Context r3 = r0.getContext$react_native_vision_camera_release()
            if (r16 == 0) goto L_0x01a7
            r5 = r15
            goto L_0x01a8
        L_0x01a7:
            r5 = r14
        L_0x01a8:
            r6 = 3
            java.lang.String r16 = "NIGHT"
            r1.L$0 = r0
            r1.L$1 = r10
            r1.L$2 = r8
            r1.L$3 = r7
            r1.label = r12
            r4 = r10
            r12 = r7
            r7 = r16
            r16 = r8
            r8 = r1
            java.lang.Object r1 = com.mrousavy.camera.core.extensions.CameraSelector_withExtensionKt.withExtension(r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r9) goto L_0x01c3
            return r9
        L_0x01c3:
            r4 = r10
            r2 = r12
            r3 = r16
            r19 = r1
            r1 = r0
            r0 = r19
        L_0x01cc:
            androidx.camera.core.CameraSelector r0 = (androidx.camera.core.CameraSelector) r0
            r7 = r2
            r8 = r3
            r10 = r4
            r2 = r0
            r0 = r1
            goto L_0x01e3
        L_0x01d4:
            com.mrousavy.camera.core.LowLightBoostNotSupportedWithHdr r0 = new com.mrousavy.camera.core.LowLightBoostNotSupportedWithHdr
            r0.<init>()
            throw r0
        L_0x01da:
            com.mrousavy.camera.core.LowLightBoostNotSupportedWithHdr r0 = new com.mrousavy.camera.core.LowLightBoostNotSupportedWithHdr
            r0.<init>()
            throw r0
        L_0x01e0:
            r12 = r7
            r16 = r8
        L_0x01e3:
            java.util.List r1 = r0.getCurrentUseCases$react_native_vision_camera_release()
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r15
            if (r1 == 0) goto L_0x023e
            java.util.List r1 = r0.getCurrentUseCases$react_native_vision_camera_release()
            int r1 = r1.size()
            androidx.camera.core.Camera r3 = r0.getCamera$react_native_vision_camera_release()
            if (r3 == 0) goto L_0x0209
            androidx.camera.core.CameraInfo r3 = r3.getCameraInfo()
            if (r3 == 0) goto L_0x0209
            java.lang.String r3 = com.mrousavy.camera.core.extensions.CameraInfo_idKt.getId(r3)
            goto L_0x020a
        L_0x0209:
            r3 = 0
        L_0x020a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Unbinding "
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = " use-cases for Camera #"
            r4.append(r1)
            r4.append(r3)
            r4.append(r11)
            java.lang.String r1 = r4.toString()
            android.util.Log.i(r13, r1)
            java.util.List r1 = r0.getCurrentUseCases$react_native_vision_camera_release()
            java.util.Collection r1 = (java.util.Collection) r1
            androidx.camera.core.UseCase[] r3 = new androidx.camera.core.UseCase[r14]
            java.lang.Object[] r1 = r1.toArray(r3)
            androidx.camera.core.UseCase[] r1 = (androidx.camera.core.UseCase[]) r1
            int r3 = r1.length
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            androidx.camera.core.UseCase[] r1 = (androidx.camera.core.UseCase[]) r1
            r10.unbind(r1)
        L_0x023e:
            int r1 = r7.size()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Binding "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " use-cases..."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.i(r13, r1)
            r1 = r0
            androidx.lifecycle.LifecycleOwner r1 = (androidx.lifecycle.LifecycleOwner) r1
            r3 = r7
            java.util.Collection r3 = (java.util.Collection) r3
            androidx.camera.core.UseCase[] r4 = new androidx.camera.core.UseCase[r14]
            java.lang.Object[] r3 = r3.toArray(r4)
            androidx.camera.core.UseCase[] r3 = (androidx.camera.core.UseCase[]) r3
            int r4 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            androidx.camera.core.UseCase[] r3 = (androidx.camera.core.UseCase[]) r3
            androidx.camera.core.Camera r2 = r10.bindToLifecycle((androidx.lifecycle.LifecycleOwner) r1, (androidx.camera.core.CameraSelector) r2, (androidx.camera.core.UseCase[]) r3)
            r0.setCamera$react_native_vision_camera_release(r2)
            com.mrousavy.camera.core.CameraSession$Callback r2 = r0.getCallback$react_native_vision_camera_release()
            r2.onInitialized()
            r0.setCurrentUseCases$react_native_vision_camera_release(r7)
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            androidx.camera.core.Camera r3 = r0.getCamera$react_native_vision_camera_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.camera.core.CameraInfo r3 = r3.getCameraInfo()
            androidx.lifecycle.LiveData r3 = r3.getCameraState()
            com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$2 r4 = new com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$2
            r4.<init>(r2, r0)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda0 r0 = new com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda0
            r0.<init>(r4)
            r3.observe(r1, r0)
            java.lang.String r0 = r8.getCameraId()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Successfully bound Camera #"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = "!"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.i(r13, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02be:
            com.mrousavy.camera.core.NoCameraDeviceError r0 = new com.mrousavy.camera.core.NoCameraDeviceError
            r0.<init>()
            throw r0
        L_0x02c4:
            com.mrousavy.camera.core.NoOutputsError r0 = new com.mrousavy.camera.core.NoOutputsError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_ConfigurationKt.configureCamera(com.mrousavy.camera.core.CameraSession, androidx.camera.lifecycle.ProcessCameraProvider, com.mrousavy.camera.core.CameraConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void configureCamera$lambda$8(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void configureSideProps(CameraSession cameraSession, CameraConfiguration cameraConfiguration) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(cameraConfiguration, "config");
        Camera camera$react_native_vision_camera_release = cameraSession.getCamera$react_native_vision_camera_release();
        if (camera$react_native_vision_camera_release != null) {
            ZoomState value = camera$react_native_vision_camera_release.getCameraInfo().getZoomState().getValue();
            if (!Intrinsics.areEqual(value != null ? Float.valueOf(value.getZoomRatio()) : null, cameraConfiguration.getZoom())) {
                camera$react_native_vision_camera_release.getCameraControl().setZoomRatio(cameraConfiguration.getZoom());
            }
            Integer value2 = camera$react_native_vision_camera_release.getCameraInfo().getTorchState().getValue();
            int i = 0;
            boolean z = true;
            boolean z2 = value2 != null && value2.intValue() == 1;
            if (cameraConfiguration.getTorch() != Torch.ON) {
                z = false;
            }
            if (z2 != z) {
                if (!z || camera$react_native_vision_camera_release.getCameraInfo().hasFlashUnit()) {
                    camera$react_native_vision_camera_release.getCameraControl().enableTorch(z);
                } else {
                    throw new FlashUnavailableError();
                }
            }
            int exposureCompensationIndex = camera$react_native_vision_camera_release.getCameraInfo().getExposureState().getExposureCompensationIndex();
            Double exposure = cameraConfiguration.getExposure();
            if (exposure != null) {
                i = MathKt.roundToInt(exposure.doubleValue());
            }
            if (exposureCompensationIndex != i) {
                camera$react_native_vision_camera_release.getCameraControl().setExposureCompensationIndex(i);
                return;
            }
            return;
        }
        throw new CameraNotReadyError();
    }

    public static final void configureIsActive(CameraSession cameraSession, CameraConfiguration cameraConfiguration) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(cameraConfiguration, "config");
        if (cameraConfiguration.isActive()) {
            cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.STARTED);
            cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.RESUMED);
            return;
        }
        cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.STARTED);
        cameraSession.getLifecycleRegistry$react_native_vision_camera_release().setCurrentState(Lifecycle.State.CREATED);
    }
}
