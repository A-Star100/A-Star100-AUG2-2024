package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/CustomerInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: coroutinesExtensions.kt */
final class CoroutinesExtensionsKt$awaitLogOut$2$2 extends Lambda implements Function1<CustomerInfo, Unit> {
    final /* synthetic */ Continuation<CustomerInfo> $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesExtensionsKt$awaitLogOut$2$2(Continuation<? super CustomerInfo> continuation) {
        super(1);
        this.$continuation = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "it");
        Continuation<CustomerInfo> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1230constructorimpl(customerInfo));
    }
}
