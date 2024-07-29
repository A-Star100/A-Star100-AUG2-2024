package com.mrousavy.camera.core.types;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mrousavy/camera/core/types/SnapshotOptions;", "", "quality", "", "(I)V", "getQuality", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SnapshotOptions.kt */
public final class SnapshotOptions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int quality;

    public static /* synthetic */ SnapshotOptions copy$default(SnapshotOptions snapshotOptions, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = snapshotOptions.quality;
        }
        return snapshotOptions.copy(i);
    }

    public final int component1() {
        return this.quality;
    }

    public final SnapshotOptions copy(int i) {
        return new SnapshotOptions(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SnapshotOptions) && this.quality == ((SnapshotOptions) obj).quality;
    }

    public final int getQuality() {
        return this.quality;
    }

    public int hashCode() {
        return this.quality;
    }

    public String toString() {
        int i = this.quality;
        return "SnapshotOptions(quality=" + i + ")";
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/SnapshotOptions$Companion;", "", "()V", "fromJSValue", "Lcom/mrousavy/camera/core/types/SnapshotOptions;", "options", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SnapshotOptions.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotOptions fromJSValue(ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(readableMap, "options");
            return new SnapshotOptions(readableMap.hasKey("quality") ? readableMap.getInt("quality") : 100);
        }
    }

    public SnapshotOptions(int i) {
        this.quality = i;
    }
}
