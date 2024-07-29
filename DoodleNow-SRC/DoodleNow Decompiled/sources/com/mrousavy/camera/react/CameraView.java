package com.mrousavy.camera.react;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.view.PreviewView;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.CodeScannerFrame;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeScannerOptions;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.PreviewViewType;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.ResizeMode;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.frameprocessors.Frame;
import com.mrousavy.camera.frameprocessors.FrameProcessor;
import com.mrousavy.camera.react.FpsSampleCollector;
import com.mrousavy.camera.react.extensions.ViewGroup_installHierarchyFitterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ·\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002·\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0001\u001a\u00020tH\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0014J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u000206H\u0016J%\u0010\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u00012\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u0001H\u0014J\u0014\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0014\u0010§\u0001\u001a\u00030\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0016J\n\u0010ª\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010«\u0001\u001a\u00030\u00012\u0007\u0010X\u001a\u00030¬\u0001H\u0016J\u0014\u0010­\u0001\u001a\u00030\u00012\b\u0010®\u0001\u001a\u00030¬\u0001H\u0016J\u0014\u0010¯\u0001\u001a\u00030\u00012\b\u0010°\u0001\u001a\u00030±\u0001H\u0016J\n\u0010²\u0001\u001a\u00030\u0001H\u0016J\n\u0010³\u0001\u001a\u00030\u0001H\u0016J\b\u0010´\u0001\u001a\u00030\u0001J\n\u0010µ\u0001\u001a\u00030\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030\u0001H\u0003R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\u001a\u0010,\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R\u001a\u0010/\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R$\u00102\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010H\u001a\u00020IX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0011\"\u0004\bQ\u0010\u0013R\u000e\u0010R\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R\u000e\u0010V\u001a\u00020WX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020YX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0011\"\u0004\b`\u0010\u0013R\u001a\u0010a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0011\"\u0004\bc\u0010\u0013R\u001a\u0010d\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020kX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010p\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0011\"\u0004\br\u0010\u0013R\u001c\u0010s\u001a\u0004\u0018\u00010tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010z\u001a\u00020y2\u0006\u0010\u0007\u001a\u00020y@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001f\u0010\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u000fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0011\"\u0005\b\u0001\u0010\u0013R\u001d\u0010\u0001\u001a\u00020\u000fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0011\"\u0005\b\u0001\u0010\u0013R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006¸\u0001"}, d2 = {"Lcom/mrousavy/camera/react/CameraView;", "Landroid/widget/FrameLayout;", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lcom/mrousavy/camera/core/types/PreviewViewType;", "androidPreviewViewType", "getAndroidPreviewViewType", "()Lcom/mrousavy/camera/core/types/PreviewViewType;", "setAndroidPreviewViewType", "(Lcom/mrousavy/camera/core/types/PreviewViewType;)V", "audio", "", "getAudio", "()Z", "setAudio", "(Z)V", "cameraId", "", "getCameraId", "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "cameraSession", "Lcom/mrousavy/camera/core/CameraSession;", "getCameraSession$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraSession;", "codeScannerOptions", "Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "getCodeScannerOptions", "()Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "setCodeScannerOptions", "(Lcom/mrousavy/camera/core/types/CodeScannerOptions;)V", "currentConfigureCall", "", "enableDepthData", "getEnableDepthData", "setEnableDepthData", "enableFrameProcessor", "getEnableFrameProcessor", "setEnableFrameProcessor", "enableLocation", "getEnableLocation", "setEnableLocation", "enablePortraitEffectsMatteDelivery", "getEnablePortraitEffectsMatteDelivery", "setEnablePortraitEffectsMatteDelivery", "enableZoomGesture", "getEnableZoomGesture", "setEnableZoomGesture", "exposure", "", "getExposure", "()D", "setExposure", "(D)V", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "getFormat", "()Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "setFormat", "(Lcom/mrousavy/camera/core/types/CameraDeviceFormat;)V", "fps", "", "getFps", "()Ljava/lang/Integer;", "setFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fpsSampleCollector", "Lcom/mrousavy/camera/react/FpsSampleCollector;", "frameProcessor", "Lcom/mrousavy/camera/frameprocessors/FrameProcessor;", "getFrameProcessor$react_native_vision_camera_release", "()Lcom/mrousavy/camera/frameprocessors/FrameProcessor;", "setFrameProcessor$react_native_vision_camera_release", "(Lcom/mrousavy/camera/frameprocessors/FrameProcessor;)V", "isActive", "setActive", "isMounted", "lowLightBoost", "getLowLightBoost", "setLowLightBoost", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "outputOrientation", "Lcom/mrousavy/camera/core/types/OutputOrientation;", "getOutputOrientation", "()Lcom/mrousavy/camera/core/types/OutputOrientation;", "setOutputOrientation", "(Lcom/mrousavy/camera/core/types/OutputOrientation;)V", "photo", "getPhoto", "setPhoto", "photoHdr", "getPhotoHdr", "setPhotoHdr", "photoQualityBalance", "Lcom/mrousavy/camera/core/types/QualityBalance;", "getPhotoQualityBalance", "()Lcom/mrousavy/camera/core/types/QualityBalance;", "setPhotoQualityBalance", "(Lcom/mrousavy/camera/core/types/QualityBalance;)V", "pixelFormat", "Lcom/mrousavy/camera/core/types/PixelFormat;", "getPixelFormat", "()Lcom/mrousavy/camera/core/types/PixelFormat;", "setPixelFormat", "(Lcom/mrousavy/camera/core/types/PixelFormat;)V", "preview", "getPreview", "setPreview", "previewView", "Landroidx/camera/view/PreviewView;", "getPreviewView$react_native_vision_camera_release", "()Landroidx/camera/view/PreviewView;", "setPreviewView$react_native_vision_camera_release", "(Landroidx/camera/view/PreviewView;)V", "Lcom/mrousavy/camera/core/types/ResizeMode;", "resizeMode", "getResizeMode", "()Lcom/mrousavy/camera/core/types/ResizeMode;", "setResizeMode", "(Lcom/mrousavy/camera/core/types/ResizeMode;)V", "torch", "Lcom/mrousavy/camera/core/types/Torch;", "getTorch", "()Lcom/mrousavy/camera/core/types/Torch;", "setTorch", "(Lcom/mrousavy/camera/core/types/Torch;)V", "video", "getVideo", "setVideo", "videoHdr", "getVideoHdr", "setVideoHdr", "videoStabilizationMode", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "getVideoStabilizationMode", "()Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lcom/mrousavy/camera/core/types/VideoStabilizationMode;)V", "zoom", "", "getZoom", "()F", "setZoom", "(F)V", "createPreviewView", "destroy", "", "onAttachedToWindow", "onAverageFpsChanged", "averageFps", "onCodeScanned", "codes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "onDetachedFromWindow", "onError", "error", "", "onFrame", "frame", "Lcom/mrousavy/camera/frameprocessors/Frame;", "onInitialized", "onOutputOrientationChanged", "Lcom/mrousavy/camera/core/types/Orientation;", "onPreviewOrientationChanged", "previewOrientation", "onShutter", "type", "Lcom/mrousavy/camera/core/types/ShutterType;", "onStarted", "onStopped", "update", "updatePreview", "updateZoomGesture", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraView.kt */
public final class CameraView extends FrameLayout implements CameraSession.Callback, FpsSampleCollector.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CameraView";
    private PreviewViewType androidPreviewViewType = PreviewViewType.SURFACE_VIEW;
    private boolean audio;
    private String cameraId;
    private final CameraSession cameraSession;
    private CodeScannerOptions codeScannerOptions;
    /* access modifiers changed from: private */
    public long currentConfigureCall = System.currentTimeMillis();
    private boolean enableDepthData;
    private boolean enableFrameProcessor;
    private boolean enableLocation;
    private boolean enablePortraitEffectsMatteDelivery;
    private boolean enableZoomGesture;
    private double exposure;
    private CameraDeviceFormat format;
    private Integer fps;
    private final FpsSampleCollector fpsSampleCollector = new FpsSampleCollector(this);
    private FrameProcessor frameProcessor;
    private boolean isActive;
    private boolean isMounted;
    private boolean lowLightBoost;
    private final CoroutineScope mainCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private OutputOrientation outputOrientation = OutputOrientation.DEVICE;
    private boolean photo;
    private boolean photoHdr;
    private QualityBalance photoQualityBalance = QualityBalance.SPEED;
    private PixelFormat pixelFormat = PixelFormat.YUV;
    private boolean preview = true;
    private PreviewView previewView;
    private ResizeMode resizeMode = ResizeMode.COVER;
    private Torch torch = Torch.OFF;
    private boolean video;
    private boolean videoHdr;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom = 1.0f;

    public final PreviewViewType getAndroidPreviewViewType() {
        return this.androidPreviewViewType;
    }

    public final boolean getAudio() {
        return this.audio;
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final CameraSession getCameraSession$react_native_vision_camera_release() {
        return this.cameraSession;
    }

    public final CodeScannerOptions getCodeScannerOptions() {
        return this.codeScannerOptions;
    }

    public final boolean getEnableDepthData() {
        return this.enableDepthData;
    }

    public final boolean getEnableFrameProcessor() {
        return this.enableFrameProcessor;
    }

    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    public final boolean getEnablePortraitEffectsMatteDelivery() {
        return this.enablePortraitEffectsMatteDelivery;
    }

    public final boolean getEnableZoomGesture() {
        return this.enableZoomGesture;
    }

    public final double getExposure() {
        return this.exposure;
    }

    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final FrameProcessor getFrameProcessor$react_native_vision_camera_release() {
        return this.frameProcessor;
    }

    public final boolean getLowLightBoost() {
        return this.lowLightBoost;
    }

    public final OutputOrientation getOutputOrientation() {
        return this.outputOrientation;
    }

    public final boolean getPhoto() {
        return this.photo;
    }

    public final boolean getPhotoHdr() {
        return this.photoHdr;
    }

    public final QualityBalance getPhotoQualityBalance() {
        return this.photoQualityBalance;
    }

    public final PixelFormat getPixelFormat() {
        return this.pixelFormat;
    }

    public final boolean getPreview() {
        return this.preview;
    }

    public final PreviewView getPreviewView$react_native_vision_camera_release() {
        return this.previewView;
    }

    public final ResizeMode getResizeMode() {
        return this.resizeMode;
    }

    public final Torch getTorch() {
        return this.torch;
    }

    public final boolean getVideo() {
        return this.video;
    }

    public final boolean getVideoHdr() {
        return this.videoHdr;
    }

    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setAudio(boolean z) {
        this.audio = z;
    }

    public final void setCameraId(String str) {
        this.cameraId = str;
    }

    public final void setCodeScannerOptions(CodeScannerOptions codeScannerOptions2) {
        this.codeScannerOptions = codeScannerOptions2;
    }

    public final void setEnableDepthData(boolean z) {
        this.enableDepthData = z;
    }

    public final void setEnableFrameProcessor(boolean z) {
        this.enableFrameProcessor = z;
    }

    public final void setEnableLocation(boolean z) {
        this.enableLocation = z;
    }

    public final void setEnablePortraitEffectsMatteDelivery(boolean z) {
        this.enablePortraitEffectsMatteDelivery = z;
    }

    public final void setExposure(double d) {
        this.exposure = d;
    }

    public final void setFormat(CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    public final void setFps(Integer num) {
        this.fps = num;
    }

    public final void setFrameProcessor$react_native_vision_camera_release(FrameProcessor frameProcessor2) {
        this.frameProcessor = frameProcessor2;
    }

    public final void setLowLightBoost(boolean z) {
        this.lowLightBoost = z;
    }

    public final void setOutputOrientation(OutputOrientation outputOrientation2) {
        Intrinsics.checkNotNullParameter(outputOrientation2, "<set-?>");
        this.outputOrientation = outputOrientation2;
    }

    public final void setPhoto(boolean z) {
        this.photo = z;
    }

    public final void setPhotoHdr(boolean z) {
        this.photoHdr = z;
    }

    public final void setPhotoQualityBalance(QualityBalance qualityBalance) {
        Intrinsics.checkNotNullParameter(qualityBalance, "<set-?>");
        this.photoQualityBalance = qualityBalance;
    }

    public final void setPixelFormat(PixelFormat pixelFormat2) {
        Intrinsics.checkNotNullParameter(pixelFormat2, "<set-?>");
        this.pixelFormat = pixelFormat2;
    }

    public final void setPreviewView$react_native_vision_camera_release(PreviewView previewView2) {
        this.previewView = previewView2;
    }

    public final void setTorch(Torch torch2) {
        Intrinsics.checkNotNullParameter(torch2, "<set-?>");
        this.torch = torch2;
    }

    public final void setVideo(boolean z) {
        this.video = z;
    }

    public final void setVideoHdr(boolean z) {
        this.videoHdr = z;
    }

    public final void setVideoStabilizationMode(VideoStabilizationMode videoStabilizationMode2) {
        this.videoStabilizationMode = videoStabilizationMode2;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipToOutline(true);
        this.cameraSession = new CameraSession(context, this);
        ViewGroup_installHierarchyFitterKt.installHierarchyFitter(this);
        updatePreview();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/react/CameraView$Companion;", "", "()V", "TAG", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setPreview(boolean z) {
        this.preview = z;
        updatePreview();
    }

    public final void setAndroidPreviewViewType(PreviewViewType previewViewType) {
        Intrinsics.checkNotNullParameter(previewViewType, "value");
        this.androidPreviewViewType = previewViewType;
        updatePreview();
    }

    public final void setEnableZoomGesture(boolean z) {
        this.enableZoomGesture = z;
        updateZoomGesture();
    }

    public final void setResizeMode(ResizeMode resizeMode2) {
        Intrinsics.checkNotNullParameter(resizeMode2, "value");
        this.resizeMode = resizeMode2;
        updatePreview();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Log.i("CameraView", "CameraView attached to window!");
        super.onAttachedToWindow();
        if (!this.isMounted) {
            this.isMounted = true;
            CameraView_EventsKt.invokeOnViewReady(this);
        }
        this.fpsSampleCollector.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        Log.i("CameraView", "CameraView detached from window!");
        super.onDetachedFromWindow();
        this.fpsSampleCollector.stop();
    }

    public final void destroy() {
        this.cameraSession.close();
    }

    public final void update() {
        Log.i("CameraView", "Updating CameraSession...");
        long currentTimeMillis = System.currentTimeMillis();
        this.currentConfigureCall = currentTimeMillis;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CameraView$update$1(this, currentTimeMillis, (Continuation<? super CameraView$update$1>) null), 3, (Object) null);
    }

    private final void updateZoomGesture() {
        if (this.enableZoomGesture) {
            setOnTouchListener(new CameraView$$ExternalSyntheticLambda1(new ScaleGestureDetector(getContext(), new CameraView$updateZoomGesture$scaleGestureDetector$1(this))));
        } else {
            setOnTouchListener((View.OnTouchListener) null);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean updateZoomGesture$lambda$0(ScaleGestureDetector scaleGestureDetector, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "$scaleGestureDetector");
        return scaleGestureDetector.onTouchEvent(motionEvent);
    }

    private final void updatePreview() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CameraView$updatePreview$1(this, (Continuation<? super CameraView$updatePreview$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final PreviewView createPreviewView() {
        PreviewView previewView2 = new PreviewView(getContext());
        ViewGroup_installHierarchyFitterKt.installHierarchyFitter(previewView2);
        previewView2.setImplementationMode(this.androidPreviewViewType.toPreviewImplementationMode());
        previewView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        previewView2.getPreviewStreamState().observe(this.cameraSession, new CameraView$$ExternalSyntheticLambda0(new CameraView$createPreviewView$1$1(new Ref.BooleanRef(), this)));
        return previewView2;
    }

    /* access modifiers changed from: private */
    public static final void createPreviewView$lambda$2$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public void onFrame(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.fpsSampleCollector.onTick();
        FrameProcessor frameProcessor2 = this.frameProcessor;
        if (frameProcessor2 != null) {
            frameProcessor2.call(frame);
        }
    }

    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        CameraView_EventsKt.invokeOnError(this, th);
    }

    public void onInitialized() {
        CameraView_EventsKt.invokeOnInitialized(this);
    }

    public void onStarted() {
        CameraView_EventsKt.invokeOnStarted(this);
    }

    public void onStopped() {
        CameraView_EventsKt.invokeOnStopped(this);
    }

    public void onShutter(ShutterType shutterType) {
        Intrinsics.checkNotNullParameter(shutterType, "type");
        CameraView_EventsKt.invokeOnShutter(this, shutterType);
    }

    public void onOutputOrientationChanged(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "outputOrientation");
        CameraView_EventsKt.invokeOnOutputOrientationChanged(this, orientation);
    }

    public void onPreviewOrientationChanged(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "previewOrientation");
        CameraView_EventsKt.invokeOnPreviewOrientationChanged(this, orientation);
    }

    public void onCodeScanned(List<? extends Barcode> list, CodeScannerFrame codeScannerFrame) {
        Intrinsics.checkNotNullParameter(list, "codes");
        Intrinsics.checkNotNullParameter(codeScannerFrame, "scannerFrame");
        CameraView_EventsKt.invokeOnCodeScanned(this, list, codeScannerFrame);
    }

    public void onAverageFpsChanged(double d) {
        CameraView_EventsKt.invokeOnAverageFpsChanged(this, d);
    }
}
