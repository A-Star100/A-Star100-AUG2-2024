package com.mrousavy.camera.react;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.view.PreviewView;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.SnapshotFailedError;
import com.mrousavy.camera.core.SnapshotFailedPreviewNotEnabledError;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.core.types.SnapshotOptions;
import com.mrousavy.camera.core.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "takeSnapshot", "Lcom/facebook/react/bridge/WritableMap;", "Lcom/mrousavy/camera/react/CameraView;", "options", "Lcom/mrousavy/camera/core/types/SnapshotOptions;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: CameraView+TakeSnapshot.kt */
public final class CameraView_TakeSnapshotKt {
    private static final String TAG = "CameraView.takeSnapshot";

    public static final WritableMap takeSnapshot(CameraView cameraView, SnapshotOptions snapshotOptions) {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(snapshotOptions, "options");
        Log.i(TAG, "Capturing snapshot of Camera View...");
        PreviewView previewView$react_native_vision_camera_release = cameraView.getPreviewView$react_native_vision_camera_release();
        if (previewView$react_native_vision_camera_release != null) {
            Bitmap bitmap = previewView$react_native_vision_camera_release.getBitmap();
            if (bitmap != null) {
                cameraView.onShutter(ShutterType.SNAPSHOT);
                FileUtils.Companion companion = FileUtils.Companion;
                Context context = cameraView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                File createTempFile = companion.createTempFile(context, ".jpg");
                FileUtils.Companion.writeBitmapTofile(bitmap, createTempFile, snapshotOptions.getQuality());
                Log.i(TAG, "Successfully saved snapshot to file!");
                Orientation outputOrientation = cameraView.getCameraSession$react_native_vision_camera_release().getOutputOrientation();
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, createTempFile.getAbsolutePath());
                createMap.putInt("width", bitmap.getWidth());
                createMap.putInt("height", bitmap.getHeight());
                createMap.putString("orientation", outputOrientation.getUnionValue());
                createMap.putBoolean("isMirrored", false);
                Intrinsics.checkNotNull(createMap);
                return createMap;
            }
            throw new SnapshotFailedError();
        }
        throw new SnapshotFailedPreviewNotEnabledError();
    }
}
