package com.revenuecat.purchases.hybridcommon;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
final class CommonKt$getCustomerInfo$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ OnResult $onResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonKt$getCustomerInfo$1(OnResult onResult) {
        super(1);
        this.$onResult = onResult;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "it");
        this.$onResult.onError(PurchasesErrorKt.map$default(purchasesError, (Map) null, 1, (Object) null));
    }
}
