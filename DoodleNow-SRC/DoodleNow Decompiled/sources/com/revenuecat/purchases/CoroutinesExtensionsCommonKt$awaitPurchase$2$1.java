package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoroutinesExtensionsCommon.kt */
final class CoroutinesExtensionsCommonKt$awaitPurchase$2$1 extends Lambda implements Function2<StoreTransaction, CustomerInfo, Unit> {
    final /* synthetic */ Continuation<PurchaseResult> $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesExtensionsCommonKt$awaitPurchase$2$1(Continuation<? super PurchaseResult> continuation) {
        super(2);
        this.$continuation = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((StoreTransaction) obj, (CustomerInfo) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Continuation<PurchaseResult> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1230constructorimpl(new PurchaseResult(storeTransaction, customerInfo)));
    }
}
