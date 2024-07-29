package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$logOut$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ ReceiveCustomerInfoCallback $callback;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$logOut$1(ReceiveCustomerInfoCallback receiveCustomerInfoCallback, PurchasesOrchestrator purchasesOrchestrator) {
        super(1);
        this.$callback = receiveCustomerInfoCallback;
        this.this$0 = purchasesOrchestrator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError != null) {
            ReceiveCustomerInfoCallback receiveCustomerInfoCallback = this.$callback;
            if (receiveCustomerInfoCallback != null) {
                receiveCustomerInfoCallback.onError(purchasesError);
                return;
            }
            return;
        }
        PurchasesOrchestrator purchasesOrchestrator = this.this$0;
        synchronized (purchasesOrchestrator) {
            PurchasesState state$purchases_defaultsRelease = purchasesOrchestrator.getState$purchases_defaultsRelease();
            Map emptyMap = Collections.emptyMap();
            Intrinsics.checkNotNullExpressionValue(emptyMap, "emptyMap()");
            purchasesOrchestrator.setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, (Boolean) null, emptyMap, (ProductChangeCallback) null, false, false, 29, (Object) null));
            Unit unit = Unit.INSTANCE;
        }
        PurchasesOrchestrator purchasesOrchestrator2 = this.this$0;
        purchasesOrchestrator2.updateAllCaches(purchasesOrchestrator2.identityManager.getCurrentAppUserID(), this.$callback);
    }
}
