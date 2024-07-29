package com.revenuecat.purchases.google;

import com.revenuecat.purchases.common.caching.DeviceCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
/* synthetic */ class BillingWrapper$consumeAndSave$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    BillingWrapper$consumeAndSave$1(Object obj) {
        super(1, obj, DeviceCache.class, "addSuccessfullyPostedToken", "addSuccessfullyPostedToken(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        ((DeviceCache) this.receiver).addSuccessfullyPostedToken(str);
    }
}
