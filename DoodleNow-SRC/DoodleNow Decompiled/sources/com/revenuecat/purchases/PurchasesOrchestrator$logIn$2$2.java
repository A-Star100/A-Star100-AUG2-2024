package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.LogInCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$logIn$2$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ LogInCallback $callback;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$logIn$2$2(PurchasesOrchestrator purchasesOrchestrator, LogInCallback logInCallback) {
        super(1);
        this.this$0 = purchasesOrchestrator;
        this.$callback = logInCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        PurchasesOrchestrator purchasesOrchestrator = this.this$0;
        final LogInCallback logInCallback = this.$callback;
        purchasesOrchestrator.dispatch(new Function0<Unit>() {
            public final void invoke() {
                LogInCallback logInCallback = logInCallback;
                if (logInCallback != null) {
                    logInCallback.onError(purchasesError);
                }
            }
        });
    }
}
