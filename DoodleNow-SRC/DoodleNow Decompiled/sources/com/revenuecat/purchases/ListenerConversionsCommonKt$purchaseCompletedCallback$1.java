package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/revenuecat/purchases/ListenerConversionsCommonKt$purchaseCompletedCallback$1", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "onCompleted", "", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "userCancelled", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ListenerConversionsCommon.kt */
public final class ListenerConversionsCommonKt$purchaseCompletedCallback$1 implements PurchaseCallback {
    final /* synthetic */ Function2<PurchasesError, Boolean, Unit> $onError;
    final /* synthetic */ Function2<StoreTransaction, CustomerInfo, Unit> $onSuccess;

    ListenerConversionsCommonKt$purchaseCompletedCallback$1(Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, Function2<? super PurchasesError, ? super Boolean, Unit> function22) {
        this.$onSuccess = function2;
        this.$onError = function22;
    }

    public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        this.$onSuccess.invoke(storeTransaction, customerInfo);
    }

    public void onError(PurchasesError purchasesError, boolean z) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        this.$onError.invoke(purchasesError, Boolean.valueOf(z));
    }
}
