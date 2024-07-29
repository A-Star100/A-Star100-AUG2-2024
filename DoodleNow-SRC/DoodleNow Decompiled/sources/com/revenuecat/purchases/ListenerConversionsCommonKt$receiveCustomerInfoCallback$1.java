package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/revenuecat/purchases/ListenerConversionsCommonKt$receiveCustomerInfoCallback$1", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ListenerConversionsCommon.kt */
public final class ListenerConversionsCommonKt$receiveCustomerInfoCallback$1 implements ReceiveCustomerInfoCallback {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;

    ListenerConversionsCommonKt$receiveCustomerInfoCallback$1(Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    public void onReceived(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Function1<CustomerInfo, Unit> function1 = this.$onSuccess;
        if (function1 != null) {
            Unit invoke = function1.invoke(customerInfo);
        }
    }

    public void onError(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        Function1<PurchasesError, Unit> function1 = this.$onError;
        if (function1 != null) {
            Unit invoke = function1.invoke(purchasesError);
        }
    }
}
