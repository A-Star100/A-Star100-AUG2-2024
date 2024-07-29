package com.mrousavy.camera.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/UnknownRecorderError;", "Lcom/mrousavy/camera/core/RecorderError;", "wasVideoRecorded", "", "cause", "", "(ZLjava/lang/Throwable;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraError.kt */
public final class UnknownRecorderError extends RecorderError {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UnknownRecorderError(boolean r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            java.lang.String r0 = com.mrousavy.camera.core.CameraErrorKt.getVideoCapturedMessage(r5)
            if (r6 == 0) goto L_0x000b
            java.lang.String r1 = r6.getMessage()
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "An error occurred while recording a video! "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = " "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "recorder-error"
            r4.<init>(r1, r0, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.UnknownRecorderError.<init>(boolean, java.lang.Throwable):void");
    }
}
