package com.revenuecat.purchases.paywalls.events;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.utils.Event;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0007H\u0016J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "Lcom/revenuecat/purchases/utils/Event;", "seen1", "", "event", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "userID", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/events/PaywallEvent;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;Ljava/lang/String;)V", "getEvent", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "getUserID", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toPaywallBackendEvent", "Lcom/revenuecat/purchases/paywalls/events/PaywallBackendEvent;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: PaywallStoredEvent.kt */
public final class PaywallStoredEvent implements Event {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Json.Default json = Json.Default;
    private final PaywallEvent event;
    private final String userID;

    public static /* synthetic */ PaywallStoredEvent copy$default(PaywallStoredEvent paywallStoredEvent, PaywallEvent paywallEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            paywallEvent = paywallStoredEvent.event;
        }
        if ((i & 2) != 0) {
            str = paywallStoredEvent.userID;
        }
        return paywallStoredEvent.copy(paywallEvent, str);
    }

    public final PaywallEvent component1() {
        return this.event;
    }

    public final String component2() {
        return this.userID;
    }

    public final PaywallStoredEvent copy(PaywallEvent paywallEvent, String str) {
        Intrinsics.checkNotNullParameter(paywallEvent, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(str, "userID");
        return new PaywallStoredEvent(paywallEvent, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallStoredEvent)) {
            return false;
        }
        PaywallStoredEvent paywallStoredEvent = (PaywallStoredEvent) obj;
        return Intrinsics.areEqual((Object) this.event, (Object) paywallStoredEvent.event) && Intrinsics.areEqual((Object) this.userID, (Object) paywallStoredEvent.userID);
    }

    public final PaywallEvent getEvent() {
        return this.event;
    }

    public final String getUserID() {
        return this.userID;
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + this.userID.hashCode();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallStoredEvent(int i, PaywallEvent paywallEvent, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, PaywallStoredEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.event = paywallEvent;
        this.userID = str;
    }

    public PaywallStoredEvent(PaywallEvent paywallEvent, String str) {
        Intrinsics.checkNotNullParameter(paywallEvent, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(str, "userID");
        this.event = paywallEvent;
        this.userID = str;
    }

    @JvmStatic
    public static final void write$Self(PaywallStoredEvent paywallStoredEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(paywallStoredEvent, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, PaywallEvent$$serializer.INSTANCE, paywallStoredEvent.event);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, paywallStoredEvent.userID);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fHÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json$Default;", "getJson", "()Lkotlinx/serialization/json/Json$Default;", "fromString", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "string", "", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallStoredEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallStoredEvent> serializer() {
            return PaywallStoredEvent$$serializer.INSTANCE;
        }

        public final Json.Default getJson() {
            return PaywallStoredEvent.json;
        }

        public final PaywallStoredEvent fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "string");
            StringFormat json = getJson();
            KSerializer<Object> serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(PaywallStoredEvent.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (PaywallStoredEvent) json.decodeFromString(serializer, str);
        }
    }

    public final PaywallBackendEvent toPaywallBackendEvent() {
        String uuid = this.event.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "event.creationData.id.toString()");
        String value = this.event.getType().getValue();
        String str = this.userID;
        String uuid2 = this.event.getData().getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "event.data.sessionIdentifier.toString()");
        return new PaywallBackendEvent(uuid, 1, value, str, uuid2, this.event.getData().getOfferingIdentifier(), this.event.getData().getPaywallRevision(), this.event.getCreationData().getDate().getTime(), this.event.getData().getDisplayMode(), this.event.getData().getDarkMode(), this.event.getData().getLocaleIdentifier());
    }

    public String toString() {
        StringFormat stringFormat = json;
        KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(PaywallStoredEvent.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return stringFormat.encodeToString(serializer, this);
    }
}
