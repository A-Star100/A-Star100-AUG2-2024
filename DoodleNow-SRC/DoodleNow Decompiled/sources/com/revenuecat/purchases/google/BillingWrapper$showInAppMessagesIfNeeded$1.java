package com.revenuecat.purchases.google;

import android.app.Activity;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.InAppMessageParams;
import com.android.billingclient.api.InAppMessageResult;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.BillingStrings;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$showInAppMessagesIfNeeded$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ InAppMessageParams $inAppMessageParams;
    final /* synthetic */ Function0<Unit> $subscriptionStatusChange;
    final /* synthetic */ WeakReference<Activity> $weakActivity;
    final /* synthetic */ BillingWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$showInAppMessagesIfNeeded$1(BillingWrapper billingWrapper, WeakReference<Activity> weakReference, InAppMessageParams inAppMessageParams, Function0<Unit> function0) {
        super(1);
        this.this$0 = billingWrapper;
        this.$weakActivity = weakReference;
        this.$inAppMessageParams = inAppMessageParams;
        this.$subscriptionStatusChange = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError != null) {
            String format = String.format(BillingStrings.BILLING_CONNECTION_ERROR_INAPP_MESSAGES, Arrays.copyOf(new Object[]{purchasesError}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
            return;
        }
        BillingWrapper billingWrapper = this.this$0;
        final WeakReference<Activity> weakReference = this.$weakActivity;
        final InAppMessageParams inAppMessageParams = this.$inAppMessageParams;
        final Function0<Unit> function0 = this.$subscriptionStatusChange;
        billingWrapper.withConnectedClient(new Function1<BillingClient, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BillingClient) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BillingClient billingClient) {
                Intrinsics.checkNotNullParameter(billingClient, "$this$withConnectedClient");
                Activity activity = (Activity) weakReference.get();
                if (activity == null) {
                    LogUtilsKt.debugLog("Activity is null, not showing Google Play in-app message.");
                } else {
                    billingClient.showInAppMessages(activity, inAppMessageParams, new BillingWrapper$showInAppMessagesIfNeeded$1$1$$ExternalSyntheticLambda0(function0));
                }
            }

            /* access modifiers changed from: private */
            public static final void invoke$lambda$1(Function0 function0, InAppMessageResult inAppMessageResult) {
                Intrinsics.checkNotNullParameter(function0, "$subscriptionStatusChange");
                Intrinsics.checkNotNullParameter(inAppMessageResult, "inAppMessageResult");
                int responseCode = inAppMessageResult.getResponseCode();
                if (responseCode == 0) {
                    LogUtilsKt.verboseLog(BillingStrings.BILLING_INAPP_MESSAGE_NONE);
                } else if (responseCode != 1) {
                    String format = String.format(BillingStrings.BILLING_INAPP_MESSAGE_UNEXPECTED_CODE, Arrays.copyOf(new Object[]{Integer.valueOf(responseCode)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
                } else {
                    LogUtilsKt.debugLog(BillingStrings.BILLING_INAPP_MESSAGE_UPDATE);
                    function0.invoke();
                }
            }
        });
    }
}
