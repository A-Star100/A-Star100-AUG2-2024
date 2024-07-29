package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.OfferingStrings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "backendError", "Lcom/revenuecat/purchases/PurchasesError;", "isServerError", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsManager.kt */
final class OfferingsManager$fetchAndCacheOfferings$2 extends Lambda implements Function2<PurchasesError, Boolean, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<Offerings, Unit> $onSuccess;
    final /* synthetic */ OfferingsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsManager$fetchAndCacheOfferings$2(OfferingsManager offeringsManager, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        super(2);
        this.this$0 = offeringsManager;
        this.$onError = function1;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError, boolean z) {
        Intrinsics.checkNotNullParameter(purchasesError, "backendError");
        if (z) {
            JSONObject cachedOfferingsResponse = this.this$0.offeringsCache.getCachedOfferingsResponse();
            if (cachedOfferingsResponse == null) {
                this.this$0.handleErrorFetchingOfferings(purchasesError, this.$onError);
                return;
            }
            LogUtilsKt.warnLog(OfferingStrings.ERROR_FETCHING_OFFERINGS_USING_DISK_CACHE);
            this.this$0.createAndCacheOfferings(cachedOfferingsResponse, this.$onError, this.$onSuccess);
            return;
        }
        this.this$0.handleErrorFetchingOfferings(purchasesError, this.$onError);
    }
}
