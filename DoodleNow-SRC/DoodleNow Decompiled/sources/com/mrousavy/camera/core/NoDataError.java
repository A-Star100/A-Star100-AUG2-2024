package com.mrousavy.camera.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/NoDataError;", "Lcom/mrousavy/camera/core/RecorderError;", "cause", "", "(Ljava/lang/Throwable;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraError.kt */
public final class NoDataError extends RecorderError {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NoDataError(java.lang.Throwable r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0007
            java.lang.String r0 = r4.getMessage()
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "The Video Recording failed because no data was received! ("
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = ") Did you stop the recording before any Frames arrived?"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            java.lang.String r2 = "no-data"
            r3.<init>(r2, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.NoDataError.<init>(java.lang.Throwable):void");
    }
}
