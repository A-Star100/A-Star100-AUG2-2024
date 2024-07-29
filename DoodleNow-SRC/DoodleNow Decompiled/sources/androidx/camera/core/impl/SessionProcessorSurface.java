package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public final class SessionProcessorSurface extends DeferrableSurface {
    private final int mOutputConfigId;
    private final Surface mSurface;

    public int getOutputConfigId() {
        return this.mOutputConfigId;
    }

    public SessionProcessorSurface(Surface surface, int i) {
        this.mSurface = surface;
        this.mOutputConfigId = i;
    }

    public ListenableFuture<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }
}
