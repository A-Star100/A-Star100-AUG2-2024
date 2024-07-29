package com.revenuecat.purchases.common.diagnostics;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DiagnosticsTracker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DiagnosticsTracker f$0;
    public final /* synthetic */ DiagnosticsEntry f$1;

    public /* synthetic */ DiagnosticsTracker$$ExternalSyntheticLambda0(DiagnosticsTracker diagnosticsTracker, DiagnosticsEntry diagnosticsEntry) {
        this.f$0 = diagnosticsTracker;
        this.f$1 = diagnosticsEntry;
    }

    public final void run() {
        DiagnosticsTracker.trackEvent$lambda$0(this.f$0, this.f$1);
    }
}
