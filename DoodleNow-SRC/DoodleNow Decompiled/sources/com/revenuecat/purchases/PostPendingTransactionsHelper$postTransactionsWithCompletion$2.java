package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.utils.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/revenuecat/purchases/models/StoreTransaction;", "purchasesError", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostPendingTransactionsHelper.kt */
final class PostPendingTransactionsHelper$postTransactionsWithCompletion$2 extends Lambda implements Function2<StoreTransaction, PurchasesError, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ List<Result<CustomerInfo, PurchasesError>> $results;
    final /* synthetic */ List<StoreTransaction> $transactionsToSync;
    final /* synthetic */ PostPendingTransactionsHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostPendingTransactionsHelper$postTransactionsWithCompletion$2(List<Result<CustomerInfo, PurchasesError>> list, PostPendingTransactionsHelper postPendingTransactionsHelper, List<StoreTransaction> list2, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        super(2);
        this.$results = list;
        this.this$0 = postPendingTransactionsHelper;
        this.$transactionsToSync = list2;
        this.$onError = function1;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((StoreTransaction) obj, (PurchasesError) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(StoreTransaction storeTransaction, PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(storeTransaction, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
        this.$results.add(new Result.Error(purchasesError));
        this.this$0.callCompletionFromResults(this.$transactionsToSync, this.$results, this.$onError, this.$onSuccess);
    }
}
