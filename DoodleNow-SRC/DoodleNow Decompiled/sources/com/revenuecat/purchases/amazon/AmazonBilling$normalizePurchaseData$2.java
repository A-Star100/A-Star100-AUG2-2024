package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$normalizePurchaseData$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ String $purchaseToken;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$normalizePurchaseData$2(AmazonBilling amazonBilling, Function1<? super PurchasesError, Unit> function1, String str, Function1<? super String, Unit> function12) {
        super(1);
        this.this$0 = amazonBilling;
        this.$onError = function1;
        this.$purchaseToken = str;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "response");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AmazonStrings.RECEIPT_DATA_RECEIVED, Arrays.copyOf(new Object[]{jSONObject.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        String access$getTermSkuFromJSON = this.this$0.getTermSkuFromJSON(jSONObject);
        if (access$getTermSkuFromJSON == null) {
            this.$onError.invoke(ErrorsKt.missingTermSkuError(jSONObject));
            return;
        }
        this.this$0.cache.cacheSkusByToken(MapsKt.mapOf(TuplesKt.to(this.$purchaseToken, access$getTermSkuFromJSON)));
        this.$onSuccess.invoke(access$getTermSkuFromJSON);
    }
}
