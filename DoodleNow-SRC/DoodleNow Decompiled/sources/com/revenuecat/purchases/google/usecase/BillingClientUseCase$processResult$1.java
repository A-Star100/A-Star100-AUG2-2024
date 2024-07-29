package com.revenuecat.purchases.google.usecase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingClientUseCase.kt */
/* synthetic */ class BillingClientUseCase$processResult$1 extends FunctionReferenceImpl implements Function1<T, Unit> {
    BillingClientUseCase$processResult$1(Object obj) {
        super(1, obj, BillingClientUseCase.class, "onOk", "onOk(Ljava/lang/Object;)V", 0);
    }

    public final void invoke(T t) {
        ((BillingClientUseCase) this.receiver).onOk(t);
    }
}
