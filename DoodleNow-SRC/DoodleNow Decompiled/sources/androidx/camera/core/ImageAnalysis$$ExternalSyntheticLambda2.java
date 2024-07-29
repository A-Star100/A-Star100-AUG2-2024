package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda2 implements ResolutionFilter {
    public final /* synthetic */ Size f$0;

    public /* synthetic */ ImageAnalysis$$ExternalSyntheticLambda2(Size size) {
        this.f$0 = size;
    }

    public final List filter(List list, int i) {
        return ImageAnalysis.lambda$onMergeConfig$0(this.f$0, list, i);
    }
}
