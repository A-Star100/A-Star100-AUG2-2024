package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "info", "Lcom/revenuecat/purchases/CustomerInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostReceiptHelper.kt */
final class PostReceiptHelper$postTransactionAndConsumeIfNeeded$1 extends Lambda implements Function1<CustomerInfo, Unit> {
    final /* synthetic */ PostReceiptInitiationSource $initiationSource;
    final /* synthetic */ Function2<StoreTransaction, CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ StoreTransaction $purchase;
    final /* synthetic */ PostReceiptHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostReceiptHelper$postTransactionAndConsumeIfNeeded$1(PostReceiptHelper postReceiptHelper, StoreTransaction storeTransaction, PostReceiptInitiationSource postReceiptInitiationSource, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2) {
        super(1);
        this.this$0 = postReceiptHelper;
        this.$purchase = storeTransaction;
        this.$initiationSource = postReceiptInitiationSource;
        this.$onSuccess = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "info");
        this.this$0.billing.consumeAndSave(this.this$0.getFinishTransactions(), this.$purchase, this.$initiationSource);
        Function2<StoreTransaction, CustomerInfo, Unit> function2 = this.$onSuccess;
        if (function2 != null) {
            function2.invoke(this.$purchase, customerInfo);
        }
    }
}
