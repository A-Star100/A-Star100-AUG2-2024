package com.revenuecat.purchases.paywalls.events;

import java.util.List;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "stream", "Ljava/util/stream/Stream;", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PaywallEventsManager.kt */
final class PaywallEventsManager$getEventsToSync$1 extends Lambda implements Function1<Stream<PaywallStoredEvent>, Unit> {
    final /* synthetic */ Ref.ObjectRef<List<PaywallStoredEvent>> $eventsToSync;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaywallEventsManager$getEventsToSync$1(Ref.ObjectRef<List<PaywallStoredEvent>> objectRef) {
        super(1);
        this.$eventsToSync = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Stream<PaywallStoredEvent>) PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(obj));
        return Unit.INSTANCE;
    }

    public final void invoke(Stream<PaywallStoredEvent> stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Ref.ObjectRef<List<PaywallStoredEvent>> objectRef = this.$eventsToSync;
        T m = stream.limit(50).collect(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m());
        Intrinsics.checkNotNullExpressionValue(m, "stream.limit(FLUSH_COUNT…lect(Collectors.toList())");
        objectRef.element = m;
    }
}
