package androidx.camera.lifecycle;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProcessCameraProvider$$ExternalSyntheticLambda3 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ProcessCameraProvider f$0;
    public final /* synthetic */ CameraX f$1;

    public /* synthetic */ ProcessCameraProvider$$ExternalSyntheticLambda3(ProcessCameraProvider processCameraProvider, CameraX cameraX) {
        this.f$0 = processCameraProvider;
        this.f$1 = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ProcessCameraProvider.getOrCreateCameraXInstance$lambda$8$lambda$7(this.f$0, this.f$1, completer);
    }
}
