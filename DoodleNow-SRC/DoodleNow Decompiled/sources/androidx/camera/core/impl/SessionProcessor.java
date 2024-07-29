package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SessionProcessor {

    public interface CaptureCallback {

        /* renamed from: androidx.camera.core.impl.SessionProcessor$CaptureCallback$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureCompleted(CaptureCallback _this, long j, int i, Map map) {
            }

            public static void $default$onCaptureFailed(CaptureCallback _this, int i) {
            }

            public static void $default$onCaptureProcessProgressed(CaptureCallback _this, int i) {
            }

            public static void $default$onCaptureProcessStarted(CaptureCallback _this, int i) {
            }

            public static void $default$onCaptureSequenceAborted(CaptureCallback _this, int i) {
            }

            public static void $default$onCaptureSequenceCompleted(CaptureCallback _this, int i) {
            }

            public static void $default$onCaptureStarted(CaptureCallback _this, int i, long j) {
            }
        }

        void onCaptureCompleted(long j, int i, Map<CaptureResult.Key, Object> map);

        void onCaptureFailed(int i);

        void onCaptureProcessProgressed(int i);

        void onCaptureProcessStarted(int i);

        void onCaptureSequenceAborted(int i);

        void onCaptureSequenceCompleted(int i);

        void onCaptureStarted(int i, long j);
    }

    void abortCapture(int i);

    void deInitSession();

    Pair<Long, Long> getRealtimeCaptureLatency();

    Set<Integer> getSupportedCameraOperations();

    Map<Integer, List<Size>> getSupportedPostviewSize(Size size);

    SessionConfig initSession(CameraInfo cameraInfo, OutputSurfaceConfiguration outputSurfaceConfiguration);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(RequestProcessor requestProcessor);

    void setParameters(Config config);

    int startCapture(boolean z, CaptureCallback captureCallback);

    int startRepeating(CaptureCallback captureCallback);

    int startTrigger(Config config, CaptureCallback captureCallback);

    void stopRepeating();

    /* renamed from: androidx.camera.core.impl.SessionProcessor$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Pair $default$getRealtimeCaptureLatency(SessionProcessor _this) {
            return null;
        }

        public static int $default$startTrigger(SessionProcessor _this, Config config, CaptureCallback captureCallback) {
            return -1;
        }

        public static Map $default$getSupportedPostviewSize(SessionProcessor _this, Size size) {
            return Collections.emptyMap();
        }

        public static Set $default$getSupportedCameraOperations(SessionProcessor _this) {
            return Collections.emptySet();
        }
    }
}
