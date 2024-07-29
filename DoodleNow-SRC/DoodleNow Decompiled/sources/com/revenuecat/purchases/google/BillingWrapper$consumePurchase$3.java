package com.revenuecat.purchases.google;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
/* synthetic */ class BillingWrapper$consumePurchase$3 extends FunctionReferenceImpl implements Function2<Long, Function1<? super PurchasesError, ? extends Unit>, Unit> {
    BillingWrapper$consumePurchase$3(Object obj) {
        super(2, obj, BillingWrapper.class, "executeRequestOnUIThread", "executeRequestOnUIThread(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Long) obj, (Function1<? super PurchasesError, Unit>) (Function1) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Long l, Function1<? super PurchasesError, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "p1");
        ((BillingWrapper) this.receiver).executeRequestOnUIThread(l, function1);
    }
}
