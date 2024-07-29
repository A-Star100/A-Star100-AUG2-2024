package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
/* synthetic */ class BillingWrapper$findPurchaseInPurchaseHistory$1$2 extends FunctionReferenceImpl implements Function1<Function1<? super BillingClient, ? extends Unit>, Unit> {
    BillingWrapper$findPurchaseInPurchaseHistory$1$2(Object obj) {
        super(1, obj, BillingWrapper.class, "withConnectedClient", "withConnectedClient(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function1<? super BillingClient, Unit>) (Function1) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Function1<? super BillingClient, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "p0");
        ((BillingWrapper) this.receiver).withConnectedClient(function1);
    }
}
