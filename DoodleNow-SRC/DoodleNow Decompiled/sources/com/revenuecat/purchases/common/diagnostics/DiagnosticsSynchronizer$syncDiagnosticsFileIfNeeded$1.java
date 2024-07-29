package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.LogUtilsKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DiagnosticsSynchronizer.kt */
final class DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DiagnosticsSynchronizer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1(DiagnosticsSynchronizer diagnosticsSynchronizer) {
        super(0);
        this.this$0 = diagnosticsSynchronizer;
    }

    public final void invoke() {
        try {
            List access$getEventsToSync = this.this$0.getEventsToSync();
            final int size = access$getEventsToSync.size();
            if (size == 0) {
                LogUtilsKt.verboseLog("No diagnostics to sync.");
                return;
            }
            Backend access$getBackend$p = this.this$0.backend;
            final DiagnosticsSynchronizer diagnosticsSynchronizer = this.this$0;
            final DiagnosticsSynchronizer diagnosticsSynchronizer2 = this.this$0;
            access$getBackend$p.postDiagnostics(access$getEventsToSync, new Function1<JSONObject, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((JSONObject) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(JSONObject jSONObject) {
                    Intrinsics.checkNotNullParameter(jSONObject, "it");
                    LogUtilsKt.verboseLog("Synced diagnostics file successfully.");
                    diagnosticsSynchronizer.clearConsecutiveNumberOfErrors();
                    diagnosticsSynchronizer.diagnosticsFileHelper.clear(size);
                }
            }, new Function2<PurchasesError, Boolean, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PurchasesError purchasesError, boolean z) {
                    Intrinsics.checkNotNullParameter(purchasesError, "error");
                    if (z) {
                        LogUtilsKt.verboseLog("Error syncing diagnostics file: " + purchasesError + ". Will retry the next time the SDK is initialized");
                        if (diagnosticsSynchronizer2.increaseConsecutiveNumberOfErrors() >= 3) {
                            LogUtilsKt.verboseLog("Error syncing diagnostics file: " + purchasesError + ". This was the final attempt (3). Deleting diagnostics file without posting.");
                            diagnosticsSynchronizer2.resetDiagnosticsStatus();
                            return;
                        }
                        return;
                    }
                    LogUtilsKt.verboseLog("Error syncing diagnostics file: " + purchasesError + ". Deleting diagnostics file without retrying.");
                    diagnosticsSynchronizer2.resetDiagnosticsStatus();
                }
            });
        } catch (Exception e) {
            LogUtilsKt.verboseLog("Error syncing diagnostics file: " + e);
            try {
                this.this$0.resetDiagnosticsStatus();
            } catch (IOException e2) {
                LogUtilsKt.verboseLog("Error deleting diagnostics file: " + e2);
            }
        }
    }
}
