package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "offerings", "Lcom/revenuecat/purchases/Offerings;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsManager.kt */
final class OfferingsManager$createAndCacheOfferings$2 extends Lambda implements Function1<Offerings, Unit> {
    final /* synthetic */ JSONObject $offeringsJSON;
    final /* synthetic */ Function1<Offerings, Unit> $onSuccess;
    final /* synthetic */ OfferingsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsManager$createAndCacheOfferings$2(OfferingsManager offeringsManager, JSONObject jSONObject, Function1<? super Offerings, Unit> function1) {
        super(1);
        this.this$0 = offeringsManager;
        this.$offeringsJSON = jSONObject;
        this.$onSuccess = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Offerings) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final Offerings offerings) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Offering current = offerings.getCurrent();
        if (current != null) {
            this.this$0.offeringImagePreDownloader.preDownloadOfferingImages(current);
        }
        this.this$0.offeringsCache.cacheOfferings(offerings, this.$offeringsJSON);
        OfferingsManager offeringsManager = this.this$0;
        final Function1<Offerings, Unit> function1 = this.$onSuccess;
        offeringsManager.dispatch(new Function0<Unit>() {
            public final void invoke() {
                Function1<Offerings, Unit> function1 = function1;
                if (function1 != null) {
                    function1.invoke(offerings);
                }
            }
        });
    }
}
