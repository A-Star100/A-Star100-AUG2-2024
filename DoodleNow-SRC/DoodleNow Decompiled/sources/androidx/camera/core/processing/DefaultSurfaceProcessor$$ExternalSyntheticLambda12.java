package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSurfaceProcessor$$ExternalSyntheticLambda12 implements Runnable {
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$0;

    public /* synthetic */ DefaultSurfaceProcessor$$ExternalSyntheticLambda12(CallbackToFutureAdapter.Completer completer) {
        this.f$0 = completer;
    }

    public final void run() {
        this.f$0.setException(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
    }
}
