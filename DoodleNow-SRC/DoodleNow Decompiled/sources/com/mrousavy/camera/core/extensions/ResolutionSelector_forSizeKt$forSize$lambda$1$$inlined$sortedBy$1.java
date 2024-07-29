package com.mrousavy.camera.core.extensions;

import android.util.Size;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class ResolutionSelector_forSizeKt$forSize$lambda$1$$inlined$sortedBy$1<T> implements Comparator {
    final /* synthetic */ Size $size$inlined;

    public ResolutionSelector_forSizeKt$forSize$lambda$1$$inlined$sortedBy$1(Size size) {
        this.$size$inlined = size;
    }

    public final int compare(T t, T t2) {
        Size size = (Size) t;
        Intrinsics.checkNotNull(size);
        Size size2 = (Size) t2;
        Intrinsics.checkNotNull(size2);
        return ComparisonsKt.compareValues(Integer.valueOf(ResolutionSelector_forSizeKt.difference(size, this.$size$inlined)), Integer.valueOf(ResolutionSelector_forSizeKt.difference(size2, this.$size$inlined)));
    }
}
