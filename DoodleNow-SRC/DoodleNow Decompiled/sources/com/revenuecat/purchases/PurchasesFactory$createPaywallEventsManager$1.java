package com.revenuecat.purchases;

import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesFactory.kt */
/* synthetic */ class PurchasesFactory$createPaywallEventsManager$1 extends FunctionReferenceImpl implements Function1<String, PaywallStoredEvent> {
    PurchasesFactory$createPaywallEventsManager$1(Object obj) {
        super(1, obj, PaywallStoredEvent.Companion.class, "fromString", "fromString(Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", 0);
    }

    public final PaywallStoredEvent invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        return ((PaywallStoredEvent.Companion) this.receiver).fromString(str);
    }
}
