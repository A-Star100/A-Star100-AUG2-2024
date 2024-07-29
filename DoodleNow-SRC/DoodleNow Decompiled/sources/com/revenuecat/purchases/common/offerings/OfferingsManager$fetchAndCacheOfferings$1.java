package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsManager.kt */
final class OfferingsManager$fetchAndCacheOfferings$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<Offerings, Unit> $onSuccess;
    final /* synthetic */ OfferingsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsManager$fetchAndCacheOfferings$1(OfferingsManager offeringsManager, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        super(1);
        this.this$0 = offeringsManager;
        this.$onError = function1;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "it");
        this.this$0.createAndCacheOfferings(jSONObject, this.$onError, this.$onSuccess);
    }
}
