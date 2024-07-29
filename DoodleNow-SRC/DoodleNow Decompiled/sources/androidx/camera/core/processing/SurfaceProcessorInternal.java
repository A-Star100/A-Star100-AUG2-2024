package androidx.camera.core.processing;

import androidx.camera.core.SurfaceProcessor;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public interface SurfaceProcessorInternal extends SurfaceProcessor {
    void release();

    ListenableFuture<Void> snapshot(int i, int i2);

    /* renamed from: androidx.camera.core.processing.SurfaceProcessorInternal$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ListenableFuture $default$snapshot(SurfaceProcessorInternal _this, int i, int i2) {
            return Futures.immediateFuture(null);
        }
    }
}
