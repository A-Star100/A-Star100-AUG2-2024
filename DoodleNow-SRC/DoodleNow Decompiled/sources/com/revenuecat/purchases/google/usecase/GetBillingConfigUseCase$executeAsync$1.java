package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.GetBillingConfigParams;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: GetBillingConfigUseCase.kt */
final class GetBillingConfigUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ GetBillingConfigUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetBillingConfigUseCase$executeAsync$1(GetBillingConfigUseCase getBillingConfigUseCase) {
        super(1);
        this.this$0 = getBillingConfigUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "$this$invoke");
        billingClient.getBillingConfigAsync(GetBillingConfigParams.newBuilder().build(), new GetBillingConfigUseCase$executeAsync$1$$ExternalSyntheticLambda0(new AtomicBoolean(false), this.this$0));
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(AtomicBoolean atomicBoolean, GetBillingConfigUseCase getBillingConfigUseCase, BillingResult billingResult, BillingConfig billingConfig) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "$hasResponded");
        Intrinsics.checkNotNullParameter(getBillingConfigUseCase, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "result");
        if (atomicBoolean.getAndSet(true)) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(OfferingStrings.EXTRA_GET_BILLING_CONFIG_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            return;
        }
        BillingClientUseCase.processResult$default(getBillingConfigUseCase, billingResult, billingConfig, (Function1) null, (Function1) null, 12, (Object) null);
    }
}
