package com.revenuecat.purchases.paywalls.events;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/events/PaywallEvent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: PaywallEvent.kt */
public final class PaywallEvent$$serializer implements GeneratedSerializer<PaywallEvent> {
    public static final PaywallEvent$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PaywallEvent$$serializer paywallEvent$$serializer = new PaywallEvent$$serializer();
        INSTANCE = paywallEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallEvent", paywallEvent$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("creationData", false);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallEvent$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallEvent$CreationData$$serializer.INSTANCE, PaywallEvent$Data$$serializer.INSTANCE, EnumsKt.createSimpleEnumSerializer("com.revenuecat.purchases.paywalls.events.PaywallEventType", (Enum[]) PaywallEventType.values())};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.paywalls.events.PaywallEvent deserialize(kotlinx.serialization.encoding.Decoder r13) {
        /*
            r12 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r12.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r13 = r13.beginStructure(r0)
            boolean r1 = r13.decodeSequentially()
            java.lang.String r2 = "com.revenuecat.purchases.paywalls.events.PaywallEventType"
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r1 == 0) goto L_0x003d
            com.revenuecat.purchases.paywalls.events.PaywallEvent$CreationData$$serializer r1 = com.revenuecat.purchases.paywalls.events.PaywallEvent$CreationData$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1
            java.lang.Object r1 = r13.decodeSerializableElement(r0, r5, r1, r6)
            com.revenuecat.purchases.paywalls.events.PaywallEvent$Data$$serializer r5 = com.revenuecat.purchases.paywalls.events.PaywallEvent$Data$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r4 = r13.decodeSerializableElement(r0, r4, r5, r6)
            com.revenuecat.purchases.paywalls.events.PaywallEventType[] r5 = com.revenuecat.purchases.paywalls.events.PaywallEventType.values()
            java.lang.Enum[] r5 = (java.lang.Enum[]) r5
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.internal.EnumsKt.createSimpleEnumSerializer(r2, r5)
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r13.decodeSerializableElement(r0, r3, r2, r6)
            r3 = 7
            r7 = r4
            r4 = r3
            goto L_0x0084
        L_0x003d:
            r9 = r4
            r1 = r5
            r7 = r6
            r8 = r7
        L_0x0041:
            if (r9 == 0) goto L_0x0081
            int r10 = r13.decodeElementIndex(r0)
            r11 = -1
            if (r10 == r11) goto L_0x007f
            if (r10 == 0) goto L_0x0074
            if (r10 == r4) goto L_0x0069
            if (r10 != r3) goto L_0x0063
            com.revenuecat.purchases.paywalls.events.PaywallEventType[] r10 = com.revenuecat.purchases.paywalls.events.PaywallEventType.values()
            java.lang.Enum[] r10 = (java.lang.Enum[]) r10
            kotlinx.serialization.KSerializer r10 = kotlinx.serialization.internal.EnumsKt.createSimpleEnumSerializer(r2, r10)
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            java.lang.Object r8 = r13.decodeSerializableElement(r0, r3, r10, r8)
            r1 = r1 | 4
            goto L_0x0041
        L_0x0063:
            kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
            r13.<init>((int) r10)
            throw r13
        L_0x0069:
            com.revenuecat.purchases.paywalls.events.PaywallEvent$Data$$serializer r10 = com.revenuecat.purchases.paywalls.events.PaywallEvent$Data$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            java.lang.Object r7 = r13.decodeSerializableElement(r0, r4, r10, r7)
            r1 = r1 | 2
            goto L_0x0041
        L_0x0074:
            com.revenuecat.purchases.paywalls.events.PaywallEvent$CreationData$$serializer r10 = com.revenuecat.purchases.paywalls.events.PaywallEvent$CreationData$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            java.lang.Object r6 = r13.decodeSerializableElement(r0, r5, r10, r6)
            r1 = r1 | 1
            goto L_0x0041
        L_0x007f:
            r9 = r5
            goto L_0x0041
        L_0x0081:
            r4 = r1
            r1 = r6
            r2 = r8
        L_0x0084:
            r13.endStructure(r0)
            com.revenuecat.purchases.paywalls.events.PaywallEvent r13 = new com.revenuecat.purchases.paywalls.events.PaywallEvent
            r5 = r1
            com.revenuecat.purchases.paywalls.events.PaywallEvent$CreationData r5 = (com.revenuecat.purchases.paywalls.events.PaywallEvent.CreationData) r5
            r6 = r7
            com.revenuecat.purchases.paywalls.events.PaywallEvent$Data r6 = (com.revenuecat.purchases.paywalls.events.PaywallEvent.Data) r6
            r7 = r2
            com.revenuecat.purchases.paywalls.events.PaywallEventType r7 = (com.revenuecat.purchases.paywalls.events.PaywallEventType) r7
            r8 = 0
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.events.PaywallEvent$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.paywalls.events.PaywallEvent");
    }

    public void serialize(Encoder encoder, PaywallEvent paywallEvent) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(paywallEvent, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PaywallEvent.write$Self(paywallEvent, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
