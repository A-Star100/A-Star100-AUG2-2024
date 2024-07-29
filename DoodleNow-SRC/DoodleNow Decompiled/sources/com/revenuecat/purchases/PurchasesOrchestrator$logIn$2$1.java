package com.revenuecat.purchases;

import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.interfaces.LogInCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "created", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$logIn$2$1 extends Lambda implements Function2<CustomerInfo, Boolean, Unit> {
    final /* synthetic */ LogInCallback $callback;
    final /* synthetic */ String $newAppUserID;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$logIn$2$1(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback) {
        super(2);
        this.this$0 = purchasesOrchestrator;
        this.$newAppUserID = str;
        this.$callback = logInCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CustomerInfo) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final CustomerInfo customerInfo, final boolean z) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        PurchasesOrchestrator purchasesOrchestrator = this.this$0;
        final LogInCallback logInCallback = this.$callback;
        final PurchasesOrchestrator purchasesOrchestrator2 = this.this$0;
        purchasesOrchestrator.dispatch(new Function0<Unit>() {
            public final void invoke() {
                LogInCallback logInCallback = logInCallback;
                if (logInCallback != null) {
                    logInCallback.onReceived(customerInfo, z);
                }
                purchasesOrchestrator2.customerInfoUpdateHandler.notifyListeners(customerInfo);
            }
        });
        OfferingsManager.fetchAndCacheOfferings$default(this.this$0.offeringsManager, this.$newAppUserID, this.this$0.getState$purchases_defaultsRelease().getAppInBackground(), (Function1) null, (Function1) null, 12, (Object) null);
    }
}
