package com.revenuecat.purchases;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PostPendingTransactionsHelper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PostPendingTransactionsHelper f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Function1 f$3;
    public final /* synthetic */ Function1 f$4;

    public /* synthetic */ PostPendingTransactionsHelper$$ExternalSyntheticLambda0(PostPendingTransactionsHelper postPendingTransactionsHelper, String str, boolean z, Function1 function1, Function1 function12) {
        this.f$0 = postPendingTransactionsHelper;
        this.f$1 = str;
        this.f$2 = z;
        this.f$3 = function1;
        this.f$4 = function12;
    }

    public final void run() {
        PostPendingTransactionsHelper.syncPendingPurchaseQueue$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
