package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.LogUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PaywallEventsManager.kt */
final class PaywallEventsManager$flushEvents$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PaywallEventsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaywallEventsManager$flushEvents$1(PaywallEventsManager paywallEventsManager) {
        super(0);
        this.this$0 = paywallEventsManager;
    }

    public final void invoke() {
        if (this.this$0.flushInProgress) {
            LogUtilsKt.debugLog("Flush already in progress.");
            return;
        }
        this.this$0.flushInProgress = true;
        final List access$getEventsToSync = this.this$0.getEventsToSync();
        List filterNotNull = CollectionsKt.filterNotNull(access$getEventsToSync);
        int size = filterNotNull.size();
        if (filterNotNull.isEmpty()) {
            LogUtilsKt.verboseLog("No paywall events to sync.");
            this.this$0.flushInProgress = false;
            return;
        }
        LogUtilsKt.verboseLog("Paywall event flush: posting " + size + " events.");
        Backend access$getBackend$p = this.this$0.backend;
        Iterable<PaywallStoredEvent> iterable = filterNotNull;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (PaywallStoredEvent paywallBackendEvent : iterable) {
            arrayList.add(paywallBackendEvent.toPaywallBackendEvent());
        }
        PaywallEventRequest paywallEventRequest = new PaywallEventRequest((List) arrayList);
        final PaywallEventsManager paywallEventsManager = this.this$0;
        final PaywallEventsManager paywallEventsManager2 = this.this$0;
        access$getBackend$p.postPaywallEvents(paywallEventRequest, new Function0<Unit>() {
            public final void invoke() {
                LogUtilsKt.verboseLog("Paywall event flush: success.");
                PaywallEventsManager paywallEventsManager = paywallEventsManager;
                final PaywallEventsManager paywallEventsManager2 = paywallEventsManager;
                final List<PaywallStoredEvent> list = access$getEventsToSync;
                PaywallEventsManager.enqueue$default(paywallEventsManager, (Delay) null, new Function0<Unit>() {
                    public final void invoke() {
                        paywallEventsManager2.fileHelper.clear(list.size());
                        paywallEventsManager2.flushInProgress = false;
                    }
                }, 1, (Object) null);
            }
        }, new Function2<PurchasesError, Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError, final boolean z) {
                Intrinsics.checkNotNullParameter(purchasesError, "error");
                LogUtilsKt.errorLog$default("Paywall event flush error: " + purchasesError + '.', (Throwable) null, 2, (Object) null);
                PaywallEventsManager paywallEventsManager = paywallEventsManager2;
                final PaywallEventsManager paywallEventsManager2 = paywallEventsManager2;
                final List<PaywallStoredEvent> list = access$getEventsToSync;
                PaywallEventsManager.enqueue$default(paywallEventsManager, (Delay) null, new Function0<Unit>() {
                    public final void invoke() {
                        if (z) {
                            paywallEventsManager2.fileHelper.clear(list.size());
                        }
                        paywallEventsManager2.flushInProgress = false;
                    }
                }, 1, (Object) null);
            }
        });
    }
}
