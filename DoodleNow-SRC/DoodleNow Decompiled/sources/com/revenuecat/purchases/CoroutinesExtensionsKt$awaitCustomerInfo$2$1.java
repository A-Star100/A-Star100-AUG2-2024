package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: coroutinesExtensions.kt */
/* synthetic */ class CoroutinesExtensionsKt$awaitCustomerInfo$2$1 extends FunctionReferenceImpl implements Function1<CustomerInfo, Unit> {
    CoroutinesExtensionsKt$awaitCustomerInfo$2$1(Object obj) {
        super(1, obj, ContinuationKt.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "p0");
        Result.Companion companion = Result.Companion;
        ((Continuation) this.receiver).resumeWith(Result.m1230constructorimpl(customerInfo));
    }
}
