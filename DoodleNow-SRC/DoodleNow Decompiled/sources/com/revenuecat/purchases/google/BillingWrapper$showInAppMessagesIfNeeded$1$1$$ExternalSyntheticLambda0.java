package com.revenuecat.purchases.google;

import com.android.billingclient.api.InAppMessageResponseListener;
import com.android.billingclient.api.InAppMessageResult;
import com.revenuecat.purchases.google.BillingWrapper$showInAppMessagesIfNeeded$1;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BillingWrapper$showInAppMessagesIfNeeded$1$1$$ExternalSyntheticLambda0 implements InAppMessageResponseListener {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ BillingWrapper$showInAppMessagesIfNeeded$1$1$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final void onInAppMessageResponse(InAppMessageResult inAppMessageResult) {
        BillingWrapper$showInAppMessagesIfNeeded$1.AnonymousClass1.invoke$lambda$1(this.f$0, inAppMessageResult);
    }
}
