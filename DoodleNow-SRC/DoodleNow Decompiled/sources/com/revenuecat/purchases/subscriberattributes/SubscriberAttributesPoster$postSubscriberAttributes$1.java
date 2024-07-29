package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesPoster.kt */
final class SubscriberAttributesPoster$postSubscriberAttributes$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Function3<PurchasesError, Boolean, List<SubscriberAttributeError>, Unit> $onErrorHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesPoster$postSubscriberAttributes$1(Function3<? super PurchasesError, ? super Boolean, ? super List<SubscriberAttributeError>, Unit> function3) {
        super(1);
        this.$onErrorHandler = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        this.$onErrorHandler.invoke(purchasesError, false, CollectionsKt.emptyList());
    }
}
