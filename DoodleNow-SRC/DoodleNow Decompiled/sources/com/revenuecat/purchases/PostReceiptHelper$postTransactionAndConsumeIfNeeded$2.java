package com.revenuecat.purchases;

import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "backendError", "Lcom/revenuecat/purchases/PurchasesError;", "errorHandlingBehavior", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "<anonymous parameter 2>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostReceiptHelper.kt */
final class PostReceiptHelper$postTransactionAndConsumeIfNeeded$2 extends Lambda implements Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ PostReceiptInitiationSource $initiationSource;
    final /* synthetic */ Function2<StoreTransaction, PurchasesError, Unit> $onError;
    final /* synthetic */ Function2<StoreTransaction, CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ StoreTransaction $purchase;
    final /* synthetic */ PostReceiptHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostReceiptHelper$postTransactionAndConsumeIfNeeded$2(PostReceiptHelper postReceiptHelper, StoreTransaction storeTransaction, PostReceiptInitiationSource postReceiptInitiationSource, String str, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, Function2<? super StoreTransaction, ? super PurchasesError, Unit> function22) {
        super(3);
        this.this$0 = postReceiptHelper;
        this.$purchase = storeTransaction;
        this.$initiationSource = postReceiptInitiationSource;
        this.$appUserID = str;
        this.$onSuccess = function2;
        this.$onError = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(final PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(purchasesError, "backendError");
        Intrinsics.checkNotNullParameter(postReceiptErrorHandlingBehavior, "errorHandlingBehavior");
        if (postReceiptErrorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED) {
            this.this$0.billing.consumeAndSave(this.this$0.getFinishTransactions(), this.$purchase, this.$initiationSource);
        }
        PostReceiptHelper postReceiptHelper = this.this$0;
        String str = this.$appUserID;
        final Function2<StoreTransaction, CustomerInfo, Unit> function2 = this.$onSuccess;
        final StoreTransaction storeTransaction = this.$purchase;
        final Function2<StoreTransaction, PurchasesError, Unit> function22 = this.$onError;
        final StoreTransaction storeTransaction2 = this.$purchase;
        postReceiptHelper.useOfflineEntitlementsCustomerInfoIfNeeded(postReceiptErrorHandlingBehavior, str, new Function1<CustomerInfo, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Function2<StoreTransaction, CustomerInfo, Unit> function2 = function2;
                if (function2 != null) {
                    function2.invoke(storeTransaction, customerInfo);
                }
            }
        }, new Function0<Unit>() {
            public final void invoke() {
                Function2<StoreTransaction, PurchasesError, Unit> function2 = function22;
                if (function2 != null) {
                    function2.invoke(storeTransaction2, purchasesError);
                }
            }
        });
    }
}
