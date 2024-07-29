package com.revenuecat.purchases.paywalls;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048B@BX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "", "()V", "<set-?>", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "lastPaywallImpressionEvent", "cachePresentedPaywall", "", "paywallEvent", "getAndRemovePresentedEvent", "receiveEvent", "event", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PaywallPresentedCache.kt */
public final class PaywallPresentedCache {
    private PaywallEvent lastPaywallImpressionEvent;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallPresentedCache.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.revenuecat.purchases.paywalls.events.PaywallEventType[] r0 = com.revenuecat.purchases.paywalls.events.PaywallEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.paywalls.events.PaywallEventType r1 = com.revenuecat.purchases.paywalls.events.PaywallEventType.IMPRESSION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.paywalls.events.PaywallEventType r1 = com.revenuecat.purchases.paywalls.events.PaywallEventType.CLOSE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.PaywallPresentedCache.WhenMappings.<clinit>():void");
        }
    }

    public final synchronized PaywallEvent getAndRemovePresentedEvent() {
        PaywallEvent paywallEvent;
        paywallEvent = this.lastPaywallImpressionEvent;
        this.lastPaywallImpressionEvent = null;
        return paywallEvent;
    }

    public final synchronized void cachePresentedPaywall(PaywallEvent paywallEvent) {
        Intrinsics.checkNotNullParameter(paywallEvent, "paywallEvent");
        this.lastPaywallImpressionEvent = paywallEvent;
    }

    public final synchronized void receiveEvent(PaywallEvent paywallEvent) {
        Intrinsics.checkNotNullParameter(paywallEvent, NotificationCompat.CATEGORY_EVENT);
        int i = WhenMappings.$EnumSwitchMapping$0[paywallEvent.getType().ordinal()];
        if (i == 1) {
            LogUtilsKt.verboseLog("Caching paywall impression event.");
            this.lastPaywallImpressionEvent = paywallEvent;
        } else if (i == 2) {
            LogUtilsKt.verboseLog("Clearing cached paywall impression event.");
            this.lastPaywallImpressionEvent = null;
        }
    }
}
