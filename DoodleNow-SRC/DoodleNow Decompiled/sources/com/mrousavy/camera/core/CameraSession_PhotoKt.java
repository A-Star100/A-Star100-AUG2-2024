package com.mrousavy.camera.core;

import android.util.Log;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"getEnableShutterSoundActual", "", "Lcom/mrousavy/camera/core/CameraSession;", "enable", "takePhoto", "Lcom/mrousavy/camera/core/Photo;", "flash", "Lcom/mrousavy/camera/core/types/Flash;", "enableShutterSound", "(Lcom/mrousavy/camera/core/CameraSession;Lcom/mrousavy/camera/core/types/Flash;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraSession+Photo.kt */
public final class CameraSession_PhotoKt {
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0127, code lost:
        if (r2.isFrontFacing() == true) goto L_0x012b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object takePhoto(com.mrousavy.camera.core.CameraSession r17, com.mrousavy.camera.core.types.Flash r18, boolean r19, kotlin.coroutines.Continuation<? super com.mrousavy.camera.core.Photo> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1 r1 = (com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1 r1 = new com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L_0x004f
            if (r3 != r4) goto L_0x0047
            boolean r2 = r1.Z$0
            java.lang.Object r2 = r1.L$5
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            java.lang.Object r2 = r1.L$4
            com.mrousavy.camera.core.CameraSession$Callback r2 = (com.mrousavy.camera.core.CameraSession.Callback) r2
            java.lang.Object r2 = r1.L$3
            com.mrousavy.camera.core.MetadataProvider r2 = (com.mrousavy.camera.core.MetadataProvider) r2
            java.lang.Object r2 = r1.L$2
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r2 = r1.L$1
            androidx.camera.core.ImageCapture r2 = (androidx.camera.core.ImageCapture) r2
            java.lang.Object r1 = r1.L$0
            androidx.camera.core.ImageCapture r1 = (androidx.camera.core.ImageCapture) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x015d
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.camera.core.Camera r0 = r17.getCamera$react_native_vision_camera_release()
            if (r0 == 0) goto L_0x01a5
            androidx.camera.core.ImageCapture r3 = r17.getPhotoOutput$react_native_vision_camera_release()
            if (r3 == 0) goto L_0x019f
            com.mrousavy.camera.core.types.Flash r5 = com.mrousavy.camera.core.types.Flash.OFF
            r6 = r18
            if (r6 == r5) goto L_0x0075
            androidx.camera.core.CameraInfo r0 = r0.getCameraInfo()
            boolean r0 = r0.hasFlashUnit()
            if (r0 == 0) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            com.mrousavy.camera.core.FlashUnavailableError r0 = new com.mrousavy.camera.core.FlashUnavailableError
            r0.<init>()
            throw r0
        L_0x0075:
            int r0 = r18.toFlashMode()
            r3.setFlashMode(r0)
            r0 = r17
            r5 = r19
            boolean r6 = getEnableShutterSoundActual(r0, r5)
            android.content.Context r5 = r17.getContext$react_native_vision_camera_release()
            com.mrousavy.camera.core.MetadataProvider r7 = r17.getMetadataProvider$react_native_vision_camera_release()
            com.mrousavy.camera.core.CameraSession$Callback r8 = r17.getCallback$react_native_vision_camera_release()
            com.mrousavy.camera.core.CameraQueues$Companion r0 = com.mrousavy.camera.core.CameraQueues.Companion
            java.util.concurrent.ExecutorService r0 = r0.getCameraExecutor()
            java.util.concurrent.Executor r0 = (java.util.concurrent.Executor) r0
            r1.L$0 = r3
            r1.L$1 = r3
            r1.L$2 = r5
            r1.L$3 = r7
            r1.L$4 = r8
            r1.L$5 = r0
            r1.Z$0 = r6
            r1.label = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            kotlinx.coroutines.CancellableContinuationImpl r12 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r1)
            r12.<init>(r9, r4)
            r12.initCancellability()
            r9 = r12
            kotlinx.coroutines.CancellableContinuation r9 = (kotlinx.coroutines.CancellableContinuation) r9
            if (r6 == 0) goto L_0x00c1
            android.media.MediaActionSound r10 = new android.media.MediaActionSound
            r10.<init>()
            goto L_0x00c2
        L_0x00c1:
            r10 = 0
        L_0x00c2:
            r11 = 0
            if (r10 == 0) goto L_0x00c8
            r10.load(r11)
        L_0x00c8:
            com.mrousavy.camera.core.utils.FileUtils$Companion r13 = com.mrousavy.camera.core.utils.FileUtils.Companion
            java.lang.String r14 = ".jpg"
            java.io.File r13 = r13.createTempFile(r5, r14)
            androidx.camera.core.ImageCapture$OutputFileOptions$Builder r5 = new androidx.camera.core.ImageCapture$OutputFileOptions$Builder
            r5.<init>((java.io.File) r13)
            androidx.camera.core.ImageCapture$Metadata r14 = new androidx.camera.core.ImageCapture$Metadata
            r14.<init>()
            android.location.Location r15 = r7.getLocation()
            if (r15 == 0) goto L_0x0116
            r17 = r12
            double r11 = r15.getLatitude()
            r19 = r5
            double r4 = r15.getLongitude()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r16 = r2
            java.lang.String r2 = "Setting Photo Location to "
            r15.<init>(r2)
            r15.append(r11)
            java.lang.String r2 = ", "
            r15.append(r2)
            r15.append(r4)
            java.lang.String r2 = "..."
            r15.append(r2)
            java.lang.String r2 = r15.toString()
            java.lang.String r4 = "ImageCapture"
            android.util.Log.i(r4, r2)
            android.location.Location r2 = r7.getLocation()
            r14.setLocation(r2)
            goto L_0x011c
        L_0x0116:
            r16 = r2
            r19 = r5
            r17 = r12
        L_0x011c:
            androidx.camera.core.impl.CameraInternal r2 = r3.getCamera()
            if (r2 == 0) goto L_0x012a
            boolean r2 = r2.isFrontFacing()
            r4 = 1
            if (r2 != r4) goto L_0x012a
            goto L_0x012b
        L_0x012a:
            r4 = 0
        L_0x012b:
            r14.setReversedHorizontal(r4)
            r2 = r19
            r2.setMetadata(r14)
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r2.build()
            java.lang.String r4 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            com.mrousavy.camera.core.extensions.ImageCapture_takePictureKt$takePicture$2$1 r4 = new com.mrousavy.camera.core.extensions.ImageCapture_takePictureKt$takePicture$2$1
            r5 = r4
            r7 = r10
            r10 = r13
            r11 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            androidx.camera.core.ImageCapture$OnImageSavedCallback r4 = (androidx.camera.core.ImageCapture.OnImageSavedCallback) r4
            r3.m141lambda$takePicture$2$androidxcameracoreImageCapture(r2, r0, r4)
            java.lang.Object r0 = r17.getResult()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r2) goto L_0x0157
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r1)
        L_0x0157:
            r1 = r16
            if (r0 != r1) goto L_0x015c
            return r1
        L_0x015c:
            r1 = r3
        L_0x015d:
            com.mrousavy.camera.core.extensions.PhotoFileInfo r0 = (com.mrousavy.camera.core.extensions.PhotoFileInfo) r0
            androidx.camera.core.ImageCapture$Metadata r2 = r0.getMetadata()
            boolean r8 = r2.isReversedHorizontal()
            com.mrousavy.camera.core.utils.FileUtils$Companion r2 = com.mrousavy.camera.core.utils.FileUtils.Companion
            java.net.URI r3 = r0.getUri()
            java.lang.String r3 = r3.getPath()
            java.lang.String r4 = "getPath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.util.Size r2 = r2.getImageSize(r3)
            int r1 = r1.getTargetRotation()
            com.mrousavy.camera.core.types.Orientation$Companion r3 = com.mrousavy.camera.core.types.Orientation.Companion
            com.mrousavy.camera.core.types.Orientation r7 = r3.fromSurfaceRotation(r1)
            com.mrousavy.camera.core.Photo r1 = new com.mrousavy.camera.core.Photo
            java.net.URI r0 = r0.getUri()
            java.lang.String r0 = r0.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            int r5 = r2.getWidth()
            int r6 = r2.getHeight()
            r3 = r1
            r4 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r1
        L_0x019f:
            com.mrousavy.camera.core.PhotoNotEnabledError r0 = new com.mrousavy.camera.core.PhotoNotEnabledError
            r0.<init>()
            throw r0
        L_0x01a5:
            com.mrousavy.camera.core.CameraNotReadyError r0 = new com.mrousavy.camera.core.CameraNotReadyError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_PhotoKt.takePhoto(com.mrousavy.camera.core.CameraSession, com.mrousavy.camera.core.types.Flash, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean getEnableShutterSoundActual(CameraSession cameraSession, boolean z) {
        if (!z || cameraSession.getAudioManager$react_native_vision_camera_release().getRingerMode() == 2) {
            return z;
        }
        int ringerMode = cameraSession.getAudioManager$react_native_vision_camera_release().getRingerMode();
        Log.i(CameraSession.TAG, "Ringer mode is silent (" + ringerMode + "), disabling shutter sound...");
        return false;
    }
}
