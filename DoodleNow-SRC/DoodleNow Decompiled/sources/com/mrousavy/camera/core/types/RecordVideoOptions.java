package com.mrousavy.camera.core.types;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)V", "fileType", "Lcom/mrousavy/camera/core/types/VideoFileType;", "getFileType", "()Lcom/mrousavy/camera/core/types/VideoFileType;", "setFileType", "(Lcom/mrousavy/camera/core/types/VideoFileType;)V", "videoBitRateMultiplier", "", "getVideoBitRateMultiplier", "()Ljava/lang/Double;", "setVideoBitRateMultiplier", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "videoBitRateOverride", "getVideoBitRateOverride", "setVideoBitRateOverride", "videoCodec", "Lcom/mrousavy/camera/core/types/VideoCodec;", "getVideoCodec", "()Lcom/mrousavy/camera/core/types/VideoCodec;", "setVideoCodec", "(Lcom/mrousavy/camera/core/types/VideoCodec;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RecordVideoOptions.kt */
public final class RecordVideoOptions {
    private VideoFileType fileType = VideoFileType.MOV;
    private Double videoBitRateMultiplier;
    private Double videoBitRateOverride;
    private VideoCodec videoCodec = VideoCodec.H264;

    public final VideoFileType getFileType() {
        return this.fileType;
    }

    public final Double getVideoBitRateMultiplier() {
        return this.videoBitRateMultiplier;
    }

    public final Double getVideoBitRateOverride() {
        return this.videoBitRateOverride;
    }

    public final VideoCodec getVideoCodec() {
        return this.videoCodec;
    }

    public final void setFileType(VideoFileType videoFileType) {
        Intrinsics.checkNotNullParameter(videoFileType, "<set-?>");
        this.fileType = videoFileType;
    }

    public final void setVideoBitRateMultiplier(Double d) {
        this.videoBitRateMultiplier = d;
    }

    public final void setVideoBitRateOverride(Double d) {
        this.videoBitRateOverride = d;
    }

    public final void setVideoCodec(VideoCodec videoCodec2) {
        Intrinsics.checkNotNullParameter(videoCodec2, "<set-?>");
        this.videoCodec = videoCodec2;
    }

    public RecordVideoOptions(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "map");
        if (readableMap.hasKey("fileType")) {
            this.fileType = VideoFileType.Companion.fromUnionValue(readableMap.getString("fileType"));
        }
        if (readableMap.hasKey("videoCodec")) {
            this.videoCodec = VideoCodec.Companion.fromUnionValue(readableMap.getString("videoCodec"));
        }
        if (readableMap.hasKey("videoBitRateOverride")) {
            this.videoBitRateOverride = Double.valueOf(readableMap.getDouble("videoBitRateOverride"));
        }
        if (readableMap.hasKey("videoBitRateMultiplier")) {
            this.videoBitRateMultiplier = Double.valueOf(readableMap.getDouble("videoBitRateMultiplier"));
        }
    }
}
