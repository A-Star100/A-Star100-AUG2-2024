package com.revenuecat.purchases.hybridcommon;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "userCancelled", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
final class CommonKt$getPurchaseErrorFunction$1 extends Lambda implements Function2<PurchasesError, Boolean, Unit> {
    final /* synthetic */ OnResult $onResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonKt$getPurchaseErrorFunction$1(OnResult onResult) {
        super(2);
        this.$onResult = onResult;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError, boolean z) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        this.$onResult.onError(PurchasesErrorKt.map(purchasesError, MapsKt.mapOf(TuplesKt.to("userCancelled", Boolean.valueOf(z)))));
    }
}
