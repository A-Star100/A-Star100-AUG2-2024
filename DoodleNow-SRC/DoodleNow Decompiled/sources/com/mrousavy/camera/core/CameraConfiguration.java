package com.mrousavy.camera.core;

import androidx.camera.core.Preview;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeType;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.Video$$ExternalSyntheticBackport0;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b]\b\b\u0018\u0000 x2\u00020\u0001:\nuvwxyz{|}~BÛ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0010\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005¢\u0006\u0002\u0010#J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010>J\t\u0010`\u001a\u00020\u0010HÆ\u0003J\t\u0010a\u001a\u00020\u0019HÆ\u0003J\t\u0010b\u001a\u00020\u001bHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u00105J\t\u0010d\u001a\u00020\u001fHÆ\u0003J\t\u0010e\u001a\u00020\u0010HÆ\u0003J\u000f\u0010f\u001a\b\u0012\u0004\u0012\u00020\"0\u0005HÆ\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003J\u000f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005HÆ\u0003J\t\u0010l\u001a\u00020\u0010HÆ\u0003J\t\u0010m\u001a\u00020\u0012HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0014HÆ\u0003Jä\u0001\u0010o\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00102\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020\u00102\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010s\u001a\u00020\u0016HÖ\u0001J\t\u0010t\u001a\u00020\u0003HÖ\u0001R \u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'R\u001a\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010/\"\u0004\bD\u00101R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010'R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010%\"\u0004\bL\u0010'R\u0013\u0010M\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010%\"\u0004\bU\u0010'R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration;", "", "cameraId", "", "preview", "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "Lcom/mrousavy/camera/core/CameraConfiguration$Preview;", "photo", "Lcom/mrousavy/camera/core/CameraConfiguration$Photo;", "video", "Lcom/mrousavy/camera/core/CameraConfiguration$Video;", "frameProcessor", "Lcom/mrousavy/camera/core/CameraConfiguration$FrameProcessor;", "codeScanner", "Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "enableLocation", "", "outputOrientation", "Lcom/mrousavy/camera/core/types/OutputOrientation;", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "fps", "", "enableLowLightBoost", "torch", "Lcom/mrousavy/camera/core/types/Torch;", "videoStabilizationMode", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "exposure", "", "zoom", "", "isActive", "audio", "Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "(Ljava/lang/String;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;ZLcom/mrousavy/camera/core/types/OutputOrientation;Lcom/mrousavy/camera/core/types/CameraDeviceFormat;Ljava/lang/Integer;ZLcom/mrousavy/camera/core/types/Torch;Lcom/mrousavy/camera/core/types/VideoStabilizationMode;Ljava/lang/Double;FZLcom/mrousavy/camera/core/CameraConfiguration$Output;)V", "getAudio", "()Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "setAudio", "(Lcom/mrousavy/camera/core/CameraConfiguration$Output;)V", "getCameraId", "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "getCodeScanner", "setCodeScanner", "getEnableLocation", "()Z", "setEnableLocation", "(Z)V", "getEnableLowLightBoost", "setEnableLowLightBoost", "getExposure", "()Ljava/lang/Double;", "setExposure", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getFormat", "()Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "setFormat", "(Lcom/mrousavy/camera/core/types/CameraDeviceFormat;)V", "getFps", "()Ljava/lang/Integer;", "setFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFrameProcessor", "setFrameProcessor", "setActive", "getOutputOrientation", "()Lcom/mrousavy/camera/core/types/OutputOrientation;", "setOutputOrientation", "(Lcom/mrousavy/camera/core/types/OutputOrientation;)V", "getPhoto", "setPhoto", "getPreview", "setPreview", "targetPreviewAspectRatio", "getTargetPreviewAspectRatio", "()Ljava/lang/Float;", "getTorch", "()Lcom/mrousavy/camera/core/types/Torch;", "setTorch", "(Lcom/mrousavy/camera/core/types/Torch;)V", "getVideo", "setVideo", "getVideoStabilizationMode", "()Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lcom/mrousavy/camera/core/types/VideoStabilizationMode;)V", "getZoom", "()F", "setZoom", "(F)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;ZLcom/mrousavy/camera/core/types/OutputOrientation;Lcom/mrousavy/camera/core/types/CameraDeviceFormat;Ljava/lang/Integer;ZLcom/mrousavy/camera/core/types/Torch;Lcom/mrousavy/camera/core/types/VideoStabilizationMode;Ljava/lang/Double;FZLcom/mrousavy/camera/core/CameraConfiguration$Output;)Lcom/mrousavy/camera/core/CameraConfiguration;", "equals", "other", "hashCode", "toString", "AbortThrow", "Audio", "CodeScanner", "Companion", "Difference", "FrameProcessor", "Output", "Photo", "Preview", "Video", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraConfiguration.kt */
public final class CameraConfiguration {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Output<Audio> audio;
    private String cameraId;
    private Output<CodeScanner> codeScanner;
    private boolean enableLocation;
    private boolean enableLowLightBoost;
    private Double exposure;
    private CameraDeviceFormat format;
    private Integer fps;
    private Output<FrameProcessor> frameProcessor;
    private boolean isActive;
    private OutputOrientation outputOrientation;
    private Output<Photo> photo;
    private Output<Preview> preview;
    private Torch torch;
    private Output<Video> video;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$AbortThrow;", "", "()V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class AbortThrow extends Throwable {
    }

