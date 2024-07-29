package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.Receipt;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$getMissingSkusForReceipts$1$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Map<String, PurchasesError> $errorMap;
    final /* synthetic */ Function2<Map<String, String>, Map<String, PurchasesError>, Unit> $onCompletion;
    final /* synthetic */ Receipt $receipt;
    final /* synthetic */ Ref.IntRef $receiptsLeft;
    final /* synthetic */ Map<String, String> $successMap;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$getMissingSkusForReceipts$1$1(Map<String, String> map, Receipt receipt, Ref.IntRef intRef, AmazonBilling amazonBilling, Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function2, Map<String, PurchasesError> map2) {
        super(1);
        this.$successMap = map;
        this.$receipt = receipt;
        this.$receiptsLeft = intRef;
        this.this$0 = amazonBilling;
        this.$onCompletion = function2;
        this.$errorMap = map2;
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
        Map<String, String> map = this.$successMap;
        String receiptId = this.$receipt.getReceiptId();
        Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
        Object obj = jSONObject.get(b.L);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        map.put(receiptId, (String) obj);
        this.$receiptsLeft.element--;
        if (this.$receiptsLeft.element == 0) {
            this.this$0.cache.cacheSkusByToken(this.$successMap);
            this.$onCompletion.invoke(this.$successMap, this.$errorMap);
        }
    }
}
