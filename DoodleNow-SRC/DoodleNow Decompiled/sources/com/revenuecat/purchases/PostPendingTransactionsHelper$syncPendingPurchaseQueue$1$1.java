package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "purchasesByHashedToken", "", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostPendingTransactionsHelper.kt */
final class PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$1 extends Lambda implements Function1<Map<String, ? extends StoreTransaction>, Unit> {
    final /* synthetic */ boolean $allowSharingPlayStoreAccount;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ PostPendingTransactionsHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$1(PostPendingTransactionsHelper postPendingTransactionsHelper, boolean z, String str, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        super(1);
        this.this$0 = postPendingTransactionsHelper;
        this.$allowSharingPlayStoreAccount = z;
        this.$appUserID = str;
        this.$onError = function1;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, StoreTransaction>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, StoreTransaction> map) {
        Intrinsics.checkNotNullParameter(map, "purchasesByHashedToken");
        for (Map.Entry next : map.entrySet()) {
            LogIntent logIntent = LogIntent.DEBUG;
            String format = String.format(RestoreStrings.QUERYING_PURCHASE_WITH_HASH, Arrays.copyOf(new Object[]{((StoreTransaction) next.getValue()).getType(), (String) next.getKey()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
        this.this$0.deviceCache.cleanPreviouslySentTokens(map.keySet());
        this.this$0.postTransactionsWithCompletion(this.this$0.deviceCache.getActivePurchasesNotInCache(map), this.$allowSharingPlayStoreAccount, this.$appUserID, this.$onError, this.$onSuccess);
    }
}
