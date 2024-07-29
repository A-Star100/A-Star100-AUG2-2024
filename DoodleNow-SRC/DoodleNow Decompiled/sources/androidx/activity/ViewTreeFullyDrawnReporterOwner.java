package androidx.activity;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"findViewTreeFullyDrawnReporterOwner", "Landroidx/activity/FullyDrawnReporterOwner;", "Landroid/view/View;", "get", "setViewTreeFullyDrawnReporterOwner", "", "fullyDrawnReporterOwner", "set", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewTreeFullyLoadedReporterOwner.kt */
public final class ViewTreeFullyDrawnReporterOwner {
    public static final void set(View view, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }

    public static final FullyDrawnReporterOwner get(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (FullyDrawnReporterOwner) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(view, ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$1.INSTANCE), ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.INSTANCE));
    }
}
