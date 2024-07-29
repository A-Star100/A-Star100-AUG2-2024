package com.mrousavy.camera.core.extensions;

import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/util/Size;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ResolutionSelector+forAspectRatio.kt */
final class ResolutionSelector_forAspectRatioKt$forAspectRatio$1$2 extends Lambda implements Function1<Size, Comparable<?>> {
    public static final ResolutionSelector_forAspectRatioKt$forAspectRatio$1$2 INSTANCE = new ResolutionSelector_forAspectRatioKt$forAspectRatio$1$2();

    ResolutionSelector_forAspectRatioKt$forAspectRatio$1$2() {
        super(1);
    }

    public final Comparable<?> invoke(Size size) {
        return Integer.valueOf(-(size.getWidth() * size.getHeight()));
    }
}
