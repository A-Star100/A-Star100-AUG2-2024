package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfflineEntitlementsManager.kt */
final class OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$2 extends Lambda implements Function1<CustomerInfo, Unit> {
    final /* synthetic */ String $appUserId;
    final /* synthetic */ OfflineEntitlementsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$2(OfflineEntitlementsManager offlineEntitlementsManager, String str) {
        super(1);
        this.this$0 = offlineEntitlementsManager;
        this.$appUserId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        OfflineEntitlementsManager offlineEntitlementsManager = this.this$0;
        String str = this.$appUserId;
        synchronized (offlineEntitlementsManager) {
            LogUtilsKt.warnLog(OfflineEntitlementsStrings.USING_OFFLINE_ENTITLEMENTS_CUSTOMER_INFO);
            offlineEntitlementsManager._offlineCustomerInfo = customerInfo;
            String cachedAppUserID = offlineEntitlementsManager.deviceCache.getCachedAppUserID();
            if (cachedAppUserID != null) {
                offlineEntitlementsManager.deviceCache.clearCustomerInfoCache(cachedAppUserID);
            }
            List<Pair> list = (List) offlineEntitlementsManager.offlineCustomerInfoCallbackCache.remove(str);
            if (list != null) {
                for (Pair component1 : list) {
                    ((Function1) component1.component1()).invoke(customerInfo);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
