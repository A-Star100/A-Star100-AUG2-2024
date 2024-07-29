package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfflineCustomerInfoCalculator.kt */
final class OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$2(Function1<? super PurchasesError, Unit> function1) {
        super(1);
        this.$onError = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        String format = String.format(CustomerInfoStrings.COMPUTING_OFFLINE_CUSTOMER_INFO_FAILED, Arrays.copyOf(new Object[]{purchasesError}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
        this.$onError.invoke(purchasesError);
    }
}
