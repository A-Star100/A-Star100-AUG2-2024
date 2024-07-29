package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

public interface VideoOutput {

    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    VideoCapabilities getMediaCapabilities(CameraInfo cameraInfo);

    Observable<MediaSpec> getMediaSpec();

    Observable<StreamInfo> getStreamInfo();

    void onSourceStateChanged(SourceState sourceState);

    void onSurfaceRequested(SurfaceRequest surfaceRequest);

    void onSurfaceRequested(SurfaceRequest surfaceRequest, Timebase timebase);

    /* renamed from: androidx.camera.video.VideoOutput$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onSourceStateChanged(VideoOutput _this, SourceState sourceState) {
        }

        public static void $default$onSurfaceRequested(VideoOutput _this, SurfaceRequest surfaceRequest, Timebase timebase) {
            _this.onSurfaceRequested(surfaceRequest);
        }

        public static Observable $default$getStreamInfo(VideoOutput _this) {
            return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
        }

        public static Observable $default$getMediaSpec(VideoOutput _this) {
            return ConstantObservable.withValue(null);
        }

        public static VideoCapabilities $default$getMediaCapabilities(VideoOutput _this, CameraInfo cameraInfo) {
            return VideoCapabilities.EMPTY;
        }
    }
}
