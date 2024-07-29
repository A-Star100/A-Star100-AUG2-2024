package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "purchasesError", "Lcom/revenuecat/purchases/PurchasesError;", "userCancelled", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoroutinesExtensionsCommon.kt */
final class CoroutinesExtensionsCommonKt$awaitPurchase$2$2 extends Lambda implements Function2<PurchasesError, Boolean, Unit> {
    final /* synthetic */ Continuation<PurchaseResult> $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesExtensionsCommonKt$awaitPurchase$2$2(Continuation<? super PurchaseResult> continuation) {
        super(2);
        this.$continuation = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError, boolean z) {
        Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
        Continuation<PurchaseResult> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1230constructorimpl(ResultKt.createFailure(new PurchasesTransactionException(purchasesError, z))));
    }
}
