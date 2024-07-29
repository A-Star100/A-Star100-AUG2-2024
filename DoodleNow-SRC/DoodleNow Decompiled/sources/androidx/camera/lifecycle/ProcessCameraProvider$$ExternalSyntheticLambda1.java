package androidx.camera.lifecycle;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProcessCameraProvider$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ProcessCameraProvider f$0;

    public /* synthetic */ ProcessCameraProvider$$ExternalSyntheticLambda1(ProcessCameraProvider processCameraProvider) {
        this.f$0 = processCameraProvider;
    }

    public final void run() {
        ProcessCameraProvider.shutdownAsync$lambda$0(this.f$0);
    }
}
