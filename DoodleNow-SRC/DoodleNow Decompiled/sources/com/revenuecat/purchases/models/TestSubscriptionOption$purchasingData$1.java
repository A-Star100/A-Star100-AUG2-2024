package com.revenuecat.purchases.models;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/revenuecat/purchases/models/TestSubscriptionOption$purchasingData$1", "Lcom/revenuecat/purchases/models/PurchasingData;", "productId", "", "getProductId", "()Ljava/lang/String;", "productType", "Lcom/revenuecat/purchases/ProductType;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TestStoreProduct.kt */
public final class TestSubscriptionOption$purchasingData$1 implements PurchasingData {
    final /* synthetic */ TestSubscriptionOption this$0;

    TestSubscriptionOption$purchasingData$1(TestSubscriptionOption testSubscriptionOption) {
        this.this$0 = testSubscriptionOption;
    }

    public String getProductId() {
        return this.this$0.getProductIdentifier();
    }

    public ProductType getProductType() {
        return ProductType.SUBS;
    }
}
