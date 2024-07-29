package com.revenuecat.purchases.paywalls.events;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.utils.EventsFileHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager;", "", "fileHelper", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "paywallEventsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "(Lcom/revenuecat/purchases/utils/EventsFileHelper;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/Backend;)V", "<set-?>", "", "flushInProgress", "enqueue", "", "delay", "Lcom/revenuecat/purchases/common/Delay;", "command", "Lkotlin/Function0;", "flushEvents", "getEventsToSync", "", "track", "event", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PaywallEventsManager.kt */
public final class PaywallEventsManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FLUSH_COUNT = 50;
    public static final String PAYWALL_EVENTS_FILE_PATH = "RevenueCat/paywall_event_store/paywall_event_store.jsonl";
    /* access modifiers changed from: private */
    public final Backend backend;
    /* access modifiers changed from: private */
    public final EventsFileHelper<PaywallStoredEvent> fileHelper;
    /* access modifiers changed from: private */
    public boolean flushInProgress;
    /* access modifiers changed from: private */
    public final IdentityManager identityManager;
    private final Dispatcher paywallEventsDispatcher;

    public PaywallEventsManager(EventsFileHelper<PaywallStoredEvent> eventsFileHelper, IdentityManager identityManager2, Dispatcher dispatcher, Backend backend2) {
        Intrinsics.checkNotNullParameter(eventsFileHelper, "fileHelper");
        Intrinsics.checkNotNullParameter(identityManager2, "identityManager");
        Intrinsics.checkNotNullParameter(dispatcher, "paywallEventsDispatcher");
        Intrinsics.checkNotNullParameter(backend2, "backend");
        this.fileHelper = eventsFileHelper;
        this.identityManager = identityManager2;
        this.paywallEventsDispatcher = dispatcher;
        this.backend = backend2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEventsManager$Companion;", "", "()V", "FLUSH_COUNT", "", "PAYWALL_EVENTS_FILE_PATH", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallEventsManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final synchronized void track(PaywallEvent paywallEvent) {
        Intrinsics.checkNotNullParameter(paywallEvent, NotificationCompat.CATEGORY_EVENT);
        enqueue$default(this, (Delay) null, new PaywallEventsManager$track$1(paywallEvent, this), 1, (Object) null);
    }

    public final synchronized void flushEvents() {
        enqueue$default(this, (Delay) null, new PaywallEventsManager$flushEvents$1(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final List<PaywallStoredEvent> getEventsToSync() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        this.fileHelper.readFile(new PaywallEventsManager$getEventsToSync$1(objectRef));
        return (List) objectRef.element;
    }

    static /* synthetic */ void enqueue$default(PaywallEventsManager paywallEventsManager, Delay delay, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            delay = Delay.NONE;
        }
        paywallEventsManager.enqueue(delay, function0);
    }

    private final void enqueue(Delay delay, Function0<Unit> function0) {
        this.paywallEventsDispatcher.enqueue(new PaywallEventsManager$$ExternalSyntheticLambda0(function0), delay);
    }

    /* access modifiers changed from: private */
    public static final void enqueue$lambda$0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$command");
        function0.invoke();
    }
}
