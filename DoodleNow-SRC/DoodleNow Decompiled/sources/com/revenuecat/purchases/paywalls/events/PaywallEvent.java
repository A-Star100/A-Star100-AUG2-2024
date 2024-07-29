package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.utils.serializers.DateSerializer;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import java.util.Date;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 )2\u00020\u0001:\u0004()*+B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\r\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001J!\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006,"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "", "seen1", "", "creationData", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", "data", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "type", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;)V", "getCreationData", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", "getData", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "getType", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toPaywallPostReceiptData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "toPaywallPostReceiptData$purchases_defaultsRelease", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "CreationData", "Data", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* compiled from: PaywallEvent.kt */
public final class PaywallEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CreationData creationData;
    private final Data data;
    private final PaywallEventType type;

    public static /* synthetic */ PaywallEvent copy$default(PaywallEvent paywallEvent, CreationData creationData2, Data data2, PaywallEventType paywallEventType, int i, Object obj) {
        if ((i & 1) != 0) {
            creationData2 = paywallEvent.creationData;
        }
        if ((i & 2) != 0) {
            data2 = paywallEvent.data;
        }
        if ((i & 4) != 0) {
            paywallEventType = paywallEvent.type;
        }
        return paywallEvent.copy(creationData2, data2, paywallEventType);
    }

    public final CreationData component1() {
        return this.creationData;
    }

    public final Data component2() {
        return this.data;
    }

    public final PaywallEventType component3() {
        return this.type;
    }

    public final PaywallEvent copy(CreationData creationData2, Data data2, PaywallEventType paywallEventType) {
        Intrinsics.checkNotNullParameter(creationData2, "creationData");
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(paywallEventType, "type");
        return new PaywallEvent(creationData2, data2, paywallEventType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallEvent)) {
            return false;
        }
        PaywallEvent paywallEvent = (PaywallEvent) obj;
        return Intrinsics.areEqual((Object) this.creationData, (Object) paywallEvent.creationData) && Intrinsics.areEqual((Object) this.data, (Object) paywallEvent.data) && this.type == paywallEvent.type;
    }

    public final CreationData getCreationData() {
        return this.creationData;
    }

    public final Data getData() {
        return this.data;
    }

    public final PaywallEventType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.creationData.hashCode() * 31) + this.data.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "PaywallEvent(creationData=" + this.creationData + ", data=" + this.data + ", type=" + this.type + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PaywallEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaywallEvent> serializer() {
            return PaywallEvent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PaywallEvent(int i, CreationData creationData2, Data data2, PaywallEventType paywallEventType, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, PaywallEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.creationData = creationData2;
        this.data = data2;
        this.type = paywallEventType;
    }

    public PaywallEvent(CreationData creationData2, Data data2, PaywallEventType paywallEventType) {
        Intrinsics.checkNotNullParameter(creationData2, "creationData");
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(paywallEventType, "type");
        this.creationData = creationData2;
        this.data = data2;
        this.type = paywallEventType;
    }

    @JvmStatic
    public static final void write$Self(PaywallEvent paywallEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(paywallEvent, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, PaywallEvent$CreationData$$serializer.INSTANCE, paywallEvent.creationData);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, PaywallEvent$Data$$serializer.INSTANCE, paywallEvent.data);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, EnumsKt.createSimpleEnumSerializer("com.revenuecat.purchases.paywalls.events.PaywallEventType", (Enum[]) PaywallEventType.values()), paywallEvent.type);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0002#$B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", "", "seen1", "", "id", "Ljava/util/UUID;", "date", "Ljava/util/Date;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/UUID;Ljava/util/Date;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/UUID;Ljava/util/Date;)V", "getDate$annotations", "()V", "getDate", "()Ljava/util/Date;", "getId$annotations", "getId", "()Ljava/util/UUID;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: PaywallEvent.kt */
    public static final class CreationData {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Date date;
        private final UUID id;

        public static /* synthetic */ CreationData copy$default(CreationData creationData, UUID uuid, Date date2, int i, Object obj) {
            if ((i & 1) != 0) {
                uuid = creationData.id;
            }
            if ((i & 2) != 0) {
                date2 = creationData.date;
            }
            return creationData.copy(uuid, date2);
        }

        @Serializable(with = DateSerializer.class)
        public static /* synthetic */ void getDate$annotations() {
        }

        @Serializable(with = UUIDSerializer.class)
        public static /* synthetic */ void getId$annotations() {
        }

        public final UUID component1() {
            return this.id;
        }

        public final Date component2() {
            return this.date;
        }

        public final CreationData copy(UUID uuid, Date date2) {
            Intrinsics.checkNotNullParameter(uuid, "id");
            Intrinsics.checkNotNullParameter(date2, "date");
            return new CreationData(uuid, date2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreationData)) {
                return false;
            }
            CreationData creationData = (CreationData) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) creationData.id) && Intrinsics.areEqual((Object) this.date, (Object) creationData.date);
        }

        public final Date getDate() {
            return this.date;
        }

        public final UUID getId() {
            return this.id;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.date.hashCode();
        }

        public String toString() {
            return "CreationData(id=" + this.id + ", date=" + this.date + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: PaywallEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CreationData> serializer() {
                return PaywallEvent$CreationData$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CreationData(int i, @Serializable(with = UUIDSerializer.class) UUID uuid, @Serializable(with = DateSerializer.class) Date date2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, PaywallEvent$CreationData$$serializer.INSTANCE.getDescriptor());
            }
            this.id = uuid;
            this.date = date2;
        }

        public CreationData(UUID uuid, Date date2) {
            Intrinsics.checkNotNullParameter(uuid, "id");
            Intrinsics.checkNotNullParameter(date2, "date");
            this.id = uuid;
            this.date = date2;
        }

        @JvmStatic
        public static final void write$Self(CreationData creationData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(creationData, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, UUIDSerializer.INSTANCE, creationData.id);
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, DateSerializer.INSTANCE, creationData.date);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 02\u00020\u0001:\u0002/0BS\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J!\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.HÇ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "", "seen1", "", "offeringIdentifier", "", "paywallRevision", "sessionIdentifier", "Ljava/util/UUID;", "displayMode", "localeIdentifier", "darkMode", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/util/UUID;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/util/UUID;Ljava/lang/String;Ljava/lang/String;Z)V", "getDarkMode", "()Z", "getDisplayMode", "()Ljava/lang/String;", "getLocaleIdentifier", "getOfferingIdentifier", "getPaywallRevision", "()I", "getSessionIdentifier$annotations", "()V", "getSessionIdentifier", "()Ljava/util/UUID;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    /* compiled from: PaywallEvent.kt */
    public static final class Data {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean darkMode;
        private final String displayMode;
        private final String localeIdentifier;
        private final String offeringIdentifier;
        private final int paywallRevision;
        private final UUID sessionIdentifier;

        public static /* synthetic */ Data copy$default(Data data, String str, int i, UUID uuid, String str2, String str3, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = data.offeringIdentifier;
            }
            if ((i2 & 2) != 0) {
                i = data.paywallRevision;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                uuid = data.sessionIdentifier;
            }
            UUID uuid2 = uuid;
            if ((i2 & 8) != 0) {
                str2 = data.displayMode;
            }
            String str4 = str2;
            if ((i2 & 16) != 0) {
                str3 = data.localeIdentifier;
            }
            String str5 = str3;
            if ((i2 & 32) != 0) {
                z = data.darkMode;
            }
            return data.copy(str, i3, uuid2, str4, str5, z);
        }

        @Serializable(with = UUIDSerializer.class)
        public static /* synthetic */ void getSessionIdentifier$annotations() {
        }

        public final String component1() {
            return this.offeringIdentifier;
        }

        public final int component2() {
            return this.paywallRevision;
        }

        public final UUID component3() {
            return this.sessionIdentifier;
        }

        public final String component4() {
            return this.displayMode;
        }

        public final String component5() {
            return this.localeIdentifier;
        }

        public final boolean component6() {
            return this.darkMode;
        }

        public final Data copy(String str, int i, UUID uuid, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "offeringIdentifier");
            Intrinsics.checkNotNullParameter(uuid, "sessionIdentifier");
            Intrinsics.checkNotNullParameter(str2, "displayMode");
            Intrinsics.checkNotNullParameter(str3, "localeIdentifier");
            return new Data(str, i, uuid, str2, str3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.offeringIdentifier, (Object) data.offeringIdentifier) && this.paywallRevision == data.paywallRevision && Intrinsics.areEqual((Object) this.sessionIdentifier, (Object) data.sessionIdentifier) && Intrinsics.areEqual((Object) this.displayMode, (Object) data.displayMode) && Intrinsics.areEqual((Object) this.localeIdentifier, (Object) data.localeIdentifier) && this.darkMode == data.darkMode;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final String getOfferingIdentifier() {
            return this.offeringIdentifier;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final UUID getSessionIdentifier() {
            return this.sessionIdentifier;
        }

        public int hashCode() {
            int hashCode = ((((((((this.offeringIdentifier.hashCode() * 31) + this.paywallRevision) * 31) + this.sessionIdentifier.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.localeIdentifier.hashCode()) * 31;
            boolean z = this.darkMode;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "Data(offeringIdentifier=" + this.offeringIdentifier + ", paywallRevision=" + this.paywallRevision + ", sessionIdentifier=" + this.sessionIdentifier + ", displayMode=" + this.displayMode + ", localeIdentifier=" + this.localeIdentifier + ", darkMode=" + this.darkMode + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: PaywallEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return PaywallEvent$Data$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Data(int i, String str, int i2, @Serializable(with = UUIDSerializer.class) UUID uuid, String str2, String str3, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, PaywallEvent$Data$$serializer.INSTANCE.getDescriptor());
            }
            this.offeringIdentifier = str;
            this.paywallRevision = i2;
            this.sessionIdentifier = uuid;
            this.displayMode = str2;
            this.localeIdentifier = str3;
            this.darkMode = z;
        }

        public Data(String str, int i, UUID uuid, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "offeringIdentifier");
            Intrinsics.checkNotNullParameter(uuid, "sessionIdentifier");
            Intrinsics.checkNotNullParameter(str2, "displayMode");
            Intrinsics.checkNotNullParameter(str3, "localeIdentifier");
            this.offeringIdentifier = str;
            this.paywallRevision = i;
            this.sessionIdentifier = uuid;
            this.displayMode = str2;
            this.localeIdentifier = str3;
            this.darkMode = z;
        }

        @JvmStatic
        public static final void write$Self(Data data, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(data, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            compositeEncoder.encodeStringElement(serialDescriptor, 0, data.offeringIdentifier);
            compositeEncoder.encodeIntElement(serialDescriptor, 1, data.paywallRevision);
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, UUIDSerializer.INSTANCE, data.sessionIdentifier);
            compositeEncoder.encodeStringElement(serialDescriptor, 3, data.displayMode);
            compositeEncoder.encodeStringElement(serialDescriptor, 4, data.localeIdentifier);
            compositeEncoder.encodeBooleanElement(serialDescriptor, 5, data.darkMode);
        }
    }

    public final PaywallPostReceiptData toPaywallPostReceiptData$purchases_defaultsRelease() {
        String uuid = this.data.getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "data.sessionIdentifier.toString()");
        return new PaywallPostReceiptData(uuid, this.data.getPaywallRevision(), this.data.getDisplayMode(), this.data.getDarkMode(), this.data.getLocaleIdentifier(), this.data.getOfferingIdentifier());
    }
}
