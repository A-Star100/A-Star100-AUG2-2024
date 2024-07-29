package com.mrousavy.camera.core.extensions;

import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"forAspectRatio", "Landroidx/camera/core/resolutionselector/ResolutionSelector$Builder;", "aspectRatio", "", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: ResolutionSelector+forAspectRatio.kt */
public final class ResolutionSelector_forAspectRatioKt {
    public static final ResolutionSelector.Builder forAspectRatio(ResolutionSelector.Builder builder, float f) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        ResolutionSelector.Builder resolutionFilter = builder.setResolutionFilter(new ResolutionSelector_forAspectRatioKt$$ExternalSyntheticLambda0(f));
        Intrinsics.checkNotNullExpressionValue(resolutionFilter, "setResolutionFilter(...)");
        return resolutionFilter;
    }

    /* access modifiers changed from: private */
    public static final List forAspectRatio$lambda$0(float f, List list, int i) {
        Intrinsics.checkNotNullParameter(list, "supportedSizes");
        return CollectionsKt.sortedWith(list, ComparisonsKt.compareBy((Function1<? super T, ? extends Comparable<?>>[]) new Function1[]{new ResolutionSelector_forAspectRatioKt$forAspectRatio$1$1(f), ResolutionSelector_forAspectRatioKt$forAspectRatio$1$2.INSTANCE}));
    }
}
