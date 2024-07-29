package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ListenerConversionsCommon.kt */
final class ListenerConversionsCommonKt$ON_ERROR_STUB$1 extends Lambda implements Function1<PurchasesError, Unit> {
    public static final ListenerConversionsCommonKt$ON_ERROR_STUB$1 INSTANCE = new ListenerConversionsCommonKt$ON_ERROR_STUB$1();

    ListenerConversionsCommonKt$ON_ERROR_STUB$1() {
        super(1);
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }
}