    public CameraConfiguration() {
        this((String) null, (Output) null, (Output) null, (Output) null, (Output) null, (Output) null, false, (OutputOrientation) null, (CameraDeviceFormat) null, (Integer) null, false, (Torch) null, (VideoStabilizationMode) null, (Double) null, 0.0f, false, (Output) null, 131071, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CameraConfiguration copy$default(CameraConfiguration cameraConfiguration, String str, Output output, Output output2, Output output3, Output output4, Output output5, boolean z, OutputOrientation outputOrientation2, CameraDeviceFormat cameraDeviceFormat, Integer num, boolean z2, Torch torch2, VideoStabilizationMode videoStabilizationMode2, Double d, float f, boolean z3, Output output6, int i, Object obj) {
        CameraConfiguration cameraConfiguration2 = cameraConfiguration;
        int i2 = i;
        return cameraConfiguration.copy((i2 & 1) != 0 ? cameraConfiguration2.cameraId : str, (i2 & 2) != 0 ? cameraConfiguration2.preview : output, (i2 & 4) != 0 ? cameraConfiguration2.photo : output2, (i2 & 8) != 0 ? cameraConfiguration2.video : output3, (i2 & 16) != 0 ? cameraConfiguration2.frameProcessor : output4, (i2 & 32) != 0 ? cameraConfiguration2.codeScanner : output5, (i2 & 64) != 0 ? cameraConfiguration2.enableLocation : z, (i2 & 128) != 0 ? cameraConfiguration2.outputOrientation : outputOrientation2, (i2 & 256) != 0 ? cameraConfiguration2.format : cameraDeviceFormat, (i2 & 512) != 0 ? cameraConfiguration2.fps : num, (i2 & 1024) != 0 ? cameraConfiguration2.enableLowLightBoost : z2, (i2 & 2048) != 0 ? cameraConfiguration2.torch : torch2, (i2 & 4096) != 0 ? cameraConfiguration2.videoStabilizationMode : videoStabilizationMode2, (i2 & 8192) != 0 ? cameraConfiguration2.exposure : d, (i2 & 16384) != 0 ? cameraConfiguration2.zoom : f, (i2 & 32768) != 0 ? cameraConfiguration2.isActive : z3, (i2 & 65536) != 0 ? cameraConfiguration2.audio : output6);
    }

    public final String component1() {
        return this.cameraId;
    }

    public final Integer component10() {
        return this.fps;
    }

    public final boolean component11() {
        return this.enableLowLightBoost;
    }

    public final Torch component12() {
        return this.torch;
    }

    public final VideoStabilizationMode component13() {
        return this.videoStabilizationMode;
    }

    public final Double component14() {
        return this.exposure;
    }

    public final float component15() {
        return this.zoom;
    }

    public final boolean component16() {
        return this.isActive;
    }

    public final Output<Audio> component17() {
        return this.audio;
    }

    public final Output<Preview> component2() {
        return this.preview;
    }

    public final Output<Photo> component3() {
        return this.photo;
    }

    public final Output<Video> component4() {
        return this.video;
    }

    public final Output<FrameProcessor> component5() {
        return this.frameProcessor;
    }

    public final Output<CodeScanner> component6() {
        return this.codeScanner;
    }

    public final boolean component7() {
        return this.enableLocation;
    }

    public final OutputOrientation component8() {
        return this.outputOrientation;
    }

    public final CameraDeviceFormat component9() {
        return this.format;
    }

    public final CameraConfiguration copy(String str, Output<Preview> output, Output<Photo> output2, Output<Video> output3, Output<FrameProcessor> output4, Output<CodeScanner> output5, boolean z, OutputOrientation outputOrientation2, CameraDeviceFormat cameraDeviceFormat, Integer num, boolean z2, Torch torch2, VideoStabilizationMode videoStabilizationMode2, Double d, float f, boolean z3, Output<Audio> output6) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(output, "preview");
        Intrinsics.checkNotNullParameter(output2, "photo");
        Intrinsics.checkNotNullParameter(output3, "video");
        Intrinsics.checkNotNullParameter(output4, "frameProcessor");
        Intrinsics.checkNotNullParameter(output5, "codeScanner");
        Intrinsics.checkNotNullParameter(outputOrientation2, "outputOrientation");
        Intrinsics.checkNotNullParameter(torch2, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode2, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(output6, "audio");
        return new CameraConfiguration(str, output, output2, output3, output4, output5, z, outputOrientation2, cameraDeviceFormat, num, z2, torch2, videoStabilizationMode2, d, f, z3, output6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraConfiguration)) {
            return false;
        }
        CameraConfiguration cameraConfiguration = (CameraConfiguration) obj;
        return Intrinsics.areEqual((Object) this.cameraId, (Object) cameraConfiguration.cameraId) && Intrinsics.areEqual((Object) this.preview, (Object) cameraConfiguration.preview) && Intrinsics.areEqual((Object) this.photo, (Object) cameraConfiguration.photo) && Intrinsics.areEqual((Object) this.video, (Object) cameraConfiguration.video) && Intrinsics.areEqual((Object) this.frameProcessor, (Object) cameraConfiguration.frameProcessor) && Intrinsics.areEqual((Object) this.codeScanner, (Object) cameraConfiguration.codeScanner) && this.enableLocation == cameraConfiguration.enableLocation && this.outputOrientation == cameraConfiguration.outputOrientation && Intrinsics.areEqual((Object) this.format, (Object) cameraConfiguration.format) && Intrinsics.areEqual((Object) this.fps, (Object) cameraConfiguration.fps) && this.enableLowLightBoost == cameraConfiguration.enableLowLightBoost && this.torch == cameraConfiguration.torch && this.videoStabilizationMode == cameraConfiguration.videoStabilizationMode && Intrinsics.areEqual((Object) this.exposure, (Object) cameraConfiguration.exposure) && Float.compare(this.zoom, cameraConfiguration.zoom) == 0 && this.isActive == cameraConfiguration.isActive && Intrinsics.areEqual((Object) this.audio, (Object) cameraConfiguration.audio);
    }

    public final Output<Audio> getAudio() {
        return this.audio;
    }

    public final String getCameraId() {
        return this.cameraId;
    }

    public final Output<CodeScanner> getCodeScanner() {
        return this.codeScanner;
    }

    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    public final boolean getEnableLowLightBoost() {
        return this.enableLowLightBoost;
    }

    public final Double getExposure() {
        return this.exposure;
    }

    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final Integer getFps() {
        return this.fps;
    }

    public final Output<FrameProcessor> getFrameProcessor() {
        return this.frameProcessor;
    }

    public final OutputOrientation getOutputOrientation() {
        return this.outputOrientation;
    }

    public final Output<Photo> getPhoto() {
        return this.photo;
    }

    public final Output<Preview> getPreview() {
        return this.preview;
    }

    public final Torch getTorch() {
        return this.torch;
    }

    public final Output<Video> getVideo() {
        return this.video;
    }

    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        String str = this.cameraId;
        int i = 0;
        int hashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.preview.hashCode()) * 31) + this.photo.hashCode()) * 31) + this.video.hashCode()) * 31) + this.frameProcessor.hashCode()) * 31) + this.codeScanner.hashCode()) * 31) + Video$$ExternalSyntheticBackport0.m(this.enableLocation)) * 31) + this.outputOrientation.hashCode()) * 31;
        CameraDeviceFormat cameraDeviceFormat = this.format;
        int hashCode2 = (hashCode + (cameraDeviceFormat == null ? 0 : cameraDeviceFormat.hashCode())) * 31;
        Integer num = this.fps;
        int hashCode3 = (((((((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Video$$ExternalSyntheticBackport0.m(this.enableLowLightBoost)) * 31) + this.torch.hashCode()) * 31) + this.videoStabilizationMode.hashCode()) * 31;
        Double d = this.exposure;
        if (d != null) {
            i = d.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + Float.floatToIntBits(this.zoom)) * 31) + Video$$ExternalSyntheticBackport0.m(this.isActive)) * 31) + this.audio.hashCode();
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setAudio(Output<Audio> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.audio = output;
    }

    public final void setCameraId(String str) {
        this.cameraId = str;
    }

    public final void setCodeScanner(Output<CodeScanner> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.codeScanner = output;
    }

    public final void setEnableLocation(boolean z) {
        this.enableLocation = z;
    }

    public final void setEnableLowLightBoost(boolean z) {
        this.enableLowLightBoost = z;
    }

    public final void setExposure(Double d) {
        this.exposure = d;
    }

    public final void setFormat(CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    public final void setFps(Integer num) {
        this.fps = num;
    }

    public final void setFrameProcessor(Output<FrameProcessor> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.frameProcessor = output;
    }

    public final void setOutputOrientation(OutputOrientation outputOrientation2) {
        Intrinsics.checkNotNullParameter(outputOrientation2, "<set-?>");
        this.outputOrientation = outputOrientation2;
    }

    public final void setPhoto(Output<Photo> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.photo = output;
    }

    public final void setPreview(Output<Preview> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.preview = output;
    }

    public final void setTorch(Torch torch2) {
        Intrinsics.checkNotNullParameter(torch2, "<set-?>");
        this.torch = torch2;
    }

    public final void setVideo(Output<Video> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.video = output;
    }

    public final void setVideoStabilizationMode(VideoStabilizationMode videoStabilizationMode2) {
        Intrinsics.checkNotNullParameter(videoStabilizationMode2, "<set-?>");
        this.videoStabilizationMode = videoStabilizationMode2;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public String toString() {
        String str = this.cameraId;
        Output<Preview> output = this.preview;
        Output<Photo> output2 = this.photo;
        Output<Video> output3 = this.video;
        Output<FrameProcessor> output4 = this.frameProcessor;
        Output<CodeScanner> output5 = this.codeScanner;
        boolean z = this.enableLocation;
        OutputOrientation outputOrientation2 = this.outputOrientation;
        CameraDeviceFormat cameraDeviceFormat = this.format;
        Integer num = this.fps;
        boolean z2 = this.enableLowLightBoost;
        Torch torch2 = this.torch;
        VideoStabilizationMode videoStabilizationMode2 = this.videoStabilizationMode;
        Double d = this.exposure;
        float f = this.zoom;
        boolean z3 = this.isActive;
        return "CameraConfiguration(cameraId=" + str + ", preview=" + output + ", photo=" + output2 + ", video=" + output3 + ", frameProcessor=" + output4 + ", codeScanner=" + output5 + ", enableLocation=" + z + ", outputOrientation=" + outputOrientation2 + ", format=" + cameraDeviceFormat + ", fps=" + num + ", enableLowLightBoost=" + z2 + ", torch=" + torch2 + ", videoStabilizationMode=" + videoStabilizationMode2 + ", exposure=" + d + ", zoom=" + f + ", isActive=" + z3 + ", audio=" + this.audio + ")";
    }

    public CameraConfiguration(String str, Output<Preview> output, Output<Photo> output2, Output<Video> output3, Output<FrameProcessor> output4, Output<CodeScanner> output5, boolean z, OutputOrientation outputOrientation2, CameraDeviceFormat cameraDeviceFormat, Integer num, boolean z2, Torch torch2, VideoStabilizationMode videoStabilizationMode2, Double d, float f, boolean z3, Output<Audio> output6) {
        Output<FrameProcessor> output7 = output4;
        Output<CodeScanner> output8 = output5;
        OutputOrientation outputOrientation3 = outputOrientation2;
        Torch torch3 = torch2;
        VideoStabilizationMode videoStabilizationMode3 = videoStabilizationMode2;
        Output<Audio> output9 = output6;
        Intrinsics.checkNotNullParameter(output, "preview");
        Intrinsics.checkNotNullParameter(output2, "photo");
        Intrinsics.checkNotNullParameter(output3, "video");
        Intrinsics.checkNotNullParameter(output7, "frameProcessor");
        Intrinsics.checkNotNullParameter(output8, "codeScanner");
        Intrinsics.checkNotNullParameter(outputOrientation3, "outputOrientation");
        Intrinsics.checkNotNullParameter(torch3, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode3, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(output9, "audio");
        this.cameraId = str;
        this.preview = output;
        this.photo = output2;
        this.video = output3;
        this.frameProcessor = output7;
        this.codeScanner = output8;
        this.enableLocation = z;
        this.outputOrientation = outputOrientation3;
        this.format = cameraDeviceFormat;
        this.fps = num;
        this.enableLowLightBoost = z2;
        this.torch = torch3;
        this.videoStabilizationMode = videoStabilizationMode3;
        this.exposure = d;
        this.zoom = f;
        this.isActive = z3;
        this.audio = output9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CameraConfiguration(java.lang.String r19, com.mrousavy.camera.core.CameraConfiguration.Output r20, com.mrousavy.camera.core.CameraConfiguration.Output r21, com.mrousavy.camera.core.CameraConfiguration.Output r22, com.mrousavy.camera.core.CameraConfiguration.Output r23, com.mrousavy.camera.core.CameraConfiguration.Output r24, boolean r25, com.mrousavy.camera.core.types.OutputOrientation r26, com.mrousavy.camera.core.types.CameraDeviceFormat r27, java.lang.Integer r28, boolean r29, com.mrousavy.camera.core.types.Torch r30, com.mrousavy.camera.core.types.VideoStabilizationMode r31, java.lang.Double r32, float r33, boolean r34, com.mrousavy.camera.core.CameraConfiguration.Output r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0017
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled$Companion r3 = com.mrousavy.camera.core.CameraConfiguration.Output.Disabled.Companion
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled r3 = r3.create()
            com.mrousavy.camera.core.CameraConfiguration$Output r3 = (com.mrousavy.camera.core.CameraConfiguration.Output) r3
            goto L_0x0019
        L_0x0017:
            r3 = r20
        L_0x0019:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0026
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled$Companion r4 = com.mrousavy.camera.core.CameraConfiguration.Output.Disabled.Companion
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled r4 = r4.create()
            com.mrousavy.camera.core.CameraConfiguration$Output r4 = (com.mrousavy.camera.core.CameraConfiguration.Output) r4
            goto L_0x0028
        L_0x0026:
            r4 = r21
        L_0x0028:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0035
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled$Companion r5 = com.mrousavy.camera.core.CameraConfiguration.Output.Disabled.Companion
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled r5 = r5.create()
            com.mrousavy.camera.core.CameraConfiguration$Output r5 = (com.mrousavy.camera.core.CameraConfiguration.Output) r5
            goto L_0x0037
        L_0x0035:
            r5 = r22
        L_0x0037:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0044
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled$Companion r6 = com.mrousavy.camera.core.CameraConfiguration.Output.Disabled.Companion
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled r6 = r6.create()
            com.mrousavy.camera.core.CameraConfiguration$Output r6 = (com.mrousavy.camera.core.CameraConfiguration.Output) r6
            goto L_0x0046
        L_0x0044:
            r6 = r23
        L_0x0046:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0053
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled$Companion r7 = com.mrousavy.camera.core.CameraConfiguration.Output.Disabled.Companion
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled r7 = r7.create()
            com.mrousavy.camera.core.CameraConfiguration$Output r7 = (com.mrousavy.camera.core.CameraConfiguration.Output) r7
            goto L_0x0055
        L_0x0053:
            r7 = r24
        L_0x0055:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x005b
            r8 = 0
            goto L_0x005d
        L_0x005b:
            r8 = r25
        L_0x005d:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0064
            com.mrousavy.camera.core.types.OutputOrientation r10 = com.mrousavy.camera.core.types.OutputOrientation.DEVICE
            goto L_0x0066
        L_0x0064:
            r10 = r26
        L_0x0066:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x006c
            r11 = 0
            goto L_0x006e
        L_0x006c:
            r11 = r27
        L_0x006e:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0074
            r12 = 0
            goto L_0x0076
        L_0x0074:
            r12 = r28
        L_0x0076:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x007c
            r13 = 0
            goto L_0x007e
        L_0x007c:
            r13 = r29
        L_0x007e:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0085
            com.mrousavy.camera.core.types.Torch r14 = com.mrousavy.camera.core.types.Torch.OFF
            goto L_0x0087
        L_0x0085:
            r14 = r30
        L_0x0087:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x008e
            com.mrousavy.camera.core.types.VideoStabilizationMode r15 = com.mrousavy.camera.core.types.VideoStabilizationMode.OFF
            goto L_0x0090
        L_0x008e:
            r15 = r31
        L_0x0090:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0096
            r2 = 0
            goto L_0x0098
        L_0x0096:
            r2 = r32
        L_0x0098:
            r9 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x009f
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00a1
        L_0x009f:
            r9 = r33
        L_0x00a1:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00ab
            r16 = 0
            goto L_0x00ad
        L_0x00ab:
            r16 = r34
        L_0x00ad:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00bc
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled$Companion r0 = com.mrousavy.camera.core.CameraConfiguration.Output.Disabled.Companion
            com.mrousavy.camera.core.CameraConfiguration$Output$Disabled r0 = r0.create()
            com.mrousavy.camera.core.CameraConfiguration$Output r0 = (com.mrousavy.camera.core.CameraConfiguration.Output) r0
            goto L_0x00be
        L_0x00bc:
            r0 = r35
        L_0x00be:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r9
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraConfiguration.<init>(java.lang.String, com.mrousavy.camera.core.CameraConfiguration$Output, com.mrousavy.camera.core.CameraConfiguration$Output, com.mrousavy.camera.core.CameraConfiguration$Output, com.mrousavy.camera.core.CameraConfiguration$Output, com.mrousavy.camera.core.CameraConfiguration$Output, boolean, com.mrousavy.camera.core.types.OutputOrientation, com.mrousavy.camera.core.types.CameraDeviceFormat, java.lang.Integer, boolean, com.mrousavy.camera.core.types.Torch, com.mrousavy.camera.core.types.VideoStabilizationMode, java.lang.Double, float, boolean, com.mrousavy.camera.core.CameraConfiguration$Output, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "", "codeTypes", "", "Lcom/mrousavy/camera/core/types/CodeType;", "(Ljava/util/List;)V", "getCodeTypes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class CodeScanner {
        private final List<CodeType> codeTypes;

        public static /* synthetic */ CodeScanner copy$default(CodeScanner codeScanner, List<CodeType> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = codeScanner.codeTypes;
            }
            return codeScanner.copy(list);
        }

        public final List<CodeType> component1() {
            return this.codeTypes;
        }

        public final CodeScanner copy(List<? extends CodeType> list) {
            Intrinsics.checkNotNullParameter(list, "codeTypes");
            return new CodeScanner(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CodeScanner) && Intrinsics.areEqual((Object) this.codeTypes, (Object) ((CodeScanner) obj).codeTypes);
        }

        public final List<CodeType> getCodeTypes() {
            return this.codeTypes;
        }

        public int hashCode() {
            return this.codeTypes.hashCode();
        }

        public String toString() {
            List<CodeType> list = this.codeTypes;
            return "CodeScanner(codeTypes=" + list + ")";
        }

        public CodeScanner(List<? extends CodeType> list) {
            Intrinsics.checkNotNullParameter(list, "codeTypes");
            this.codeTypes = list;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Photo;", "", "enableHdr", "", "photoQualityBalance", "Lcom/mrousavy/camera/core/types/QualityBalance;", "(ZLcom/mrousavy/camera/core/types/QualityBalance;)V", "getEnableHdr", "()Z", "getPhotoQualityBalance", "()Lcom/mrousavy/camera/core/types/QualityBalance;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class Photo {
        private final boolean enableHdr;
        private final QualityBalance photoQualityBalance;

        public static /* synthetic */ Photo copy$default(Photo photo, boolean z, QualityBalance qualityBalance, int i, Object obj) {
            if ((i & 1) != 0) {
                z = photo.enableHdr;
            }
            if ((i & 2) != 0) {
                qualityBalance = photo.photoQualityBalance;
            }
            return photo.copy(z, qualityBalance);
        }

        public final boolean component1() {
            return this.enableHdr;
        }

        public final QualityBalance component2() {
            return this.photoQualityBalance;
        }

        public final Photo copy(boolean z, QualityBalance qualityBalance) {
            Intrinsics.checkNotNullParameter(qualityBalance, "photoQualityBalance");
            return new Photo(z, qualityBalance);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Photo)) {
                return false;
            }
            Photo photo = (Photo) obj;
            return this.enableHdr == photo.enableHdr && this.photoQualityBalance == photo.photoQualityBalance;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        public final QualityBalance getPhotoQualityBalance() {
            return this.photoQualityBalance;
        }

        public int hashCode() {
            return (Video$$ExternalSyntheticBackport0.m(this.enableHdr) * 31) + this.photoQualityBalance.hashCode();
        }

        public String toString() {
            boolean z = this.enableHdr;
            QualityBalance qualityBalance = this.photoQualityBalance;
            return "Photo(enableHdr=" + z + ", photoQualityBalance=" + qualityBalance + ")";
        }

        public Photo(boolean z, QualityBalance qualityBalance) {
            Intrinsics.checkNotNullParameter(qualityBalance, "photoQualityBalance");
            this.enableHdr = z;
            this.photoQualityBalance = qualityBalance;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Video;", "", "enableHdr", "", "(Z)V", "getEnableHdr", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class Video {
        private final boolean enableHdr;

        public static /* synthetic */ Video copy$default(Video video, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = video.enableHdr;
            }
            return video.copy(z);
        }

        public final boolean component1() {
            return this.enableHdr;
        }

        public final Video copy(boolean z) {
            return new Video(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Video) && this.enableHdr == ((Video) obj).enableHdr;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        public int hashCode() {
            return Video$$ExternalSyntheticBackport0.m(this.enableHdr);
        }

        public String toString() {
            boolean z = this.enableHdr;
            return "Video(enableHdr=" + z + ")";
        }

        public Video(boolean z) {
            this.enableHdr = z;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$FrameProcessor;", "", "pixelFormat", "Lcom/mrousavy/camera/core/types/PixelFormat;", "(Lcom/mrousavy/camera/core/types/PixelFormat;)V", "getPixelFormat", "()Lcom/mrousavy/camera/core/types/PixelFormat;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class FrameProcessor {
        private final PixelFormat pixelFormat;

        public static /* synthetic */ FrameProcessor copy$default(FrameProcessor frameProcessor, PixelFormat pixelFormat2, int i, Object obj) {
            if ((i & 1) != 0) {
                pixelFormat2 = frameProcessor.pixelFormat;
            }
            return frameProcessor.copy(pixelFormat2);
        }

        public final PixelFormat component1() {
            return this.pixelFormat;
        }

        public final FrameProcessor copy(PixelFormat pixelFormat2) {
            Intrinsics.checkNotNullParameter(pixelFormat2, "pixelFormat");
            return new FrameProcessor(pixelFormat2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FrameProcessor) && this.pixelFormat == ((FrameProcessor) obj).pixelFormat;
        }

        public final PixelFormat getPixelFormat() {
            return this.pixelFormat;
        }

        public int hashCode() {
            return this.pixelFormat.hashCode();
        }

        public String toString() {
            PixelFormat pixelFormat2 = this.pixelFormat;
            return "FrameProcessor(pixelFormat=" + pixelFormat2 + ")";
        }

        public FrameProcessor(PixelFormat pixelFormat2) {
            Intrinsics.checkNotNullParameter(pixelFormat2, "pixelFormat");
            this.pixelFormat = pixelFormat2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0018\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "", "nothing", "", "(Lkotlin/Unit;)V", "getNothing", "()Lkotlin/Unit;", "Lkotlin/Unit;", "component1", "copy", "(Lkotlin/Unit;)Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class Audio {
        private final Unit nothing;

        public static /* synthetic */ Audio copy$default(Audio audio, Unit unit, int i, Object obj) {
            if ((i & 1) != 0) {
                unit = audio.nothing;
            }
            return audio.copy(unit);
        }

        public final void component1() {
        }

        public final Audio copy(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "nothing");
            return new Audio(unit);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Audio) && Intrinsics.areEqual((Object) this.nothing, (Object) ((Audio) obj).nothing);
        }

        public final Unit getNothing() {
            return this.nothing;
        }

        public int hashCode() {
            return this.nothing.hashCode();
        }

        public String toString() {
            Unit unit = this.nothing;
            return "Audio(nothing=" + unit + ")";
        }

        public Audio(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "nothing");
            this.nothing = unit;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Preview;", "", "surfaceProvider", "Landroidx/camera/core/Preview$SurfaceProvider;", "(Landroidx/camera/core/Preview$SurfaceProvider;)V", "getSurfaceProvider", "()Landroidx/camera/core/Preview$SurfaceProvider;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class Preview {
        private final Preview.SurfaceProvider surfaceProvider;

        public static /* synthetic */ Preview copy$default(Preview preview, Preview.SurfaceProvider surfaceProvider2, int i, Object obj) {
            if ((i & 1) != 0) {
                surfaceProvider2 = preview.surfaceProvider;
            }
            return preview.copy(surfaceProvider2);
        }

        public final Preview.SurfaceProvider component1() {
            return this.surfaceProvider;
        }

        public final Preview copy(Preview.SurfaceProvider surfaceProvider2) {
            Intrinsics.checkNotNullParameter(surfaceProvider2, "surfaceProvider");
            return new Preview(surfaceProvider2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Preview) && Intrinsics.areEqual((Object) this.surfaceProvider, (Object) ((Preview) obj).surfaceProvider);
        }

        public final Preview.SurfaceProvider getSurfaceProvider() {
            return this.surfaceProvider;
        }

        public int hashCode() {
            return this.surfaceProvider.hashCode();
        }

        public String toString() {
            Preview.SurfaceProvider surfaceProvider2 = this.surfaceProvider;
            return "Preview(surfaceProvider=" + surfaceProvider2 + ")";
        }

        public Preview(Preview.SurfaceProvider surfaceProvider2) {
            Intrinsics.checkNotNullParameter(surfaceProvider2, "surfaceProvider");
            this.surfaceProvider = surfaceProvider2;
        }
    }

    public final Float getTargetPreviewAspectRatio() {
        CameraDeviceFormat cameraDeviceFormat = this.format;
        if (cameraDeviceFormat == null) {
            return null;
        }
        Output<Video> output = this.video;
        Output.Enabled enabled = output instanceof Output.Enabled ? (Output.Enabled) output : null;
        Output<Photo> output2 = this.photo;
        Output.Enabled enabled2 = output2 instanceof Output.Enabled ? (Output.Enabled) output2 : null;
        if (enabled != null) {
            return Float.valueOf(((float) cameraDeviceFormat.getVideoWidth()) / ((float) cameraDeviceFormat.getVideoHeight()));
        }
        if (enabled2 != null) {
            return Float.valueOf(((float) cameraDeviceFormat.getPhotoWidth()) / ((float) cameraDeviceFormat.getPhotoHeight()));
        }
        return null;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "T", "", "()V", "isEnabled", "", "()Z", "Disabled", "Enabled", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static abstract class Output<T> {
        public /* synthetic */ Output(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Output() {
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \b*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\t"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", "T", "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "()V", "equals", "", "other", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: CameraConfiguration.kt */
        public static final class Disabled<T> extends Output<T> {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

            public /* synthetic */ Disabled(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Disabled() {
                super((DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled$Companion;", "", "()V", "create", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", "T", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* compiled from: CameraConfiguration.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final <T> Disabled<T> create() {
                    return new Disabled<>((DefaultConstructorMarker) null);
                }
            }

            public boolean equals(Object obj) {
                return obj instanceof Disabled;
            }
        }

        public final boolean isEnabled() {
            return this instanceof Enabled;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \f*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "T", "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "config", "(Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: CameraConfiguration.kt */
        public static final class Enabled<T> extends Output<T> {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final T config;

            public /* synthetic */ Enabled(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj);
            }

            public final T getConfig() {
                return this.config;
            }

            private Enabled(T t) {
                super((DefaultConstructorMarker) null);
                this.config = t;
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled$Companion;", "", "()V", "create", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "T", "config", "(Ljava/lang/Object;)Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* compiled from: CameraConfiguration.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final <T> Enabled<T> create(T t) {
                    return new Enabled<>(t, (DefaultConstructorMarker) null);
                }
            }

            public boolean equals(Object obj) {
                return (obj instanceof Enabled) && Intrinsics.areEqual((Object) this.config, (Object) ((Enabled) obj).config);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Difference;", "", "deviceChanged", "", "outputsChanged", "sidePropsChanged", "isActiveChanged", "orientationChanged", "locationChanged", "(ZZZZZZ)V", "getDeviceChanged", "()Z", "hasChanges", "getHasChanges", "getLocationChanged", "getOrientationChanged", "getOutputsChanged", "getSidePropsChanged", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class Difference {
        private final boolean deviceChanged;
        private final boolean isActiveChanged;
        private final boolean locationChanged;
        private final boolean orientationChanged;
        private final boolean outputsChanged;
        private final boolean sidePropsChanged;

        public static /* synthetic */ Difference copy$default(Difference difference, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            if ((i & 1) != 0) {
                z = difference.deviceChanged;
            }
            if ((i & 2) != 0) {
                z2 = difference.outputsChanged;
            }
            boolean z7 = z2;
            if ((i & 4) != 0) {
                z3 = difference.sidePropsChanged;
            }
            boolean z8 = z3;
            if ((i & 8) != 0) {
                z4 = difference.isActiveChanged;
            }
            boolean z9 = z4;
            if ((i & 16) != 0) {
                z5 = difference.orientationChanged;
            }
            boolean z10 = z5;
            if ((i & 32) != 0) {
                z6 = difference.locationChanged;
            }
            return difference.copy(z, z7, z8, z9, z10, z6);
        }

        public final boolean component1() {
            return this.deviceChanged;
        }

        public final boolean component2() {
            return this.outputsChanged;
        }

        public final boolean component3() {
            return this.sidePropsChanged;
        }

        public final boolean component4() {
            return this.isActiveChanged;
        }

        public final boolean component5() {
            return this.orientationChanged;
        }

        public final boolean component6() {
            return this.locationChanged;
        }

        public final Difference copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            return new Difference(z, z2, z3, z4, z5, z6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Difference)) {
                return false;
            }
            Difference difference = (Difference) obj;
            return this.deviceChanged == difference.deviceChanged && this.outputsChanged == difference.outputsChanged && this.sidePropsChanged == difference.sidePropsChanged && this.isActiveChanged == difference.isActiveChanged && this.orientationChanged == difference.orientationChanged && this.locationChanged == difference.locationChanged;
        }

        public final boolean getDeviceChanged() {
            return this.deviceChanged;
        }

        public final boolean getHasChanges() {
            return this.deviceChanged || this.outputsChanged || this.sidePropsChanged || this.isActiveChanged || this.orientationChanged || this.locationChanged;
        }

        public final boolean getLocationChanged() {
            return this.locationChanged;
        }

        public final boolean getOrientationChanged() {
            return this.orientationChanged;
        }

        public final boolean getOutputsChanged() {
            return this.outputsChanged;
        }

        public final boolean getSidePropsChanged() {
            return this.sidePropsChanged;
        }

        public int hashCode() {
            return (((((((((Video$$ExternalSyntheticBackport0.m(this.deviceChanged) * 31) + Video$$ExternalSyntheticBackport0.m(this.outputsChanged)) * 31) + Video$$ExternalSyntheticBackport0.m(this.sidePropsChanged)) * 31) + Video$$ExternalSyntheticBackport0.m(this.isActiveChanged)) * 31) + Video$$ExternalSyntheticBackport0.m(this.orientationChanged)) * 31) + Video$$ExternalSyntheticBackport0.m(this.locationChanged);
        }

        public final boolean isActiveChanged() {
            return this.isActiveChanged;
        }

        public String toString() {
            boolean z = this.deviceChanged;
            boolean z2 = this.outputsChanged;
            boolean z3 = this.sidePropsChanged;
            boolean z4 = this.isActiveChanged;
            boolean z5 = this.orientationChanged;
            boolean z6 = this.locationChanged;
            return "Difference(deviceChanged=" + z + ", outputsChanged=" + z2 + ", sidePropsChanged=" + z3 + ", isActiveChanged=" + z4 + ", orientationChanged=" + z5 + ", locationChanged=" + z6 + ")";
        }

        public Difference(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.deviceChanged = z;
            this.outputsChanged = z2;
            this.sidePropsChanged = z3;
            this.isActiveChanged = z4;
            this.orientationChanged = z5;
            this.locationChanged = z6;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Companion;", "", "()V", "copyOf", "Lcom/mrousavy/camera/core/CameraConfiguration;", "other", "difference", "Lcom/mrousavy/camera/core/CameraConfiguration$Difference;", "left", "right", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CameraConfiguration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r0 = com.mrousavy.camera.core.CameraConfiguration.copy$default(r22, (java.lang.String) null, (com.mrousavy.camera.core.CameraConfiguration.Output) null, (com.mrousavy.camera.core.CameraConfiguration.Output) null, (com.mrousavy.camera.core.CameraConfiguration.Output) null, (com.mrousavy.camera.core.CameraConfiguration.Output) null, (com.mrousavy.camera.core.CameraConfiguration.Output) null, false, (com.mrousavy.camera.core.types.OutputOrientation) null, (com.mrousavy.camera.core.types.CameraDeviceFormat) null, (java.lang.Integer) null, false, (com.mrousavy.camera.core.types.Torch) null, (com.mrousavy.camera.core.types.VideoStabilizationMode) null, (java.lang.Double) null, 0.0f, false, (com.mrousavy.camera.core.CameraConfiguration.Output) null, 131071, (java.lang.Object) null);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.mrousavy.camera.core.CameraConfiguration copyOf(com.mrousavy.camera.core.CameraConfiguration r22) {
            /*
                r21 = this;
                if (r22 == 0) goto L_0x0022
                r1 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 131071(0x1ffff, float:1.8367E-40)
                r19 = 0
                r0 = r22
                com.mrousavy.camera.core.CameraConfiguration r0 = com.mrousavy.camera.core.CameraConfiguration.copy$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
                if (r0 != 0) goto L_0x0041
            L_0x0022:
                com.mrousavy.camera.core.CameraConfiguration r0 = new com.mrousavy.camera.core.CameraConfiguration
                r1 = r0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 131071(0x1ffff, float:1.8367E-40)
                r20 = 0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            L_0x0041:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraConfiguration.Companion.copyOf(com.mrousavy.camera.core.CameraConfiguration):com.mrousavy.camera.core.CameraConfiguration");
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00d9  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00e3  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00e5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.mrousavy.camera.core.CameraConfiguration.Difference difference(com.mrousavy.camera.core.CameraConfiguration r11, com.mrousavy.camera.core.CameraConfiguration r12) {
            /*
                r10 = this;
                java.lang.String r0 = "right"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                r0 = 0
                if (r11 == 0) goto L_0x000d
                java.lang.String r1 = r11.getCameraId()
                goto L_0x000e
            L_0x000d:
                r1 = r0
            L_0x000e:
                java.lang.String r2 = r12.getCameraId()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
                r2 = 1
                r4 = r1 ^ 1
                if (r11 == 0) goto L_0x0020
                com.mrousavy.camera.core.CameraConfiguration$Output r1 = r11.getPhoto()
                goto L_0x0021
            L_0x0020:
                r1 = r0
            L_0x0021:
                com.mrousavy.camera.core.CameraConfiguration$Output r3 = r12.getPhoto()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
                r3 = 0
                if (r1 == 0) goto L_0x0097
                com.mrousavy.camera.core.CameraConfiguration$Output r1 = r11.getVideo()
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r12.getVideo()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
                if (r1 == 0) goto L_0x0097
                boolean r1 = r11.getEnableLowLightBoost()
                boolean r5 = r12.getEnableLowLightBoost()
                if (r1 != r5) goto L_0x0097
                com.mrousavy.camera.core.types.VideoStabilizationMode r1 = r11.getVideoStabilizationMode()
                com.mrousavy.camera.core.types.VideoStabilizationMode r5 = r12.getVideoStabilizationMode()
                if (r1 != r5) goto L_0x0097
                com.mrousavy.camera.core.CameraConfiguration$Output r1 = r11.getFrameProcessor()
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r12.getFrameProcessor()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
                if (r1 == 0) goto L_0x0097
                com.mrousavy.camera.core.CameraConfiguration$Output r1 = r11.getCodeScanner()
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r12.getCodeScanner()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
                if (r1 == 0) goto L_0x0097
                com.mrousavy.camera.core.CameraConfiguration$Output r1 = r11.getPreview()
                com.mrousavy.camera.core.CameraConfiguration$Output r5 = r12.getPreview()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
                if (r1 == 0) goto L_0x0097
                com.mrousavy.camera.core.types.CameraDeviceFormat r1 = r11.getFormat()
                com.mrousavy.camera.core.types.CameraDeviceFormat r5 = r12.getFormat()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
                if (r1 == 0) goto L_0x0097
                java.lang.Integer r1 = r11.getFps()
                java.lang.Integer r5 = r12.getFps()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
                if (r1 != 0) goto L_0x0095
                goto L_0x0097
            L_0x0095:
                r5 = r3
                goto L_0x0098
            L_0x0097:
                r5 = r2
            L_0x0098:
                if (r5 != 0) goto L_0x00c5
                if (r11 == 0) goto L_0x00a1
                com.mrousavy.camera.core.types.Torch r1 = r11.getTorch()
                goto L_0x00a2
            L_0x00a1:
                r1 = r0
            L_0x00a2:
                com.mrousavy.camera.core.types.Torch r6 = r12.getTorch()
                if (r1 != r6) goto L_0x00c5
                float r1 = r11.getZoom()
                float r6 = r12.getZoom()
                int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r1 != 0) goto L_0x00c5
                java.lang.Double r1 = r11.getExposure()
                java.lang.Double r6 = r12.getExposure()
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Double) r1, (java.lang.Double) r6)
                if (r1 != 0) goto L_0x00c3
                goto L_0x00c5
            L_0x00c3:
                r6 = r3
                goto L_0x00c6
            L_0x00c5:
                r6 = r2
            L_0x00c6:
                if (r11 == 0) goto L_0x00d4
                boolean r1 = r11.isActive()
                boolean r7 = r12.isActive()
                if (r1 != r7) goto L_0x00d4
                r1 = r2
                goto L_0x00d5
            L_0x00d4:
                r1 = r3
            L_0x00d5:
                r7 = r1 ^ 1
                if (r11 == 0) goto L_0x00dd
                com.mrousavy.camera.core.types.OutputOrientation r0 = r11.getOutputOrientation()
            L_0x00dd:
                com.mrousavy.camera.core.types.OutputOrientation r1 = r12.getOutputOrientation()
                if (r0 == r1) goto L_0x00e5
                r8 = r2
                goto L_0x00e6
            L_0x00e5:
                r8 = r3
            L_0x00e6:
                if (r11 == 0) goto L_0x00f3
                boolean r11 = r11.getEnableLocation()
                boolean r12 = r12.getEnableLocation()
                if (r11 != r12) goto L_0x00f3
                r3 = r2
            L_0x00f3:
                r9 = r3 ^ 1
                com.mrousavy.camera.core.CameraConfiguration$Difference r11 = new com.mrousavy.camera.core.CameraConfiguration$Difference
                r3 = r11
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraConfiguration.Companion.difference(com.mrousavy.camera.core.CameraConfiguration, com.mrousavy.camera.core.CameraConfiguration):com.mrousavy.camera.core.CameraConfiguration$Difference");
        }
    }
}
