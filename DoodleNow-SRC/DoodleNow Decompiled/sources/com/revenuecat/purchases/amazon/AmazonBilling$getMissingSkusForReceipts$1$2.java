package com.revenuecat.purchases.amazon;

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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$getMissingSkusForReceipts$1$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Map<String, PurchasesError> $errorMap;
    final /* synthetic */ Function2<Map<String, String>, Map<String, PurchasesError>, Unit> $onCompletion;
    final /* synthetic */ Receipt $receipt;
    final /* synthetic */ Ref.IntRef $receiptsLeft;
    final /* synthetic */ Map<String, String> $successMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$getMissingSkusForReceipts$1$2(Map<String, PurchasesError> map, Receipt receipt, Ref.IntRef intRef, Function2<? super Map<String, String>, ? super Map<String, PurchasesError>, Unit> function2, Map<String, String> map2) {
        super(1);
        this.$errorMap = map;
        this.$receipt = receipt;
        this.$receiptsLeft = intRef;
        this.$onCompletion = function2;
        this.$successMap = map2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        LogIntent logIntent = LogIntent.AMAZON_ERROR;
        String format = String.format(AmazonStrings.ERROR_FETCHING_RECEIPT_INFO, Arrays.copyOf(new Object[]{purchasesError}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Map<String, PurchasesError> map = this.$errorMap;
        String receiptId = this.$receipt.getReceiptId();
        Intrinsics.checkNotNullExpressionValue(receiptId, "receipt.receiptId");
        map.put(receiptId, purchasesError);
        this.$receiptsLeft.element--;
        if (this.$receiptsLeft.element == 0) {
            this.$onCompletion.invoke(this.$successMap, this.$errorMap);
        }
    }
}
