package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "productEntitlementMapping", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfflineEntitlementsManager.kt */
final class OfflineEntitlementsManager$updateProductEntitlementMappingCacheIfStale$1 extends Lambda implements Function1<ProductEntitlementMapping, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $completion;
    final /* synthetic */ OfflineEntitlementsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfflineEntitlementsManager$updateProductEntitlementMappingCacheIfStale$1(OfflineEntitlementsManager offlineEntitlementsManager, Function1<? super PurchasesError, Unit> function1) {
        super(1);
        this.this$0 = offlineEntitlementsManager;
        this.$completion = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductEntitlementMapping) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductEntitlementMapping productEntitlementMapping) {
        Intrinsics.checkNotNullParameter(productEntitlementMapping, "productEntitlementMapping");
        this.this$0.deviceCache.cacheProductEntitlementMapping(productEntitlementMapping);
        LogUtilsKt.debugLog(OfflineEntitlementsStrings.SUCCESSFULLY_UPDATED_PRODUCT_ENTITLEMENTS);
        Function1<PurchasesError, Unit> function1 = this.$completion;
        if (function1 != null) {
            function1.invoke(null);
        }
    }
}
