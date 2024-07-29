package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "billingConfig", "Lcom/android/billingclient/api/BillingConfig;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$getStorefront$1 extends Lambda implements Function1<BillingConfig, Unit> {
    final /* synthetic */ Function1<String, Unit> $onSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$getStorefront$1(Function1<? super String, Unit> function1) {
        super(1);
        this.$onSuccess = function1;
    }

    public final void invoke(BillingConfig billingConfig) {
        Intrinsics.checkNotNullParameter(billingConfig, "billingConfig");
        Function1<String, Unit> function1 = this.$onSuccess;
        String countryCode = billingConfig.getCountryCode();
        Intrinsics.checkNotNullExpressionValue(countryCode, "billingConfig.countryCode");
        function1.invoke(countryCode);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingConfig) obj);
        return Unit.INSTANCE;
    }
}
