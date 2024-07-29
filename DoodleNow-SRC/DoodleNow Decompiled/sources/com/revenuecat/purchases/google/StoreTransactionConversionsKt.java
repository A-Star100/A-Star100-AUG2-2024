package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0005\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"originalGooglePurchase", "Lcom/android/billingclient/api/Purchase;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "getOriginalGooglePurchase", "(Lcom/revenuecat/purchases/models/StoreTransaction;)Lcom/android/billingclient/api/Purchase;", "toStoreTransaction", "productType", "Lcom/revenuecat/purchases/ProductType;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "subscriptionOptionId", "", "replacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "purchaseContext", "Lcom/revenuecat/purchases/google/PurchaseContext;", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "type", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: storeTransactionConversions.kt */
public final class StoreTransactionConversionsKt {
    public static /* synthetic */ StoreTransaction toStoreTransaction$default(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode, int i, Object obj) {
        if ((i & 2) != 0) {
            presentedOfferingContext = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            googleReplacementMode = null;
        }
        return toStoreTransaction(purchase, productType, presentedOfferingContext, str, googleReplacementMode);
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        Intrinsics.checkNotNullParameter(productType, "productType");
        String orderId = purchase.getOrderId();
        List<String> products = purchase.getProducts();
        List<String> list = products;
        Intrinsics.checkNotNullExpressionValue(products, "this.products");
        long purchaseTime = purchase.getPurchaseTime();
        String purchaseToken = purchase.getPurchaseToken();
        String str2 = purchaseToken;
        Intrinsics.checkNotNullExpressionValue(purchaseToken, "this.purchaseToken");
        PurchaseState revenueCatPurchaseState = PurchaseStateConversionsKt.toRevenueCatPurchaseState(purchase.getPurchaseState());
        Boolean valueOf = Boolean.valueOf(purchase.isAutoRenewing());
        String signature = purchase.getSignature();
        JSONObject jSONObject = r13;
        JSONObject jSONObject2 = new JSONObject(purchase.getOriginalJson());
        return new StoreTransaction(orderId, list, productType, purchaseTime, str2, revenueCatPurchaseState, valueOf, signature, jSONObject, presentedOfferingContext, (String) null, PurchaseType.GOOGLE_PURCHASE, (String) null, str, (ReplacementMode) googleReplacementMode);
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, PurchaseContext purchaseContext) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        Intrinsics.checkNotNullParameter(purchaseContext, "purchaseContext");
        return toStoreTransaction(purchase, purchaseContext.getProductType(), purchaseContext.getPresentedOfferingContext(), purchaseContext.getSelectedSubscriptionOptionId(), purchaseContext.getReplacementMode());
    }

    public static final Purchase getOriginalGooglePurchase(StoreTransaction storeTransaction) {
        Intrinsics.checkNotNullParameter(storeTransaction, "<this>");
        String signature = storeTransaction.getSignature();
        if (signature == null) {
            return null;
        }
        if (storeTransaction.getPurchaseType() != PurchaseType.GOOGLE_PURCHASE) {
            signature = null;
        }
        if (signature != null) {
            return new Purchase(storeTransaction.getOriginalJson().toString(), signature);
        }
        return null;
    }

    public static final StoreTransaction toStoreTransaction(PurchaseHistoryRecord purchaseHistoryRecord, ProductType productType) {
        Intrinsics.checkNotNullParameter(purchaseHistoryRecord, "<this>");
        Intrinsics.checkNotNullParameter(productType, "type");
        List<String> products = purchaseHistoryRecord.getProducts();
        List<String> list = products;
        Intrinsics.checkNotNullExpressionValue(products, "this.products");
        long purchaseTime = purchaseHistoryRecord.getPurchaseTime();
        String purchaseToken = purchaseHistoryRecord.getPurchaseToken();
        String str = purchaseToken;
        Intrinsics.checkNotNullExpressionValue(purchaseToken, "this.purchaseToken");
        PurchaseState purchaseState = PurchaseState.UNSPECIFIED_STATE;
        String signature = purchaseHistoryRecord.getSignature();
        JSONObject jSONObject = r12;
        JSONObject jSONObject2 = new JSONObject(purchaseHistoryRecord.getOriginalJson());
        return new StoreTransaction((String) null, list, productType, purchaseTime, str, purchaseState, (Boolean) null, signature, jSONObject, (PresentedOfferingContext) null, (String) null, PurchaseType.GOOGLE_RESTORED_PURCHASE, (String) null, (String) null, (ReplacementMode) null);
    }
}
