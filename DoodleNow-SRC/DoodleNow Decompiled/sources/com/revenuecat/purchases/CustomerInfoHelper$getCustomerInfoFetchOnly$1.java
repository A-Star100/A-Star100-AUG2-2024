package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "info", "Lcom/revenuecat/purchases/CustomerInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomerInfoHelper.kt */
final class CustomerInfoHelper$getCustomerInfoFetchOnly$1 extends Lambda implements Function1<CustomerInfo, Unit> {
    final /* synthetic */ ReceiveCustomerInfoCallback $callback;
    final /* synthetic */ CustomerInfoHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerInfoHelper$getCustomerInfoFetchOnly$1(CustomerInfoHelper customerInfoHelper, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        super(1);
        this.this$0 = customerInfoHelper;
        this.$callback = receiveCustomerInfoCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "info");
        LogWrapperKt.log(LogIntent.RC_SUCCESS, CustomerInfoStrings.CUSTOMERINFO_UPDATED_FROM_NETWORK);
        this.this$0.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
        this.this$0.customerInfoUpdateHandler.cacheAndNotifyListeners(customerInfo);
        CustomerInfoHelper customerInfoHelper = this.this$0;
        final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = this.$callback;
        customerInfoHelper.dispatch(new Function0<Unit>() {
            public final void invoke() {
                ReceiveCustomerInfoCallback receiveCustomerInfoCallback = receiveCustomerInfoCallback;
                if (receiveCustomerInfoCallback != null) {
                    receiveCustomerInfoCallback.onReceived(customerInfo);
                }
            }
        });
    }
}
