package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.LogInCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/revenuecat/purchases/ListenerConversionsKt$logInSuccessListener$1", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "created", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: listenerConversions.kt */
public final class ListenerConversionsKt$logInSuccessListener$1 implements LogInCallback {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function2<CustomerInfo, Boolean, Unit> $onSuccess;

    ListenerConversionsKt$logInSuccessListener$1(Function2<? super CustomerInfo, ? super Boolean, Unit> function2, Function1<? super PurchasesError, Unit> function1) {
        this.$onSuccess = function2;
        this.$onError = function1;
    }

    public void onReceived(CustomerInfo customerInfo, boolean z) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Function2<CustomerInfo, Boolean, Unit> function2 = this.$onSuccess;
        if (function2 != null) {
            Unit invoke = function2.invoke(customerInfo, Boolean.valueOf(z));
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
