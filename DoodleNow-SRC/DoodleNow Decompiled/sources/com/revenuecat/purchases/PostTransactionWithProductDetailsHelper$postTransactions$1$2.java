package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostTransactionWithProductDetailsHelper.kt */
final class PostTransactionWithProductDetailsHelper$postTransactions$1$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ boolean $allowSharingPlayStoreAccount;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ PostReceiptInitiationSource $initiationSource;
    final /* synthetic */ StoreTransaction $transaction;
    final /* synthetic */ Function2<StoreTransaction, PurchasesError, Unit> $transactionPostError;
    final /* synthetic */ Function2<StoreTransaction, CustomerInfo, Unit> $transactionPostSuccess;
    final /* synthetic */ PostTransactionWithProductDetailsHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostTransactionWithProductDetailsHelper$postTransactions$1$2(PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, StoreTransaction storeTransaction, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, Function2<? super StoreTransaction, ? super PurchasesError, Unit> function22) {
        super(1);
        this.this$0 = postTransactionWithProductDetailsHelper;
        this.$transaction = storeTransaction;
        this.$allowSharingPlayStoreAccount = z;
        this.$appUserID = str;
        this.$initiationSource = postReceiptInitiationSource;
        this.$transactionPostSuccess = function2;
        this.$transactionPostError = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "it");
        this.this$0.postReceiptHelper.postTransactionAndConsumeIfNeeded(this.$transaction, (StoreProduct) null, this.$allowSharingPlayStoreAccount, this.$appUserID, this.$initiationSource, this.$transactionPostSuccess, this.$transactionPostError);
    }
}
