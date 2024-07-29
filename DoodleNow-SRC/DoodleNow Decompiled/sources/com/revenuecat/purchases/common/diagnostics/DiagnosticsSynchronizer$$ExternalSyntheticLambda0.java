package com.revenuecat.purchases.common.diagnostics;

import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DiagnosticsSynchronizer$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ DiagnosticsSynchronizer$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final void run() {
        DiagnosticsSynchronizer.enqueue$lambda$0(this.f$0);
    }
}
