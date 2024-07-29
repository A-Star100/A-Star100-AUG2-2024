package com.mrousavy.camera.core;

import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/RecoverableError;", "Lcom/mrousavy/camera/core/CameraError;", "cause", "", "(Ljava/lang/Throwable;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraError.kt */
public final class RecoverableError extends CameraError {
    public RecoverableError(Throwable th) {
        super(OutcomeEventsTable.COLUMN_NAME_SESSION, "recoverable-error", "An unknown error occurred while creating the Camera Session, but the Camera can recover from it.", th);
    }
}
