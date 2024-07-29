package androidx.camera.core.processing;

import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.processing.SurfaceEdge;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SurfaceEdge$$ExternalSyntheticLambda4 implements AsyncFunction {
    public final /* synthetic */ SurfaceEdge f$0;
    public final /* synthetic */ SurfaceEdge.SettableSurface f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Size f$3;
    public final /* synthetic */ Rect f$4;
    public final /* synthetic */ int f$5;
    public final /* synthetic */ boolean f$6;
    public final /* synthetic */ CameraInternal f$7;

    public /* synthetic */ SurfaceEdge$$ExternalSyntheticLambda4(SurfaceEdge surfaceEdge, SurfaceEdge.SettableSurface settableSurface, int i, Size size, Rect rect, int i2, boolean z, CameraInternal cameraInternal) {
        this.f$0 = surfaceEdge;
        this.f$1 = settableSurface;
        this.f$2 = i;
        this.f$3 = size;
        this.f$4 = rect;
        this.f$5 = i2;
        this.f$6 = z;
        this.f$7 = cameraInternal;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.m194lambda$createSurfaceOutputFuture$2$androidxcameracoreprocessingSurfaceEdge(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Surface) obj);
    }
}
