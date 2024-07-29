package com.revenuecat.purchases.amazon;

import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.BillingStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "connectionError", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$getStorefront$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$getStorefront$1(AmazonBilling amazonBilling, Function1<? super PurchasesError, Unit> function1, Function1<? super String, Unit> function12) {
        super(1);
        this.this$0 = amazonBilling;
        this.$onError = function1;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError == null) {
            UserDataResponseListener access$getUserDataHandler$p = this.this$0.userDataHandler;
            final AmazonBilling amazonBilling = this.this$0;
            final Function1<String, Unit> function1 = this.$onSuccess;
            final Function1<PurchasesError, Unit> function12 = this.$onError;
            final Function1<PurchasesError, Unit> function13 = this.$onError;
            access$getUserDataHandler$p.getUserData(new Function1<UserData, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((UserData) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(UserData userData) {
                    Intrinsics.checkNotNullParameter(userData, "userData");
                    String marketplace = userData.getMarketplace();
                    if (marketplace == null) {
                        function12.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_USER_DATA_MARKETPLACE_NULL_STORE_PROBLEM));
                    } else {
                        function1.invoke(marketplace);
                    }
                }
            }, new Function1<PurchasesError, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(PurchasesError purchasesError) {
                    Intrinsics.checkNotNullParameter(purchasesError, "error");
                    String format = String.format(BillingStrings.BILLING_AMAZON_ERROR_STOREFRONT, Arrays.copyOf(new Object[]{purchasesError}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
                    function13.invoke(purchasesError);
                }
            });
            return;
        }
        String format = String.format(BillingStrings.BILLING_CONNECTION_ERROR_STORE_COUNTRY, Arrays.copyOf(new Object[]{purchasesError}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
        this.$onError.invoke(purchasesError);
    }
}
