package com.revenuecat.purchases;

import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "backendError", "Lcom/revenuecat/purchases/PurchasesError;", "errorHandlingBehavior", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "<anonymous parameter 2>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostReceiptHelper.kt */
final class PostReceiptHelper$postTokenWithoutConsuming$2 extends Lambda implements Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ String $purchaseToken;
    final /* synthetic */ PostReceiptHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostReceiptHelper$postTokenWithoutConsuming$2(PostReceiptHelper postReceiptHelper, String str, String str2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        super(3);
        this.this$0 = postReceiptHelper;
        this.$purchaseToken = str;
        this.$appUserID = str2;
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(final PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(purchasesError, "backendError");
        Intrinsics.checkNotNullParameter(postReceiptErrorHandlingBehavior, "errorHandlingBehavior");
        if (postReceiptErrorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED) {
            this.this$0.deviceCache.addSuccessfullyPostedToken(this.$purchaseToken);
        }
        PostReceiptHelper postReceiptHelper = this.this$0;
        String str = this.$appUserID;
        final Function1<CustomerInfo, Unit> function1 = this.$onSuccess;
        final Function1<PurchasesError, Unit> function12 = this.$onError;
        postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(postReceiptErrorHandlingBehavior, str, new Function1<CustomerInfo, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "it");
                function1.invoke(customerInfo);
            }
        }, new Function0<Unit>() {
            public final void invoke() {
                function12.invoke(purchasesError);
            }
        });
    }
}
