package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SyncPurchasesHelper.kt */
final class SyncPurchasesHelper$syncPurchases$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncPurchasesHelper$syncPurchases$2(Function1<? super PurchasesError, Unit> function1) {
        super(1);
        this.$onError = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "it");
        LogIntent logIntent = LogIntent.RC_ERROR;
        String format = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{purchasesError}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.$onError.invoke(purchasesError);
    }
}
