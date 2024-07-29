package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "backendError", "Lcom/revenuecat/purchases/PurchasesError;", "isServerError", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomerInfoHelper.kt */
final class CustomerInfoHelper$getCustomerInfoFetchOnly$2 extends Lambda implements Function2<PurchasesError, Boolean, Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ ReceiveCustomerInfoCallback $callback;
    final /* synthetic */ CustomerInfoHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerInfoHelper$getCustomerInfoFetchOnly$2(CustomerInfoHelper customerInfoHelper, String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        super(2);
        this.this$0 = customerInfoHelper;
        this.$appUserID = str;
        this.$callback = receiveCustomerInfoCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final PurchasesError purchasesError, boolean z) {
        Intrinsics.checkNotNullParameter(purchasesError, "backendError");
        String format = String.format(CustomerInfoStrings.ERROR_FETCHING_CUSTOMER_INFO, Arrays.copyOf(new Object[]{purchasesError}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
        this.this$0.deviceCache.clearCustomerInfoCacheTimestamp(this.$appUserID);
        if (this.this$0.offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInGetCustomerInfoRequest(z, this.$appUserID)) {
            OfflineEntitlementsManager access$getOfflineEntitlementsManager$p = this.this$0.offlineEntitlementsManager;
            String str = this.$appUserID;
            final CustomerInfoHelper customerInfoHelper = this.this$0;
            final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = this.$callback;
            final CustomerInfoHelper customerInfoHelper2 = this.this$0;
            final ReceiveCustomerInfoCallback receiveCustomerInfoCallback2 = this.$callback;
            access$getOfflineEntitlementsManager$p.calculateAndCacheOfflineCustomerInfo(str, new Function1<CustomerInfo, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(final CustomerInfo customerInfo) {
                    Intrinsics.checkNotNullParameter(customerInfo, "offlineComputedCustomerInfo");
                    customerInfoHelper.customerInfoUpdateHandler.notifyListeners(customerInfo);
                    CustomerInfoHelper customerInfoHelper = customerInfoHelper;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = receiveCustomerInfoCallback;
                    customerInfoHelper.dispatch(new Function0<Unit>() {
                        public final void invoke() {
                            ReceiveCustomerInfoCallback receiveCustomerInfoCallback = receiveCustomerInfoCallback;
                            if (receiveCustomerInfoCallback != null) {
                                receiveCustomerInfoCallback.onReceived(customerInfo);
                            }
                        }
                    });
                }
            }, new Function1<PurchasesError, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(PurchasesError purchasesError) {
                    Intrinsics.checkNotNullParameter(purchasesError, "it");
                    CustomerInfoHelper customerInfoHelper = customerInfoHelper2;
                    final ReceiveCustomerInfoCallback receiveCustomerInfoCallback = receiveCustomerInfoCallback2;
                    final PurchasesError purchasesError2 = purchasesError;
                    customerInfoHelper.dispatch(new Function0<Unit>() {
                        public final void invoke() {
                            ReceiveCustomerInfoCallback receiveCustomerInfoCallback = receiveCustomerInfoCallback;
                            if (receiveCustomerInfoCallback != null) {
                                receiveCustomerInfoCallback.onError(purchasesError2);
                            }
                        }
                    });
                }
            });
            return;
        }
        CustomerInfoHelper customerInfoHelper3 = this.this$0;
        final ReceiveCustomerInfoCallback receiveCustomerInfoCallback3 = this.$callback;
        customerInfoHelper3.dispatch(new Function0<Unit>() {
            public final void invoke() {
                ReceiveCustomerInfoCallback receiveCustomerInfoCallback = receiveCustomerInfoCallback3;
                if (receiveCustomerInfoCallback != null) {
                    receiveCustomerInfoCallback.onError(purchasesError);
                }
            }
        });
    }
}
