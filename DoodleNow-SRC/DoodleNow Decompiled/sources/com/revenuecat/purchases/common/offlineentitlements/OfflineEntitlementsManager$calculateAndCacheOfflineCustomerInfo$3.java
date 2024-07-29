package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.PurchasesError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfflineEntitlementsManager.kt */
final class OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$3 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ String $appUserId;
    final /* synthetic */ OfflineEntitlementsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfflineEntitlementsManager$calculateAndCacheOfflineCustomerInfo$3(OfflineEntitlementsManager offlineEntitlementsManager, String str) {
        super(1);
        this.this$0 = offlineEntitlementsManager;
        this.$appUserId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "it");
        OfflineEntitlementsManager offlineEntitlementsManager = this.this$0;
        String str = this.$appUserId;
        synchronized (offlineEntitlementsManager) {
            List<Pair> list = (List) offlineEntitlementsManager.offlineCustomerInfoCallbackCache.remove(str);
            if (list != null) {
                for (Pair component2 : list) {
                    ((Function1) component2.component2()).invoke(purchasesError);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
