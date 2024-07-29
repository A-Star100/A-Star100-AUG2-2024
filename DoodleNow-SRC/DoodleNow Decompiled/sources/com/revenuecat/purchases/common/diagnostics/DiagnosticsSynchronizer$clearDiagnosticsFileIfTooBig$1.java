package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.common.LogUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DiagnosticsSynchronizer.kt */
final class DiagnosticsSynchronizer$clearDiagnosticsFileIfTooBig$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DiagnosticsSynchronizer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiagnosticsSynchronizer$clearDiagnosticsFileIfTooBig$1(DiagnosticsSynchronizer diagnosticsSynchronizer) {
        super(0);
        this.this$0 = diagnosticsSynchronizer;
    }

    public final void invoke() {
        if (this.this$0.diagnosticsFileHelper.isDiagnosticsFileTooBig()) {
            LogUtilsKt.verboseLog("Diagnostics file is too big. Deleting it.");
            DiagnosticsTracker.trackMaxEventsStoredLimitReached$default(this.this$0.diagnosticsTracker, false, 1, (Object) null);
            this.this$0.resetDiagnosticsStatus();
        }
    }
}
