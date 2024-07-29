package com.mrousavy.camera.core.extensions;

import androidx.camera.core.resolutionselector.ResolutionFilter;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ResolutionSelector_forAspectRatioKt$$ExternalSyntheticLambda0 implements ResolutionFilter {
    public final /* synthetic */ float f$0;

    public /* synthetic */ ResolutionSelector_forAspectRatioKt$$ExternalSyntheticLambda0(float f) {
        this.f$0 = f;
    }

    public final List filter(List list, int i) {
        return ResolutionSelector_forAspectRatioKt.forAspectRatio$lambda$0(this.f$0, list, i);
    }
}
