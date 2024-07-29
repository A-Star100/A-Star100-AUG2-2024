package com.revenuecat.purchases.amazon.listener;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00030\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\tH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/amazon/listener/ProductDataResponseListener;", "Lcom/amazon/device/iap/PurchasingListener;", "getProductData", "", "skus", "", "", "marketplace", "onReceive", "Lkotlin/Function1;", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "onPurchaseResponse", "response", "Lcom/amazon/device/iap/model/PurchaseResponse;", "onPurchaseUpdatesResponse", "Lcom/amazon/device/iap/model/PurchaseUpdatesResponse;", "onUserDataResponse", "Lcom/amazon/device/iap/model/UserDataResponse;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ProductDataResponseListener.kt */
public interface ProductDataResponseListener extends PurchasingListener {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ProductDataResponseListener.kt */
    public static final class DefaultImpls {
        public static void onPurchaseResponse(ProductDataResponseListener productDataResponseListener, PurchaseResponse purchaseResponse) {
            Intrinsics.checkNotNullParameter(purchaseResponse, "response");
        }

        public static void onPurchaseUpdatesResponse(ProductDataResponseListener productDataResponseListener, PurchaseUpdatesResponse purchaseUpdatesResponse) {
            Intrinsics.checkNotNullParameter(purchaseUpdatesResponse, "response");
        }

        public static void onUserDataResponse(ProductDataResponseListener productDataResponseListener, UserDataResponse userDataResponse) {
            Intrinsics.checkNotNullParameter(userDataResponse, "response");
        }
    }

    void getProductData(Set<String> set, String str, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12);

    void onPurchaseResponse(PurchaseResponse purchaseResponse);

    void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse);

    void onUserDataResponse(UserDataResponse userDataResponse);
}
