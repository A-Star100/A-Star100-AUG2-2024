package com.mrousavy.camera.core.extensions;

import android.content.Context;
import android.location.Location;
import android.media.MediaActionSound;
import android.util.Log;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraInternal;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.MetadataProvider;
import com.mrousavy.camera.core.utils.FileUtils;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHH¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"takePicture", "Lcom/mrousavy/camera/core/extensions/PhotoFileInfo;", "Landroidx/camera/core/ImageCapture;", "context", "Landroid/content/Context;", "enableShutterSound", "", "metadataProvider", "Lcom/mrousavy/camera/core/MetadataProvider;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "executor", "Ljava/util/concurrent/Executor;", "(Landroidx/camera/core/ImageCapture;Landroid/content/Context;ZLcom/mrousavy/camera/core/MetadataProvider;Lcom/mrousavy/camera/core/CameraSession$Callback;Ljava/util/concurrent/Executor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: ImageCapture+takePicture.kt */
public final class ImageCapture_takePictureKt {
    private static final Object takePicture$$forInline(ImageCapture imageCapture, Context context, boolean z, MetadataProvider metadataProvider, CameraSession.Callback callback, Executor executor, Continuation<? super PhotoFileInfo> continuation) {
        boolean z2 = false;
        InlineMarker.mark(0);
        Continuation continuation2 = continuation;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        MediaActionSound mediaActionSound = z ? new MediaActionSound() : null;
        if (mediaActionSound != null) {
            mediaActionSound.load(0);
            Unit unit = Unit.INSTANCE;
        }
        Context context2 = context;
        File createTempFile = FileUtils.Companion.createTempFile(context, ".jpg");
        ImageCapture.OutputFileOptions.Builder builder = new ImageCapture.OutputFileOptions.Builder(createTempFile);
        ImageCapture.OutputFileOptions.Builder builder2 = builder;
        ImageCapture.Metadata metadata = new ImageCapture.Metadata();
        Location location = metadataProvider.getLocation();
        if (location != null) {
            Location location2 = location;
            Log.i("ImageCapture", "Setting Photo Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            metadata.setLocation(metadataProvider.getLocation());
            Unit unit2 = Unit.INSTANCE;
            Unit unit3 = Unit.INSTANCE;
        }
        CameraInternal camera = imageCapture.getCamera();
        if (camera != null && camera.isFrontFacing()) {
            z2 = true;
        }
        metadata.setReversedHorizontal(z2);
        builder.setMetadata(metadata);
        Unit unit4 = Unit.INSTANCE;
        ImageCapture.OutputFileOptions build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        ImageCapture.OutputFileOptions outputFileOptions = build;
        ImageCapture imageCapture2 = imageCapture;
        imageCapture.m141lambda$takePicture$2$androidxcameracoreImageCapture(build, executor, new ImageCapture_takePictureKt$takePicture$2$1(z, mediaActionSound, callback, cancellableContinuation, createTempFile, build));
        Unit unit5 = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final Object takePicture(ImageCapture imageCapture, Context context, boolean z, MetadataProvider metadataProvider, CameraSession.Callback callback, Executor executor, Continuation<? super PhotoFileInfo> continuation) {
        boolean z2 = true;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        MediaActionSound mediaActionSound = z ? new MediaActionSound() : null;
        if (mediaActionSound != null) {
            mediaActionSound.load(0);
        }
        Context context2 = context;
        File createTempFile = FileUtils.Companion.createTempFile(context, ".jpg");
        ImageCapture.OutputFileOptions.Builder builder = new ImageCapture.OutputFileOptions.Builder(createTempFile);
        ImageCapture.Metadata metadata = new ImageCapture.Metadata();
        Location location = metadataProvider.getLocation();
        if (location != null) {
            Log.i("ImageCapture", "Setting Photo Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            metadata.setLocation(metadataProvider.getLocation());
        }
        CameraInternal camera = imageCapture.getCamera();
        if (camera == null || !camera.isFrontFacing()) {
            z2 = false;
        }
        metadata.setReversedHorizontal(z2);
        builder.setMetadata(metadata);
        ImageCapture.OutputFileOptions build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        ImageCapture imageCapture2 = imageCapture;
        imageCapture.m141lambda$takePicture$2$androidxcameracoreImageCapture(build, executor, new ImageCapture_takePictureKt$takePicture$2$1(z, mediaActionSound, callback, cancellableContinuation, createTempFile, build));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
