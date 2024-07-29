package com.revenuecat.purchases.amazon.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/revenuecat/purchases/amazon/handler/PurchaseHandler$createRequestIdResultReceiver$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchaseHandler.kt */
public final class PurchaseHandler$createRequestIdResultReceiver$1 extends ResultReceiver {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function2<Receipt, UserData, Unit> $onSuccess;
    final /* synthetic */ StoreProduct $storeProduct;
    final /* synthetic */ PurchaseHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchaseHandler$createRequestIdResultReceiver$1(Handler handler, PurchaseHandler purchaseHandler, Function2<? super Receipt, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1, StoreProduct storeProduct) {
        super(handler);
        this.this$0 = purchaseHandler;
        this.$onSuccess = function2;
        this.$onError = function1;
        this.$storeProduct = storeProduct;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        Object obj;
        PurchaseHandler purchaseHandler = this.this$0;
        Function2<Receipt, UserData, Unit> function2 = this.$onSuccess;
        Function1<PurchasesError, Unit> function1 = this.$onError;
        StoreProduct storeProduct = this.$storeProduct;
        synchronized (purchaseHandler) {
            if (bundle != null) {
                try {
                    obj = bundle.get(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                obj = null;
            }
            RequestId requestId = obj instanceof RequestId ? (RequestId) obj : null;
            if (requestId != null) {
                purchaseHandler.purchaseCallbacks.put(requestId, TuplesKt.to(function2, function1));
                purchaseHandler.productTypes.put(storeProduct.getId(), storeProduct.getType());
            } else {
                LogUtilsKt.errorLog$default("No RequestId coming from ProxyAmazonBillingActivity", (Throwable) null, 2, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
