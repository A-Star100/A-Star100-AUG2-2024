package com.mrousavy.camera.react;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.types.SnapshotOptions;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/mrousavy/camera/core/utils/RunOnUiThreadKt$runOnUiThread$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: runOnUiThread.kt */
public final class CameraViewModule$takeSnapshot$1$invokeSuspend$$inlined$runOnUiThread$1 implements Runnable {
    final /* synthetic */ ReadableMap $jsOptions$inlined;
    final /* synthetic */ Promise $promise$inlined;
    final /* synthetic */ CameraView $view$inlined;

    public CameraViewModule$takeSnapshot$1$invokeSuspend$$inlined$runOnUiThread$1(ReadableMap readableMap, CameraView cameraView, Promise promise) {
        this.$jsOptions$inlined = readableMap;
        this.$view$inlined = cameraView;
        this.$promise$inlined = promise;
    }

    public final void run() {
        try {
            this.$promise$inlined.resolve(CameraView_TakeSnapshotKt.takeSnapshot(this.$view$inlined, SnapshotOptions.Companion.fromJSValue(this.$jsOptions$inlined)));
        } catch (Throwable th) {
            this.$promise$inlined.reject(th);
        }
    }
}
