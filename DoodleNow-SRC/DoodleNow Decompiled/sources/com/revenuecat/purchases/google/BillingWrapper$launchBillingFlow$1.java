package com.revenuecat.purchases.google;

import android.app.Activity;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.BillingStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$launchBillingFlow$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ BillingFlowParams $params;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$launchBillingFlow$1(Activity activity, BillingFlowParams billingFlowParams) {
        super(1);
        this.$activity = activity;
        this.$params = billingFlowParams;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "$this$withConnectedClient");
        BillingResult launchBillingFlow = billingClient.launchBillingFlow(this.$activity, this.$params);
        if (launchBillingFlow.getResponseCode() == 0) {
            launchBillingFlow = null;
        }
        if (launchBillingFlow != null) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(BillingStrings.BILLING_INTENT_FAILED, Arrays.copyOf(new Object[]{BillingResultExtensionsKt.toHumanReadableDescription(launchBillingFlow)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
    }
}
