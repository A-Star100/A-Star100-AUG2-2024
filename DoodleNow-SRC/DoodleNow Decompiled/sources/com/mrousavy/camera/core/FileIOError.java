package com.mrousavy.camera.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/FileIOError;", "Lcom/mrousavy/camera/core/CameraError;", "throwable", "", "(Ljava/lang/Throwable;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraError.kt */
public final class FileIOError extends CameraError {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FileIOError(java.lang.Throwable r4) {
        /*
            r3 = this;
            java.lang.String r0 = "throwable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "An unexpected File IO error occurred! Error: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = "."
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "capture"
            java.lang.String r2 = "file-io-error"
            r3.<init>(r1, r2, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.FileIOError.<init>(java.lang.Throwable):void");
    }
}
