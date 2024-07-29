package com.mrousavy.camera.react;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeScannerOptions;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.PreviewViewType;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.ResizeMode;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0007J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0014H\u0007J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0014H\u0007J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0014H\u0007J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0014H\u0007J\u0018\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0007J\u001a\u0010'\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0019H\u0007J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+H\u0007J\u0018\u0010,\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0014H\u0007J\u0018\u0010.\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0014H\u0007J\u001a\u00100\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u00102\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0014H\u0007J\u0018\u00104\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0014H\u0007J\u001a\u00106\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u00108\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010:\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0014H\u0007J\u001a\u0010<\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010=\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010>\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010@\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u0014H\u0007J\u0018\u0010B\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0014H\u0007J\u001a\u0010D\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010E\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010F\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010G\u001a\u00020&H\u0007¨\u0006I"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/mrousavy/camera/react/CameraView;", "()V", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onAfterUpdateTransaction", "", "view", "onDropViewInstance", "setAndroidPreviewViewType", "androidPreviewViewType", "setAudio", "audio", "", "setCameraId", "cameraId", "setCodeScanner", "codeScannerOptions", "Lcom/facebook/react/bridge/ReadableMap;", "setEnableDepthData", "enableDepthData", "setEnableFrameProcessor", "enableFrameProcessor", "setEnableLocation", "enableLocation", "setEnablePortraitEffectsMatteDelivery", "enablePortraitEffectsMatteDelivery", "setEnableZoomGesture", "enableZoomGesture", "setExposure", "exposure", "", "setFormat", "format", "setFps", "fps", "", "setIsActive", "isActive", "setLowLightBoost", "lowLightBoost", "setOrientation", "outputOrientation", "setPhoto", "photo", "setPhotoHdr", "photoHdr", "setPhotoQualityBalance", "photoQualityBalance", "setPixelFormat", "pixelFormat", "setPreview", "preview", "setResizeMode", "resizeMode", "setTorch", "torch", "setVideo", "video", "setVideoHdr", "videoHdr", "setVideoStabilizationMode", "videoStabilizationMode", "setZoom", "zoom", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraViewManager.kt */
public final class CameraViewManager extends ViewGroupManager<CameraView> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CameraView";

    public String getName() {
        return "CameraView";
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewManager$Companion;", "", "()V", "TAG", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CameraView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new CameraView(themedReactContext);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        super.onAfterUpdateTransaction(cameraView);
        cameraView.update();
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("cameraViewReady", MapBuilder.of("registrationName", "onViewReady")).put("cameraInitialized", MapBuilder.of("registrationName", "onInitialized")).put("cameraStarted", MapBuilder.of("registrationName", "onStarted")).put("cameraStopped", MapBuilder.of("registrationName", "onStopped")).put("cameraPreviewStarted", MapBuilder.of("registrationName", "onPreviewStarted")).put("cameraPreviewStopped", MapBuilder.of("registrationName", "onPreviewStopped")).put("cameraShutter", MapBuilder.of("registrationName", "onShutter")).put("cameraOutputOrientationChanged", MapBuilder.of("registrationName", "onOutputOrientationChanged")).put("cameraPreviewOrientationChanged", MapBuilder.of("registrationName", "onPreviewOrientationChanged")).put("averageFpsChanged", MapBuilder.of("registrationName", "onAverageFpsChanged")).put("cameraError", MapBuilder.of("registrationName", "onError")).put("cameraCodeScanned", MapBuilder.of("registrationName", "onCodeScanned")).build();
    }

    public void onDropViewInstance(CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.destroy();
        super.onDropViewInstance(cameraView);
    }

    @ReactProp(name = "cameraId")
    public final void setCameraId(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        Intrinsics.checkNotNullParameter(str, "cameraId");
        cameraView.setCameraId(str);
    }

    @ReactProp(defaultBoolean = true, name = "preview")
    public final void setPreview(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setPreview(z);
    }

    @ReactProp(name = "photo")
    public final void setPhoto(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setPhoto(z);
    }

    @ReactProp(name = "video")
    public final void setVideo(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setVideo(z);
    }

    @ReactProp(name = "audio")
    public final void setAudio(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setAudio(z);
    }

    @ReactProp(name = "enableLocation")
    public final void setEnableLocation(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setEnableLocation(z);
    }

    @ReactProp(name = "enableFrameProcessor")
    public final void setEnableFrameProcessor(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setEnableFrameProcessor(z);
    }

    @ReactProp(name = "pixelFormat")
    public final void setPixelFormat(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (str != null) {
            cameraView.setPixelFormat(PixelFormat.Companion.fromUnionValue(str));
        } else {
            cameraView.setPixelFormat(PixelFormat.YUV);
        }
    }

    @ReactProp(name = "enableDepthData")
    public final void setEnableDepthData(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setEnableDepthData(z);
    }

    @ReactProp(name = "enableZoomGesture")
    public final void setEnableZoomGesture(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setEnableZoomGesture(z);
    }

    @ReactProp(name = "videoStabilizationMode")
    public final void setVideoStabilizationMode(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (str != null) {
            cameraView.setVideoStabilizationMode(VideoStabilizationMode.Companion.fromUnionValue(str));
        } else {
            cameraView.setVideoStabilizationMode((VideoStabilizationMode) null);
        }
    }

    @ReactProp(name = "enablePortraitEffectsMatteDelivery")
    public final void setEnablePortraitEffectsMatteDelivery(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setEnablePortraitEffectsMatteDelivery(z);
    }

    @ReactProp(name = "format")
    public final void setFormat(CameraView cameraView, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (readableMap != null) {
            cameraView.setFormat(CameraDeviceFormat.Companion.fromJSValue(readableMap));
        } else {
            cameraView.setFormat((CameraDeviceFormat) null);
        }
    }

    @ReactProp(name = "resizeMode")
    public final void setResizeMode(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (str != null) {
            cameraView.setResizeMode(ResizeMode.Companion.fromUnionValue(str));
        } else {
            cameraView.setResizeMode(ResizeMode.COVER);
        }
    }

    @ReactProp(name = "androidPreviewViewType")
    public final void setAndroidPreviewViewType(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (str != null) {
            cameraView.setAndroidPreviewViewType(PreviewViewType.Companion.fromUnionValue(str));
        } else {
            cameraView.setAndroidPreviewViewType(PreviewViewType.SURFACE_VIEW);
        }
    }

    @ReactProp(defaultInt = -1, name = "fps")
    public final void setFps(CameraView cameraView, int i) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setFps(i > 0 ? Integer.valueOf(i) : null);
    }

    @ReactProp(name = "photoHdr")
    public final void setPhotoHdr(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setPhotoHdr(z);
    }

    @ReactProp(name = "photoQualityBalance")
    public final void setPhotoQualityBalance(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (str != null) {
            cameraView.setPhotoQualityBalance(QualityBalance.Companion.fromUnionValue(str));
        } else {
            cameraView.setPhotoQualityBalance(QualityBalance.BALANCED);
        }
    }

    @ReactProp(name = "videoHdr")
    public final void setVideoHdr(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setVideoHdr(z);
    }

    @ReactProp(name = "lowLightBoost")
    public final void setLowLightBoost(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setLowLightBoost(z);
    }

    @ReactProp(name = "isActive")
    public final void setIsActive(CameraView cameraView, boolean z) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setActive(z);
    }

    @ReactProp(name = "torch")
    public final void setTorch(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (str != null) {
            cameraView.setTorch(Torch.Companion.fromUnionValue(str));
        } else {
            cameraView.setTorch(Torch.OFF);
        }
    }

    @ReactProp(name = "zoom")
    public final void setZoom(CameraView cameraView, double d) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setZoom((float) d);
    }

    @ReactProp(name = "exposure")
    public final void setExposure(CameraView cameraView, double d) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        cameraView.setExposure(d);
    }

    @ReactProp(name = "outputOrientation")
    public final void setOrientation(CameraView cameraView, String str) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (str != null) {
            cameraView.setOutputOrientation(OutputOrientation.Companion.fromUnionValue(str));
        } else {
            cameraView.setOutputOrientation(OutputOrientation.DEVICE);
        }
    }

    @ReactProp(name = "codeScannerOptions")
    public final void setCodeScanner(CameraView cameraView, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(cameraView, "view");
        if (readableMap != null) {
            cameraView.setCodeScannerOptions(CodeScannerOptions.Companion.fromJSValue(readableMap));
        } else {
            cameraView.setCodeScannerOptions((CodeScannerOptions) null);
        }
    }
}
