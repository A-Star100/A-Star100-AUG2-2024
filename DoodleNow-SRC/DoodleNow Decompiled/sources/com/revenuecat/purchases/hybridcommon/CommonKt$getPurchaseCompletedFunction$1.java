package com.revenuecat.purchases.hybridcommon;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt;
import com.revenuecat.purchases.hybridcommon.mappers.StoreTransactionMapperKt;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "transaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
final class CommonKt$getPurchaseCompletedFunction$1 extends Lambda implements Function2<StoreTransaction, CustomerInfo, Unit> {
    final /* synthetic */ OnResult $onResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonKt$getPurchaseCompletedFunction$1(OnResult onResult) {
        super(2);
        this.$onResult = onResult;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((StoreTransaction) obj, (CustomerInfo) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
        Unit unit;
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        if (storeTransaction != null) {
            this.$onResult.onReceived(MapsKt.mapOf(TuplesKt.to("productIdentifier", storeTransaction.getProductIds().get(0)), TuplesKt.to("customerInfo", CustomerInfoMapperKt.map(customerInfo)), TuplesKt.to("transaction", StoreTransactionMapperKt.map(storeTransaction))));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.$onResult.onError(new ErrorContainer(PurchasesErrorCode.UnsupportedError.getCode(), "Error purchasing. Null transaction returned from a successful non-upgrade purchase.", MapsKt.emptyMap()));
        }
    }
}
