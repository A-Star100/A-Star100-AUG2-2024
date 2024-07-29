package com.revenuecat.purchases.paywalls.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\fHÖ\u0001J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÇ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEventRequest;", "", "seen1", "", "events", "", "Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "cacheKey", "", "getCacheKey", "()Ljava/util/List;", "getEvents", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: PaywallEventRequest.kt */
public final class PaywallEventRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Json json = Json.Default;
    private final List<PaywallBackendEvent> events;

    public static /* synthetic */ PaywallEventRequest copy$default(PaywallEventRequest paywallEventRequest, List<PaywallBackendEvent> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = paywallEventRequest.events;
        }
        return paywallEventRequest.copy(list);
    }

    public final List<PaywallBackendEvent> component1() {
        return this.events;
    }

    public final PaywallEventRequest copy(List<PaywallBackendEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        return new PaywallEventRequest(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaywallEventRequest) && Intrinsics.areEqual((Object) this.events, (Object) ((PaywallEventRequest) obj).events);
    }

    public final List<PaywallBackendEvent> getEvents() {
        return this.events;
    }

    public int hashCode() {
        return this.events.hashCode();
    }

    public String toString() {
        return "PaywallEventRequest(events=" + this.events + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallEventRequest(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, PaywallEventRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.events = list;
    }

    public PaywallEventRequest(List<PaywallBackendEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        this.events = list;
    }

    @JvmStatic
    public static final void write$Self(PaywallEventRequest paywallEventRequest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(paywallEventRequest, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(PaywallBackendEvent$$serializer.INSTANCE), paywallEventRequest.events);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEventRequest$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventRequest;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallEventRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallEventRequest> serializer() {
            return PaywallEventRequest$$serializer.INSTANCE;
        }

        public final Json getJson() {
            return PaywallEventRequest.json;
        }
    }

    public final List<String> getCacheKey() {
        Iterable<PaywallBackendEvent> iterable = this.events;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (PaywallBackendEvent hashCode : iterable) {
            arrayList.add(String.valueOf(hashCode.hashCode()));
        }
        return (List) arrayList;
    }
}
