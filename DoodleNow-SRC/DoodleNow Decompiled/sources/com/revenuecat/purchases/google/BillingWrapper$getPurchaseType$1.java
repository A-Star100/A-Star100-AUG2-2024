package com.revenuecat.purchases.google;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "subFound", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$getPurchaseType$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1<ProductType, Unit> $listener;
    final /* synthetic */ String $purchaseToken;
    final /* synthetic */ BillingWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$getPurchaseType$1(Function1<? super ProductType, Unit> function1, BillingWrapper billingWrapper, String str) {
        super(1);
        this.$listener = function1;
        this.this$0 = billingWrapper;
        this.$purchaseToken = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.$listener.invoke(ProductType.SUBS);
            return;
        }
        BillingWrapper billingWrapper = this.this$0;
        String str = this.$purchaseToken;
        Function1<ProductType, Unit> function1 = this.$listener;
        final Function1<ProductType, Unit> function12 = this.$listener;
        billingWrapper.queryPurchaseType("inapp", str, function1, new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    function12.invoke(ProductType.INAPP);
                } else {
                    function12.invoke(ProductType.UNKNOWN);
                }
            }
        });
    }
}
